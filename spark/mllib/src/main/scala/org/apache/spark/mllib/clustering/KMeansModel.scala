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

package org.apache.spark.mllib.clustering

import scala.collection.JavaConverters._

import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

import org.apache.spark.SparkContext
import org.apache.spark.annotation.Since
import org.apache.spark.api.java.JavaRDD
import org.apache.spark.mllib.linalg.Vector
import org.apache.spark.mllib.pmml.PMMLExportable
import org.apache.spark.mllib.util.{Loader, Saveable}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SparkSession}

/**
 * A clustering model for K-means. Each point belongs to the cluster with the closest center.
 */
@Since("0.8.0")
class KMeansModel @Since("1.1.0") (@Since("1.0.0") val clusterCenters: Array[Vector])
  extends Saveable with Serializable with PMMLExportable {

  private val clusterCentersWithNorm =
    if (clusterCenters == null) null else clusterCenters.map(new VectorWithNorm(_))

  /**
   * A Java-friendly constructor that takes an Iterable of Vectors.
   */
  @Since("1.4.0")
  def this(centers: java.lang.Iterable[Vector]) = this(centers.asScala.toArray)

  /**
   * Total number of clusters.
   */
  @Since("0.8.0")
  def k: Int = clusterCentersWithNorm.length

  /**
   * Returns the cluster index that a given point belongs to.
   */
  @Since("0.8.0")
  def predict(point: Vector): Int = {
    KMeans.findClosest(clusterCentersWithNorm, new VectorWithNorm(point))._1
  }

  /**
   * Maps given points to their cluster indices.
   */
  @Since("1.0.0")
  def predict(points: RDD[Vector]): RDD[Int] = {
    val bcCentersWithNorm = points.context.broadcast(clusterCentersWithNorm)
    points.map(p => KMeans.findClosest(bcCentersWithNorm.value, new VectorWithNorm(p))._1)
  }

  /**
   * Maps given points to their cluster indices.
   */
  @Since("1.0.0")
  def predict(points: JavaRDD[Vector]): JavaRDD[java.lang.Integer] =
    predict(points.rdd).toJavaRDD().asInstanceOf[JavaRDD[java.lang.Integer]]

  /**
   * Return the K-means cost (sum of squared distances of points to their nearest center) for this
   * model on the given data.
   */
  @Since("0.8.0")
  def computeCost(data: RDD[Vector]): Double = {
    val bcCentersWithNorm = data.context.broadcast(clusterCentersWithNorm)
    data.map(p => KMeans.pointCost(bcCentersWithNorm.value, new VectorWithNorm(p))).sum()
  }


  @Since("1.4.0")
  override def save(sc: SparkContext, path: String): Unit = {
    KMeansModel.SaveLoadV1_0.save(sc, this, path)
  }

  override protected def formatVersion: String = "1.0"
}

@Since("1.4.0")
object KMeansModel extends Loader[KMeansModel] {

  @Since("1.4.0")
  override def load(sc: SparkContext, path: String): KMeansModel = {
    KMeansModel.SaveLoadV1_0.load(sc, path)
  }

  private case class Cluster(id: Int, point: Vector)

  private object Cluster {
    def apply(r: Row): Cluster = {
      Cluster(r.getInt(0), r.getAs[Vector](1))
    }
  }

  private[clustering]
  object SaveLoadV1_0 {

    private val thisFormatVersion = "1.0"

    private[clustering]
    val thisClassName = "org.apache.spark.mllib.clustering.KMeansModel"

    def save(sc: SparkContext, model: KMeansModel, path: String): Unit = {
      val spark = SparkSession.builder().sparkContext(sc).getOrCreate()
      val metadata = compact(render(
        ("class" -> thisClassName) ~ ("version" -> thisFormatVersion) ~ ("k" -> model.k)))
      sc.parallelize(Seq(metadata), 1).saveAsTextFile(Loader.metadataPath(path))
      val dataRDD = sc.parallelize(model.clusterCentersWithNorm.zipWithIndex).map { case (p, id) =>
        Cluster(id, p.vector)
      }
      spark.createDataFrame(dataRDD).write.parquet(Loader.dataPath(path))
    }

    def load(sc: SparkContext, path: String): KMeansModel = {
      implicit val formats = DefaultFormats
      val spark = SparkSession.builder().sparkContext(sc).getOrCreate()
      val (className, formatVersion, metadata) = Loader.loadMetadata(sc, path)
      assert(className == thisClassName)
      assert(formatVersion == thisFormatVersion)
      val k = (metadata \ "k").extract[Int]
      val centroids = spark.read.parquet(Loader.dataPath(path))
      Loader.checkSchema[Cluster](centroids.schema)
      val localCentroids = centroids.rdd.map(Cluster.apply).collect()
      assert(k == localCentroids.length)
      new KMeansModel(localCentroids.sortBy(_.id).map(_.point))
    }
  }
}
