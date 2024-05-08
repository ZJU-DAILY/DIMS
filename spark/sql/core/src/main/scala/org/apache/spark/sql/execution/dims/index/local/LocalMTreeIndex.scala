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

import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.dims.index.LocalIndex
import org.apache.spark.sql.execution.dims.partition.local.LocalMTreePartitioner

case class LocalMTreeIndex(partitioner: LocalMTreePartitioner) extends LocalIndex {
  def getCandidatesWithThreshold(query: Point[Any], threshold: Double): List[Point[Any]] = {
    partitioner.getPartitionsWithThreshold(query, threshold)
  }

  def getResultWithThreshold(query: Point[Any], threshold: Double): List[(Point[Any], Double)] = {
    partitioner.getResultWithThreshold(query, threshold)
  }
  def deletePoint(query: Point[Any]): Boolean = {
    partitioner.deletePoint(query)
  }
  def insertPoint(query: Point[Any]): Unit = {
    partitioner.insertPoint(query)
  }
  def getCandidatesWithKNN(query: Point[Any], k: Int): Double = {
    partitioner.getEstimatedKNNDist(query, k)
  }
}

object LocalMTreeIndex {
  def buildIndex(data: Array[Point[Any]]): LocalMTreeIndex = {
    val (_, partitioner) = LocalMTreePartitioner.partition(data)
    LocalMTreeIndex(partitioner)
  }
}