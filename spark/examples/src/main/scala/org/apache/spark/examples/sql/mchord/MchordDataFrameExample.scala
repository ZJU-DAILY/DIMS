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

package org.apache.spark.examples.sql.mchord

import org.apache.spark.internal.Logging
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.expressions.mchord.MetricSimilarityFunction
import org.apache.spark.sql.catalyst.expressions.mchord.common.MchordConfigConstants
import org.apache.spark.sql.catalyst.expressions.mchord.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.mchord.common.metric.MetricData
import org.apache.spark.sql.execution.mchord.sql.MchordIternalRow
import org.apache.spark.sql.catalyst.util.ArrayData
import org.apache.spark.util.SizeEstimator
// import org.apache.spark.sql.catalyst.expressions.mchord.common.trajectory.Trajectory

object MchordDataFrameExample extends Logging {

  case class MetricRecord(id: Long, metric: Array[Double])

  case class MetricRecordString(id: Long, metric: String)

  private def getMetric(line: (String, Long)): MetricRecord = {
    val points = line._1.split(" ").map(x => x.toDouble)
    MetricRecord(line._2, points)
  }

  private def getMetricString(line: (String, Long)): MetricRecordString = {
    MetricRecordString(line._2, line._1)
  }

  def main(args: Array[String]) {
    val spark = SparkSession
      .builder()
      //      .master("spark://node20:7077")
      //      .master("local[*]")
      .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .getOrCreate()

    // For implicit conversions like converting RDDs to DataFrames
    import spark.implicits._
    val textDir = if (args.length > 0) args(0) else "examples/src/main/resources/mpeg.txt"

    MchordConfigConstants.DATA_TYPE = if (args.length > 1) args(1).toInt else 0
    MchordConfigConstants.MCHORD_DISTANCE_TYPE = if (args.length > 2) args(2).toInt else 1
    MchordConfigConstants.KNN = if (args.length > 3) args(3).toInt else 8
    MchordConfigConstants.RANGE = if (args.length > 4) args(4).toDouble else 3800
    MchordConfigConstants.GLOBAL_INDEXED_PIVOT_COUNT = if (args.length > 5) args(5).toInt else 160
    val SEARCH_TIME = if (args.length > 6) args(6).toInt else 3
    val INSERT_OR_NOT = if (args.length > 7) args(7).toInt else 1
    val INSERT_NUM = if (args.length > 8) args(8).toInt else 10000

    val metric = spark.sparkContext
      .textFile(textDir)
      .zipWithIndex()
      .filter(_._1 != "")

    if (MchordConfigConstants.DATA_TYPE == 0) {

      val metricData = metric.map(getMetric)


      val df1 = metricData.toDF()
      df1.createOrReplaceTempView("metric1")
      df1.createMchordIndex(df1("metric"), "metric_index1")


      //      val queryPoint = Point[Any](metricData.filter(t => t.id == 982).take(1).head.metric)
      var start = System.currentTimeMillis()
      var end = start
      val times = Array.ofDim[Long](SEARCH_TIME)

      if (INSERT_OR_NOT == 1) {
        for (i <- 0 until SEARCH_TIME) {
          val radius = MchordConfigConstants.RANGE
          val queryPoint = Point[Any](metricData.filter(t => t.id == (982 + i)).take(1).head.metric)
          start = System.currentTimeMillis()
          df1.metricSimilarityWithRangeSearch(queryPoint, radius, df1("metric")).show()
          end = System.currentTimeMillis()
          logWarning(s"Mchord Range Search Times ${i}: ${end - start} ms")
          times(i) = end - start
        }
        logWarning(s"Mchord KNN Search Average Time: ${times.sum / SEARCH_TIME} ms")
        for (i <- 0 until INSERT_NUM) {
          val insertPoint = Point[Any](metricData.takeSample(false, 1).take(1).head.metric)
          df1.mchordInsert(insertPoint, df1("metric")).show()
        }
        for (i <- 0 until INSERT_NUM) {
          val deletePoint = Point[Any](metricData.takeSample(false, 1).take(1).head.metric)
          df1.mchordDelete(deletePoint, df1("metric")).show()
        }
      } else {
        for (i <- 0 until SEARCH_TIME) {
          val queryPoint = Point[Any](metricData.filter(t => t.id == (982 + i)).take(1).head.metric)
          start = System.currentTimeMillis()
          val nn = MchordConfigConstants.KNN
          df1.metricSimilarityWithKNNSearch(queryPoint, df1("metric"),
            MetricSimilarityFunction.EUCLID, nn).show()
          end = System.currentTimeMillis()
          logWarning(s"Mchord KNN Search Times ${i}: ${end - start} ms")
          times(i) = end - start
        }
        logWarning(s"Mchord KNN Search Average Time: ${times.sum / SEARCH_TIME} ms")
      }

      for (i <- 0 until SEARCH_TIME) {
        val radius = MchordConfigConstants.RANGE
        val queryPoint = Point[Any](metricData.filter(t => t.id == (982 + i)).take(1).head.metric)
        start = System.currentTimeMillis()
        df1.metricSimilarityWithRangeSearch(queryPoint, radius, df1("metric")).show()
        end = System.currentTimeMillis()
        logWarning(s"Mchord Range Search Times ${i}: ${end - start} ms")
        times(i) = end - start
      }
      logWarning(s"Mchord Range Search Average Time: ${times.sum / SEARCH_TIME} ms")
    } else {
      val metricData = metric.map(getMetricString)

      val df1 = metricData.toDF()
      df1.createOrReplaceTempView("metric1")
      df1.createMchordIndex(df1("metric"), "metric_index1")


      val queryPoint = Point[Any](metricData.filter(t => t.id == 982).take(1).head.metric)
      var start = System.currentTimeMillis()
      var end = start
      val times = Array.ofDim[Long](SEARCH_TIME)
      if (INSERT_OR_NOT == 1) {
        for (i <- 0 until SEARCH_TIME) {
          val queryPoint = Point[Any](metricData.filter(t => t.id == (982 + i)).take(1).head.metric)
          val radius = MchordConfigConstants.RANGE
          start = System.currentTimeMillis()
          df1.metricSimilarityWithRangeSearch(queryPoint, radius, df1("metric")).show()
          end = System.currentTimeMillis()
          logWarning(s"Mchord Range Search Times ${i}: ${end - start} ms")
          times(i) = end - start
        }
        logWarning(s"Mchord Range Search Average Time: ${times.sum / SEARCH_TIME} ms")

        for (i <- 0 until INSERT_NUM) {
          val insertPoint = Point[Any](metricData.takeSample(false, 1).take(1).head.metric)
          df1.mchordInsert(insertPoint, df1("metric")).show()
        }
        for (i <- 0 until INSERT_NUM) {
          val deletePoint = Point[Any](metricData.takeSample(false, 1).take(1).head.metric)
          df1.mchordDelete(deletePoint, df1("metric")).show()
        }
      } else {
        for (i <- 0 until SEARCH_TIME) {
          val queryPoint = Point[Any](metricData.filter(t => t.id == (982 + i)).take(1).head.metric)
          val nn = MchordConfigConstants.KNN
          start = System.currentTimeMillis()
          df1.metricSimilarityWithKNNSearch(queryPoint, df1("metric"),
            MetricSimilarityFunction.EUCLID, nn).show()
          end = System.currentTimeMillis()
          logWarning(s"Mchord KNN Search Times ${i}: ${end - start} ms")
          times(i) = end - start
        }
        logWarning(s"Mchord KNN Search Average Time: ${times.sum / SEARCH_TIME} ms")
      }
      for (i <- 0 until SEARCH_TIME) {
        val queryPoint = Point[Any](metricData.filter(t => t.id == (982 + i)).take(1).head.metric)
        val radius = MchordConfigConstants.RANGE
        start = System.currentTimeMillis()
        df1.metricSimilarityWithRangeSearch(queryPoint, radius, df1("metric")).show()
        end = System.currentTimeMillis()
        logWarning(s"Mchord Range Search Times ${i}: ${end - start} ms")
        times(i) = end - start
      }
      logWarning(s"Mchord Range Search Average Time: ${times.sum / SEARCH_TIME} ms")
    }


    spark.stop()
  }
}
