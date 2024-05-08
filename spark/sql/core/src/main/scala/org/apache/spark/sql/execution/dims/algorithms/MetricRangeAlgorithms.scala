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

import org.apache.spark.{HashPartitioner, SparkContext}
import org.apache.spark.internal.Logging
import org.apache.spark.rdd.{PartitionPruningRDD, RDD}
import org.apache.spark.sql.catalyst.expressions.dims.PackedPartition
import org.apache.spark.sql.catalyst.expressions.dims.common.DIMSConfigConstants
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.{Point, Shape}
import org.apache.spark.sql.execution.dims.index.global.{GlobalBPlusTreeIndex, GlobalDIMSIndex}
import org.apache.spark.sql.execution.dims.index.local.{LocalDIMSIndex, LocalMTreeIndex, LocalPivotIndex, LocalSimpleIndex}
import org.apache.spark.sql.execution.dims.rdd.DIMSRDD

object MetricRangeAlgorithms {
  def localSearchMode1(query: Point[Any], packedPartition: PackedPartition,
                       threshold: Double, distanceFromParent: Double):
  Iterator[(Point[Any], Double)] = {
    val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalDIMSIndex]).head
      .asInstanceOf[LocalDIMSIndex]
    val answers = localIndex.getCandidatesWithThreshold(query, threshold, distanceFromParent)
      .map(x => (x, x.minDist(query)))
      .filter(x => x._2 <= threshold).iterator
    answers
  }

  def localSearchMode2(query: Point[Any], packedPartition: PackedPartition,
                       threshold: Double, distanceFromParent: Double):
  List[Int] = {
    val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalDIMSIndex]).head
      .asInstanceOf[LocalDIMSIndex]
    val candidatesIndex = localIndex.getCandidatesIntWithThreshold(query,
      threshold, distanceFromParent)
    // TODO:QT???RDD RDD??
    //    val answers = PartitionPruningRDD.create(newPackedRDD, candidatesIndex.contains)
    candidatesIndex
  }

  def localSearchMode3(query: Point[Any], packedPartition: PackedPartition,
                       threshold: Double):
  Iterator[(Point[Any], Double)] = {
    val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalMTreeIndex]).head
      .asInstanceOf[LocalMTreeIndex]
    val answers = localIndex.getCandidatesWithThreshold(query, threshold)
      .map(x => (x, x.minDist(query))).filter(x => x._2 <= threshold).iterator
    answers

  }

  // search from M-tree
  def localSearchMode5(query: Point[Any], packedPartition: PackedPartition,
                       threshold: Double):
  Iterator[(Point[Any], Double)] = {

    val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalMTreeIndex]).head
      .asInstanceOf[LocalMTreeIndex]
    val answers = localIndex.getResultWithThreshold(query, threshold).iterator
    answers
  }

  // search from M-tree
  def localSearchMode6(query: Point[Any], packedPartition: PackedPartition,
                       threshold: Double):
  Iterator[(Point[Any], Double)] = {

    val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalSimpleIndex]).head
      .asInstanceOf[LocalSimpleIndex]
    val answers = localIndex.getResultWithThreshold(query, threshold).iterator
    answers
  }

  // search from M-tree
  def localSearchMode7(query: Point[Any], packedPartition: PackedPartition,
                       threshold: Double):
  Iterator[(Point[Any], Double)] = {

    val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalPivotIndex]).head
      .asInstanceOf[LocalPivotIndex]
    val answers = localIndex.getResultWithThreshold(query, threshold).iterator
    answers
  }

  object DistributedSearch extends Logging {
    def search(sparkContext: SparkContext, query: Point[Any], dimsRDD: DIMSRDD,
               threshold: Double): RDD[(Point[Any], Double)] = {
      val bQuery = sparkContext.broadcast(query)

      DIMSConfigConstants.DIMS_MODE match {
        case 1 =>
          val globalDIMSIndex = dimsRDD.globalIndex.asInstanceOf[GlobalDIMSIndex]
          var start = System.currentTimeMillis()
          var end = start
          val globalCandidatePartitions = globalDIMSIndex.
            getPartitionsWithThreshold(bQuery.value, threshold)
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get candidatePartitions: ${end - start} ms")

          start = System.currentTimeMillis()
          end = start
          val distanceFromParent = globalDIMSIndex.getQueryDistanceFromParent(bQuery.value)
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get distanceFromParent: ${end - start} ms")

          start = System.currentTimeMillis()
          end = start
          val res = PartitionPruningRDD.create(dimsRDD.packedRDD, globalCandidatePartitions.contains)
            .flatMap(packedPartition => localSearchMode1(bQuery.value, packedPartition, threshold, distanceFromParent))
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get Result of LocalSearch: ${end - start} ms")
          res
        case 2 =>
          val globalDIMSIndex = dimsRDD.globalIndex.asInstanceOf[GlobalDIMSIndex]
          var start = System.currentTimeMillis()
          var end = start
          val globalCandidatePartitions = globalDIMSIndex.
            getPartitionsWithThreshold(bQuery.value, threshold)
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get candidatePartitions: ${end - start} ms")

          start = System.currentTimeMillis()
          end = start
          val distanceFromParent = globalDIMSIndex.getQueryDistanceFromParent(bQuery.value)
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get distanceFromParent: ${end - start} ms")

          start = System.currentTimeMillis()
          end = start
          val hashPartitioner = new HashPartitioner(40)
          val localCandidatesPartition = PartitionPruningRDD
            .create(dimsRDD.packedRDD, globalCandidatePartitions.contains)
            .flatMap(packedPartition =>
              localSearchMode2(bQuery.value, packedPartition, threshold, distanceFromParent)
                .map(x => hashPartitioner.getPartition(packedPartition.id.toString + "," + x.toString))).distinct()
          // TODO:QT .distinct()?
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get Candidate Local Partition: ${end - start} ms")

          start = System.currentTimeMillis()
          end = start
          val answers = PartitionPruningRDD.create(dimsRDD.newPackedRDD,
            localCandidatesPartition.collect().toList.contains).map(x => (x, x.minDist(query)))
            .filter(x => x._2 <= threshold)
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get Result of LocalSearch: ${end - start} ms")
          answers
        //          sparkContext.parallelize(answers)
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
          val globalCandidatePartitions = globalBPlusTreeIndex.
            getPartitionsWithThreshold(bQuery.value, threshold, distanceFromParent)
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get candidatePartitions: ${end - start} ms")

          start = System.currentTimeMillis()
          end = start
          val answers = PartitionPruningRDD.create(dimsRDD.globalBPlusRDD,
            globalCandidatePartitions.contains)
            .flatMap(packedPartition => localSearchMode5(bQuery.value, packedPartition, threshold)).distinct()
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get Result of LocalSearch: ${end - start} ms")
          val aaa = answers.count()
          logWarning(s"DIMS Get ${aaa} Result: ")
          answers
        case 4 =>
          val globalDIMSIndex = dimsRDD.globalIndex.asInstanceOf[GlobalDIMSIndex]
          var start = System.currentTimeMillis()
          var end = start
          val globalCandidatePartitions = globalDIMSIndex.
            getPartitionsWithThreshold(bQuery.value, threshold).distinct
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get candidatePartitions: ${end - start} ms")

          start = System.currentTimeMillis()
          val distanceFromParent = globalDIMSIndex.getQueryDistanceFromParent(bQuery.value)
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get distanceFromParent: ${end - start} ms")
          //          val numLocalPartition = DIMSConfigConstants.DIMS4_LOCAL_PARTITION
          //          val hashPartitioner = new HashPartitioner(numLocalPartition)
          start = System.currentTimeMillis()
          val localCandidatesPartition = PartitionPruningRDD
            .create(dimsRDD.packedRDD, globalCandidatePartitions.contains)
            .flatMap(packedPartition =>
              localSearchMode2(bQuery.value,
                packedPartition, threshold, distanceFromParent)).distinct()
          //          val aaa = localCandidatesPartition.collect()


          end = System.currentTimeMillis()
          logWarning(s"DIMS Get Local BPlusTree Candidates(Mode2): ${end - start} ms")

          val answers = PartitionPruningRDD
            .create(dimsRDD.finalPackedRDD,
              localCandidatesPartition.collect().toList.contains)
            .flatMap(packedPartition =>
              localSearchMode3(bQuery.value, packedPartition, threshold))
          //          val aaa = answers.collect()

          end = System.currentTimeMillis()
          logWarning(s"DIMS Get Result of LocalSearch(Mode3): ${end - start} ms")
          answers
        case 5 =>
          val globalDIMSIndex = dimsRDD.globalIndex.asInstanceOf[GlobalDIMSIndex]
          val globalBPlusTreeIndex = dimsRDD.globalBPlusTreeIndex.asInstanceOf[GlobalBPlusTreeIndex]

          var start = System.currentTimeMillis()
          var end = start
          val distanceFromParent = globalDIMSIndex.getQueryDistanceFromParent(bQuery.value)
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get distanceFromParent: ${end - start} ms")

          start = System.currentTimeMillis()
          end = start
          val globalCandidatePartitions = globalBPlusTreeIndex.
            getPartitionsWithThreshold(bQuery.value, threshold, distanceFromParent)
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get candidatePartitions: ${end - start} ms")

          start = System.currentTimeMillis()
          end = start
          val answers = PartitionPruningRDD.create(dimsRDD.globalBPlusRDD,
            globalCandidatePartitions.contains)
            .flatMap(packedPartition => localSearchMode6(bQuery.value, packedPartition, threshold)).distinct()
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get Result of LocalSearch: ${end - start} ms")
          val aaa = answers.count()
          logWarning(s"DIMS Get ${aaa} Result: ")
          answers
        case 6 =>
          val globalDIMSIndex = dimsRDD.globalIndex.asInstanceOf[GlobalDIMSIndex]
          val globalBPlusTreeIndex = dimsRDD.globalBPlusTreeIndex.asInstanceOf[GlobalBPlusTreeIndex]

          var start = System.currentTimeMillis()
          var end = start
          val distanceFromParent = globalDIMSIndex.getQueryDistanceFromParent(bQuery.value)
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get distanceFromParent: ${end - start} ms")

          start = System.currentTimeMillis()
          end = start
          val globalCandidatePartitions = globalBPlusTreeIndex.
            getPartitionsWithThreshold(bQuery.value, threshold, distanceFromParent)
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get candidatePartitions: ${end - start} ms")

          start = System.currentTimeMillis()
          end = start
          val answers = PartitionPruningRDD.create(dimsRDD.globalBPlusRDD,
            globalCandidatePartitions.contains)
            .flatMap(packedPartition => localSearchMode7(bQuery.value, packedPartition, threshold)).distinct()
          end = System.currentTimeMillis()
          logWarning(s"DIMS Get Result of LocalSearch: ${end - start} ms")
          val aaa = answers.count()
          logWarning(s"DIMS Get ${aaa} Result: ")
          answers
      }
    }
  }
}

