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

package org.apache.spark.sql.execution.amds.partition.global

import org.apache.spark.Partitioner
import org.apache.spark.rdd.{RDD, ShuffledRDD}
import org.apache.spark.sql.catalyst.expressions.amds.common.AMDSConfigConstants
import org.apache.spark.sql.catalyst.expressions.amds.common.shape.{Point, Rectangle, Shape}
import org.apache.spark.sql.execution.amds.index.global.RTree
import org.apache.spark.util.SizeEstimator

import scala.collection.mutable

case class Bounds(min: Array[Double], max: Array[Double])

case class GlobalAMDSPartitioner(numOfPartition: Int,
                                 dimension: Int,
                                 maxEntriesPerNode: Int,
                                 sampleRate: Double,
                                 minSampleSize: Long,
                                 maxSampleSize: Long,
                                 @transient
                                 dataRDD: RDD[_ <: Product2[Point[Any], Any]]) extends Partitioner {
  def indexedPivotCount: Int = AMDSConfigConstants.GLOBAL_INDEXED_PIVOT_COUNT

  override def numPartitions: Int = mbrBounds.length

  var mbrBounds: Array[(Rectangle, Int)] = {
    val (dataBounds, totalCount) = getBoundsAndCount
    val data = getData(totalCount)

    val mbrs = if (numOfPartition > 1) {
      val dimensionCount = new Array[Int](dimension)
      var remaining = numOfPartition.toDouble
      for (i <- 0 until dimension) {
        dimensionCount(i) = Math.ceil(Math.pow(remaining, 1.0 / (dimension - i))).toInt
        remaining /= dimensionCount(i)
      }

      val currentBounds = Bounds(new Array[Double](dimension), new Array[Double](dimension))
      val aa =
        recursiveGroupPoint(dimensionCount, dataBounds, data, currentBounds, 0, dimension - 1)
      aa
    } else {
      if (dataBounds == null) {
        val min = new Array[Double](dimension).map(_ => Double.MaxValue)
        val max = new Array[Double](dimension).map(_ => Double.MinValue)
        Array(Rectangle(Point[Any](Array[Double](0), min), Point[Any](Array[Double](0), max)))
      } else {
        Array(Rectangle(Point[Any](Array[Double](0), dataBounds.min),
          Point[Any](Array[Double](0), dataBounds.max)))
      }
    }

    mbrs.zipWithIndex
  }
  val rTree: RTree = if (mbrBounds.nonEmpty) {
    RTree(mbrBounds.map(x => (x._1, x._2, 1)), maxEntriesPerNode)
  } else {
    null
  }

  override def getPartition(key: Any): Int = {
    if (rTree == null) {
      -1
    } else {
      if (key.isInstanceOf[(Point[Any], Point[Any])]) {
        val k = key.asInstanceOf[(Point[Any], Point[Any])]._2
        val partitions = rTree.circleRange(k, 0.0)
        val partitionNum = partitions((k.coord.toString.hashCode % partitions.length +
          partitions.length) % partitions.length)._2
        partitionNum
      }
      else {
        val k = key.asInstanceOf[Point[Any]]
        val partitions = rTree.circleRange(k, 0.0)
        val partitionNum = partitions((k.coord.toString.hashCode % partitions.length +
          partitions.length) % partitions.length)._2
        partitionNum
      }
    }
  }

  def getBoundsAndCount: (Bounds, Long) = {
    dataRDD.aggregate[(Bounds, Long)]((null, 0))((bound, data) => {
      val new_bound = if (bound._1 == null) {
        Bounds(data._1.coord, data._1.coord)
      } else {
        Bounds(bound._1.min.zip(data._1.coord).map(x => Math.min(x._1, x._2)),
          bound._1.max.zip(data._1.coord).map(x => Math.max(x._1, x._2)))
      }
      (new_bound, bound._2 + SizeEstimator.estimate(data._1))
    }, (left, right) => {
      val new_bound = {
        if (left._1 == null) right._1
        else if (right._1 == null) left._1
        else {
          Bounds(left._1.min.zip(right._1.min).map(x => Math.min(x._1, x._2)),
            left._1.max.zip(right._1.max).map(x => Math.max(x._1, x._2)))
        }
      }
      (new_bound, left._2 + right._2)
    })
  }

  def recursiveGroupPoint(dimensionCount: Array[Int], dataBounds: Bounds,
                          entries: Array[Point[Any]], currentBounds: Bounds,
                          currentDimension: Int, untilDimension: Int): Array[Rectangle] = {
    var ans = mutable.ArrayBuffer[Rectangle]()
    if (entries.isEmpty) {
      return ans.toArray
    }

    val len = entries.length.toDouble
    val grouped = entries.sortWith(_.coord(currentDimension) < _.coord(currentDimension))
      .grouped(Math.ceil(len / dimensionCount(currentDimension)).toInt).toArray
    if (currentDimension < untilDimension) {
      for (i <- grouped.indices) {
        if (i == 0 && i == grouped.length - 1) {
          currentBounds.min(currentDimension) = dataBounds.min(currentDimension)
          currentBounds.max(currentDimension) = dataBounds.max(currentDimension)
        } else if (i == 0) {
          currentBounds.min(currentDimension) = dataBounds.min(currentDimension)
          currentBounds.max(currentDimension) = grouped(i + 1).head.coord(currentDimension)
        } else if (i == grouped.length - 1) {
          currentBounds.min(currentDimension) = grouped(i).head.coord(currentDimension)
          currentBounds.max(currentDimension) = dataBounds.max(currentDimension)
        } else {
          currentBounds.min(currentDimension) = grouped(i).head.coord(currentDimension)
          currentBounds.max(currentDimension) = grouped(i + 1).head.coord(currentDimension)
        }
        ans ++= recursiveGroupPoint(dimensionCount, dataBounds, grouped(i),
          currentBounds, currentDimension + 1, untilDimension)
      }
      ans.toArray
    } else {
      for (i <- grouped.indices) {
        if (i == 0 && i == grouped.length - 1) {
          currentBounds.min(currentDimension) = dataBounds.min(currentDimension)
          currentBounds.max(currentDimension) = dataBounds.max(currentDimension)
        } else if (i == 0) {
          currentBounds.min(currentDimension) = dataBounds.min(currentDimension)
          currentBounds.max(currentDimension) = grouped(i + 1).head.coord(currentDimension)
        } else if (i == grouped.length - 1) {
          currentBounds.min(currentDimension) = grouped(i).head.coord(currentDimension)
          currentBounds.max(currentDimension) = dataBounds.max(currentDimension)
        } else {
          currentBounds.min(currentDimension) = grouped(i).head.coord(currentDimension)
          currentBounds.max(currentDimension) = grouped(i + 1).head.coord(currentDimension)
        }
        ans += Rectangle(Point[Any](Array[Double](0), currentBounds.min.clone()),
          Point[Any](Array[Double](0), currentBounds.max.clone()))
      }
      ans.toArray
    }
  }

  def getData(totalCount: Long): Array[Point[Any]] = {
    val seed = System.currentTimeMillis()
    if (totalCount <= minSampleSize) {
      dataRDD.map(_._1).collect()
    } else if (totalCount * sampleRate <= maxSampleSize) {
      dataRDD.sample(withReplacement = false, sampleRate, seed).map(_._1).collect()
    } else {
      dataRDD.sample(withReplacement = false,
        maxSampleSize.toDouble / totalCount, seed).map(_._1).collect()
    }
  }

  //  def getPartitionsWithThreshold(key: Any, threshold: Double): List[Int] = {
  //    val pivotDist = (0 until pivots.length).map(p => pivots(p)
  //    .minDist(key.asInstanceOf[Point[Any]]))
  //    pivotDist.zipWithIndex.map { case (dist, index) =>
  //      if (dist <= threshold + maxPivotDistance(index)) {
  //        index
  //      } else {
  //        -1
  //      }
  //    }.filter(_ != -1).toList
  //  }
  def getPartitionsWithThreshold(key: Any, threshold: Double): List[(Shape, Int)] = {
    if (rTree == null) {
      List.empty
    } else {
      val k = key.asInstanceOf[Point[Any]]
      rTree.circleRange(k, threshold)
    }
  }


}

object GlobalAMDSPartitioner {
  private val sampleRate = AMDSConfigConstants.SAMPLE_RATE
  private val minSampleSize = AMDSConfigConstants.MIN_SAMPLE_SIZE
  private val maxSampleSize = AMDSConfigConstants.MAX_SAMPLE_SIZE
  private val maxEntriesPerNode = AMDSConfigConstants.GLOBAL_MAX_ENTRIES_PER_NODE

  def partition(dataRDD: RDD[Point[Any]]):
  (RDD[Point[Any]], GlobalAMDSPartitioner) = {
    val pairedDataRDD = dataRDD.map(x => (x, None))
    val numOfPartition = AMDSConfigConstants.GLOBAL_NUM_PARTITIONS
    val dimension = dataRDD.first().coord.length
    val partitioner = new GlobalAMDSPartitioner(numOfPartition, dimension,
      maxEntriesPerNode, sampleRate, minSampleSize, maxSampleSize, pairedDataRDD)

    //    val ss = dataRDD.collect().map(x => partitioner.getPartition(x))

    val shuffled = new ShuffledRDD[Point[Any], Any, Any](pairedDataRDD, partitioner)
    (shuffled.map(_._1), partitioner)
  }


}
