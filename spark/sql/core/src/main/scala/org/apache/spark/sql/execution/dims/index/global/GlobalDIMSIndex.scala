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

package org.apache.spark.sql.execution.dims.index.global

import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Shape
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.dims.common.metric.{MetricData, DIMSSimilarity}
import org.apache.spark.sql.catalyst.expressions.dims.index.GlobalIndex
import org.apache.spark.sql.execution.dims.partition.global.GlobalDIMSPartitioner

import scala.collection.mutable.ArrayBuffer

case class GlobalDIMSIndex(partitioner: GlobalDIMSPartitioner) extends GlobalIndex {
  def getPartition(key: Point[Any]): Int = {
    partitioner.getPartition(key)
  }

  def getPartitionsWithThreshold(key: Point[Any], threshold: Double): List[Int] = {
    partitioner.getPartitionsWithThreshold(key, threshold)
  }

  def getQueryDistanceFromParent(key: Point[Any]): Double = {
    partitioner.getQueryDistanceFromParent(key)
  }

  def getEstimatedKNNDist(key: Point[Any], k: Int): Double = {
    partitioner.getEstimatedKNNDist(key, k)
  }

}