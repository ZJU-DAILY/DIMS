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
package org.apache.spark.status.api.v1

import java.util.zip.ZipOutputStream
import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest
import javax.ws.rs._
import javax.ws.rs.core.{Context, Response}

import org.eclipse.jetty.server.handler.ContextHandler
import org.eclipse.jetty.servlet.{ServletContextHandler, ServletHolder}
import org.glassfish.jersey.server.ServerProperties
import org.glassfish.jersey.servlet.ServletContainer

import org.apache.spark.SecurityManager
import org.apache.spark.ui.SparkUI

/**
 * Main entry point for serving spark application metrics as json, using JAX-RS.
 *
 * Each resource should have endpoints that return **public** classes defined in api.scala.  Mima
 * binary compatibility checks ensure that we don't inadvertently make changes that break the api.
 * The returned objects are automatically converted to json by jackson with JacksonMessageWriter.
 * In addition, there are a number of tests in HistoryServerSuite that compare the json to "golden
 * files".  Any changes and additions should be reflected there as well -- see the notes in
 * HistoryServerSuite.
 */
@Path("/v1")
private[v1] class ApiRootResource extends ApiRequestContext {

  @Path("applications")
  def getApplicationList(): ApplicationListResource = {
    new ApplicationListResource(uiRoot)
  }

  @Path("applications/{appId}")
  def getApplication(): OneApplicationResource = {
    new OneApplicationResource(uiRoot)
  }

  @Path("applications/{appId}/{attemptId}/jobs")
  def getJobs(
      @PathParam("appId") appId: String,
      @PathParam("attemptId") attemptId: String): AllJobsResource = {
    withSparkUI(appId, Some(attemptId)) { ui =>
      new AllJobsResource(ui)
    }
  }

  @Path("applications/{appId}/jobs")
  def getJobs(@PathParam("appId") appId: String): AllJobsResource = {
    withSparkUI(appId, None) { ui =>
      new AllJobsResource(ui)
    }
  }

  @Path("applications/{appId}/jobs/{jobId: \\d+}")
  def getJob(@PathParam("appId") appId: String): OneJobResource = {
    withSparkUI(appId, None) { ui =>
      new OneJobResource(ui)
    }
  }

  @Path("applications/{appId}/{attemptId}/jobs/{jobId: \\d+}")
  def getJob(
      @PathParam("appId") appId: String,
      @PathParam("attemptId") attemptId: String): OneJobResource = {
    withSparkUI(appId, Some(attemptId)) { ui =>
      new OneJobResource(ui)
    }
  }

  @Path("applications/{appId}/executors")
  def getExecutors(@PathParam("appId") appId: String): ExecutorListResource = {
    withSparkUI(appId, None) { ui =>
      new ExecutorListResource(ui)
    }
  }

  @Path("applications/{appId}/allexecutors")
  def getAllExecutors(@PathParam("appId") appId: String): AllExecutorListResource = {
    withSparkUI(appId, None) { ui =>
      new AllExecutorListResource(ui)
    }
  }

  @Path("applications/{appId}/{attemptId}/executors")
  def getExecutors(
      @PathParam("appId") appId: String,
      @PathParam("attemptId") attemptId: String): ExecutorListResource = {
    withSparkUI(appId, Some(attemptId)) { ui =>
      new ExecutorListResource(ui)
    }
  }

  @Path("applications/{appId}/{attemptId}/allexecutors")
  def getAllExecutors(
      @PathParam("appId") appId: String,
      @PathParam("attemptId") attemptId: String): AllExecutorListResource = {
    withSparkUI(appId, Some(attemptId)) { ui =>
      new AllExecutorListResource(ui)
    }
  }

  @Path("applications/{appId}/stages")
  def getStages(@PathParam("appId") appId: String): AllStagesResource = {
    withSparkUI(appId, None) { ui =>
      new AllStagesResource(ui)
    }
  }

  @Path("applications/{appId}/{attemptId}/stages")
  def getStages(
      @PathParam("appId") appId: String,
      @PathParam("attemptId") attemptId: String): AllStagesResource = {
    withSparkUI(appId, Some(attemptId)) { ui =>
      new AllStagesResource(ui)
    }
  }

  @Path("applications/{appId}/stages/{stageId: \\d+}")
  def getStage(@PathParam("appId") appId: String): OneStageResource = {
    withSparkUI(appId, None) { ui =>
      new OneStageResource(ui)
    }
  }

  @Path("applications/{appId}/{attemptId}/stages/{stageId: \\d+}")
  def getStage(
      @PathParam("appId") appId: String,
      @PathParam("attemptId") attemptId: String): OneStageResource = {
    withSparkUI(appId, Some(attemptId)) { ui =>
      new OneStageResource(ui)
    }
  }

  @Path("applications/{appId}/storage/rdd")
  def getRdds(@PathParam("appId") appId: String): AllRDDResource = {
    withSparkUI(appId, None) { ui =>
      new AllRDDResource(ui)
    }
  }

  @Path("applications/{appId}/{attemptId}/storage/rdd")
  def getRdds(
      @PathParam("appId") appId: String,
      @PathParam("attemptId") attemptId: String): AllRDDResource = {
    withSparkUI(appId, Some(attemptId)) { ui =>
      new AllRDDResource(ui)
    }
  }

  @Path("applications/{appId}/storage/rdd/{rddId: \\d+}")
  def getRdd(@PathParam("appId") appId: String): OneRDDResource = {
    withSparkUI(appId, None) { ui =>
      new OneRDDResource(ui)
    }
  }

  @Path("applications/{appId}/{attemptId}/storage/rdd/{rddId: \\d+}")
  def getRdd(
      @PathParam("appId") appId: String,
      @PathParam("attemptId") attemptId: String): OneRDDResource = {
    withSparkUI(appId, Some(attemptId)) { ui =>
      new OneRDDResource(ui)
    }
  }

  @Path("applications/{appId}/logs")
  def getEventLogs(
      @PathParam("appId") appId: String): EventLogDownloadResource = {
    try {
      // withSparkUI will throw NotFoundException if attemptId exists for this application.
      // So we need to try again with attempt id "1".
      withSparkUI(appId, None) { _ =>
        new EventLogDownloadResource(uiRoot, appId, None)
      }
    } catch {
      case _: NotFoundException =>
        withSparkUI(appId, Some("1")) { _ =>
          new EventLogDownloadResource(uiRoot, appId, None)
        }
    }
  }

  @Path("applications/{appId}/{attemptId}/logs")
  def getEventLogs(
      @PathParam("appId") appId: String,
      @PathParam("attemptId") attemptId: String): EventLogDownloadResource = {
    withSparkUI(appId, Some(attemptId)) { _ =>
      new EventLogDownloadResource(uiRoot, appId, Some(attemptId))
    }
  }

  @Path("version")
  def getVersion(): VersionResource = {
    new VersionResource(uiRoot)
  }

  @Path("applications/{appId}/environment")
  def getEnvironment(@PathParam("appId") appId: String): ApplicationEnvironmentResource = {
    withSparkUI(appId, None) { ui =>
      new ApplicationEnvironmentResource(ui)
    }
  }

  @Path("applications/{appId}/{attemptId}/environment")
  def getEnvironment(
      @PathParam("appId") appId: String,
      @PathParam("attemptId") attemptId: String): ApplicationEnvironmentResource = {
    withSparkUI(appId, Some(attemptId)) { ui =>
      new ApplicationEnvironmentResource(ui)
    }
  }
}

private[spark] object ApiRootResource {

  def getServletHandler(uiRoot: UIRoot): ServletContextHandler = {
    val jerseyContext = new ServletContextHandler(ServletContextHandler.NO_SESSIONS)
    jerseyContext.setContextPath("/api")
    val holder: ServletHolder = new ServletHolder(classOf[ServletContainer])
    holder.setInitParameter(ServerProperties.PROVIDER_PACKAGES, "org.apache.spark.status.api.v1")
    UIRootFromServletContext.setUiRoot(jerseyContext, uiRoot)
    jerseyContext.addServlet(holder, "/*")
    jerseyContext
  }
}

/**
 * This trait is shared by the all the root containers for application UI information --
 * the HistoryServer and the application UI.  This provides the common
 * interface needed for them all to expose application info as json.
 */
private[spark] trait UIRoot {
  def getSparkUI(appKey: String): Option[SparkUI]
  def getApplicationInfoList: Iterator[ApplicationInfo]
  def getApplicationInfo(appId: String): Option[ApplicationInfo]

  /**
   * Write the event logs for the given app to the [[ZipOutputStream]] instance. If attemptId is
   * [[None]], event logs for all attempts of this application will be written out.
   */
  def writeEventLogs(appId: String, attemptId: Option[String], zipStream: ZipOutputStream): Unit = {
    Response.serverError()
      .entity("Event logs are only available through the history server.")
      .status(Response.Status.SERVICE_UNAVAILABLE)
      .build()
  }
  def securityManager: SecurityManager
}

private[v1] object UIRootFromServletContext {

  private val attribute = getClass.getCanonicalName

  def setUiRoot(contextHandler: ContextHandler, uiRoot: UIRoot): Unit = {
    contextHandler.setAttribute(attribute, uiRoot)
  }

  def getUiRoot(context: ServletContext): UIRoot = {
    context.getAttribute(attribute).asInstanceOf[UIRoot]
  }
}

private[v1] trait ApiRequestContext {
  @Context
  protected var servletContext: ServletContext = _

  @Context
  protected var httpRequest: HttpServletRequest = _

  def uiRoot: UIRoot = UIRootFromServletContext.getUiRoot(servletContext)


  /**
   * Get the spark UI with the given appID, and apply a function
   * to it.  If there is no such app, throw an appropriate exception
   */
  def withSparkUI[T](appId: String, attemptId: Option[String])(f: SparkUI => T): T = {
    val appKey = attemptId.map(appId + "/" + _).getOrElse(appId)
    uiRoot.getSparkUI(appKey) match {
      case Some(ui) =>
        val user = httpRequest.getRemoteUser()
        if (!ui.securityManager.checkUIViewPermissions(user)) {
          throw new ForbiddenException(raw"""user "$user" is not authorized""")
        }
        f(ui)
      case None => throw new NotFoundException("no such app: " + appId)
    }
  }
}

private[v1] class ForbiddenException(msg: String) extends WebApplicationException(
  Response.status(Response.Status.FORBIDDEN).entity(msg).build())

private[v1] class NotFoundException(msg: String) extends WebApplicationException(
  new NoSuchElementException(msg),
    Response
      .status(Response.Status.NOT_FOUND)
      .entity(ErrorWrapper(msg))
      .build()
)

private[v1] class BadParameterException(msg: String) extends WebApplicationException(
  new IllegalArgumentException(msg),
  Response
    .status(Response.Status.BAD_REQUEST)
    .entity(ErrorWrapper(msg))
    .build()
) {
  def this(param: String, exp: String, actual: String) = {
    this(raw"""Bad value for parameter "$param".  Expected a $exp, got "$actual"""")
  }
}

/**
 * Signal to JacksonMessageWriter to not convert the message into json (which would result in an
 * extra set of quotes).
 */
private[v1] case class ErrorWrapper(s: String)
