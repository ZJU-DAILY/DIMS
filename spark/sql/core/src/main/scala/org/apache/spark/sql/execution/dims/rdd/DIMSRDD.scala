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

package org.apache.spark.sql.execution.dims.rdd

import com.codahale.metrics.Metric
import org.apache.spark.HashPartitioner
import org.apache.spark.rdd.{RDD, ShuffledRDD}
import org.apache.spark.sql.catalyst.expressions.dims.BPlusPackedPartition
import org.apache.spark.sql.catalyst.expressions.dims.PackedPartition
import org.apache.spark.sql.catalyst.expressions.dims.common.metric.MetricData
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.dims.common.DIMSConfigConstants
import org.apache.spark.sql.catalyst.expressions.dims.index.{GlobalIndex, LocalIndex}
import org.apache.spark.sql.execution.dims.index.global.GlobalDIMSIndex
import org.apache.spark.sql.execution.dims.index.global.GlobalBPlusTreeIndex
import org.apache.spark.sql.execution.dims.index.local.LocalDIMSIndex
import org.apache.spark.sql.execution.dims.index.local.LocalMTreeIndex
import org.apache.spark.sql.execution.dims.index.local.LocalPivotIndex
import org.apache.spark.sql.execution.dims.index.local.LocalSimpleIndex
import org.apache.spark.sql.execution.dims.partition.global.GlobalBPlusTreePartitioner
import org.apache.spark.sql.execution.dims.partition.global.GlobalDIMSPartitioner
import org.apache.spark.sql.execution.dims.partition.local.KeyPartitioner
import org.apache.spark.storage.StorageLevel
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.mutable.ArrayBuffer

class DIMSRDD(dataRDD: RDD[Point[Any]]) {
  val LOG: Logger = LoggerFactory.getLogger(getClass)

  var packedRDD: RDD[PackedPartition] = _
  var newPackedRDD: RDD[Point[Any]] = _
  var finalPackedRDD: RDD[PackedPartition] = _
  var globalBPlusRDD: RDD[PackedPartition] = _
  var globalIndex: GlobalIndex = _
  var globalBPlusTreeIndex: GlobalIndex = _
  var numOfLocalPartition: Int = _

  private def buildIndex(): Unit = {
    var start = System.currentTimeMillis()
    var end = start

    // get partition
    start = System.currentTimeMillis()
    val (partitionedRDD, partitioner) = GlobalDIMSPartitioner.partition(dataRDD)
    end = System.currentTimeMillis()
    LOG.warn(s"DIMS Partitioning Time1: ${end - start} ms")

    // build local index
    start = System.currentTimeMillis()

    DIMSConfigConstants.DIMS_MODE match {
      case 1 =>
        packedRDD = partitionedRDD.mapPartitionsWithIndex { case (index, iter) =>
          val data = iter.toArray
          val dataKeyValuePair = data.map(x => (partitioner.getDistanceFromParent(x), x))
          val indexes = ArrayBuffer.empty[LocalIndex]
          val localIndex = LocalDIMSIndex.buildIndex(dataKeyValuePair)
          indexes.append(localIndex)
          Array(PackedPartition(index, dataKeyValuePair, indexes.toArray)).iterator
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
        val globalTreeIndex = GlobalDIMSIndex(partitioner)
        globalIndex = globalTreeIndex
        end = System.currentTimeMillis()
        LOG.warn(s"Building Global Index Time: ${end - start} ms")

      case 2 =>
        //        val aa = partitionedRDD.collect().map(x => partitioner.getDistanceFromParent(x))
        //        val bb = aa.map(println(_))
        val keyValueRDD = partitionedRDD.map(x =>
          (partitioner.getDistanceFromParent(x), x))
        packedRDD = keyValueRDD.mapPartitionsWithIndex { case (index, iter) =>
          val data = iter.toArray
          //          val dataKeyValuePair = data.map(x => (partitioner.getDistanceFromParent(x), x))
          val indexes = ArrayBuffer.empty[LocalIndex]
          val localIndex = LocalDIMSIndex.buildIndex(data)
          val numLeaf = localIndex.getNumLeaf
          // local index, Point
          val dataPairWithIndex = data.map(x =>
            (index.toString + "," + localIndex.partitioner.getPartition(x).toString, x._2))
          indexes.append(localIndex)
          Array(PackedPartition(index, dataPairWithIndex, indexes.toArray, numLeaf)).iterator
        }

        //        numOfLocalPartition = packedRDD.map(x => x.numOfLocalPartition).sum().toInt
        //
        //        val keyValuePair = packedRDD.flatMap(packedPartition =>
        //          packedPartition.data.asInstanceOf[Array[(Int, Point[Any])]].map(
        //            x => (packedPartition.id.toString
        //              + "," + x._1.toString, x._2)))

        packedRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
        packedRDD.count()
        val tempRDD = packedRDD.flatMap(x =>
          x.data.asInstanceOf[Array[(String, Point[Any])]]
        )
        newPackedRDD = tempRDD.repartition(40)
          .map(x => x._2)
        newPackedRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
        newPackedRDD.count()
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
        LOG.warn(s"5% Partition Size: ${
          sortedPartitionSizes((partitionSizes.length * 0.05).toInt)
        }")
        LOG.warn(s"25% Partition Size: ${
          sortedPartitionSizes((partitionSizes.length * 0.25).toInt)
        }")
        LOG.warn(s"50% Partition Size: ${
          sortedPartitionSizes((partitionSizes.length * 0.5).toInt)
        }")
        LOG.warn(s"75% Partition Size: ${
          sortedPartitionSizes((partitionSizes.length * 0.75).toInt)
        }")
        LOG.warn(s"95% Partition Size: ${
          sortedPartitionSizes((partitionSizes.length * 0.95).toInt)
        }")
        // build global index
        start = System.currentTimeMillis()
        val globalTreeIndex = GlobalDIMSIndex(partitioner)
        globalIndex = globalTreeIndex
        end = System.currentTimeMillis()
        LOG.warn(s"Building Global Index Time: ${end - start} ms")

      case 3 =>

        //        val aaa = partitionedRDD.getNumPartitions

        LOG.warn(s"Calculating Distance From Parent")
        val keyValueRDD = partitionedRDD.map(x =>
          (partitioner.getDistanceFromParent(x), x))
        //        val aaa = keyValueRDD.collect()
        keyValueRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
        keyValueRDD.count()

        LOG.warn(s"Calculate Distance From Parent Down")
        start = System.currentTimeMillis()
        val (bPlusRDD, globalPartitioner) = GlobalBPlusTreePartitioner.partition(keyValueRDD)
        end = System.currentTimeMillis()
        LOG.warn(s"DIMS Partitioning Time2: ${end - start} ms")

        start = System.currentTimeMillis()
        globalBPlusRDD = bPlusRDD.mapPartitionsWithIndex {
          case (index, iter) =>
            val data = iter.toArray
            val indexes = ArrayBuffer.empty[LocalIndex]
            indexes.append(LocalMTreeIndex.buildIndex(data))
            Array(PackedPartition(index, data, indexes.toArray)).iterator
        }
        globalBPlusRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
        globalBPlusRDD.count()
        end = System.currentTimeMillis()
        LOG.warn(s"Building Global BPlus Index Time: ${end - start} ms")

        // log statistics
        val partitionSizes = globalBPlusRDD.mapPartitions(iter => iter.map(_.data.length)).collect()
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
        val globalTreeIndex = GlobalDIMSIndex(partitioner) // Global M-Tree
        val globalBPlusIndex = GlobalBPlusTreeIndex(globalPartitioner) // Global B+-Tree
        globalIndex = globalTreeIndex
        globalBPlusTreeIndex = globalBPlusIndex
        end = System.currentTimeMillis()
        LOG.warn(s"Building Global Index Time: ${end - start} ms")
      case 4 =>
        val keyValueRDD = partitionedRDD.map(x =>
          (partitioner.getDistanceFromParent(x), x))
        keyValueRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
        keyValueRDD.count()
        packedRDD = keyValueRDD.mapPartitionsWithIndex { case (index, iter) =>
          val data = iter.toArray
          val indexes = ArrayBuffer.empty[LocalIndex]
          val localIndex = LocalDIMSIndex.buildIndex(data)
          val numLeaf = localIndex.getNumLeaf
          val dataPairWithIndex = data.map(x =>
            ((localIndex.partitioner.getPartition(x), x._2), None))
          indexes.append(localIndex)
          Array(PackedPartition(index, dataPairWithIndex, indexes.toArray, numLeaf)).iterator
        }
        packedRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
        packedRDD.count()

        val numLocalPartition = packedRDD.map(x => x.numOfLocalPartition).max

        val keyPartitioner = KeyPartitioner(numLocalPartition)
        //        val hashPartitioner = new HashPartitioner(DIMSConfigConstants.DIMS4_LOCAL_PARTITION)
        val keyValuePair = packedRDD.flatMap(x =>
          x.data.asInstanceOf[Array[((Int, Point[Any]), Any)]])
        val shuffled = new ShuffledRDD[(Int, Point[Any]),
          Any, Any](keyValuePair, keyPartitioner)

        newPackedRDD = shuffled.map(x => x._1._2)
        newPackedRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
        newPackedRDD.count()

        finalPackedRDD = newPackedRDD.mapPartitionsWithIndex {
          case (index, iter) =>
            val data = iter.toArray
            val indexes = ArrayBuffer.empty[LocalIndex]
            indexes.append(LocalMTreeIndex.buildIndex(data))
            Array(PackedPartition(index, data, indexes.toArray)).iterator
        }

        finalPackedRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
        finalPackedRDD.count()
        end = System.currentTimeMillis()
        LOG.warn(s"Building Local Index Time: ${end - start} ms")

        // log statistics
        val partitionSizes = finalPackedRDD.mapPartitions(iter => iter.map(_.data.length)).collect()
        LOG.warn(s"Local Partitions Count: ${partitionSizes.length}")
        LOG.warn(s"Local Partitions Sizes: ${partitionSizes.mkString(",")}")
        LOG.warn(s"Max Partition Size: ${partitionSizes.max}")
        LOG.warn(s"Min Partition Size: ${partitionSizes.min}")
        LOG.warn(s"Avg Partition Size: ${partitionSizes.sum / partitionSizes.length}")
        val sortedPartitionSizes = partitionSizes.sorted
        LOG.warn(s"5% Partition Size: ${
          sortedPartitionSizes((partitionSizes.length * 0.05)
            .toInt)
        }")
        LOG.warn(s"25% Partition Size: ${
          sortedPartitionSizes((partitionSizes.length * 0.25)
            .toInt)
        }")
        LOG.warn(s"50% Partition Size: ${
          sortedPartitionSizes((partitionSizes.length * 0.5)
            .toInt)
        }")
        LOG.warn(s"75% Partition Size: ${
          sortedPartitionSizes((partitionSizes.length * 0.75)
            .toInt)
        }")
        LOG.warn(s"95% Partition Size: ${
          sortedPartitionSizes((partitionSizes.length * 0.95)
            .toInt)
        }")
        // build global index
        start = System.currentTimeMillis()
        val globalTreeIndex = GlobalDIMSIndex(partitioner)
        globalIndex = globalTreeIndex
        end = System.currentTimeMillis()
        LOG.warn(s"Building Global Index Time: ${end - start} ms")
      case 5 =>
        LOG.warn(s"Calculating Distance From Parent")
        val keyValueRDD = partitionedRDD.map(x =>
          (partitioner.getDistanceFromParent(x), x))
        //        val aaa = keyValueRDD.collect()
        keyValueRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
        keyValueRDD.count()

        LOG.warn(s"Calculate Distance From Parent Down")
        start = System.currentTimeMillis()
        val (bPlusRDD, globalPartitioner) = GlobalBPlusTreePartitioner.partition(keyValueRDD)
        end = System.currentTimeMillis()
        LOG.warn(s"DIMS Partitioning Time2: ${end - start} ms")

        start = System.currentTimeMillis()
        globalBPlusRDD = bPlusRDD.mapPartitionsWithIndex {
          case (index, iter) =>
            val data = iter.toArray
            val indexes = ArrayBuffer.empty[LocalIndex]
            indexes.append(LocalSimpleIndex.buildIndex(data))
            Array(PackedPartition(index, data, indexes.toArray)).iterator
        }
        globalBPlusRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
        globalBPlusRDD.count()
        end = System.currentTimeMillis()
        LOG.warn(s"Building Global BPlus Index Time: ${end - start} ms")

        // log statistics
        val partitionSizes = globalBPlusRDD.mapPartitions(iter => iter.map(_.data.length)).collect()
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
        val globalTreeIndex = GlobalDIMSIndex(partitioner) // Global M-Tree
        val globalBPlusIndex = GlobalBPlusTreeIndex(globalPartitioner) // Global B+-Tree
        globalIndex = globalTreeIndex
        globalBPlusTreeIndex = globalBPlusIndex
        end = System.currentTimeMillis()
        LOG.warn(s"Building Global Index Time: ${end - start} ms")
      case 6 =>
        LOG.warn(s"Calculating Distance From Parent")
        val keyValueRDD = partitionedRDD.map(x =>
          (partitioner.getDistanceFromParent(x), x))
        //        val aaa = keyValueRDD.collect()
        keyValueRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
        keyValueRDD.count()

        LOG.warn(s"Calculate Distance From Parent Down")
        start = System.currentTimeMillis()
        val (bPlusRDD, globalPartitioner) = GlobalBPlusTreePartitioner.partition(keyValueRDD)
        end = System.currentTimeMillis()
        LOG.warn(s"DIMS Partitioning Time2: ${end - start} ms")

        start = System.currentTimeMillis()
        globalBPlusRDD = bPlusRDD.mapPartitionsWithIndex {
          case (index, iter) =>
            val data = iter.toArray
            val indexes = ArrayBuffer.empty[LocalIndex]
            indexes.append(LocalPivotIndex.buildIndex(data))
            Array(PackedPartition(index, data, indexes.toArray)).iterator
        }
        globalBPlusRDD.persist(StorageLevel.MEMORY_AND_DISK_SER)
        globalBPlusRDD.count()
        end = System.currentTimeMillis()
        LOG.warn(s"Building Global BPlus Index Time: ${end - start} ms")

        // log statistics
        val partitionSizes = globalBPlusRDD.mapPartitions(iter => iter.map(_.data.length)).collect()
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
        val globalTreeIndex = GlobalDIMSIndex(partitioner) // Global M-Tree
        val globalBPlusIndex = GlobalBPlusTreeIndex(globalPartitioner) // Global B+-Tree
        globalIndex = globalTreeIndex
        globalBPlusTreeIndex = globalBPlusIndex
        end = System.currentTimeMillis()
        LOG.warn(s"Building Global Index Time: ${end - start} ms")
    }
  }

  buildIndex()


}