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
package org.apache.spark.sql.catalyst.expressions.amds.common.metric

import org.apache.spark.sql.catalyst.expressions.amds.common.AMDSConfigConstants
import org.apache.spark.sql.catalyst.expressions.amds.common.shape.Point
import org.slf4j.{Logger, LoggerFactory}
import hep.aida.bin.StaticBin1D

import scala.collection.immutable.HashSet
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import cern.colt.list.LongArrayList
import scala.util.Random
import scala.util.control.Breaks._

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
  generatePivots(AMDSConfigConstants.GLOBAL_INDEXED_PIVOT_COUNT).map(_._1)
  //  @transient
  //  private lazy val localIndexedPivot: Array[Point[Any]] =
  //    calcPivot(MchordConfigConstants.LOCAL_INDEXED_PIVOT_COUNT).map(_._1)

  @transient
  private lazy val numDimensions = points.head.coord.length

  //  private def calcMBR(): Rectangle = {
  //    val dimension = numDimensions
  //    val min = (0 until dimension).map(i => points.map(_.coord(i)).min).toArray
  //    val max = (0 until dimension).map(i => points.map(_.coord(i)).max).toArray
  //    Rectangle(Point[Any](min), Point[Any](max))
  //  }
  //
  //  private def calcExtendedMBR(threshold: Double): Rectangle = {
  //    Rectangle(Point[Any](mbr.low.coord.map(_ - threshold)),
  //    Point[Any](mbr.high.coord.map(_ + threshold)))
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

   def generatePivots(num: Int): Array[Point[Any]] = {
     val outliers = ListBuffer[Point[Any]]()
     val centers = ListBuffer[Point[Any]]()
     val pointsList = points.toList
     val SEEDNUM = 5
     val MAXCENTERS = 100
     val MAXOUTLIERS = 500
     val OUTLIERRATIO = 1.5
     val MAXDISTANCE = 10
     val PERCENTAGE = 0.2
     val LOG: Logger = LoggerFactory.getLogger(getClass)
     // find outliers
     for (_ <- 1 to SEEDNUM) {
       outliers += findFarthest(Random.shuffle(pointsList).head, pointsList, outliers)
     }
  
     for (i <- 0 until SEEDNUM) {
       outliers += findFarthest(outliers(i), pointsList, outliers)
     }
  
     // find center objects
     breakable {
       for (o <- points) {
         var equalCount = 0
         for (j <- 0 until SEEDNUM) {
           val d1 = outliers(j).minDist(o)
           val d2 = outliers(j + SEEDNUM).minDist(o)
           if (math.abs(d1 - d2) <= MAXDISTANCE * PERCENTAGE) {
             equalCount += 1
           }
         }
         if (equalCount == SEEDNUM) {
           centers += o
         }
         if (centers.size > MAXCENTERS) {
           break
         }
       }
     }
  
     // find the radius
     var radius = 0.0
     for (c <- centers) {
       for (o <- outliers) {
         val d = c.minDist(o)
         if (d > radius) {
           radius = d
         }
       }
     }
  
     // get enough outliers
     breakable {
       for (o <- pointsList) {
         if (outliers.size > MAXOUTLIERS) {
           break
         }
         for (c <- centers) {
           if (o.minDist(c) >= radius * OUTLIERRATIO) {
             var skip = false
             for (k <- outliers) {
               if (k == o) {
                 skip = true
                 break
               }
             }
             if (!skip) {
               outliers += o
             }
           }
         }
       }
     }
  
     val pivots = ListBuffer[Point[Any]]()
  
     // set initial values
     for (_ <- 0 until num) {
       pivots += outliers.last
       outliers.remove(outliers.size - 1)
     }
  
     for (o <- outliers) {
       pivots += o
       var maxSum = 0.0
       var pos = 0
       for (j <- 0 until num + 1) {
         var sum = 0.0
         for (k <- 0 until num + 1) {
           sum += pivots(k).minDist(pivots(j))
         }
         if (sum > maxSum) {
           maxSum = sum
           pos = j
         }
       }
       pivots(pos) = pivots(num)
       pivots.remove(num)
     }
  
     LOG.warn("Pivots found! " + pivots.size)
     for (p <- pivots) {
       LOG.warn(p.toString)
     }
     pivots.toArray
   }
  
   private def findFarthest(o: Point[Any], pointsList: List[Point[Any]],
                            outliers: ListBuffer[Point[Any]]): Point[Any] = {
     var farthest = o
     var maxDistance = 0.0
     for (obj <- pointsList) {
       if (!outliers.contains(obj)) {
         val d = obj.minDist(o)
         if (d > maxDistance) {
           maxDistance = d
           farthest = obj
         }
       }
     }
     farthest
   }
  // def generatePivots(pivotCount: Int): Array[(Point[Any], Int)] = {
  //   val random = new Random()
  //   val LOG: Logger = LoggerFactory.getLogger(getClass)
  //   val ids = selectUnique(200, random, null)
  //   var i = 0

  //   for (id1 <- ids) {

  //     LOG.warn(s"Doing: $i mean: ${maxDistance.mean()}")
  //     for (id2 <- ids) {
  //       if (id1 != id2) {
  //         val candidate1 = points(id1.toInt)
  //         val candidate2 = points(id2.toInt)
  //         maxDistance.add(candidate1.minDist(candidate2))
  //       }
  //     }
  //     i += 1
  //   }
  //   LOG.warn(s"Sample histogram calculated, mean dist: ${maxDistance.mean()}")

  //   var pivots = Array[(Point[Any], Int)]()
  //   val list = new LongArrayList(pivotCount);
  //   while (pivots.size < pivotCount) {
  //     val shouldAdd = true
  //     // add the pivot if it is sparsely separated
  //     val id = selectUnique(1, random, list).head
  //     val candidate = points(id.toInt)
  //     val max = current

  //     if (addOrNot(candidate, pivots, false)) {
  //       pivots = pivots :+ (candidate, id.toInt)
  //       list.add(id)
  //       LOG.warn("Added candidate! " + pivots.size + " pivots found!"
  //         + " max: " + maxDistance.mean + " iter: " + i)
  //     }

  //     i += 1
  //   }
  //   LOG.warn("Found: " + pivots.size + " pivots")
  //   // take // take

  //   pivots.sortBy(_._2)

  //   pivots
  // }

  private def current = maxDistance.mean + (maxDistance.standardDeviation * alpha)


  private def addOrNot(candidate: Point[Any], pivots: Array[(Point[Any], Int)],
                       ignore: Boolean): Boolean = {
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