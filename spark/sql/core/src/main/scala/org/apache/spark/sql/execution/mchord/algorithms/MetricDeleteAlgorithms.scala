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

package org.apache.spark.sql.execution.mchord.algorithms

import org.apache.spark.SparkContext
import org.apache.spark.internal.Logging
import org.apache.spark.rdd.{PartitionPruningRDD, RDD}
import org.apache.spark.sql.catalyst.expressions.mchord.PackedPartition
import org.apache.spark.sql.catalyst.expressions.mchord.common.shape.Point
import org.apache.spark.sql.execution.mchord.index.global.GlobalMchordIndex
import org.apache.spark.sql.execution.mchord.index.local.LocalMchordIndex
import org.apache.spark.sql.execution.mchord.rdd.MchordRDD

object MetricDeleteAlgorithms {
  def localDelete(query: Point[Any], packedPartition: PackedPartition,
                  globalPivots: Array[Point[Any]]):
  Iterator[(Point[Any], Double)] = {
    val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalMchordIndex]).head
      .asInstanceOf[LocalMchordIndex]
    val res = localIndex.deletePoint(packedPartition.id,
      query, globalPivots).iterator
    res
  }

  object DistributedSearch extends Logging {
    def search(sparkContext: SparkContext, query: Point[Any],
               mchordRDD: MchordRDD): RDD[(Point[Any], Double)] = {
      val bQuery = sparkContext.broadcast(query)
      val globalMchordIndex = mchordRDD.globalIndex.asInstanceOf[GlobalMchordIndex]
      val globalPivots = mchordRDD.globalPivots
      // found the closest pivots
      val index = globalPivots.map(x => (x, x.minDist(query)))
        .zipWithIndex.minBy(_._1._2)._2
      val candidatePartitions = List(index)
      val res = PartitionPruningRDD.create(mchordRDD.packedRDD, candidatePartitions.contains)
        .flatMap(packedPartition => localDelete(bQuery.value,
          packedPartition, globalPivots)).distinct()
      res

    }
  }
}
