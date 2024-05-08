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

package org.apache.spark.sql.execution.mchord.rdd

import com.codahale.metrics.Metric
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.expressions.mchord.PackedPartition
import org.apache.spark.sql.catalyst.expressions.mchord.common.metric.MetricData
import org.apache.spark.sql.catalyst.expressions.mchord.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.mchord.common.MchordConfigConstants
import org.apache.spark.sql.catalyst.expressions.mchord.index.{GlobalIndex, LocalIndex}
import org.apache.spark.sql.execution.mchord.index.global.GlobalMchordIndex
import org.apache.spark.sql.execution.mchord.index.local.LocalMchordIndex
import org.apache.spark.sql.execution.mchord.partition.global.GlobalMchordPartitioner
import org.apache.spark.storage.StorageLevel
import org.apache.spark.util.SizeEstimator
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.mutable.ArrayBuffer

class MchordRDD(dataRDD: RDD[Point[Any]]) {
  val LOG: Logger = LoggerFactory.getLogger(getClass)

  var packedRDD: RDD[PackedPartition] = _
  var globalPivots: Array[Point[Any]] = _
  var globalIndex: GlobalIndex = _
//  var maxPivotDistance: List[Double] = _


  private def buildIndex(): Unit = {
    var start = System.currentTimeMillis()
    var end = start

    // get partition
    start = System.currentTimeMillis()
    //    val metricDataArray = dataRDD.collect()
    //    val metric = MetricData(metricDataArray)
    //    val pivots = dataRDD.first().getGlobalPivot
    val seed = System.currentTimeMillis()
    val totalCount = SizeEstimator.estimate(dataRDD)
    val sampledRDD = if (totalCount <= MchordConfigConstants.SAMPLE_SIZE) {
      dataRDD.collect()
    }
    else {
      dataRDD.sample(withReplacement = false,
        MchordConfigConstants.SAMPLE_SIZE.toDouble / totalCount, seed)
        .collect()
    }
    val metric = MetricData(sampledRDD)
    val pivots = metric.getGlobalIndexedPivot
    globalPivots = pivots
    end = System.currentTimeMillis()

    val pairRDD = dataRDD.map(x => {
      val dist = pivots.indices.map(i => pivots(i).minDist(x))
      val index = dist.indexOf(dist.min)
      val iDis = index * MchordConfigConstants.iDistanceConstant + dist(index)
      (index, iDis.toInt, x)
    })


    start = System.currentTimeMillis()
    val (partitionedRDD, partitioner) = GlobalMchordPartitioner.partition(pairRDD, pivots)
    end = System.currentTimeMillis()
    LOG.warn(s"Mchord Partitioning Time: ${end - start} ms")

    // build local index
    start = System.currentTimeMillis()
    packedRDD = partitionedRDD.mapPartitionsWithIndex { case (index, iter) =>
      val data = iter.toArray
      val indexes = ArrayBuffer.empty[LocalIndex]
      indexes.append(LocalMchordIndex.buildIndex(data))
      Array(PackedPartition(index, data, indexes.toArray)).iterator
    }
    packedRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
    packedRDD.count()
    end = System.currentTimeMillis()
    LOG.warn(s"Building Local Index Time: ${end - start} ms")

    // log statistics
    val partitionSizes = packedRDD.mapPartitions(iter => iter.map(_.data.length)).collect()
    LOG.warn(s"Local Partitions Count: ${partitionSizes.length}")
    LOG.warn(s"Local Partitions Sizes: ${partitionSizes.mkString(",")}")
    LOG.warn(s"Max Partition Size: ${partitionSizes.max}")
    LOG.warn(s"Min Partition Size: ${partitionSizes.min}")
    LOG.warn(s"Avg Partition Size: ${partitionSizes.sum / partitionSizes.length}")
    val sortedPartitionSizes = partitionSizes.sorted
    LOG.warn(s"5% Partition Size: ${sortedPartitionSizes((partitionSizes.length * 0.05).toInt)}")
    LOG.warn(s"25% Partition Size: ${sortedPartitionSizes((partitionSizes.length * 0.25).toInt)}")
    LOG.warn(s"50% Partition Size: ${sortedPartitionSizes((partitionSizes.length * 0.5).toInt)}")
    LOG.warn(s"75% Partition Size: ${sortedPartitionSizes((partitionSizes.length * 0.75).toInt)}")
    LOG.warn(s"95% Partition Size: ${sortedPartitionSizes((partitionSizes.length * 0.95).toInt)}")

    // build global index
    start = System.currentTimeMillis()
    val globalTreeIndex = GlobalMchordIndex(partitioner)
    globalIndex = globalTreeIndex
    end = System.currentTimeMillis()
    LOG.warn(s"Building Global Index Time: ${end - start} ms")
  }

  buildIndex()


}