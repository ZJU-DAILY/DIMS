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
package org.apache.spark.sql.execution.dims.partition.global

import org.apache.spark.Partitioner
import org.apache.spark.rdd.{RDD, ShuffledRDD}
import org.apache.spark.sql.catalyst.expressions.dims.common.DIMSConfigConstants
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import org.apache.spark.sql.execution.dims.index.global.MemoryBPlusTree
import org.apache.spark.util.SizeEstimator

import scala.collection.mutable.ArrayBuffer
import scala.math.max

case class GlobalBPlusTreePartitioner(@transient dataKeyValuePair
                                      : RDD[_ <: Product2[(Double, Point[Any]), Any]],
                                      sampleSize: Long)
  extends Partitioner {
  val BPlusTree = buildBPlusTree()
  //  var dataShuffled: RDD[Point] = _

  private def buildBPlusTree(): MemoryBPlusTree[Double, Any] = {
    val totalCount = SizeEstimator.estimate(dataKeyValuePair)
    val data = getData(totalCount)
    val bPlusTree = new MemoryBPlusTree[Double, Any](DIMSConfigConstants.GlobalBPlusTreeOrder)
    data.foreach(x => bPlusTree.insertKeys(x._1))
    bPlusTree.setLeafIndex()
    bPlusTree
  }

  def getData(totalCount: Long): Array[(Double, Point[Any])] = {
    val seed = System.currentTimeMillis()
    if (totalCount <= sampleSize) {
      dataKeyValuePair.map(_._1).collect()
    } else {
      dataKeyValuePair.sample(withReplacement = false,
        sampleSize.toDouble / totalCount, seed).map(x => x._1).collect()
    }
  }

  override def numPartitions: Int = BPlusTree.getNumLeaf

  override def getPartition(key: Any): Int = {
    val k = key.asInstanceOf[(Double, Point[Any])]
    val exactPartition = BPlusTree.samplelookup(k._1)
    exactPartition._2 match {
      case Some(x) => x.asInstanceOf[Int]
    }

    //    else {
    //      val lowerBoundReturn1 = BPlusTree.greatestLessThan(k._1.toInt)
    //      val lowerBoundReturn2 = BPlusTree.leastGreaterThan(k._1.toInt)
    //      if (!lowerBoundReturn1.isEmpty) {
    //        return lowerBoundReturn1.get._2.asInstanceOf[Int]
    //      }
    //      else if (!lowerBoundReturn2.isEmpty) {
    //        return lowerBoundReturn2.get._2.asInstanceOf[Int]
    //      }
    //      else {
    //        return -1
    //      }
    //    }
    //    exactPartition.asInstanceOf[Int]
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

  //  def getCandidatesWithThreshold(key: Point, threshold: Double,
  //                                 distanceFromParent: Double): List[Point] = {
  //    val lowerBound = max(0, distanceFromParent - threshold)
  //    val upperBound = distanceFromParent + threshold
  //    searchBPlusTree(lowerBound.toInt, upperBound.toInt)
  //  }

  def getCandidatesIntWithThreshold(key: Point[Any], threshold: Double,
                                    distanceFromParent: Double): List[Int] = {
    val lowerBound = max(0, distanceFromParent - threshold)
    val upperBound = distanceFromParent + threshold
    searchBPlusTreeCandidate(lowerBound.toInt, upperBound.toInt)
  }
}

object GlobalBPlusTreePartitioner {
  private val sampleSize = DIMSConfigConstants.SAMPLE_SIZE

  def partition(dataKeyValuePair: RDD[(Double, Point[Any])]):
  (RDD[Point[Any]], GlobalBPlusTreePartitioner) = {
    val pairedDataRDD = dataKeyValuePair.map(x => (x, None))
    val partitioner = new GlobalBPlusTreePartitioner(pairedDataRDD,
      sampleSize)
//    val aaa = dataKeyValuePair.collect().map(_ => partitioner.getPartition(_))
    val shuffled = new ShuffledRDD[(Double, Point[Any]), Any, Any](
      pairedDataRDD, partitioner).map(_._1._2)
    //    partitioner.dataShuffled = shuffled
    (shuffled, partitioner)
  }
}
