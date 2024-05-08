
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
package org.apache.spark.sql.execution.mchord.sql

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.analysis.MultiInstanceRelation
import org.apache.spark.sql.catalyst.expressions.mchord.common.MchordConfigConstants
import org.apache.spark.sql.catalyst.expressions.mchord.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.mchord.index.{GlobalIndex, IndexedRelation}
import org.apache.spark.sql.catalyst.expressions.mchord.{MetricSimilarityExpression, PackedPartition}
import org.apache.spark.sql.catalyst.expressions.{Attribute, BindReferences, UnsafeArrayData, UnsafeRow}
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.mchord.rdd.MchordRDD

case class MchordIndexedRelation(child: SparkPlan, key: Attribute)
                                (var mchordRDD: MchordRDD = null)
  extends IndexedRelation with MultiInstanceRelation {

  if (mchordRDD == null) {
    mchordRDD = buildIndex()
  }

  override def indexedRDD: RDD[PackedPartition] = mchordRDD.packedRDD

  override def globalIndex: GlobalIndex = mchordRDD.globalIndex

  override def newInstance(): IndexedRelation = {
    MchordIndexedRelation(child, key)(mchordRDD).asInstanceOf[this.type]
  }

  private def buildIndex(): MchordRDD = {

    val dataRDD = child.execute().asInstanceOf[RDD[UnsafeRow]].map(row =>
      new MchordIternalRow(row,
        //        if (MchordConfigConstants.DATA_TYPE == 0) {
        //          MetricSimilarityExpression.getPoints(
        //            BindReferences.bindReference(key, child.output)
        //              .eval(row).asInstanceOf[UnsafeArrayData])
        //        } else {
        //          MetricSimilarityExpression.getPoints(
        //            BindReferences.bindReference(key, child.output)
        //              .eval(row).toString)
        //        }
        MetricSimilarityExpression.getPoints(row)
      )).asInstanceOf[RDD[Point[Any]]]

    new MchordRDD(dataRDD)
  }
}

