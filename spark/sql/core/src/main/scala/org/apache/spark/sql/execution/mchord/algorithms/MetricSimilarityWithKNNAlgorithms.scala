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
import org.apache.spark.sql.catalyst.expressions.mchord.common.MchordConfigConstants
import org.apache.spark.sql.catalyst.expressions.mchord.common.metric.MetricSimilarity
import org.apache.spark.sql.catalyst.expressions.mchord.common.shape.Point
import org.apache.spark.sql.execution.mchord.index.global.GlobalMchordIndex
import org.apache.spark.sql.execution.mchord.index.local.LocalMchordIndex
import org.apache.spark.sql.execution.mchord.partition.global.ExactKeyPartitioner
import org.apache.spark.sql.execution.mchord.rdd.MchordRDD

import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Queue

object MetricSimilarityWithKNNAlgorithms {


  object DistributedSearch extends Logging {
    implicit val order = new Ordering[(Point[Any], Double)] {
      def compare(x: (Point[Any], Double), y: (Point[Any], Double)): Int = {
        x._2.compare(y._2)
      }
    }

    def localSearch(query: Point[Any], packedPartition: PackedPartition,
                    threshold: Double, thresholdOld: Double, globalPivots: Array[Point[Any]]):
    Iterator[(Point[Any], Double)] = {
      val localIndex = packedPartition.indexes.filter(_.isInstanceOf[LocalMchordIndex]).head
        .asInstanceOf[LocalMchordIndex]
      val answers = localIndex.getCandidatesWithThreshold(packedPartition.id,
        query, threshold, thresholdOld, globalPivots)
        .map(x => (x, x.minDist(query)))
        .filter(x => x._2 <= threshold)
      answers.iterator
    }

    def search(sparkContext: SparkContext, query: Point[Any], mchordRDD: MchordRDD,
               count: Int): RDD[(Point[Any], Double)] = {

      val bQuery = sparkContext.broadcast(query)
      val globalMchordIndex = mchordRDD.globalIndex.asInstanceOf[GlobalMchordIndex]
      val pivots = mchordRDD.globalPivots.zipWithIndex
      val maxPivotDistance = pivots.map(x =>
        (MchordConfigConstants.iDistanceConstant.toDouble, x._2))
      var knnSearched = 0
      val unSearched = Queue(maxPivotDistance: _*)
      val searched = new ArrayBuffer[(Double, Int)]()

      val pivotDistance = pivots.indices.map(
        i => (query.minDist(pivots(i)._1), pivots(i)._2)).sortBy(_._2)


      var thresholdOld = 0.0
      val answerArray = new ArrayBuffer[(Point[Any], Double)]()
      while (knnSearched <= count && searched.length <= maxPivotDistance.length) {
        val pivotCandidate = unSearched.dequeue()
        val threshold = pivotDistance.filter(_._2 == pivotCandidate._2).head._1
        val candidatePartitions = globalMchordIndex.getPartitionsWithThreshold(query, threshold)
        val candidatePartitionsFiltered = candidatePartitions.filter(x => {
          var canAdd = true
          searched.foreach(y => {
            if (x == y._2) {
              canAdd = false
            }
          })
          canAdd
        })
        val globalPivots = mchordRDD.globalPivots
        val tempSearched = PartitionPruningRDD.create(mchordRDD.packedRDD,
          candidatePartitionsFiltered.contains)
          .flatMap(packedPartition =>
            localSearch(bQuery.value, packedPartition,
              threshold, thresholdOld, globalPivots))
        knnSearched += tempSearched.count().toInt
        answerArray ++= tempSearched.collect()
        searched += pivotCandidate
        thresholdOld = threshold
      }

      logWarning(s"Answer Count: ${knnSearched}")
      sparkContext.parallelize(answerArray.distinct.toArray.sortBy(_._2).take(count))
    }
  }
}
