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

case class LocalDIMSPartitioner(dataKeyValuePair: Array[(Double, Point[Any])]) extends Partitioner {
  val BPlusTree = buildBPlusTree()
  var dataShuffled: Array[Array[Point[Any]]] = _

  private def buildBPlusTree(): MemoryBPlusTree[Double, Any] = {
    val bPlusTree = new MemoryBPlusTree[Double, Any](DIMSConfigConstants.BPlusTreeOrder)
    dataKeyValuePair.foreach(x => bPlusTree.insertKeys(x._1))
    bPlusTree.setLeafIndex()
    bPlusTree
  }

  override def numPartitions: Int = BPlusTree.getNumLeaf

//  def getNumLeaf: Int = numPartitions

  override def getPartition(key: Any): Int = {
    val k = key.asInstanceOf[(Double, Point[Any])]
    val exactPartition = BPlusTree.search(k._1).get
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


  def searchBPlusTreeCandidate(lowerBound: Int, upperBound: Int):
  List[Int] = {
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
        val candidates: ArrayBuffer[Int] = ArrayBuffer[Int]()
        for (i <- lowerIndex until (upperIndex + 1)) {
          candidates += i
        }
        candidates.toList
      }
      else {
        val candidates = List[Int](upperIndex)
        candidates
      }
    }
    else if (lowerIndex != (-1)) {
      val candidates = List[Int](lowerIndex)
      candidates
    }
    else if (upperIndex != (-1)) {
      val candidates = List[Int](upperIndex)
      candidates
    }
    else {
      List.empty
    }
  }

  def getCandidatesWithThreshold(key: Point[Any], threshold: Double,
                                 distanceFromParent: Double): List[Point[Any]] = {
    val lowerBound = max(0, distanceFromParent - threshold)
    val upperBound = distanceFromParent + threshold
    searchBPlusTree(lowerBound.toInt, upperBound.toInt)
  }

  def getCandidatesIntWithThreshold(key: Point[Any], threshold: Double,
                                    distanceFromParent: Double): List[Int] = {
    val lowerBound = max(0, distanceFromParent - threshold)
    val upperBound = distanceFromParent + threshold
    searchBPlusTreeCandidate(lowerBound.toInt, upperBound.toInt)
  }
}

object LocalDIMSPartitioner {
  def partition(dataKeyValuePair: Array[(Double, Point[Any])]):
  (Array[Array[Point[Any]]], LocalDIMSPartitioner) = {
    val partitioner = new LocalDIMSPartitioner(dataKeyValuePair)
    val shuffled = dataKeyValuePair.groupBy(p => partitioner.getPartition(p))
    val dataShuffled = (0 until partitioner.numPartitions).map(i =>
      shuffled.getOrElse(i, Array.empty).map(x => x._2)).toArray
    partitioner.dataShuffled = dataShuffled
    (dataShuffled, partitioner)
  }


}
