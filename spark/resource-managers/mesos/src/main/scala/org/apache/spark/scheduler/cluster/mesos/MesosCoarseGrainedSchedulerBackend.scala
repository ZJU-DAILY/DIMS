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

package org.apache.spark.scheduler.cluster.mesos

import java.io.File
import java.util.{Collections, List => JList}
import java.util.concurrent.locks.ReentrantLock

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.concurrent.Future

import org.apache.mesos.Protos.{TaskInfo => MesosTaskInfo, _}
import org.apache.mesos.SchedulerDriver

import org.apache.spark.{SecurityManager, SparkContext, SparkException, TaskState}
import org.apache.spark.network.netty.SparkTransportConf
import org.apache.spark.network.shuffle.mesos.MesosExternalShuffleClient
import org.apache.spark.rpc.RpcEndpointAddress
import org.apache.spark.scheduler.{SlaveLost, TaskSchedulerImpl}
import org.apache.spark.scheduler.cluster.CoarseGrainedSchedulerBackend
import org.apache.spark.util.Utils

/**
 * A SchedulerBackend that runs tasks on Mesos, but uses "coarse-grained" tasks, where it holds
 * onto each Mesos node for the duration of the Spark job instead of relinquishing cores whenever
 * a task is done. It launches Spark tasks within the coarse-grained Mesos tasks using the
 * CoarseGrainedSchedulerBackend mechanism. This class is useful for lower and more predictable
 * latency.
 *
 * Unfortunately this has a bit of duplication from [[MesosFineGrainedSchedulerBackend]],
 * but it seems hard to remove this.
 */
private[spark] class MesosCoarseGrainedSchedulerBackend(
    scheduler: TaskSchedulerImpl,
    sc: SparkContext,
    master: String,
    securityManager: SecurityManager)
  extends CoarseGrainedSchedulerBackend(scheduler, sc.env.rpcEnv)
  with org.apache.mesos.Scheduler
  with MesosSchedulerUtils {

  // Blacklist a slave after this many failures
  private val MAX_SLAVE_FAILURES = 2

  private val maxCoresOption = conf.getOption("spark.cores.max").map(_.toInt)

  private val executorCoresOption = conf.getOption("spark.executor.cores").map(_.toInt)

  private val minCoresPerExecutor = executorCoresOption.getOrElse(1)

  // Maximum number of cores to acquire
  private val maxCores = {
    val cores = maxCoresOption.getOrElse(Int.MaxValue)
    // Set maxCores to a multiple of smallest executor we can launch
    cores - (cores % minCoresPerExecutor)
  }

  private val useFetcherCache = conf.getBoolean("spark.mesos.fetcherCache.enable", false)

  private val maxGpus = conf.getInt("spark.mesos.gpus.max", 0)

  private val taskLabels = conf.get("spark.mesos.task.labels", "")

  private[this] val shutdownTimeoutMS =
    conf.getTimeAsMs("spark.mesos.coarse.shutdownTimeout", "10s")
      .ensuring(_ >= 0, "spark.mesos.coarse.shutdownTimeout must be >= 0")

  // Synchronization protected by stateLock
  private[this] var stopCalled: Boolean = false

  // If shuffle service is enabled, the Spark driver will register with the shuffle service.
  // This is for cleaning up shuffle files reliably.
  private val shuffleServiceEnabled = conf.getBoolean("spark.shuffle.service.enabled", false)

  // Cores we have acquired with each Mesos task ID
  private val coresByTaskId = new mutable.HashMap[String, Int]
  private val gpusByTaskId = new mutable.HashMap[String, Int]
  private var totalCoresAcquired = 0
  private var totalGpusAcquired = 0

  // SlaveID -> Slave
  // This map accumulates entries for the duration of the job.  Slaves are never deleted, because
  // we need to maintain e.g. failure state and connection state.
  private val slaves = new mutable.HashMap[String, Slave]

  /**
   * The total number of executors we aim to have. Undefined when not using dynamic allocation.
   * Initially set to 0 when using dynamic allocation, the executor allocation manager will send
   * the real initial limit later.
   */
  private var executorLimitOption: Option[Int] = {
    if (Utils.isDynamicAllocationEnabled(conf)) {
      Some(0)
    } else {
      None
    }
  }

  /**
   *  Return the current executor limit, which may be [[Int.MaxValue]]
   *  before properly initialized.
   */
  private[mesos] def executorLimit: Int = executorLimitOption.getOrElse(Int.MaxValue)

  // private lock object protecting mutable state above. Using the intrinsic lock
  // may lead to deadlocks since the superclass might also try to lock
  private val stateLock = new ReentrantLock

  private val extraCoresPerExecutor = conf.getInt("spark.mesos.extra.cores", 0)

  // Offer constraints
  private val slaveOfferConstraints =
    parseConstraintString(sc.conf.get("spark.mesos.constraints", ""))

  // Reject offers with mismatched constraints in seconds
  private val rejectOfferDurationForUnmetConstraints =
    getRejectOfferDurationForUnmetConstraints(sc.conf)

  // Reject offers when we reached the maximum number of cores for this framework
  private val rejectOfferDurationForReachedMaxCores =
    getRejectOfferDurationForReachedMaxCores(sc.conf)

  // A client for talking to the external shuffle service
  private val mesosExternalShuffleClient: Option[MesosExternalShuffleClient] = {
    if (shuffleServiceEnabled) {
      Some(getShuffleClient())
    } else {
      None
    }
  }

  // This method is factored out for testability
  protected def getShuffleClient(): MesosExternalShuffleClient = {
    new MesosExternalShuffleClient(
      SparkTransportConf.fromSparkConf(conf, "shuffle"),
      securityManager,
      securityManager.isAuthenticationEnabled())
  }

  private var nextMesosTaskId = 0

  @volatile var appId: String = _

  private var schedulerDriver: SchedulerDriver = _

  def newMesosTaskId(): String = {
    val id = nextMesosTaskId
    nextMesosTaskId += 1
    id.toString
  }

  override def start() {
    super.start()
    val driver = createSchedulerDriver(
      master,
      MesosCoarseGrainedSchedulerBackend.this,
      sc.sparkUser,
      sc.appName,
      sc.conf,
      sc.conf.getOption("spark.mesos.driver.webui.url").orElse(sc.ui.map(_.webUrl)),
      None,
      None,
      sc.conf.getOption("spark.mesos.driver.frameworkId")
    )

    unsetFrameworkID(sc)
    startScheduler(driver)
  }

  def createCommand(offer: Offer, numCores: Int, taskId: String): CommandInfo = {
    val environment = Environment.newBuilder()
    val extraClassPath = conf.getOption("spark.executor.extraClassPath")
    extraClassPath.foreach { cp =>
      environment.addVariables(
        Environment.Variable.newBuilder().setName("SPARK_EXECUTOR_CLASSPATH").setValue(cp).build())
    }
    val extraJavaOpts = conf.get("spark.executor.extraJavaOptions", "")

    // Set the environment variable through a command prefix
    // to append to the existing value of the variable
    val prefixEnv = conf.getOption("spark.executor.extraLibraryPath").map { p =>
      Utils.libraryPathEnvPrefix(Seq(p))
    }.getOrElse("")

    environment.addVariables(
      Environment.Variable.newBuilder()
        .setName("SPARK_EXECUTOR_OPTS")
        .setValue(extraJavaOpts)
        .build())

    sc.executorEnvs.foreach { case (key, value) =>
      environment.addVariables(Environment.Variable.newBuilder()
        .setName(key)
        .setValue(value)
        .build())
    }
    val command = CommandInfo.newBuilder()
      .setEnvironment(environment)

    val uri = conf.getOption("spark.executor.uri")
      .orElse(Option(System.getenv("SPARK_EXECUTOR_URI")))

    if (uri.isEmpty) {
      val executorSparkHome = conf.getOption("spark.mesos.executor.home")
        .orElse(sc.getSparkHome())
        .getOrElse {
          throw new SparkException("Executor Spark home `spark.mesos.executor.home` is not set!")
        }
      val runScript = new File(executorSparkHome, "./bin/spark-class").getPath
      command.setValue(
        "%s \"%s\" org.apache.spark.executor.CoarseGrainedExecutorBackend"
          .format(prefixEnv, runScript) +
        s" --driver-url $driverURL" +
        s" --executor-id $taskId" +
        s" --hostname ${executorHostname(offer)}" +
        s" --cores $numCores" +
        s" --app-id $appId")
    } else {
      // Grab everything to the first '.'. We'll use that and '*' to
      // glob the directory "correctly".
      val basename = uri.get.split('/').last.split('.').head
      command.setValue(
        s"cd $basename*; $prefixEnv " +
        "./bin/spark-class org.apache.spark.executor.CoarseGrainedExecutorBackend" +
        s" --driver-url $driverURL" +
        s" --executor-id $taskId" +
        s" --hostname ${executorHostname(offer)}" +
        s" --cores $numCores" +
        s" --app-id $appId")
      command.addUris(CommandInfo.URI.newBuilder().setValue(uri.get).setCache(useFetcherCache))
    }

    conf.getOption("spark.mesos.uris").foreach(setupUris(_, command, useFetcherCache))

    command.build()
  }

  protected def driverURL: String = {
    if (conf.contains("spark.testing")) {
      "driverURL"
    } else {
      RpcEndpointAddress(
        conf.get("spark.driver.host"),
        conf.get("spark.driver.port").toInt,
        CoarseGrainedSchedulerBackend.ENDPOINT_NAME).toString
    }
  }

  override def offerRescinded(d: org.apache.mesos.SchedulerDriver, o: OfferID) {}

  override def registered(
      driver: org.apache.mesos.SchedulerDriver,
      frameworkId: FrameworkID,
      masterInfo: MasterInfo) {
    this.appId = frameworkId.getValue
    this.mesosExternalShuffleClient.foreach(_.init(appId))
    this.schedulerDriver = driver
    markRegistered()
  }

  override def sufficientResourcesRegistered(): Boolean = {
    totalCoreCount.get >= maxCoresOption.getOrElse(0) * minRegisteredRatio
  }

  override def disconnected(d: org.apache.mesos.SchedulerDriver) {}

  override def reregistered(d: org.apache.mesos.SchedulerDriver, masterInfo: MasterInfo) {}

  /**
   * Method called by Mesos to offer resources on slaves. We respond by launching an executor,
   * unless we've already launched more than we wanted to.
   */
  override def resourceOffers(d: org.apache.mesos.SchedulerDriver, offers: JList[Offer]) {
    stateLock.synchronized {
      if (stopCalled) {
        logDebug("Ignoring offers during shutdown")
        // Driver should simply return a stopped status on race
        // condition between this.stop() and completing here
        offers.asScala.map(_.getId).foreach(d.declineOffer)
        return
      }

      logDebug(s"Received ${offers.size} resource offers.")

      val (matchedOffers, unmatchedOffers) = offers.asScala.partition { offer =>
        val offerAttributes = toAttributeMap(offer.getAttributesList)
        matchesAttributeRequirements(slaveOfferConstraints, offerAttributes)
      }

      declineUnmatchedOffers(d, unmatchedOffers)
      handleMatchedOffers(d, matchedOffers)
    }
  }

  private def declineUnmatchedOffers(
      driver: org.apache.mesos.SchedulerDriver, offers: mutable.Buffer[Offer]): Unit = {
    offers.foreach { offer =>
      declineOffer(
        driver,
        offer,
        Some("unmet constraints"),
        Some(rejectOfferDurationForUnmetConstraints))
    }
  }

  /**
   * Launches executors on accepted offers, and declines unused offers. Executors are launched
   * round-robin on offers.
   *
   * @param driver SchedulerDriver
   * @param offers Mesos offers that match attribute constraints
   */
  private def handleMatchedOffers(
      driver: org.apache.mesos.SchedulerDriver, offers: mutable.Buffer[Offer]): Unit = {
    val tasks = buildMesosTasks(offers)
    for (offer <- offers) {
      val offerAttributes = toAttributeMap(offer.getAttributesList)
      val offerMem = getResource(offer.getResourcesList, "mem")
      val offerCpus = getResource(offer.getResourcesList, "cpus")
      val offerPorts = getRangeResource(offer.getResourcesList, "ports")
      val id = offer.getId.getValue

      if (tasks.contains(offer.getId)) { // accept
        val offerTasks = tasks(offer.getId)

        logDebug(s"Accepting offer: $id with attributes: $offerAttributes " +
          s"mem: $offerMem cpu: $offerCpus ports: $offerPorts." +
          s"  Launching ${offerTasks.size} Mesos tasks.")

        for (task <- offerTasks) {
          val taskId = task.getTaskId
          val mem = getResource(task.getResourcesList, "mem")
          val cpus = getResource(task.getResourcesList, "cpus")
          val ports = getRangeResource(task.getResourcesList, "ports").mkString(",")

          logDebug(s"Launching Mesos task: ${taskId.getValue} with mem: $mem cpu: $cpus" +
            s" ports: $ports")
        }

        driver.launchTasks(
          Collections.singleton(offer.getId),
          offerTasks.asJava)
      } else if (totalCoresAcquired >= maxCores) {
        // Reject an offer for a configurable amount of time to avoid starving other frameworks
        declineOffer(driver,
          offer,
          Some("reached spark.cores.max"),
          Some(rejectOfferDurationForReachedMaxCores))
      } else {
        declineOffer(
          driver,
          offer)
      }
    }
  }

  /**
   * Returns a map from OfferIDs to the tasks to launch on those offers.  In order to maximize
   * per-task memory and IO, tasks are round-robin assigned to offers.
   *
   * @param offers Mesos offers that match attribute constraints
   * @return A map from OfferID to a list of Mesos tasks to launch on that offer
   */
  private def buildMesosTasks(offers: mutable.Buffer[Offer]): Map[OfferID, List[MesosTaskInfo]] = {
    // offerID -> tasks
    val tasks = new mutable.HashMap[OfferID, List[MesosTaskInfo]].withDefaultValue(Nil)

    // offerID -> resources
    val remainingResources = mutable.Map(offers.map(offer =>
      (offer.getId.getValue, offer.getResourcesList)): _*)

    var launchTasks = true

    // TODO(mgummelt): combine offers for a single slave
    //
    // round-robin create executors on the available offers
    while (launchTasks) {
      launchTasks = false

      for (offer <- offers) {
        val slaveId = offer.getSlaveId.getValue
        val offerId = offer.getId.getValue
        val resources = remainingResources(offerId)

        if (canLaunchTask(slaveId, resources)) {
          // Create a task
          launchTasks = true
          val taskId = newMesosTaskId()
          val offerCPUs = getResource(resources, "cpus").toInt
          val taskGPUs = Math.min(
            Math.max(0, maxGpus - totalGpusAcquired), getResource(resources, "gpus").toInt)

          val taskCPUs = executorCores(offerCPUs)
          val taskMemory = executorMemory(sc)

          slaves.getOrElseUpdate(slaveId, new Slave(offer.getHostname)).taskIDs.add(taskId)

          val (resourcesLeft, resourcesToUse) =
            partitionTaskResources(resources, taskCPUs, taskMemory, taskGPUs)

          val taskBuilder = MesosTaskInfo.newBuilder()
            .setTaskId(TaskID.newBuilder().setValue(taskId.toString).build())
            .setSlaveId(offer.getSlaveId)
            .setCommand(createCommand(offer, taskCPUs + extraCoresPerExecutor, taskId))
            .setName(s"${sc.appName} $taskId")

          taskBuilder.addAllResources(resourcesToUse.asJava)
          taskBuilder.setContainer(MesosSchedulerBackendUtil.containerInfo(sc.conf))

          val labelsBuilder = taskBuilder.getLabelsBuilder
          val labels = buildMesosLabels().asJava

          labelsBuilder.addAllLabels(labels)

          taskBuilder.setLabels(labelsBuilder)

          tasks(offer.getId) ::= taskBuilder.build()
          remainingResources(offerId) = resourcesLeft.asJava
          totalCoresAcquired += taskCPUs
          coresByTaskId(taskId) = taskCPUs
          if (taskGPUs > 0) {
            totalGpusAcquired += taskGPUs
            gpusByTaskId(taskId) = taskGPUs
          }
        }
      }
    }
    tasks.toMap
  }

  private def buildMesosLabels(): List[Label] = {
   taskLabels.split(",").flatMap(label =>
      label.split(":") match {
        case Array(key, value) =>
          Some(Label.newBuilder()
            .setKey(key)
            .setValue(value)
            .build())
        case _ =>
          logWarning(s"Unable to parse $label into a key:value label for the task.")
          None
      }
    ).toList
  }

  /** Extracts task needed resources from a list of available resources. */
  private def partitionTaskResources(
      resources: JList[Resource],
      taskCPUs: Int,
      taskMemory: Int,
      taskGPUs: Int)
    : (List[Resource], List[Resource]) = {

    // partition cpus & mem
    val (afterCPUResources, cpuResourcesToUse) = partitionResources(resources, "cpus", taskCPUs)
    val (afterMemResources, memResourcesToUse) =
      partitionResources(afterCPUResources.asJava, "mem", taskMemory)
    val (afterGPUResources, gpuResourcesToUse) =
      partitionResources(afterMemResources.asJava, "gpus", taskGPUs)

    // If user specifies port numbers in SparkConfig then consecutive tasks will not be launched
    // on the same host. This essentially means one executor per host.
    // TODO: handle network isolator case
    val (nonPortResources, portResourcesToUse) =
      partitionPortResources(nonZeroPortValuesFromConfig(sc.conf), afterGPUResources)

    (nonPortResources,
      cpuResourcesToUse ++ memResourcesToUse ++ portResourcesToUse ++ gpuResourcesToUse)
  }

  private def canLaunchTask(slaveId: String, resources: JList[Resource]): Boolean = {
    val offerMem = getResource(resources, "mem")
    val offerCPUs = getResource(resources, "cpus").toInt
    val cpus = executorCores(offerCPUs)
    val mem = executorMemory(sc)
    val ports = getRangeResource(resources, "ports")
    val meetsPortRequirements = checkPorts(sc.conf, ports)

    cpus > 0 &&
      cpus <= offerCPUs &&
      cpus + totalCoresAcquired <= maxCores &&
      mem <= offerMem &&
      numExecutors() < executorLimit &&
      slaves.get(slaveId).map(_.taskFailures).getOrElse(0) < MAX_SLAVE_FAILURES &&
      meetsPortRequirements
  }

  private def executorCores(offerCPUs: Int): Int = {
    executorCoresOption.getOrElse(
      math.min(offerCPUs, maxCores - totalCoresAcquired)
    )
  }

  override def statusUpdate(d: org.apache.mesos.SchedulerDriver, status: TaskStatus) {
    val taskId = status.getTaskId.getValue
    val slaveId = status.getSlaveId.getValue
    val state = mesosToTaskState(status.getState)

    logInfo(s"Mesos task $taskId is now ${status.getState}")

    stateLock.synchronized {
      val slave = slaves(slaveId)

      // If the shuffle service is enabled, have the driver register with each one of the
      // shuffle services. This allows the shuffle services to clean up state associated with
      // this application when the driver exits. There is currently not a great way to detect
      // this through Mesos, since the shuffle services are set up independently.
      if (state.equals(TaskState.RUNNING) &&
          shuffleServiceEnabled &&
          !slave.shuffleRegistered) {
        assume(mesosExternalShuffleClient.isDefined,
          "External shuffle client was not instantiated even though shuffle service is enabled.")
        // TODO: Remove this and allow the MesosExternalShuffleService to detect
        // framework termination when new Mesos Framework HTTP API is available.
        val externalShufflePort = conf.getInt("spark.shuffle.service.port", 7337)

        logDebug(s"Connecting to shuffle service on slave $slaveId, " +
            s"host ${slave.hostname}, port $externalShufflePort for app ${conf.getAppId}")

        mesosExternalShuffleClient.get
          .registerDriverWithShuffleService(
            slave.hostname,
            externalShufflePort,
            sc.conf.getTimeAsMs("spark.storage.blockManagerSlaveTimeoutMs",
              s"${sc.conf.getTimeAsMs("spark.network.timeout", "120s")}ms"),
            sc.conf.getTimeAsMs("spark.executor.heartbeatInterval", "10s"))
        slave.shuffleRegistered = true
      }

      if (TaskState.isFinished(state)) {
        // Remove the cores we have remembered for this task, if it's in the hashmap
        for (cores <- coresByTaskId.get(taskId)) {
          totalCoresAcquired -= cores
          coresByTaskId -= taskId
        }
        // Also remove the gpus we have remembered for this task, if it's in the hashmap
        for (gpus <- gpusByTaskId.get(taskId)) {
          totalGpusAcquired -= gpus
          gpusByTaskId -= taskId
        }
        // If it was a failure, mark the slave as failed for blacklisting purposes
        if (TaskState.isFailed(state)) {
          slave.taskFailures += 1

          if (slave.taskFailures >= MAX_SLAVE_FAILURES) {
            logInfo(s"Blacklisting Mesos slave $slaveId due to too many failures; " +
                "is Spark installed on it?")
          }
        }
        executorTerminated(d, slaveId, taskId, s"Executor finished with state $state")
        // In case we'd rejected everything before but have now lost a node
        d.reviveOffers()
      }
    }
  }

  override def error(d: org.apache.mesos.SchedulerDriver, message: String) {
    logError(s"Mesos error: $message")
    scheduler.error(message)
  }

  override def stop() {
    // Make sure we're not launching tasks during shutdown
    stateLock.synchronized {
      if (stopCalled) {
        logWarning("Stop called multiple times, ignoring")
        return
      }
      stopCalled = true
      super.stop()
    }

    // Wait for executors to report done, or else mesosDriver.stop() will forcefully kill them.
    // See SPARK-12330
    val startTime = System.nanoTime()

    // slaveIdsWithExecutors has no memory barrier, so this is eventually consistent
    while (numExecutors() > 0 &&
      System.nanoTime() - startTime < shutdownTimeoutMS * 1000L * 1000L) {
      Thread.sleep(100)
    }

    if (numExecutors() > 0) {
      logWarning(s"Timed out waiting for ${numExecutors()} remaining executors "
        + s"to terminate within $shutdownTimeoutMS ms. This may leave temporary files "
        + "on the mesos nodes.")
    }

    // Close the mesos external shuffle client if used
    mesosExternalShuffleClient.foreach(_.close())

    if (schedulerDriver != null) {
      schedulerDriver.stop()
    }
  }

  override def frameworkMessage(
      d: org.apache.mesos.SchedulerDriver, e: ExecutorID, s: SlaveID, b: Array[Byte]) {}

  /**
   * Called when a slave is lost or a Mesos task finished. Updates local view on
   * what tasks are running. It also notifies the driver that an executor was removed.
   */
  private def executorTerminated(
      d: org.apache.mesos.SchedulerDriver,
      slaveId: String,
      taskId: String,
      reason: String): Unit = {
    stateLock.synchronized {
      // Do not call removeExecutor() after this scheduler backend was stopped because
      // removeExecutor() internally will send a message to the driver endpoint but
      // the driver endpoint is not available now, otherwise an exception will be thrown.
      if (!stopCalled) {
        removeExecutor(taskId, SlaveLost(reason))
      }
      slaves(slaveId).taskIDs.remove(taskId)
    }
  }

  override def slaveLost(d: org.apache.mesos.SchedulerDriver, slaveId: SlaveID): Unit = {
    logInfo(s"Mesos slave lost: ${slaveId.getValue}")
  }

  override def executorLost(
      d: org.apache.mesos.SchedulerDriver, e: ExecutorID, s: SlaveID, status: Int): Unit = {
    logInfo("Mesos executor lost: %s".format(e.getValue))
  }

  override def applicationId(): String =
    Option(appId).getOrElse {
      logWarning("Application ID is not initialized yet.")
      super.applicationId
    }

  override def doRequestTotalExecutors(requestedTotal: Int): Future[Boolean] = Future.successful {
    // We don't truly know if we can fulfill the full amount of executors
    // since at coarse grain it depends on the amount of slaves available.
    logInfo("Capping the total amount of executors to " + requestedTotal)
    executorLimitOption = Some(requestedTotal)
    true
  }

  override def doKillExecutors(executorIds: Seq[String]): Future[Boolean] = Future.successful {
    if (schedulerDriver == null) {
      logWarning("Asked to kill executors before the Mesos driver was started.")
      false
    } else {
      for (executorId <- executorIds) {
        val taskId = TaskID.newBuilder().setValue(executorId).build()
        schedulerDriver.killTask(taskId)
      }
      // no need to adjust `executorLimitOption` since the AllocationManager already communicated
      // the desired limit through a call to `doRequestTotalExecutors`.
      // See [[o.a.s.scheduler.cluster.CoarseGrainedSchedulerBackend.killExecutors]]
      true
    }
  }

  private def numExecutors(): Int = {
    slaves.values.map(_.taskIDs.size).sum
  }

  private def executorHostname(offer: Offer): String = {
    if (sc.conf.getOption("spark.mesos.network.name").isDefined) {
      // The agent's IP is not visible in a CNI container, so we bind to 0.0.0.0
      "0.0.0.0"
    } else {
      offer.getHostname
    }
  }
}

private class Slave(val hostname: String) {
  val taskIDs = new mutable.HashSet[String]()
  var taskFailures = 0
  var shuffleRegistered = false
}
