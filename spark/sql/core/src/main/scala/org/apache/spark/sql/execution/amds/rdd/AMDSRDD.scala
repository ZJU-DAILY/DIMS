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

package org.apache.spark.sql.execution.amds.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.expressions.amds.PackedPartition
import org.apache.spark.sql.catalyst.expressions.amds.common.AMDSConfigConstants
import org.apache.spark.sql.catalyst.expressions.amds.common.metric.MetricData
import org.apache.spark.sql.catalyst.expressions.amds.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.amds.index.{GlobalIndex, LocalIndex}
import org.apache.spark.sql.execution.amds.index.global.GlobalAMDSIndex
import org.apache.spark.sql.execution.amds.index.local.LocalAMDSIndex
import org.apache.spark.sql.execution.amds.partition.global.GlobalAMDSPartitioner
import org.apache.spark.storage.StorageLevel
import org.apache.spark.util.SizeEstimator
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.mutable.ArrayBuffer

class AMDSRDD(dataRDD: RDD[Point[Any]]) {
  val LOG: Logger = LoggerFactory.getLogger(getClass)

  var packedRDD: RDD[PackedPartition] = _
  var globalIndex: GlobalIndex = _

  var globalPivots: Array[Point[Any]] = _

  private def buildIndex(): Unit = {
    var start = System.currentTimeMillis()
    var end = start

    // get tree partition


    val seed = System.currentTimeMillis()
    val totalCount = SizeEstimator.estimate(dataRDD)
    val sampledRDD = if (totalCount <= AMDSConfigConstants.SAMPLE_SIZE) {
      dataRDD.collect()
    }
    else {
      dataRDD.sample(withReplacement = false,
        AMDSConfigConstants.SAMPLE_SIZE.toDouble / totalCount, seed)
        .collect()
    }
    val metric = MetricData(sampledRDD)
    val pivots = metric.getGlobalIndexedPivot
    globalPivots = pivots
    val newRDD = dataRDD.map(x => {
      val pivotDistance = pivots.indices.map(i => pivots(i).minDist(x.origin)).toArray
      x.coord = pivotDistance
      x
    })

    start = System.currentTimeMillis()
    val (partitionedRDD, partitioner) = GlobalAMDSPartitioner.partition(newRDD)
    end = System.currentTimeMillis()
    LOG.warn(s"AMDS Partitioning Time: ${end - start} ms")

    // build local index
    start = System.currentTimeMillis()
    packedRDD = partitionedRDD.mapPartitionsWithIndex { case (index, iter) =>
      val data = iter.toArray
      val indexes = ArrayBuffer.empty[LocalIndex]
      indexes.append(LocalAMDSIndex.buildIndex(data))
      Array(PackedPartition(index, data, indexes.toArray)).iterator
    }
    packedRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
    packedRDD.count()
    end = System.currentTimeMillis()
    LOG.warn(s"Building Local Index Time: ${end - start} ms")

    // log statistics
    val partitionSizes = packedRDD.mapPartitions(iter => iter.map(_.data.length)).collect()
    LOG.warn(s"Tree Partitions Count: ${partitionSizes.length}")
    LOG.warn(s"Tree Partitions Sizes: ${partitionSizes.mkString(",")}")
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
    val globalTreeIndex = GlobalAMDSIndex(partitioner)
    globalIndex = globalTreeIndex
    end = System.currentTimeMillis()
    LOG.warn(s"Building Global Index Time: ${end - start} ms")
  }

  buildIndex()
}