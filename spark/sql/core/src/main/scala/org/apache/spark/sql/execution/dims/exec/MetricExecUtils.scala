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

package org.apache.spark.sql.execution.dims.exec

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.dims.DIMSSimilarityExpression
import org.apache.spark.sql.catalyst.expressions.dims.common.DIMSConfigConstants
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.dims.index.IndexedRelation
import org.apache.spark.sql.catalyst.expressions.{BindReferences, Expression, UnsafeArrayData, UnsafeRow}
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.dims.rdd.DIMSRDD
import org.apache.spark.sql.execution.dims.sql.{DIMSIndexedRelation, DIMSIternalRow}

object MetricExecUtils {
  // TODO: This is a temporary solution to get the indexed relation.
  def getIndexedRelation(sqlContext: SQLContext, plan: LogicalPlan): Option[IndexedRelation] = {
    //    sqlContext.sessionState.dimsIndexRegistry.lookupIndex(plan).map(_.relation)
    sqlContext.sessionState.dimsIndexRegistry.getIndex().map(_.relation)
  }

  def getDIMSRDD(sqlContext: SQLContext, rdd: RDD[InternalRow], key: Expression,
                logicalPlan: LogicalPlan,
                physicalPlan: SparkPlan): DIMSRDD = {


    getIndexedRelation(sqlContext, logicalPlan)
      .map(_.asInstanceOf[DIMSIndexedRelation].dimsRDD)
      .getOrElse({
        val leftRDD = rdd.asInstanceOf[RDD[UnsafeRow]].map(row =>
          new DIMSIternalRow(row.copy(),

            DIMSSimilarityExpression.getPoints(

              row)

          )).asInstanceOf[RDD[Point[Any]]]
        new DIMSRDD(leftRDD)
      })
  }
}
