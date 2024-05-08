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
package org.apache.spark.sql.execution.amds.algorithms

import org.apache.spark.SparkContext
import org.apache.spark.internal.Logging
import org.apache.spark.rdd.{PartitionPruningRDD, RDD}
import org.apache.spark.sql.catalyst.expressions.amds.PackedPartition
import org.apache.spark.sql.catalyst.expressions.amds.common.shape.{Point, Rectangle}
import org.apache.spark.sql.execution.amds.index.global.GlobalAMDSIndex
import org.apache.spark.sql.execution.amds.index.local.LocalAMDSIndex
import org.apache.spark.sql.execution.amds.rdd.AMDSRDD

import scala.collection.mutable.{ArrayBuffer, Queue}

object MetricSimilarityWithKNNAlgorithms {

  object DistributedSearch extends Logging {
    implicit val order = new Ordering[(Point[Any], Double)] {
      def compare(x: (Point[Any], Double), y: (Point[Any], Double)): Int = {
        x._2.compare(y._2)
      }
    }

    //    def localSearch(query: Point[Any], packedPartition: PackedPartition, threshold: Double):
    //    Iterator[(Point[Any], Double)] = {
    //      val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalAMDSIndex]).head
    //        .asInstanceOf[LocalAMDSIndex]
    //      val answers = localIndex.getCandidatesWithThreshold(query, threshold)
    //        .map(x => (x, x.minDist(query))).iterator
    //      answers
    //    }

    def localSearch(query: Point[Any], packedPartition: PackedPartition, threshold: Double):
    Iterator[(Point[Any], Double)] = {
      val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalAMDSIndex]).head
        .asInstanceOf[LocalAMDSIndex]
      val answers = localIndex.getCandidatesWithThreshold(query, threshold)
        .map(x => (x, x.minDist(query))).filter(x => x._2 <= threshold).iterator
      answers
    }

    def sampleSearch(query: Point[Any], packedPartition: PackedPartition, k: Int)
    : Double = {
      val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalAMDSIndex]).head
        .asInstanceOf[LocalAMDSIndex]
      localIndex.getCandidatesWithKNN(query, k)
    }

    def search(sparkContext: SparkContext, query: Point[Any], amdsRDD: AMDSRDD,
               count: Int): RDD[(Point[Any], Double)] = {
      val globalPivots = amdsRDD.globalPivots
      val newQuery = Point[Any](query.origin, globalPivots.indices.map(
        i => query.minDist(globalPivots(i))).toArray)
      val bQuery = sparkContext.broadcast(newQuery)
      val globalAMDSIndex = amdsRDD.globalIndex.asInstanceOf[GlobalAMDSIndex]

      var start = System.currentTimeMillis()
      var end = start
      val mbr = globalAMDSIndex.getMinMBR()
      //      val knnCandidate = globalAMDSIndex.getKnnCandidate(mbr)
      val samplePartition = List(globalAMDSIndex.getPartition(mbr.low))
      val sampleDistance = PartitionPruningRDD.create(amdsRDD.packedRDD,
        samplePartition.contains).map(packedPartition =>
        sampleSearch(bQuery.value, packedPartition, count)).max
      val candidatePartitions = globalAMDSIndex.
        getPartitionsWithThreshold(bQuery.value, sampleDistance)
        .map(x => x._2).distinct
      end = System.currentTimeMillis()
      logWarning(s"AMDS Get candidatePartitions: ${candidatePartitions} ms")
      logWarning(s"AMDS Get candidatePartitions: ${end - start} ms")

      start = System.currentTimeMillis()
      end = start
      val res = PartitionPruningRDD.create(amdsRDD.packedRDD, candidatePartitions.contains)
        .flatMap(packedPartition => localSearch(bQuery.value, packedPartition, sampleDistance)).distinct().takeOrdered(count)

      end = System.currentTimeMillis()
      logWarning(s"AMDS Get Result of LocalSearch: ${end - start} ms")
      sparkContext.parallelize(res)
    }
  }
}
