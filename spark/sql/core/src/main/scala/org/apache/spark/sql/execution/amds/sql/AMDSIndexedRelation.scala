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

package org.apache.spark.sql.execution.amds.sql

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.analysis.MultiInstanceRelation
import org.apache.spark.sql.catalyst.expressions.amds.common.AMDSConfigConstants
import org.apache.spark.sql.catalyst.expressions.amds.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.amds.index.{GlobalIndex, IndexedRelation}
import org.apache.spark.sql.catalyst.expressions.amds.{AMDSSimilarityExpression, PackedPartition}
import org.apache.spark.sql.catalyst.expressions.{Attribute, BindReferences, UnsafeArrayData, UnsafeRow}
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.amds.rdd.AMDSRDD

case class AMDSIndexedRelation(child: SparkPlan, key: Attribute)
                              (var amdsRDD: AMDSRDD = null)
  extends IndexedRelation with MultiInstanceRelation {

  if (amdsRDD == null) {
    amdsRDD = buildIndex()
  }

  override def indexedRDD: RDD[PackedPartition] = amdsRDD.packedRDD

  override def globalIndex: GlobalIndex = amdsRDD.globalIndex

  override def newInstance(): IndexedRelation = {
    AMDSIndexedRelation(child, key)(amdsRDD).asInstanceOf[this.type]
  }

  private def buildIndex(): AMDSRDD = {
    val dataRDD = child.execute().asInstanceOf[RDD[UnsafeRow]].map(row =>

      new AMDSIternalRow(row,
        //        if (AMDSConfigConstants.DATA_TYPE == 0) {
        AMDSSimilarityExpression.getPoints(row)
        //            BindReferences.bindReference(key, child.output)
        //              .eval(row).asInstanceOf[UnsafeArrayData])
        //        } else {
        //          AMDSSimilarityExpression.getPoints(
        //            BindReferences.bindReference(key, child.output)
        //              .eval(row).toString)
        //        }
        //      new AMDSIternalRow(row, AMDSSimilarityExpression.getPoints(row,
        //        BindReferences.bindReference(key, child.output)
        //          .eval(row).asInstanceOf[UnsafeArrayData]
        //      )
      )).asInstanceOf[RDD[Point[Any]]]

    new AMDSRDD(dataRDD)
  }
}

