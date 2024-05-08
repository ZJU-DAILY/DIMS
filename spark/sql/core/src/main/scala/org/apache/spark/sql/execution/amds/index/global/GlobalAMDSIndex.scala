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

package org.apache.spark.sql.execution.amds.index.global

import org.apache.spark.sql.catalyst.expressions.amds.common.shape.{Point, Rectangle, Shape}
import org.apache.spark.sql.catalyst.expressions.amds.common.metric.{MetricData, AMDSSimilarity}
import org.apache.spark.sql.catalyst.expressions.amds.index.GlobalIndex
import org.apache.spark.sql.execution.amds.partition.global.GlobalAMDSPartitioner

import scala.collection.mutable.ArrayBuffer

case class GlobalAMDSIndex(partitioner: GlobalAMDSPartitioner) extends GlobalIndex {
  def getPartition(key: Point[Any]): Int = {
    partitioner.getPartition(key)
  }

  def getMinMBR(): Rectangle = {
    partitioner.mbrBounds(partitioner.mbrBounds.map(x => x._1.MBRDistance)
      .zipWithIndex.minBy(_._1)._2)._1
  }

  def getKnnCandidate(rectangle: Rectangle): List[Point[Any]] = {
    partitioner.rTree.range(rectangle).map(x => x._1.asInstanceOf[Point[Any]]).toList
  }

  def getPartitionsWithThreshold(key: Point[Any], threshold: Double): List[(Shape, Int)] = {
    partitioner.getPartitionsWithThreshold(key, threshold)
  }

}