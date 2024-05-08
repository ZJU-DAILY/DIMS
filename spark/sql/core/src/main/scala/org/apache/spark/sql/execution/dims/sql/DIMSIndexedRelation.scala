
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
package org.apache.spark.sql.execution.dims.sql

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.analysis.MultiInstanceRelation
import org.apache.spark.sql.catalyst.expressions.dims.common.DIMSConfigConstants
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.dims.index.{GlobalIndex, IndexedRelation}
import org.apache.spark.sql.catalyst.expressions.dims.{PackedPartition, DIMSSimilarityExpression}
import org.apache.spark.sql.catalyst.expressions.{Attribute, BindReferences, UnsafeArrayData, UnsafeRow}
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.dims.rdd.DIMSRDD

case class DIMSIndexedRelation(child: SparkPlan, key: Attribute)
                             (var dimsRDD: DIMSRDD = null)
  extends IndexedRelation with MultiInstanceRelation {

  if (dimsRDD == null) {
    dimsRDD = buildIndex()
  }

  override def indexedRDD: RDD[PackedPartition] = dimsRDD.packedRDD

  override def globalIndex: GlobalIndex = dimsRDD.globalIndex

  override def newInstance(): IndexedRelation = {
    DIMSIndexedRelation(child, key)(dimsRDD).asInstanceOf[this.type]
  }

  private def buildIndex(): DIMSRDD = {

    val dataRDD = child.execute().asInstanceOf[RDD[UnsafeRow]].map(row =>
      new DIMSIternalRow(row,
        //        if (DIMSConfigConstants.DATA_TYPE == 0) {
        DIMSSimilarityExpression.getPoints(
          row)
        //        } else {
        //          DIMSSimilarityExpression.getPoints(
        //            BindReferences.bindReference(key, child.output)
        //              .eval(row).toString)
        //        }
      )).asInstanceOf[RDD[Point[Any]]]

    new DIMSRDD(dataRDD)
  }
}

