/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.storage

import scala.collection.mutable

import org.apache.spark.SparkConf
import org.apache.spark.annotation.DeveloperApi
import org.apache.spark.scheduler._

/**
 * :: DeveloperApi ::
 * A SparkListener that maintains executor storage status.
 *
 * This class is thread-safe (unlike JobProgressListener)
 */
@DeveloperApi
@deprecated("This class will be removed in a future release.", "2.2.0")
class StorageStatusListener(conf: SparkConf) extends SparkListener {
  // This maintains only blocks that are cached (i.e. storage level is not StorageLevel.NONE)
  private[storage] val executorIdToStorageStatus = mutable.Map[String, StorageStatus]()
  private[storage] val deadExecutorStorageStatus = new mutable.ListBuffer[StorageStatus]()
  private[this] val retainedDeadExecutors = conf.getInt("spark.ui.retainedDeadExecutors", 100)

  def storageStatusList: Seq[StorageStatus] = synchronized {
    executorIdToStorageStatus.values.toSeq
  }

  def deadStorageStatusList: Seq[StorageStatus] = synchronized {
    deadExecutorStorageStatus
  }

  /** Update storage status list to reflect updated block statuses */
  private def updateStorageStatus(execId: String, updatedBlocks: Seq[(BlockId, BlockStatus)]) {
    executorIdToStorageStatus.get(execId).foreach { storageStatus =>
      updatedBlocks.foreach { case (blockId, updatedStatus) =>
        if (updatedStatus.storageLevel == StorageLevel.NONE) {
          storageStatus.removeBlock(blockId)
        } else {
          storageStatus.updateBlock(blockId, updatedStatus)
        }
      }
    }
  }

  /** Update storage status list to reflect the removal of an RDD from the cache */
  private def updateStorageStatus(unpersistedRDDId: Int) {
    storageStatusList.foreach { storageStatus =>
      storageStatus.rddBlocksById(unpersistedRDDId).foreach { case (blockId, _) =>
        storageStatus.removeBlock(blockId)
      }
    }
  }

  override def onUnpersistRDD(unpersistRDD: SparkListenerUnpersistRDD): Unit = synchronized {
    updateStorageStatus(unpersistRDD.rddId)
  }

  override def onBlockManagerAdded(blockManagerAdded: SparkListenerBlockManagerAdded) {
    synchronized {
      val blockManagerId = blockManagerAdded.blockManagerId
      val executorId = blockManagerId.executorId
      // The onHeap and offHeap memory are always defined for new applications,
      // but they can be missing if we are replaying old event logs.
      val storageStatus = new StorageStatus(blockManagerId, blockManagerAdded.maxMem,
        blockManagerAdded.maxOnHeapMem, blockManagerAdded.maxOffHeapMem)
      executorIdToStorageStatus(executorId) = storageStatus

      // Try to remove the dead storage status if same executor register the block manager twice.
      deadExecutorStorageStatus.zipWithIndex.find(_._1.blockManagerId.executorId == executorId)
        .foreach(toRemoveExecutor => deadExecutorStorageStatus.remove(toRemoveExecutor._2))
    }
  }

  override def onBlockManagerRemoved(blockManagerRemoved: SparkListenerBlockManagerRemoved) {
    synchronized {
      val executorId = blockManagerRemoved.blockManagerId.executorId
      executorIdToStorageStatus.remove(executorId).foreach { status =>
        deadExecutorStorageStatus += status
      }
      if (deadExecutorStorageStatus.size > retainedDeadExecutors) {
        deadExecutorStorageStatus.trimStart(1)
      }
    }
  }

  override def onBlockUpdated(blockUpdated: SparkListenerBlockUpdated): Unit = {
    val executorId = blockUpdated.blockUpdatedInfo.blockManagerId.executorId
    val blockId = blockUpdated.blockUpdatedInfo.blockId
    val storageLevel = blockUpdated.blockUpdatedInfo.storageLevel
    val memSize = blockUpdated.blockUpdatedInfo.memSize
    val diskSize = blockUpdated.blockUpdatedInfo.diskSize
    val blockStatus = BlockStatus(storageLevel, memSize, diskSize)
    updateStorageStatus(executorId, Seq((blockId, blockStatus)))
  }
}
