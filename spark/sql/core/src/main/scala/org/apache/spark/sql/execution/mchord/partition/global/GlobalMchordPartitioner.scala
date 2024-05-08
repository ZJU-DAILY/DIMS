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

package org.apache.spark.sql.execution.mchord.partition.global

import org.apache.spark.Partitioner
import org.apache.spark.rdd.{RDD, ShuffledRDD}
import org.apache.spark.sql.catalyst.expressions.mchord.common.MchordConfigConstants
import org.apache.spark.sql.catalyst.expressions.mchord.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.mchord.common.metric.MetricData

import scala.collection.mutable.ArrayBuffer

case class GlobalMchordPartitioner(numOfPartition: Int,
                                   pivots: Array[Point[Any]]) extends Partitioner {
  def indexedPivotCount: Int = MchordConfigConstants.GLOBAL_INDEXED_PIVOT_COUNT

  override def numPartitions: Int = numOfPartition

  override def getPartition(key: Any): Int = {
    key.asInstanceOf[(Int, Long, Point[Any])]._1
  }

  def getPartitionsWithThreshold(key: Any, threshold: Double): List[Int] = {
    val pivotDist = (0 until pivots.length).
      map(p => pivots(p).minDist(key.asInstanceOf[Point[Any]]))
    pivotDist.zipWithIndex.map { case (dist, index) =>
      if (dist <= threshold + MchordConfigConstants.iDistanceConstant) {
        index
      } else {
        -1
      }
    }.filter(_ != -1).toList
  }


}

object GlobalMchordPartitioner {
  def partition(dataRDD: RDD[(Int, Int, Point[Any])], pivotsIn: Array[Point[Any]]):
  (RDD[(Int, Point[Any])], GlobalMchordPartitioner) = {
    // get tree partitioner
    val totalCluster = MchordConfigConstants.GLOBAL_INDEXED_PIVOT_COUNT
    val partitioner = new GlobalMchordPartitioner(totalCluster, pivotsIn)
    // shuffle
    val pairedDataRDD = dataRDD.map(x => {
      (x, None)
    })
    // : shuffled key value pair = [Point[Any], Any,Any]?
    //    val shuffled = new ShuffledRDD[Int, Point[Any], Any](pairedDataRDD, partitioner)
    val shuffled = new ShuffledRDD[(Int, Int, Point[Any]), Any, Any](pairedDataRDD, partitioner)
    (shuffled.map(x => (x._1._2, x._1._3)), partitioner)
  }

}
