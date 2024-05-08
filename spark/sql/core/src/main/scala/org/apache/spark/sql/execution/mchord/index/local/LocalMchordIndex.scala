/*
 *  Copyright 2017 by DITA Project
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

package org.apache.spark.sql.execution.mchord.index.local

import org.apache.spark.sql.catalyst.expressions.mchord.common.metric.MetricSimilarity
import org.apache.spark.sql.catalyst.expressions.mchord.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.mchord.index.LocalIndex
import org.apache.spark.sql.execution.mchord.partition.local.LocalMchordPartitioner

case class LocalMchordIndex(partitioner: LocalMchordPartitioner) extends LocalIndex {

  //  def getCandidatesWithDistances(key: Point[Any], distanceFunction: MetricSimilarity,
  //                                 threshold: Double): List[(Point[Any], Double)] = {
  //    partitioner.getCandidates(key, distanceFunction, threshold, 0.0)
  //  }
  //  def getCandidates(key: Point[Any]): List[Point[Any]] = {
  //    partitioner.getCandidates(key)
  //  }
  def deletePoint(id: Int,
                  key: Point[Any],
                  globalPivots: Array[Point[Any]]): List[(Point[Any], Double)] = {
    partitioner.deletePoint(id, key, globalPivots)
  }

  def insertPoint(id: Int,
                  key: Point[Any],
                  globalPivots: Array[Point[Any]]): List[(Point[Any], Double)] = {
    partitioner.insertPoint(id, key, globalPivots)
  }

  def getCandidatesWithThreshold(id: Int,
                                 key: Point[Any],
                                 threshold: Double,
                                 globalPivots: Array[Point[Any]]): List[Point[Any]] = {
    partitioner.getCandidatesWithThreshold(id, key, threshold, globalPivots)
  }

  def getCandidatesWithThreshold(id: Int,
                                 key: Point[Any],
                                 threshold: Double,
                                 thresholdOld: Double,
                                 globalPivots: Array[Point[Any]]): List[Point[Any]] = {
    partitioner.getCandidatesWithThreshold(id, key, threshold, thresholdOld, globalPivots)
  }
}

object LocalMchordIndex {
  def buildIndex(data: Array[(Int, Point[Any])]): LocalMchordIndex = {
    val (_, partitioner) = LocalMchordPartitioner.partition(data)
    LocalMchordIndex(partitioner)
  }
}