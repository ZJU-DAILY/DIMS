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
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.expressions.dims.common.DIMSConfigConstants
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import org.apache.spark.sql.execution.dims.index.local.MemoryBPlusTree

import scala.math.{max, min}
import scala.collection.mutable.ArrayBuffer

case class LocalSimplePartitioner(dataKeyValuePair: Array[Point[Any]])
  extends Partitioner {
  var dataShuffled: Array[Array[Point[Any]]] = _


  override def numPartitions: Int = 1

  //  def getNumLeaf: Int = numPartitions

  override def getPartition(key: Any): Int = {
    0
  }

  def getResultWithThreshold(key: Point[Any], threshold: Double): List[(Point[Any], Double)] = {
    dataShuffled.flatMap(data => {
      data.map(p => (p, p.minDist(key)))
        .filter(_._2 <= threshold)
    }).toList
  }

}

object LocalSimplePartitioner {
  def partition(dataKeyValuePair: Array[Point[Any]]):
  (Array[Array[Point[Any]]], LocalSimplePartitioner) = {
    val partitioner = new LocalSimplePartitioner(dataKeyValuePair)
    val shuffled = dataKeyValuePair.groupBy(p => partitioner.getPartition(p))
    val dataShuffled = (0 until partitioner.numPartitions).map(i =>
      shuffled.getOrElse(i, Array.empty)).toArray
    partitioner.dataShuffled = dataShuffled
    (dataShuffled, partitioner)
  }


}
