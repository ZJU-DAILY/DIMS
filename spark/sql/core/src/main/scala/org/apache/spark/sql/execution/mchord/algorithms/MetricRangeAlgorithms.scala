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
import org.apache.spark.sql.catalyst.expressions.mchord.common.shape.{Point, Shape}
import org.apache.spark.sql.execution.mchord.index.global.GlobalMchordIndex
import org.apache.spark.sql.execution.mchord.index.local.LocalMchordIndex
import org.apache.spark.sql.execution.mchord.rdd.MchordRDD

object MetricRangeAlgorithms {
  def localSearch(query: Point[Any], packedPartition: PackedPartition, threshold: Double
                  , globalPivots: Array[Point[Any]]):
  Iterator[(Point[Any], Double)] = {
    val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalMchordIndex]).head
      .asInstanceOf[LocalMchordIndex]
    val answers = localIndex.getCandidatesWithThreshold(packedPartition.id,
      query, threshold, globalPivots)
      .map(x => (x, x.minDist(query)))
      .filter(x => x._2 <= threshold).iterator
    answers
  }

  object DistributedSearch extends Logging {
    def search(sparkContext: SparkContext, query: Point[Any], mchordRDD: MchordRDD,
               threshold: Double): RDD[(Point[Any], Double)] = {
      val bQuery = sparkContext.broadcast(query)
      val globalMchordIndex = mchordRDD.globalIndex.asInstanceOf[GlobalMchordIndex]
      val candidatePartitions = globalMchordIndex.getPartitionsWithThreshold(query, threshold)
      val globalPivots = mchordRDD.globalPivots
      val res = PartitionPruningRDD.create(mchordRDD.packedRDD, candidatePartitions.contains)
        .flatMap(packedPartition => localSearch(bQuery.value,
          packedPartition, threshold, globalPivots)).distinct()
      val aaa = res.count()
      logWarning(s"Mchord Get ${aaa} Result: ")
      res

    }
  }
}
