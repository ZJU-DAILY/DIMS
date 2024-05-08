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

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.amds.AMDSSimilarityExpression
import org.apache.spark.sql.catalyst.expressions.amds.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.amds.index.IndexedRelation
import org.apache.spark.sql.catalyst.expressions.{BindReferences, Expression, UnsafeArrayData, UnsafeRow}
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.amds.rdd.AMDSRDD
import org.apache.spark.sql.execution.amds.sql.{AMDSIndexedRelation, AMDSIternalRow}

object MetricExecUtils {
  // TODO: This is a temporary solution to get the indexed relation.
  def getIndexedRelation(sqlContext: SQLContext, plan: LogicalPlan): Option[IndexedRelation] = {
    //    sqlContext.sessionState.amdsIndexRegistry.lookupIndex(plan).map(_.relation)
    sqlContext.sessionState.amdsIndexRegistry.getIndex().map(_.relation)
  }


  def getAMDSRDD(sqlContext: SQLContext, rdd: RDD[InternalRow], key: Expression,
                 logicalPlan: LogicalPlan,
                 physicalPlan: SparkPlan): AMDSRDD = {
    getIndexedRelation(sqlContext, logicalPlan)
      .map(_.asInstanceOf[AMDSIndexedRelation].amdsRDD)
      .getOrElse({
        val leftRDD = rdd.asInstanceOf[RDD[UnsafeRow]].map(row =>
          new AMDSIternalRow(row.copy(), AMDSSimilarityExpression.getPoints(
            row)
          )).asInstanceOf[RDD[Point[Any]]]
        new AMDSRDD(leftRDD)
      })
  }
}
