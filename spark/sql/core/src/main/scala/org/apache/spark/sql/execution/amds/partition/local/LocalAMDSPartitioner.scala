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
package org.apache.spark.sql.execution.amds.partition.local

import org.apache.spark.Partitioner
import org.apache.spark.sql.catalyst.expressions.amds.common.AMDSConfigConstants
import org.apache.spark.sql.catalyst.expressions.amds.common.shape.Point
import org.apache.spark.sql.execution.amds.index.local.MTree
import org.apache.spark.sql.execution.amds.index.local.Entry

import scala.collection.mutable.ArrayBuffer
import scala.math.{max, min, pow}

case class LocalAMDSPartitioner(data: Array[Point[Any]]) extends Partitioner {
  val MTree = buildMTree()
  var dataShuffled: Array[Array[Point[Any]]] = _
  var firstPoint: Point[Any] = _

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
    val MTree = new MTree[Int](InnerOrder = AMDSConfigConstants.M_TREE_INNER_ORDER,
      LeafOrder = AMDSConfigConstants.M_TREE_LEAF_ORDER);
    data.foreach(point => {
      val e = new Entry[Int](point, 0, 0);
      MTree.insert(e)
    })
    MTree.setLeafIndex(MTree.root, 0)
    MTree.calChildrenNum(MTree.root)
    MTree
  }

  //  def getDistanceFromParent(point: Point[Any]): Double = {
  //    val e = new Entry[Int](point, 0, 0);
  //    MTree.getDistanceFromParent(e, MTree.root)
  //  }

  def getPartitionsWithThreshold(key: Point[Any],
                                 threshold: Double): List[Point[Any]] = {
    val candidatePartitions = MTree.indexRangeSearch(key, threshold).toList.distinct
    val candidates: ArrayBuffer[Point[Any]] = ArrayBuffer[Point[Any]]()
    val res = candidatePartitions.flatMap(
      index => candidates ++= dataShuffled(index)
    )
    res
  }

  def getResultWithThreshold(key: Point[Any], threshold: Double): List[(Point[Any], Double)] = {
    MTree.RangeSearch(key, threshold).map(x => (x._1.center, x._2)).toList
  }

  def deletePoint(point: Point[Any]): List[(Point[Any], Double)] = {
    val e = new Entry[Int](point, 0, 0);
    //    val partitionIndex = getPartition(point)
    val res = MTree.remove(e)
    MTree.setLeafIndex(MTree.root, 0)
    //    dataShuffled(partitionIndex) = dataShuffled(partitionIndex).filter(_ != point)
    List[(Point[Any], Double)]()
  }

  def insertPoint(point: Point[Any]): List[(Point[Any], Double)] = {
    val e = new Entry[Int](point, 0, 0);
    MTree.insert(e)
    MTree.setLeafIndex(MTree.root, 0)
    //    val partitionIndex = getPartition(point)
    //    dataShuffled(partitionIndex) = dataShuffled(partitionIndex) :+ point
    List[(Point[Any], Double)]()
  }

  //  def getQueryDistanceFromParent(key: Point[Any]): Double = {
  //    val e = new Entry[Int](key, 0, 0);
  //    MTree.getQueryDistanceFromParent(e)
  //  }
  //
  def getEstimatedKNNDist(key: Point[Any], k: Int): Double = {
    MTree.estimatedKNNDist(key, k)
  }

  //  def getCandidatesWithKNN(key: Point[Any], k: Int): List[Point[Any]] = {
  //    val searched = MTree.kNNSearch(key, k);
  //    searched.filter(_._1 != null).map {
  //      case entry: (Entry[Int], Double) => entry._1.center.asInstanceOf[Point[Any]]
  //    }.toList
  //  }

}

object LocalAMDSPartitioner {
  def partition(data: Array[Point[Any]]):
  (LocalAMDSPartitioner) = {
    val partitioner = new LocalAMDSPartitioner(data)
    //    partitioner.firstPoint = data(0)
    //    val shuffled = data.groupBy(x => partitioner.getPartition(x))
    //    val dataShuffled = (0 until partitioner.numPartitions).map(i =>
    //      shuffled.getOrElse(i, Array.empty[Point[Any]])).toArray
    //    partitioner.dataShuffled = dataShuffled
    (partitioner)
  }
}