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

package org.apache.spark.ui.exec

import scala.collection.mutable.{LinkedHashMap, ListBuffer}

import org.apache.spark.{ExceptionFailure, Resubmitted, SparkConf, SparkContext}
import org.apache.spark.annotation.DeveloperApi
import org.apache.spark.scheduler._
import org.apache.spark.storage.{StorageStatus, StorageStatusListener}
import org.apache.spark.ui.{SparkUI, SparkUITab}

private[ui] class ExecutorsTab(parent: SparkUI) extends SparkUITab(parent, "executors") {
  val listener = parent.executorsListener
  val sc = parent.sc
  val threadDumpEnabled =
    sc.isDefined && parent.conf.getBoolean("spark.ui.threadDumpsEnabled", true)

  attachPage(new ExecutorsPage(this, threadDumpEnabled))
  if (threadDumpEnabled) {
    attachPage(new ExecutorThreadDumpPage(this))
  }
}

private[ui] case class ExecutorTaskSummary(
    var executorId: String,
    var totalCores: Int = 0,
    var tasksMax: Int = 0,
    var tasksActive: Int = 0,
    var tasksFailed: Int = 0,
    var tasksComplete: Int = 0,
    var duration: Long = 0L,
    var jvmGCTime: Long = 0L,
    var inputBytes: Long = 0L,
    var inputRecords: Long = 0L,
    var outputBytes: Long = 0L,
    var outputRecords: Long = 0L,
    var shuffleRead: Long = 0L,
    var shuffleWrite: Long = 0L,
    var executorLogs: Map[String, String] = Map.empty,
    var isAlive: Boolean = true,
    var isBlacklisted: Boolean = false
)

/**
 * :: DeveloperApi ::
 * A SparkListener that prepares information to be displayed on the ExecutorsTab
 */
@DeveloperApi
@deprecated("This class will be removed in a future release.", "2.2.0")
class ExecutorsListener(storageStatusListener: StorageStatusListener, conf: SparkConf)
    extends SparkListener {
  val executorToTaskSummary = LinkedHashMap[String, ExecutorTaskSummary]()
  var executorEvents = new ListBuffer[SparkListenerEvent]()

  private val maxTimelineExecutors = conf.getInt("spark.ui.timeline.executors.maximum", 1000)
  private val retainedDeadExecutors = conf.getInt("spark.ui.retainedDeadExecutors", 100)

  def activeStorageStatusList: Seq[StorageStatus] = storageStatusListener.storageStatusList

  def deadStorageStatusList: Seq[StorageStatus] = storageStatusListener.deadStorageStatusList

  override def onExecutorAdded(
      executorAdded: SparkListenerExecutorAdded): Unit = synchronized {
    val eid = executorAdded.executorId
    val taskSummary = executorToTaskSummary.getOrElseUpdate(eid, ExecutorTaskSummary(eid))
    taskSummary.executorLogs = executorAdded.executorInfo.logUrlMap
    taskSummary.totalCores = executorAdded.executorInfo.totalCores
    taskSummary.tasksMax = taskSummary.totalCores / conf.getInt("spark.task.cpus", 1)
    executorEvents += executorAdded
    if (executorEvents.size > maxTimelineExecutors) {
      executorEvents.remove(0)
    }

    val deadExecutors = executorToTaskSummary.filter(e => !e._2.isAlive)
    if (deadExecutors.size > retainedDeadExecutors) {
      val head = deadExecutors.head
      executorToTaskSummary.remove(head._1)
    }
  }

  override def onExecutorRemoved(
      executorRemoved: SparkListenerExecutorRemoved): Unit = synchronized {
    executorEvents += executorRemoved
    if (executorEvents.size > maxTimelineExecutors) {
      executorEvents.remove(0)
    }
    executorToTaskSummary.get(executorRemoved.executorId).foreach(e => e.isAlive = false)
  }

  override def onApplicationStart(
      applicationStart: SparkListenerApplicationStart): Unit = {
    applicationStart.driverLogs.foreach { logs =>
      val storageStatus = activeStorageStatusList.find { s =>
        s.blockManagerId.executorId == SparkContext.LEGACY_DRIVER_IDENTIFIER ||
        s.blockManagerId.executorId == SparkContext.DRIVER_IDENTIFIER
      }
      storageStatus.foreach { s =>
        val eid = s.blockManagerId.executorId
        val taskSummary = executorToTaskSummary.getOrElseUpdate(eid, ExecutorTaskSummary(eid))
        taskSummary.executorLogs = logs.toMap
      }
    }
  }

  override def onTaskStart(
      taskStart: SparkListenerTaskStart): Unit = synchronized {
    val eid = taskStart.taskInfo.executorId
    val taskSummary = executorToTaskSummary.getOrElseUpdate(eid, ExecutorTaskSummary(eid))
    taskSummary.tasksActive += 1
  }

  override def onTaskEnd(
      taskEnd: SparkListenerTaskEnd): Unit = synchronized {
    val info = taskEnd.taskInfo
    if (info != null) {
      val eid = info.executorId
      val taskSummary = executorToTaskSummary.getOrElseUpdate(eid, ExecutorTaskSummary(eid))
      taskEnd.reason match {
        case Resubmitted =>
          // Note: For resubmitted tasks, we continue to use the metrics that belong to the
          // first attempt of this task. This may not be 100% accurate because the first attempt
          // could have failed half-way through. The correct fix would be to keep track of the
          // metrics added by each attempt, but this is much more complicated.
          return
        case _: ExceptionFailure =>
          taskSummary.tasksFailed += 1
        case _ =>
          taskSummary.tasksComplete += 1
      }
      if (taskSummary.tasksActive >= 1) {
        taskSummary.tasksActive -= 1
      }
      taskSummary.duration += info.duration

      // Update shuffle read/write
      val metrics = taskEnd.taskMetrics
      if (metrics != null) {
        taskSummary.inputBytes += metrics.inputMetrics.bytesRead
        taskSummary.inputRecords += metrics.inputMetrics.recordsRead
        taskSummary.outputBytes += metrics.outputMetrics.bytesWritten
        taskSummary.outputRecords += metrics.outputMetrics.recordsWritten

        taskSummary.shuffleRead += metrics.shuffleReadMetrics.remoteBytesRead
        taskSummary.shuffleWrite += metrics.shuffleWriteMetrics.bytesWritten
        taskSummary.jvmGCTime += metrics.jvmGCTime
      }
    }
  }

  private def updateExecutorBlacklist(
      eid: String,
      isBlacklisted: Boolean): Unit = {
    val execTaskSummary = executorToTaskSummary.getOrElseUpdate(eid, ExecutorTaskSummary(eid))
    execTaskSummary.isBlacklisted = isBlacklisted
  }

  override def onExecutorBlacklisted(
      executorBlacklisted: SparkListenerExecutorBlacklisted)
  : Unit = synchronized {
    updateExecutorBlacklist(executorBlacklisted.executorId, true)
  }

  override def onExecutorUnblacklisted(
      executorUnblacklisted: SparkListenerExecutorUnblacklisted)
  : Unit = synchronized {
    updateExecutorBlacklist(executorUnblacklisted.executorId, false)
  }

  override def onNodeBlacklisted(
      nodeBlacklisted: SparkListenerNodeBlacklisted)
  : Unit = synchronized {
    // Implicitly blacklist every executor associated with this node, and show this in the UI.
    activeStorageStatusList.foreach { status =>
      if (status.blockManagerId.host == nodeBlacklisted.hostId) {
        updateExecutorBlacklist(status.blockManagerId.executorId, true)
      }
    }
  }

  override def onNodeUnblacklisted(
      nodeUnblacklisted: SparkListenerNodeUnblacklisted)
  : Unit = synchronized {
    // Implicitly unblacklist every executor associated with this node, regardless of how
    // they may have been blacklisted initially (either explicitly through executor blacklisting
    // or implicitly through node blacklisting). Show this in the UI.
    activeStorageStatusList.foreach { status =>
      if (status.blockManagerId.host == nodeUnblacklisted.hostId) {
        updateExecutorBlacklist(status.blockManagerId.executorId, false)
      }
    }
  }
}
