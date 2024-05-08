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
package org.apache.spark.sql.execution.dims.partition.local

import org.apache.spark.Partitioner
import org.apache.spark.sql.catalyst.expressions.dims.common.DIMSConfigConstants
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import org.apache.spark.sql.execution.dims.index.local.VPTree

case class LocalPivotPartitioner(points: Array[Point[Any]])
  extends Partitioner {

  override def numPartitions: Int = 0

  val vpTree = VPTree(points, DIMSConfigConstants.PIVOT_INDEX)

  //  def getNumLeaf: Int = numPartitions

  override def getPartition(key: Any): Int = {
    0
  }

  def getResultWithThreshold(key: Point[Any], threshold: Double): List[(Point[Any], Double)] = {
    vpTree.nearest(key, threshold).map(p => (p, p.minDist(key))).toList
  }


}

object LocalPivotPartitioner {
  def partition(points: Array[Point[Any]]):
  (Array[Array[Point[Any]]], LocalPivotPartitioner) = {
    val partitioner = new LocalPivotPartitioner(points)
    //    val shuffled = points.groupBy(p => partitioner.getPartition(p))
    //    val dataShuffled = (0 until partitioner.numPartitions).map(i =>
    //      shuffled.getOrElse(i, Array.empty)).toArray
    //    partitioner.dataShuffled = dataShuffled
    val shuffled = new Array[Array[Point[Any]]](partitioner.numPartitions)
    (shuffled, partitioner)
  }
}
