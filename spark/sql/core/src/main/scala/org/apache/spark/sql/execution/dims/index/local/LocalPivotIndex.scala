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
import org.apache.spark.sql.execution.dims.partition.local.LocalPivotPartitioner

case class LocalPivotIndex(partitioner: LocalPivotPartitioner) extends LocalIndex {
  def getNumLeaf(): Int = {
    partitioner.numPartitions
  }

  def getResultWithThreshold(query: Point[Any], threshold: Double): List[(Point[Any], Double)] = {
    partitioner.getResultWithThreshold(query, threshold)
  }
}

object LocalPivotIndex {
  def buildIndex(dataKeyValuePair: Array[Point[Any]]): LocalPivotIndex = {
    val (_, partitioner) = LocalPivotPartitioner.partition(dataKeyValuePair)
    LocalPivotIndex(partitioner)
  }
}