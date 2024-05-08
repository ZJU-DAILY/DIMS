/*
 *  Copyright 2023 by DIMS Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.spark.sql.execution.amds.exec

import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.amds.common.metric.MetricData
import org.apache.spark.sql.catalyst.expressions.amds.common.shape.{Point, Shape}
import org.apache.spark.sql.catalyst.expressions.{Attribute, Expression}
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.execution.amds.algorithms.MetricDeleteAlgorithms
import org.apache.spark.sql.execution.amds.sql.AMDSIternalRow
import org.apache.spark.sql.execution.{SparkPlan, UnaryExecNode}

case class AMDSDeleteExec(leftQuery: Point[Any], rightKey: Expression,
                          rightLogicalPlan: LogicalPlan,
                          right: SparkPlan)
  extends UnaryExecNode with Logging {
  override def output: Seq[Attribute] = right.output

  override def child: SparkPlan = right

  sparkContext.conf.registerKryoClasses(Array(classOf[Shape],
    classOf[Point[Any]], classOf[(Point[Any], Point[Any])],
    classOf[Array[(Point[Any], Point[Any])]], classOf[Array[Point[Any]]],
    classOf[MetricData])
  )

  protected override def doExecute(): RDD[InternalRow] = {
    logWarning(s"Shape: $leftQuery")

    val rightResults = right.execute()
    val rightCount = rightResults.count()
    logWarning(s"Data count: $rightCount")

    logWarning("Applying efficient metric range search algorithm!")

    val rightAMDSRDD = MetricExecUtils.getAMDSRDD(sqlContext, rightResults,
      rightKey, rightLogicalPlan, right)
    var start = System.currentTimeMillis()
    var end = start
    start = System.currentTimeMillis()
    // get answer
    val search = MetricDeleteAlgorithms.DistributedSearch

    val answerRDD = search.search(sparkContext, leftQuery, rightAMDSRDD)
    end = System.currentTimeMillis()
    logWarning(s"AMDS Delete Time: ${end - start} ms")
    val outputRDD = answerRDD.map(x => x._1.asInstanceOf[AMDSIternalRow].row)
    logWarning(s"${outputRDD.count()}")
    outputRDD.asInstanceOf[RDD[InternalRow]]
  }
}