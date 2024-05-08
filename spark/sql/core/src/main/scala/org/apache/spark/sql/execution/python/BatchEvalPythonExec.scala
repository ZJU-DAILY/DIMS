/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.apache.spark.sql.execution.python

import java.io.File

import scala.collection.JavaConverters._
import scala.collection.mutable.ArrayBuffer

import net.razorvine.pickle.{Pickler, Unpickler}

import org.apache.spark.{SparkEnv, TaskContext}
import org.apache.spark.api.python.{ChainedPythonFunctions, PythonRunner}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.types.{DataType, StructField, StructType}
import org.apache.spark.util.Utils


/**
 * A physical plan that evaluates a [[PythonUDF]], one partition of tuples at a time.
 *
 * Python evaluation works by sending the necessary (projected) input data via a socket to an
 * external Python process, and combine the result from the Python process with the original row.
 *
 * For each row we send to Python, we also put it in a queue first. For each output row from Python,
 * we drain the queue to find the original input row. Note that if the Python process is way too
 * slow, this could lead to the queue growing unbounded and spill into disk when run out of memory.
 *
 * Here is a diagram to show how this works:
 *
 *            Downstream (for parent)
 *             /      \
 *            /     socket  (output of UDF)
 *           /         \
 *        RowQueue    Python
 *           \         /
 *            \     socket  (input of UDF)
 *             \     /
 *          upstream (from child)
 *
 * The rows sent to and received from Python are packed into batches (100 rows) and serialized,
 * there should be always some rows buffered in the socket or Python process, so the pulling from
 * RowQueue ALWAYS happened after pushing into it.
 */
case class BatchEvalPythonExec(udfs: Seq[PythonUDF], output: Seq[Attribute], child: SparkPlan)
  extends SparkPlan {

  def children: Seq[SparkPlan] = child :: Nil

  override def producedAttributes: AttributeSet = AttributeSet(output.drop(child.output.length))

  private def collectFunctions(udf: PythonUDF): (ChainedPythonFunctions, Seq[Expression]) = {
    udf.children match {
      case Seq(u: PythonUDF) =>
        val (chained, children) = collectFunctions(u)
        (ChainedPythonFunctions(chained.funcs ++ Seq(udf.func)), children)
      case children =>
        // There should not be any other UDFs, or the children can't be evaluated directly.
        assert(children.forall(_.find(_.isInstanceOf[PythonUDF]).isEmpty))
        (ChainedPythonFunctions(Seq(udf.func)), udf.children)
    }
  }

  protected override def doExecute(): RDD[InternalRow] = {
    val inputRDD = child.execute().map(_.copy())
    val bufferSize = inputRDD.conf.getInt("spark.buffer.size", 65536)
    val reuseWorker = inputRDD.conf.getBoolean("spark.python.worker.reuse", defaultValue = true)

    inputRDD.mapPartitions { iter =>
      EvaluatePython.registerPicklers()  // register pickler for Row

      // The queue used to buffer input rows so we can drain it to
      // combine input with output from Python.
      val queue = HybridRowQueue(TaskContext.get().taskMemoryManager(),
        new File(Utils.getLocalDir(SparkEnv.get.conf)), child.output.length)
      TaskContext.get().addTaskCompletionListener({ ctx =>
        queue.close()
      })

      val (pyFuncs, inputs) = udfs.map(collectFunctions).unzip

      // flatten all the arguments
      val allInputs = new ArrayBuffer[Expression]
      val dataTypes = new ArrayBuffer[DataType]
      val argOffsets = inputs.map { input =>
        input.map { e =>
          if (allInputs.exists(_.semanticEquals(e))) {
            allInputs.indexWhere(_.semanticEquals(e))
          } else {
            allInputs += e
            dataTypes += e.dataType
            allInputs.length - 1
          }
        }.toArray
      }.toArray
      val projection = newMutableProjection(allInputs, child.output)
      val schema = StructType(dataTypes.map(dt => StructField("", dt)))
      val needConversion = dataTypes.exists(EvaluatePython.needConversionInPython)

      // enable memo iff we serialize the row with schema (schema and class should be memorized)
      val pickle = new Pickler(needConversion)
      // Input iterator to Python: input rows are grouped so we send them in batches to Python.
      // For each row, add it to the queue.
      val inputIterator = iter.map { inputRow =>
        queue.add(inputRow.asInstanceOf[UnsafeRow])
        val row = projection(inputRow)
        if (needConversion) {
          EvaluatePython.toJava(row, schema)
        } else {
          // fast path for these types that does not need conversion in Python
          val fields = new Array[Any](row.numFields)
          var i = 0
          while (i < row.numFields) {
            val dt = dataTypes(i)
            fields(i) = EvaluatePython.toJava(row.get(i, dt), dt)
            i += 1
          }
          fields
        }
      }.grouped(100).map(x => pickle.dumps(x.toArray))

      val context = TaskContext.get()

      // Output iterator for results from Python.
      val outputIterator = new PythonRunner(pyFuncs, bufferSize, reuseWorker, true, argOffsets)
        .compute(inputIterator, context.partitionId(), context)

      val unpickle = new Unpickler
      val mutableRow = new GenericInternalRow(1)
      val joined = new JoinedRow
      val resultType = if (udfs.length == 1) {
        udfs.head.dataType
      } else {
        StructType(udfs.map(u => StructField("", u.dataType, u.nullable)))
      }
      val resultProj = UnsafeProjection.create(output, output)
      outputIterator.flatMap { pickedResult =>
        val unpickledBatch = unpickle.loads(pickedResult)
        unpickledBatch.asInstanceOf[java.util.ArrayList[Any]].asScala
      }.map { result =>
        val row = if (udfs.length == 1) {
          // fast path for single UDF
          mutableRow(0) = EvaluatePython.fromJava(result, resultType)
          mutableRow
        } else {
          EvaluatePython.fromJava(result, resultType).asInstanceOf[InternalRow]
        }
        resultProj(joined(queue.remove(), row))
      }
    }
  }
}
