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

package org.apache.spark.sql.execution.streaming

import java.util.concurrent.ConcurrentLinkedQueue

import scala.collection.mutable

import org.scalatest.BeforeAndAfter

import org.apache.spark.SparkException
import org.apache.spark.sql.ForeachWriter
import org.apache.spark.sql.functions.{count, window}
import org.apache.spark.sql.streaming.{OutputMode, StreamingQueryException, StreamTest}
import org.apache.spark.sql.test.SharedSQLContext

class ForeachSinkSuite extends StreamTest with SharedSQLContext with BeforeAndAfter {

  import testImplicits._

  after {
    sqlContext.streams.active.foreach(_.stop())
  }

  test("foreach() with `append` output mode") {
    withTempDir { checkpointDir =>
      val input = MemoryStream[Int]
      val query = input.toDS().repartition(2).writeStream
        .option("checkpointLocation", checkpointDir.getCanonicalPath)
        .outputMode(OutputMode.Append)
        .foreach(new TestForeachWriter())
        .start()

      // -- batch 0 ---------------------------------------
      input.addData(1, 2, 3, 4)
      query.processAllAvailable()

      var expectedEventsForPartition0 = Seq(
        ForeachSinkSuite.Open(partition = 0, version = 0),
        ForeachSinkSuite.Process(value = 1),
        ForeachSinkSuite.Process(value = 3),
        ForeachSinkSuite.Close(None)
      )
      var expectedEventsForPartition1 = Seq(
        ForeachSinkSuite.Open(partition = 1, version = 0),
        ForeachSinkSuite.Process(value = 2),
        ForeachSinkSuite.Process(value = 4),
        ForeachSinkSuite.Close(None)
      )

      var allEvents = ForeachSinkSuite.allEvents()
      assert(allEvents.size === 2)
      assert(allEvents.toSet === Set(expectedEventsForPartition0, expectedEventsForPartition1))

      ForeachSinkSuite.clear()

      // -- batch 1 ---------------------------------------
      input.addData(5, 6, 7, 8)
      query.processAllAvailable()

      expectedEventsForPartition0 = Seq(
        ForeachSinkSuite.Open(partition = 0, version = 1),
        ForeachSinkSuite.Process(value = 5),
        ForeachSinkSuite.Process(value = 7),
        ForeachSinkSuite.Close(None)
      )
      expectedEventsForPartition1 = Seq(
        ForeachSinkSuite.Open(partition = 1, version = 1),
        ForeachSinkSuite.Process(value = 6),
        ForeachSinkSuite.Process(value = 8),
        ForeachSinkSuite.Close(None)
      )

      allEvents = ForeachSinkSuite.allEvents()
      assert(allEvents.size === 2)
      assert(allEvents.toSet === Set(expectedEventsForPartition0, expectedEventsForPartition1))

      query.stop()
    }
  }

  test("foreach() with `complete` output mode") {
    withTempDir { checkpointDir =>
      val input = MemoryStream[Int]

      val query = input.toDS()
        .groupBy().count().as[Long].map(_.toInt)
        .writeStream
        .option("checkpointLocation", checkpointDir.getCanonicalPath)
        .outputMode(OutputMode.Complete)
        .foreach(new TestForeachWriter())
        .start()

      // -- batch 0 ---------------------------------------
      input.addData(1, 2, 3, 4)
      query.processAllAvailable()

      var allEvents = ForeachSinkSuite.allEvents()
      assert(allEvents.size === 1)
      var expectedEvents = Seq(
        ForeachSinkSuite.Open(partition = 0, version = 0),
        ForeachSinkSuite.Process(value = 4),
        ForeachSinkSuite.Close(None)
      )
      assert(allEvents === Seq(expectedEvents))

      ForeachSinkSuite.clear()

      // -- batch 1 ---------------------------------------
      input.addData(5, 6, 7, 8)
      query.processAllAvailable()

      allEvents = ForeachSinkSuite.allEvents()
      assert(allEvents.size === 1)
      expectedEvents = Seq(
        ForeachSinkSuite.Open(partition = 0, version = 1),
        ForeachSinkSuite.Process(value = 8),
        ForeachSinkSuite.Close(None)
      )
      assert(allEvents === Seq(expectedEvents))

      query.stop()
    }
  }

  testQuietly("foreach with error") {
    withTempDir { checkpointDir =>
      val input = MemoryStream[Int]
      val query = input.toDS().repartition(1).writeStream
        .option("checkpointLocation", checkpointDir.getCanonicalPath)
        .foreach(new TestForeachWriter() {
          override def process(value: Int): Unit = {
            super.process(value)
            throw new RuntimeException("error")
          }
        }).start()
      input.addData(1, 2, 3, 4)

      // Error in `process` should fail the Spark job
      val e = intercept[StreamingQueryException] {
        query.processAllAvailable()
      }
      assert(e.getCause.isInstanceOf[SparkException])
      assert(e.getCause.getCause.getMessage === "error")
      assert(query.isActive === false)

      val allEvents = ForeachSinkSuite.allEvents()
      assert(allEvents.size === 1)
      assert(allEvents(0)(0) === ForeachSinkSuite.Open(partition = 0, version = 0))
      assert(allEvents(0)(1) === ForeachSinkSuite.Process(value = 1))

      // `close` should be called with the error
      val errorEvent = allEvents(0)(2).asInstanceOf[ForeachSinkSuite.Close]
      assert(errorEvent.error.get.isInstanceOf[RuntimeException])
      assert(errorEvent.error.get.getMessage === "error")
    }
  }

  test("foreach with watermark: complete") {
    val inputData = MemoryStream[Int]

    val windowedAggregation = inputData.toDF()
      .withColumn("eventTime", $"value".cast("timestamp"))
      .withWatermark("eventTime", "10 seconds")
      .groupBy(window($"eventTime", "5 seconds") as 'window)
      .agg(count("*") as 'count)
      .select($"count".as[Long])
      .map(_.toInt)
      .repartition(1)

    val query = windowedAggregation
      .writeStream
      .outputMode(OutputMode.Complete)
      .foreach(new TestForeachWriter())
      .start()
    try {
      inputData.addData(10, 11, 12)
      query.processAllAvailable()

      val allEvents = ForeachSinkSuite.allEvents()
      assert(allEvents.size === 1)
      val expectedEvents = Seq(
        ForeachSinkSuite.Open(partition = 0, version = 0),
        ForeachSinkSuite.Process(value = 3),
        ForeachSinkSuite.Close(None)
      )
      assert(allEvents === Seq(expectedEvents))
    } finally {
      query.stop()
    }
  }

  test("foreach with watermark: append") {
    val inputData = MemoryStream[Int]

    val windowedAggregation = inputData.toDF()
      .withColumn("eventTime", $"value".cast("timestamp"))
      .withWatermark("eventTime", "10 seconds")
      .groupBy(window($"eventTime", "5 seconds") as 'window)
      .agg(count("*") as 'count)
      .select($"count".as[Long])
      .map(_.toInt)
      .repartition(1)

    val query = windowedAggregation
      .writeStream
      .outputMode(OutputMode.Append)
      .foreach(new TestForeachWriter())
      .start()
    try {
      inputData.addData(10, 11, 12)
      query.processAllAvailable()
      inputData.addData(25) // Advance watermark to 15 seconds
      query.processAllAvailable()
      inputData.addData(25) // Evict items less than previous watermark
      query.processAllAvailable()

      // There should be 3 batches and only does the last batch contain a value.
      val allEvents = ForeachSinkSuite.allEvents()
      assert(allEvents.size === 3)
      val expectedEvents = Seq(
        Seq(
          ForeachSinkSuite.Open(partition = 0, version = 0),
          ForeachSinkSuite.Close(None)
        ),
        Seq(
          ForeachSinkSuite.Open(partition = 0, version = 1),
          ForeachSinkSuite.Close(None)
        ),
        Seq(
          ForeachSinkSuite.Open(partition = 0, version = 2),
          ForeachSinkSuite.Process(value = 3),
          ForeachSinkSuite.Close(None)
        )
      )
      assert(allEvents === expectedEvents)
    } finally {
      query.stop()
    }
  }

  test("foreach sink should support metrics") {
    val inputData = MemoryStream[Int]
    val query = inputData.toDS()
      .writeStream
      .foreach(new TestForeachWriter())
      .start()
    try {
      inputData.addData(10, 11, 12)
      query.processAllAvailable()
      val recentProgress = query.recentProgress.filter(_.numInputRows != 0).headOption
      assert(recentProgress.isDefined && recentProgress.get.numInputRows === 3,
        s"recentProgress[${query.recentProgress.toList}] doesn't contain correct metrics")
    } finally {
      query.stop()
    }
  }
}

/** A global object to collect events in the executor */
object ForeachSinkSuite {

  trait Event

  case class Open(partition: Long, version: Long) extends Event

  case class Process[T](value: T) extends Event

  case class Close(error: Option[Throwable]) extends Event

  private val _allEvents = new ConcurrentLinkedQueue[Seq[Event]]()

  def addEvents(events: Seq[Event]): Unit = {
    _allEvents.add(events)
  }

  def allEvents(): Seq[Seq[Event]] = {
    _allEvents.toArray(new Array[Seq[Event]](_allEvents.size()))
  }

  def clear(): Unit = {
    _allEvents.clear()
  }
}

/** A [[ForeachWriter]] that writes collected events to ForeachSinkSuite */
class TestForeachWriter extends ForeachWriter[Int] {
  ForeachSinkSuite.clear()

  private val events = mutable.ArrayBuffer[ForeachSinkSuite.Event]()

  override def open(partitionId: Long, version: Long): Boolean = {
    events += ForeachSinkSuite.Open(partition = partitionId, version = version)
    true
  }

  override def process(value: Int): Unit = {
    events += ForeachSinkSuite.Process(value)
  }

  override def close(errorOrNull: Throwable): Unit = {
    events += ForeachSinkSuite.Close(error = Option(errorOrNull))
    ForeachSinkSuite.addEvents(events)
  }
}
