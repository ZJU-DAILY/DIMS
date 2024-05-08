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

package org.apache.spark.sql.execution.dims.algorithms

import org.apache.spark.internal.Logging
import org.apache.spark.rdd.{PartitionPruningRDD, RDD}
import org.apache.spark.sql.catalyst.expressions.dims.PackedPartition
import org.apache.spark.sql.catalyst.expressions.dims.common.DIMSConfigConstants
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import org.apache.spark.sql.execution.dims.index.global.{GlobalBPlusTreeIndex, GlobalDIMSIndex}
import org.apache.spark.sql.execution.dims.index.local.{LocalDIMSIndex, LocalMTreeIndex}
import org.apache.spark.sql.execution.dims.rdd.DIMSRDD
import org.apache.spark.{HashPartitioner, SparkContext}

object MetricDeleteAlgorithms {
  // search from M-tree
  def localSearchMode5(query: Point[Any], packedPartition: PackedPartition,
                       threshold: Double):
  Iterator[(Point[Any], Double)] = {
    val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalMTreeIndex]).head
      .asInstanceOf[LocalMTreeIndex]
    val answers = localIndex.getResultWithThreshold(query, threshold).iterator
    answers
  }

  def localDelete(query: Point[Any], packedPartition: PackedPartition):
  Iterator[(Point[Any], Double)] = {
    val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalMTreeIndex]).head
      .asInstanceOf[LocalMTreeIndex]
    val res = localIndex.deletePoint(query).iterator
    res
  }


  object DistributedSearch extends Logging {
    def search(sparkContext: SparkContext, query: Point[Any], dimsRDD: DIMSRDD):
    RDD[(Point[Any], Double)] = {
      val bQuery = sparkContext.broadcast(query)

      DIMSConfigConstants.DIMS_MODE match {
        case 3 =>
          val globalDIMSIndex = dimsRDD.globalIndex.asInstanceOf[GlobalDIMSIndex]
          val globalBPlusTreeIndex = dimsRDD.globalBPlusTreeIndex.asInstanceOf[GlobalBPlusTreeIndex]

          var start = System.currentTimeMillis()
          var end = start
          val distanceFromParent = globalDIMSIndex.getQueryDistanceFromParent(bQuery.value)
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get distanceFromParent: ${end - start} ms")

          start = System.currentTimeMillis()
          end = start
          val globalCandidatePartitions = List(globalBPlusTreeIndex.
            getPartition((distanceFromParent, bQuery.value)))
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get candidatePartitions: ${end - start} ms")

          start = System.currentTimeMillis()
          end = start
          val answers = PartitionPruningRDD.create(dimsRDD.globalBPlusRDD,
            globalCandidatePartitions.contains)
            .flatMap(packedPartition => localDelete(bQuery.value, packedPartition).toIterator)
          end = System.currentTimeMillis()
          // check whether contain true
          answers
      }
    }
  }
}

