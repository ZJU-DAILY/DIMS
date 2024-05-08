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

package org.apache.spark.sql.execution.dims.index.local

import org.apache.spark.sql.catalyst.expressions.dims.common.metric.DIMSSimilarity
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.dims.index.LocalIndex
import org.apache.spark.sql.execution.dims.partition.local.LocalDIMSPartitioner

case class LocalDIMSIndex(partitioner: LocalDIMSPartitioner) extends LocalIndex {
  //  def getCandidates(key: Point): List[Point] = {
  //    partitioner.getCandidates(key)
  //  }

  def getCandidatesWithThreshold(key: Point[Any], threshold: Double,
                                 distanceFromParent: Double): List[Point[Any]] = {
    partitioner.getCandidatesWithThreshold(key, threshold, distanceFromParent)
  }

  def getCandidatesIntWithThreshold(key: Point[Any], threshold: Double,
                                    distanceFromParent: Double): List[Int] = {
    partitioner.getCandidatesIntWithThreshold(key, threshold, distanceFromParent)
  }

  def getNumLeaf(): Int = {
    partitioner.numPartitions
  }


  //  def getCandidatesWithThreshold(key: Point[Any], threshold: Double,
  //                                 thresholdOld: Double): List[Point[Any]] = {
  //    partitioner.getCandidatesWithThreshold(key, threshold, thresholdOld)
  //  }
}

object LocalDIMSIndex {
  def buildIndex(dataKeyValuePair: Array[(Double, Point[Any])]): LocalDIMSIndex = {
    val (_, partitioner) = LocalDIMSPartitioner.partition(dataKeyValuePair)
    //    println(partitioner.numPartitions)
    //    val aa = partitioner.numPartitions
    LocalDIMSIndex(partitioner)

  }
}