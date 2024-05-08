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
package org.apache.spark.sql.catalyst.expressions.amds.common.shape

import org.apache.spark.sql.catalyst.expressions.amds.common.AMDSConfigConstants
import scala.math.min

case class Point[+T](origin: T, var coord: Array[Double]) extends Shape {

  def this() = this(null.asInstanceOf[T], null)

  override def minDist(other: Any): Double = {
    def euclidDist(other: Point[Array[Double]]): Double = {
      require(coord.length == other.coord.length)
      var ans = 0.0
      for (i <- coord.indices)
        ans += (coord(i) - other.coord(i)) *
          (coord(i) - other.coord(i))
      Math.sqrt(ans)
    }

    def cosineDistOrigin(other: Point[Array[Double]]): Double = {
      require(origin.asInstanceOf[Array[Double]].length == other.origin.length)
      val a = Math.sqrt(origin.asInstanceOf[Array[Double]].map(x => x * x).sum)
      val b = Math.sqrt(other.origin.map(x => x * x).sum)
      val c = origin.asInstanceOf[Array[Double]].zip(other.origin).map(x => x._1 * x._2).sum
      c / (a * b)
    }

    def L1DistOrigin(other: Point[Array[Double]]): Double = {
      require(origin.asInstanceOf[Array[Double]].length == other.origin.length)
      var ans = 0.0
      for (i <- origin.asInstanceOf[Array[Double]].indices)
        ans += (origin.asInstanceOf[Array[Double]](i) - other.origin(i)).abs
      ans
    }


    def euclidDistArray(other: Array[Double]): Double = {
      require(coord.length == other.length)
      var ans = 0.0
      for (i <- coord.indices)
        ans += (coord(i) - other(i)) *
          (coord(i) - other(i))
      Math.sqrt(ans)
    }

    def euclidDistArrayOrigin(other: Array[Double]): Double = {
      require(origin.asInstanceOf[Array[Double]].length == other.length)
      var ans = 0.0
      for (i <- origin.asInstanceOf[Array[Double]].indices)
        ans += (origin.asInstanceOf[Array[Double]](i) - other(i)) *
          (origin.asInstanceOf[Array[Double]](i) - other(i))
      Math.sqrt(ans)
    }

    def euclidDistOrigin(other: Point[Array[Double]]): Double = {
      require(origin.asInstanceOf[Array[Double]].length == other.origin.length)
      var ans = 0.0
      for (i <- origin.asInstanceOf[Array[Double]].indices)
        ans += (origin.asInstanceOf[Array[Double]](i) - other.origin(i)) *
          (origin.asInstanceOf[Array[Double]](i) - other.origin(i))
      Math.sqrt(ans)
    }

    //    def editDistString(other: String): Double = {
    //      val matrix = Array.ofDim[Int](origin.asInstanceOf[String].length + 1,
    //        other.length + 1)
    //      for (i <- 0 to origin.asInstanceOf[String].length;
    //           j <- 0 to other.length) {
    //
    //        if (i == 0) {
    //          matrix(i)(j) = j
    //        } else if (j == 0) {
    //          matrix(i)(j) = i
    //        } else {
    //          matrix(i)(j) = tripleMin(matrix(i - 1)(j) + 1,
    //            matrix(i - 1)(j - 1) + (if (origin.asInstanceOf[String](i - 1)
    //              == other(j - 1)) {
    //              0
    //            } else {
    //              1
    //            }),
    //            matrix(i)(j - 1) + 1)
    //        }
    //      }
    //      matrix(origin.asInstanceOf[String].length)(other.length)
    //    }
    //
    //    def editDist(other: Point[String]): Double = {
    //      val matrix = Array.ofDim[Int](origin.asInstanceOf[String].length + 1,
    //        other.origin.length + 1)
    //      for (i <- 0 to origin.asInstanceOf[String].length;
    //           j <- 0 to other.origin.length) {
    //
    //        if (i == 0) {
    //          matrix(i)(j) = j
    //        } else if (j == 0) {
    //          matrix(i)(j) = i
    //        } else {
    //          matrix(i)(j) = tripleMin(matrix(i - 1)(j) + 1,
    //            matrix(i - 1)(j - 1) + (if (origin.asInstanceOf[String](i - 1)
    //              == other.origin(j - 1)) {
    //              0
    //            } else {
    //              1
    //            }),
    //            matrix(i)(j - 1) + 1)
    //        }
    //      }
    //      matrix(origin.asInstanceOf[String].length)(other.origin.length)
    //    }
    def editDistString(other: String): Int = {
      val m = origin.asInstanceOf[String].length
      val n = other.length
      val dist = Array.ofDim[Int](m + 1, n + 1)
      (0 to m).foreach { i => dist(i)(0) = i }
      (0 to n).foreach { j => dist(0)(j) = j }
      (1 to m).foreach { i =>
        (1 to n).foreach { j =>
          val cost = if (origin.asInstanceOf[String](i - 1) == other(j - 1)) 0 else 1
          dist(i)(j) = min(min(dist(i - 1)(j) + 1, dist(i)(j - 1) + 1), dist(i - 1)(j - 1) + cost)
        }
      }
      dist(m)(n)
    }

    def editDist(other: Point[String]): Int = {
      val m = origin.asInstanceOf[String].length
      val n = other.origin.length
      val dist = Array.ofDim[Int](m + 1, n + 1)
      (0 to m).foreach { i => dist(i)(0) = i }
      (0 to n).foreach { j => dist(0)(j) = j }
      (1 to m).foreach { i =>
        (1 to n).foreach { j =>
          val cost = if (origin.asInstanceOf[String](i - 1) == other.origin(j - 1)) 0 else 1
          dist(i)(j) = min(min(dist(i - 1)(j) + 1, dist(i)(j - 1) + 1), dist(i - 1)(j - 1) + cost)
        }
      }
      dist(m)(n)
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

    //    println(other)
    other match {
      case mbr: Rectangle => mbr.minDist(this)
      case r: SimpleRange => r.minDist(this)
      case s: String => editDistString(s)
      case d: Array[Double] =>
        if (coord != null) {
          euclidDistArray(d)
        } else {
          euclidDistArrayOrigin(d)
        }
      case _: Point[Any] =>
        other.asInstanceOf[Point[Any]].origin match {
          case d: Array[Double] =>
            if (other.asInstanceOf[Point[Any]].coord != null) {
              euclidDist(other.asInstanceOf[Point[Array[Double]]])
            }
            else {
              if (AMDSConfigConstants.AMDS_DISTANCE_TYPE == 0) {
                euclidDistOrigin(other.asInstanceOf[Point[Array[Double]]])
              } else if (AMDSConfigConstants.AMDS_DISTANCE_TYPE == 1) {
                L1DistOrigin(other.asInstanceOf[Point[Array[Double]]])
              } else {
                cosineDistOrigin(other.asInstanceOf[Point[Array[Double]]])
              }
            }
          case d: String =>
            if (other.asInstanceOf[Point[Any]].coord != null) {
              euclidDist(other.asInstanceOf[Point[Array[Double]]])
            }
            else {
              editDist(other.asInstanceOf[Point[String]])
            }
          case _: None.type =>
            if (other.asInstanceOf[Point[Any]].coord != null) {
              euclidDist(other.asInstanceOf[Point[Array[Double]]])
            }
            else {
              if (AMDSConfigConstants.AMDS_DISTANCE_TYPE == 0) {
                euclidDistOrigin(other.asInstanceOf[Point[Array[Double]]])
              } else if (AMDSConfigConstants.AMDS_DISTANCE_TYPE == 1) {
                L1DistOrigin(other.asInstanceOf[Point[Array[Double]]])
              } else {
                cosineDistOrigin(other.asInstanceOf[Point[Array[Double]]])
              }
            }
        }


    }
  }

  override def intersects(other: Shape): Boolean = {
    other match {
      case p: Point[Any] => p == this
      case mbr: Rectangle => mbr.contains(this)
      case r: SimpleRange => r.intersects(this)
    }
  }

  def ~=(x: Double, y: Double, precision: Double): Boolean = {
    if ((x - y).abs < precision) true else false
  }

  def ==(other: Point[Any]): Boolean =
    other.origin match {
      case p: Array[Double] =>
        if (p.length !=
          origin.asInstanceOf[Array[Double]].length) {
          false
        } else {
          for (i <- origin.asInstanceOf[Array[Double]].indices)
            if (! ~=(origin.asInstanceOf[Array[Double]](i),
              p(i), 0.000001)) {
              return false
            }
          true
        }
      case p: String =>
        if (p.length != origin.asInstanceOf[String].length) {
          false
        } else {
          for (i <- origin.asInstanceOf[String].indices)
            if (origin.asInstanceOf[String](i) != p(i)) {
              return false
            }
          true
        }
      case _ => false
    }

  def <=(other: Point[Any]): Boolean = {
    for (i <- coord.indices)
      if (coord(i) > other.coord(i)) return false
    true
  }

  def -(other: Point[Any]): Point[Any] =
    Point[Any](origin = "Qtqtqtqt", coord.zip(other.coord).map(x => x._1 - x._2))

  //  def getGlobalPivot: Array[Point[Any]] = pivots

  override def toString: String = {
    def doubleToString(origin: Array[Double]): String = {
      var s = "POINT("
      //      s += origin.toString
      s += origin(0)
      for (i <- 1 until origin.length) s += "," + origin(i)
      s + ")"
    }

    def stringToString(origin: String): String = {
      var s = "POINT("
      s += origin
      s + ")"
    }

    origin match {
      case p: Array[Double] => doubleToString(p)
      case p: String => stringToString(p)
      case _ => null
    }
  }
}
