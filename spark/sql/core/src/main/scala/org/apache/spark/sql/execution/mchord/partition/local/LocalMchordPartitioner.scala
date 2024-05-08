/*
 *  Copyright 2017 by DITA Project
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
package org.apache.spark.sql.execution.mchord.partition.local

import org.apache.spark.Partitioner
import org.apache.spark.sql.catalyst.expressions.mchord.common.MchordConfigConstants
import org.apache.spark.sql.catalyst.expressions.mchord.common.shape.Point
import org.apache.spark.sql.execution.mchord.index.local.MemoryBPlusTree

import scala.math.{max, min}
import scala.collection.mutable.ArrayBuffer

case class LocalMchordPartitioner(data: Array[(Int, Point[Any])]) extends Partitioner {
  val BPlusTree = buildBPlusTree()
  var dataShuffled: Array[Array[Point[Any]]] = _


  private def buildBPlusTree(): MemoryBPlusTree[Int, Any] = {
    val bPlusTree = new MemoryBPlusTree[Int, Any](MchordConfigConstants.BPlusTreeOrder)
    data.foreach(point => bPlusTree.insertKeys(point._1))
    bPlusTree.setLeafIndex()
    bPlusTree
  }

  override def numPartitions: Int = BPlusTree.getNumLeaf

  override def getPartition(key: Any): Int = {
    val k = key.asInstanceOf[(Int, Point[Any])]
    //    val upperReturn = BPlusTree.leastGreaterThan(k.getIDistanceKey)
    //    val lowerReturn = BPlusTree.greatestLessThan(k.getIDistanceKey)
    //    println("++++++++++++++++++++++++++++")
    //    println(k.getIDistanceKey)
    //    println(upperReturn)
    //    println(lowerReturn)

    //    val upperBound = upperReturn.get._2
    //    val lowerBound = lowerReturn.get._2
    val exactPartition = BPlusTree.search(k._1).get
    //    println(exactPartition)
    exactPartition.asInstanceOf[Int]
  }

  def searchBPlusTree(lowerBound: Int, upperBound: Int):
  List[Point[Any]] = {
    val lowerBoundReturn1 = BPlusTree.greatestLessThan(lowerBound.toInt)
    val lowerBoundReturn2 = BPlusTree.leastGreaterThan(lowerBound.toInt)
    val upperBoundReturn1 = BPlusTree.greatestLessThan(upperBound.toInt)
    val upperBoundReturn2 = BPlusTree.leastGreaterThan(upperBound.toInt)

    var lowerIndex = -1
    var upperIndex = -1

    if (!lowerBoundReturn1.isEmpty) {
      lowerIndex = lowerBoundReturn1.get._2.asInstanceOf[Int]
    }
    else if (!lowerBoundReturn2.isEmpty) {
      lowerIndex = lowerBoundReturn2.get._2.asInstanceOf[Int]
    }
    else {
      lowerIndex = -1
    }
    if (!upperBoundReturn2.isEmpty) {
      upperIndex = upperBoundReturn2.get._2.asInstanceOf[Int]
    }
    else if (!upperBoundReturn1.isEmpty) {
      upperIndex = upperBoundReturn1.get._2.asInstanceOf[Int]
    }
    else {
      upperIndex = -1
    }

    if (lowerIndex != (-1) && upperIndex != (-1)) {
      if (lowerIndex < upperIndex) {
        val candidates: ArrayBuffer[Point[Any]] = ArrayBuffer[Point[Any]]()
        for (i <- lowerIndex until (upperIndex + 1)) {
          candidates ++= dataShuffled(i)
        }
        candidates.toList
      }
      else {
        val candidates = dataShuffled(upperIndex).toList
        candidates
      }
    }
    else if (lowerIndex != (-1)) {
      val candidates = dataShuffled(lowerIndex).toList
      candidates
    }
    else if (upperIndex != (-1)) {
      val candidates = dataShuffled(upperIndex).toList
      candidates
    }
    else {
      List.empty
    }
  }

  //  def getCandidates(key: Point[Any]): List[Point[Any]] = {
  //    val upperReturn = BPlusTree.leastGreaterThan(key.getIDistanceKey)
  //    val lowerReturn = BPlusTree.greatestLessThan(key.getIDistanceKey)
  //    val upperBound = upperReturn.get._2.asInstanceOf[Int]
  //    val lowerBound = lowerReturn.get._2.asInstanceOf[Int]
  //    if (upperBound == lowerBound) {
  //      return dataShuffled(upperBound).toList
  //    }
  //    val candidates = (dataShuffled(upperBound) ++
  //      dataShuffled(lowerBound)).toList
  //    candidates
  //  }

  def deletePoint(id: Int,
                  key: Point[Any],
                  globalPivots: Array[Point[Any]]): List[(Point[Any], Double)] = {
    val pivotIndex = id
    val pivotDist = key.minDist(globalPivots(id))
    val iDis = pivotIndex * MchordConfigConstants.iDistanceConstant + pivotDist
    val partitionIndex = getPartition((iDis.toInt, key))
    dataShuffled(partitionIndex) = dataShuffled(partitionIndex).filter(_ != key)
    BPlusTree.delete(iDis.toInt)
    BPlusTree.setLeafIndex()
    List[(Point[Any], Double)]()
  }

  def insertPoint(id: Int,
                  key: Point[Any],
                  globalPivots: Array[Point[Any]]): List[(Point[Any], Double)] = {
    val pivotIndex = id
    val pivotDist = key.minDist(globalPivots(id))
    val iDis = pivotIndex * MchordConfigConstants.iDistanceConstant + pivotDist
    BPlusTree.insertKeys(iDis.toInt)
    BPlusTree.setLeafIndex()
    val partitionIndex = getPartition((iDis.toInt, key))
    dataShuffled(partitionIndex) = dataShuffled(partitionIndex) :+ key
    List[(Point[Any], Double)]()
  }

  def getCandidatesWithThreshold(id: Int, key: Point[Any], threshold: Double,
                                 globalPivots: Array[Point[Any]]): List[Point[Any]] = {
    val pivotIndex = id
    val pivotDist = key.minDist(globalPivots(id))
    val lowerBound = max(
      pivotDist + pivotIndex * MchordConfigConstants.iDistanceConstant - threshold,
      pivotIndex * MchordConfigConstants.iDistanceConstant)
    val upperBound = min(
      pivotDist + pivotIndex * MchordConfigConstants.iDistanceConstant + threshold,
      MchordConfigConstants.iDistanceConstant * (pivotIndex + 1))
    searchBPlusTree(lowerBound.toInt, upperBound.toInt)
  }

  def getCandidatesWithThreshold(id: Int, key: Point[Any], threshold: Double,
                                 thresholdOld: Double, globalPivots: Array[Point[Any]]):
  List[Point[Any]] = {
    //    val samplePoint = data.take(1)(0)
    //    val pivotIndex = samplePoint.getGlobalIndex
    //    val pivotDist = key.minDist(samplePoint.getGlobalPivot(pivotIndex))
    val pivotIndex = id
    val pivotDist = key.minDist(globalPivots(id))
    val lowerBound = max(
      pivotDist + pivotIndex * MchordConfigConstants.iDistanceConstant - threshold,
      pivotIndex * MchordConfigConstants.iDistanceConstant)
    val upperBound = min(
      pivotDist + pivotIndex * MchordConfigConstants.iDistanceConstant + threshold,
      MchordConfigConstants.iDistanceConstant * (pivotIndex + 1))

    val lowerBoundOld = max(
      pivotDist + pivotIndex * MchordConfigConstants.iDistanceConstant - thresholdOld,
      pivotIndex * MchordConfigConstants.iDistanceConstant)
    val upperBoundOld = min(
      pivotDist + pivotIndex * MchordConfigConstants.iDistanceConstant + thresholdOld,
      MchordConfigConstants.iDistanceConstant * (pivotIndex + 1))
    if (upperBoundOld == upperBound) {
      val ans = searchBPlusTree(lowerBound.toInt, upperBoundOld.toInt)
      ans
    } else {
      val ans = searchBPlusTree(lowerBound.toInt, lowerBoundOld.toInt) ++
        searchBPlusTree(upperBoundOld.toInt, upperBound.toInt)
      ans
    }
  }
}

object LocalMchordPartitioner {
  def partition(data: Array[(Int, Point[Any])]):
  (Array[Array[Point[Any]]], LocalMchordPartitioner) = {
    val partitioner = new LocalMchordPartitioner(data)
    val shuffled = data.groupBy(p => partitioner.getPartition(p))
    val dataShuffled = (0 until partitioner.numPartitions).map(i =>
      shuffled.getOrElse(i, Array.empty).map(x => x._2)).toArray
    partitioner.dataShuffled = dataShuffled
    (dataShuffled, partitioner)
  }
}