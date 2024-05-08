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
package org.apache.spark.sql.catalyst.expressions.dims.common.shape

import org.apache.spark.sql.catalyst.expressions.dims.common.DIMSConfigConstants

import scala.math.min
import scala.math.max

case class Point[+T](coord: T) extends Shape {

  def this() = this(null.asInstanceOf[T])

  //  @transient
  //  var globalPivot: Point = _
  //  @transient
  //  var pivotDistance: Double = _
  //  @transient
  //  var globalIndex: Int = _

  override def minDist(other: Any): Double = {
    def L1Dist(other: Point[Array[Double]]): Double = {
      require(coord.asInstanceOf[Array[Double]].length == other.coord.length)
      var ans = 0.0
      for (i <- coord.asInstanceOf[Array[Double]].indices)
        ans += (coord.asInstanceOf[Array[Double]](i) - other.coord(i)).abs
      ans
    }

    def cosineDist(other: Point[Array[Double]]): Double = {
      require(coord.asInstanceOf[Array[Double]].length == other.coord.length)
      val a = Math.sqrt(coord.asInstanceOf[Array[Double]].map(x => x * x).sum)
      val b = Math.sqrt(other.coord.map(x => x * x).sum)
      val c = coord.asInstanceOf[Array[Double]].zip(other.coord).map(x => x._1 * x._2).sum
      c / (a * b)
    }

    def euclidDist(other: Point[Array[Double]]): Double = {
      require(coord.asInstanceOf[Array[Double]].length == other.coord.length)
      var ans = 0.0
      for (i <- coord.asInstanceOf[Array[Double]].indices)
        ans += (coord.asInstanceOf[Array[Double]](i) - other.coord(i)) *
          (coord.asInstanceOf[Array[Double]](i) - other.coord(i))
      Math.sqrt(ans)
    }

    //    def editDist(other: Point[String]): Double = {
    //      val matrix = Array.ofDim[Int](coord.asInstanceOf[String].length + 1, other.coord.length + 1)
    //      for (i <- 0 to coord.asInstanceOf[String].length;
    //           j <- 0 to other.coord.length) {
    //
    //        if (i == 0) {
    //          matrix(i)(j) = j
    //        } else if (j == 0) {
    //          matrix(i)(j) = i
    //        } else {
    //          matrix(i)(j) = tripleMin(matrix(i - 1)(j) + 1,
    //            matrix(i - 1)(j - 1) + (if (coord.asInstanceOf[String](i - 1)
    //              == other.coord(j - 1)) {
    //              0
    //            } else {
    //              1
    //            }),
    //            matrix(i)(j - 1) + 1)
    //        }
    //      }
    //      matrix(coord.asInstanceOf[String].length)(other.coord.length)
    //    }

    def editDist(other: Point[String]): Int = {
      val s1 = coord.asInstanceOf[String]
      val s2 = other.coord
      val m = s1.length
      val n = s2.length
      val dist = Array.ofDim[Int](m + 1, n + 1)

      (0 to m).foreach { i => dist(i)(0) = if (i > 0) dist(i - 1)(0) + s1(i - 1).toInt else 0 }
      (0 to n).foreach { j => dist(0)(j) = if (j > 0) dist(0)(j - 1) + s2(j - 1).toInt else 0 }

      (1 to m).foreach { i =>
        (1 to n).foreach { j =>
          val replaceCost = math.abs(s1(i - 1).toInt - s2(j - 1).toInt)
          val insertCost = dist(i)(j - 1) + s2(j - 1).toInt
          val deleteCost = dist(i - 1)(j) + s1(i - 1).toInt
          val replaceCostTotal = dist(i - 1)(j - 1) + replaceCost
          dist(i)(j) = min(min(insertCost, deleteCost), replaceCostTotal)

          // optional: swap
          if (i > 1 && j > 1 && s1(i - 1) == s2(j - 2) && s1(i - 2) == s2(j - 1)) {
            val swapCost = dist(i - 2)(j - 2) + math.abs(s1(i - 1).toInt - s1(i - 2).toInt)
            + math.abs(s2(j - 1).toInt - s2(j - 2).toInt)
            dist(i)(j) = min(dist(i)(j), swapCost)
          }
        }
      }

      dist(m)(n)

      //      val m = coord.asInstanceOf[String].length
      //      val n = other.coord.length
      //      val dist = Array.ofDim[Int](m + 1, n + 1)
      //      (0 to m).foreach { i => dist(i)(0) = i }
      //      (0 to n).foreach { j => dist(0)(j) = j }
      //      (1 to m).foreach { i =>
      //        (1 to n).foreach { j =>
      //          val cost = if (coord.asInstanceOf[String](i - 1) == other.coord(j - 1)) 0 else 1
      //          dist(i)(j) = min(min(dist(i - 1)(j) + 1, dist(i)(j - 1) + 1), dist(i - 1)(j - 1) + cost)
      //          if (i > 1 && j > 1 && coord.asInstanceOf[String](i - 1) == other.coord(j - 2)
      //            && coord.asInstanceOf[String](i - 2) == other.coord(j - 1)) {
      //            dist(i)(j) = min(dist(i)(j), dist(i - 2)(j - 2) + cost)
      //          }
      //        }
      //      }
      //      dist(m)(n)


    }


    def tripleMin(num1: Int, num2: Int, num3: Int): Int = {
      if (num1 < num2) {
        num1
      } else if (num3 < num2) {
        num3
      } else {
        num2
      }
    }

    val dist = {
      other.asInstanceOf[Point[Any]].coord match {
        case p: Array[Double] =>
          if (DIMSConfigConstants.DIMS_DISTANCE_TYPE == 0) {
            euclidDist(other.asInstanceOf[Point[Array[Double]]])
          } else if (DIMSConfigConstants.DIMS_DISTANCE_TYPE == 1) {
            L1Dist(other.asInstanceOf[Point[Array[Double]]])
          } else {
            cosineDist(other.asInstanceOf[Point[Array[Double]]])
          }
        case p: String =>
          editDist(other.asInstanceOf[Point[String]])
      }
    }
    dist
  }

  def ~=(x: Double, y: Double, precision: Double): Boolean = {
    if ((x - y).abs < precision) true else false
  }

  def ==(other: Point[Any]): Boolean =
    other.coord match {
      case p: Array[Double] =>
        if (p.length !=
          coord.asInstanceOf[Array[Double]].length) {
          false
        } else {
          for (i <- coord.asInstanceOf[Array[Double]].indices)
            if (! ~=(coord.asInstanceOf[Array[Double]](i),
              p(i), 0.000001)) {
              return false
            }
          true
        }
      case p: String =>
        if (p.length != coord.asInstanceOf[String].length) {
          false
        } else {
          for (i <- coord.asInstanceOf[String].indices)
            if (coord.asInstanceOf[String](i) != p(i)) {
              return false
            }
          true
        }
      case _ => false
    }

  override def toString: String = {
    def doubleToString(coord: Array[Double]): String = {
      var s = "POINT("
      s += coord(0).toString
      for (i <- 1 until coord.length) s += "," + coord(i)
      s + ")"
    }

    def stringToString(coord: String): String = {
      var s = "POINT("
      s += coord
      s + ")"
    }

    coord match {
      case p: Array[Double] => doubleToString(p)
      case p: String => stringToString(p)
      case _ => null
    }
  }
}