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

package org.apache.spark.sql.execution.amds.index.local

import org.apache.spark.sql.catalyst.expressions.amds.common.metric.AMDSSimilarity
import org.apache.spark.sql.catalyst.expressions.amds.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.amds.index.LocalIndex
import org.apache.spark.sql.execution.amds.partition.local.LocalAMDSPartitioner

case class LocalAMDSIndex(partitioner: LocalAMDSPartitioner) extends LocalIndex {
  def getCandidatesWithThreshold(query: Point[Any],
                                 threshold: Double): List[(Point[Any], Double)] = {
    //    partitioner.getPartitionsWithThreshold(query, threshold)
    val res = partitioner.getResultWithThreshold(query, threshold)
    res
  }

  def deletePoint(query: Point[Any]): List[(Point[Any], Double)] = {
    partitioner.deletePoint(query)
  }

  def insertPoint(query: Point[Any]): List[(Point[Any], Double)] = {
    partitioner.insertPoint(query)
  }

  def getCandidatesWithKNN(query: Point[Any], k: Int): Double = {
    partitioner.getEstimatedKNNDist(query, k)
  }
}

object LocalAMDSIndex {
  def buildIndex(data: Array[Point[Any]]): LocalAMDSIndex = {
    val partitioner = LocalAMDSPartitioner.partition(data)
    LocalAMDSIndex(partitioner)
  }
}