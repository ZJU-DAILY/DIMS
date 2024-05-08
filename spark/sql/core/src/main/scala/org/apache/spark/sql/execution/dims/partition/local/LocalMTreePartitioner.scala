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
import org.apache.spark.sql.execution.dims.index.local.{Entry, MTree}

import scala.collection.mutable.ArrayBuffer

case class LocalMTreePartitioner(data: Array[Point[Any]]) extends Partitioner {
  val MTree = buildMTree()
  var dataShuffled: Array[Array[Point[Any]]] = _

  override def numPartitions: Int = calNumPartition() + 1

  def calNumPartition(): Int = {
    val numPartition = MTree.calNumPartition(MTree.root)
    numPartition
  }

  override def getPartition(key: Any): Int = {
    if (MTree == null) {
      -1
    } else {
      val k = key.asInstanceOf[Point[Any]]
      val e = new Entry[Int](k, 0, 0);
      val partitionNum = MTree.getLeafIndex(e, MTree.root)
      partitionNum
    }
  }

  private def buildMTree(): MTree[Int] = {
    val MTree = new MTree[Int](InnerOrder = DIMSConfigConstants.LOCAL_M_TREE_INNER_ORDER,
      LeafOrder = DIMSConfigConstants.LOCAL_M_TREE_LEAF_ORDER);
    data.foreach(point => {
      val e = new Entry[Int](point, 0, 0);
      MTree.insert(e)
    })
    //    MTree.setLeafIndex(MTree.root, 0)
    MTree.calChildrenNum(MTree.root)
    MTree
  }

  //  def getDistanceFromParent(point: Point[Any]): Double = {
  //    val e = new Entry[Int](point, 0, 0);
  //    MTree.getDistanceFromParent(e, MTree.root)
  //  }

  def getPartitionsWithThreshold(key: Point[Any], threshold: Double): List[Point[Any]] = {
    val candidatePartitions = MTree.indexRangeSearch(key, threshold).toList.distinct
    val candidates: ArrayBuffer[Point[Any]] = ArrayBuffer[Point[Any]]()
    candidatePartitions.flatMap(
      index => candidates ++= dataShuffled(index)
    )
  }

  def getResultWithThreshold(key: Point[Any], threshold: Double): List[(Point[Any], Double)] = {
    MTree.RangeSearch(key, threshold).map(x => (x._1.center, x._2)).toList
  }

  //  def getQueryDistanceFromParent(key: Point[Any]): Double = {
  //    val e = new Entry[Int](key, 0, 0);
  //    MTree.getQueryDistanceFromParent(e)
  //  }
  //
  def getEstimatedKNNDist(key: Point[Any], k: Int): Double = {
    MTree.estimatedKNNDist(key, k)
  }
  def deletePoint(key: Point[Any]): Boolean = {
    val e = new Entry[Int](key, 0, 0);
    MTree.remove(e)
  }
  def insertPoint(key: Point[Any]): Unit = {
    val e = new Entry[Int](key, 0, 0);
    MTree.insert(e)
  }

  //  def getCandidatesWithKNN(key: Point[Any], k: Int): List[Point[Any]] = {
  //    val searched = MTree.kNNSearch(key, k);
  //    searched.filter(_._1 != null).map {
  //      case entry: (Entry[Int], Double) => entry._1.center.asInstanceOf[Point[Any]]
  //    }.toList
  //  }

}

object LocalMTreePartitioner {
  def partition(data: Array[Point[Any]]):
  (Array[Array[Point[Any]]], LocalMTreePartitioner) = {
    val partitioner = new LocalMTreePartitioner(data)
    val shuffled = data.groupBy(p => partitioner.getPartition(p))
    val dataShuffled = (0 until partitioner.numPartitions).map(i =>
      shuffled.getOrElse(i, Array.empty[Point[Any]])).toArray
    //    partitioner.dataShuffled = dataShuffled
    (dataShuffled, partitioner)
  }
}