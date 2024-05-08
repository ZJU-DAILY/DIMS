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
package org.apache.spark.sql.catalyst.expressions.dims.common.metric

import org.apache.spark.sql.catalyst.expressions.dims.common.DIMSConfigConstants
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import org.slf4j.{Logger, LoggerFactory}
import hep.aida.bin.StaticBin1D

import scala.util.Random

import scala.collection.immutable.HashSet
import cern.colt.list.LongArrayList
import scala.util.control.Breaks.break

case class MetricData(points: Array[Point[Any]]) {
  require(points.nonEmpty)

  /**
   * Alpha is the number of positive or negative STDS that we will add.
   */
  private var alpha = 0
  var maxDistance = new StaticBin1D()

  override def toString: String = {
    s"Metric(points = ${points.mkString(",")}"
  }

  //  @transient
  //  private lazy val mbr: Rectangle = calcMBR()
  //  @transient
  //  private var extendedMBR: Rectangle = _
  @transient
  private lazy val globalIndexedPivot: Array[Point[Any]] =
  generatePivots(DIMSConfigConstants.GLOBAL_INDEXED_PIVOT_COUNT).map(_._1)
  //  @transient
  //  private lazy val localIndexedPivot: Array[Point[Any]] =
  //    calcPivot(MchordConfigConstants.LOCAL_INDEXED_PIVOT_COUNT).map(_._1)

  //  @transient
  //  private lazy val numDimensions = points.head.coord.length

  //  private def calcMBR(): Rectangle = {
  //    val dimension = numDimensions
  //    val min = (0 until dimension).map(i => points.map(_.coord(i)).min).toArray
  //    val max = (0 until dimension).map(i => points.map(_.coord(i)).max).toArray
  //    Rectangle(Point[Any](min), Point[Any](max))
  //  }
  //
  //  private def calcExtendedMBR(threshold: Double): Rectangle = {
  //    Rectangle(Point[Any](mbr.low.coord.map(_ - threshold)), Point[Any](mbr.high.coord.map(_ + threshold)))
  //  }

  //  private def calcPivot(count: Int): Array[(Point[Any], Int)] = {
  //    val pointsWithIndex = points.zipWithIndex.init
  //    val pivot = pointsWithIndex.zip(pointsWithIndex.drop(1)).map(x => {
  //      val point1 = x._1._1
  //      val point2 = x._2._1
  //      val vector1 = point1 - point2
  //      val distance = PointDistance.eval(vector1)
  //      (x._2, distance)
  //    }).sortBy(-_._2).map(_._1).take(count)
  //
  //    pivot.sortBy(_._2)
  //
  //
  //  }

  def generatePivots(pivotCount: Int): Array[(Point[Any], Int)] = {
    val random = new Random()
    val LOG: Logger = LoggerFactory.getLogger(getClass)
    val ids = selectUnique(100, random, null)
    var i = 0

    for (id1 <- ids) {

      LOG.warn(s"Doing: $i mean: ${maxDistance.mean()}")
      for (id2 <- ids) {
        if (id1 != id2) {
          val candidate1 = points(id1.toInt)
          val candidate2 = points(id2.toInt)
          maxDistance.add(candidate1.minDist(candidate2))
        }
      }
      i += 1
    }
    LOG.warn(s"Sample histogram calculated, mean dist: ${maxDistance.mean()}")

    var pivots = Array[(Point[Any], Int)]()
    val list = new LongArrayList(pivotCount);
    while (pivots.size < pivotCount) {
      val shouldAdd = true
      // add the pivot if it is sparsely separated
      val id = selectUnique(1, random, list).head
      val candidate = points(id.toInt)
      val max = current

      if (addOrNot(candidate, pivots, false)) {
        pivots = pivots :+ (candidate, id.toInt)
        list.add(id)
        LOG.warn("Added candidate! " + pivots.size + " pivots found!"
          + " max: " + maxDistance.mean + " iter: " + i)
      }
      // if we changed the max, we have to cleanup
      //      if (pivots.size() == (pivotCount - 1)) { //clean up
      //        List < Pair < Long
      //        , O >> toRemove = new LinkedList < Pair < Long
      //        , O >> ();
      //        for (Pair < Long
      //        , O > o: pivots
      //        )
      //        {
      //          if (!shouldAdd(o.getB(), pivots, true)) {
      //            toRemove.add(o);
      //          }
      //        }
      //        pivots.removeAll(toRemove);
      //        logger.info("Cleaning up! " + pivots.size() + " new max: " + maxDistance.mean());
      //      }

      i += 1
    }
    LOG.warn("Found: " + pivots.size + " pivots")
    // take // take

    pivots.sortBy(_._2)

    pivots
  }

  private def current = maxDistance.mean + (maxDistance.standardDeviation * alpha)


  private def addOrNot(candidate: Point[Any], pivots: Array[(Point[Any], Int)], ignore: Boolean): Boolean = {
    var res: Boolean = true

    for (o <- pivots) {
      if (!(ignore && o._1 == (candidate))) {
        val dist: Double = o._1.minDist(candidate)
        maxDistance.add(dist)
        if (dist < current) {
          res = false
          return res
        }
      }
    }
    res
  }

  protected def selectUnique(k: Int, r: Random, excludes: LongArrayList): Array[Int] = {
    val max = points.size

    val res = new Array[Int](k)
    var i = 0
    var excludesSize = 0
    if (excludes != null) excludesSize = excludes.size()
    var generatedSet = new HashSet[Long]()
    var excludesSet = new HashSet[Long]()
    var cx = 0
    while (cx < excludesSize) {
      excludesSet += excludes.get(cx)
      cx += 1
    }
    var repeats = 0
    while (i < res.length) {
      val id = r.nextInt(max)
      if (excludes == null || !excludesSet.contains(id) && !generatedSet.contains(id)) {
        res(i) = id
        generatedSet += id
        i += 1
      }
      else {
        repeats += 1
      }
    }
    res
  }


  def getGlobalIndexedPivot: Array[Point[Any]] = globalIndexedPivot

}