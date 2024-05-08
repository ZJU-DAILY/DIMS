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
package org.apache.spark.sql.catalyst.expressions.mchord.common.shape

import org.apache.spark.sql.catalyst.expressions.mchord.common.MchordConfigConstants
import scala.math.min

case class Point[+T](coord: T) extends Shape {

  def this() = this(null.asInstanceOf[T])


  override def minDist(other: Any): Double = {
    def L1Dist(other: Point[Array[Double]]): Double = {
      require(coord.asInstanceOf[Array[Double]].length == other.coord.length)
      var ans = 0.0
      for (i <- coord.asInstanceOf[Array[Double]].indices)
        ans += (coord.asInstanceOf[Array[Double]](i) - other.coord(i)).abs
      ans
    }

    def L1DistArray(other: Array[Double]): Double = {
      require(coord.asInstanceOf[Array[Double]].length == other.length)
      var ans = 0.0
      for (i <- coord.asInstanceOf[Array[Double]].indices)
        ans += (coord.asInstanceOf[Array[Double]](i) - other(i)).abs
      ans
    }

    def cosineDist(other: Point[Array[Double]]): Double = {
      require(coord.asInstanceOf[Array[Double]].length == other.coord.length)
      val a = Math.sqrt(coord.asInstanceOf[Array[Double]].map(x => x * x).sum)
      val b = Math.sqrt(other.coord.map(x => x * x).sum)
      val c = coord.asInstanceOf[Array[Double]].zip(other.coord).map(x => x._1 * x._2).sum
      c / (a * b)
    }

    def cosineDistArray(other: Array[Double]): Double = {
      require(coord.asInstanceOf[Array[Double]].length == other.length)
      val a = Math.sqrt(coord.asInstanceOf[Array[Double]].map(x => x * x).sum)
      val b = Math.sqrt(other.map(x => x * x).sum)
      val c = coord.asInstanceOf[Array[Double]].zip(other).map(x => x._1 * x._2).sum
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

    def euclidDistArray(other: Array[Double]): Double = {
      require(coord.asInstanceOf[Array[Double]].length == other.length)
      var ans = 0.0
      for (i <- coord.asInstanceOf[Array[Double]].indices)
        ans += (coord.asInstanceOf[Array[Double]](i) - other(i)) *
          (coord.asInstanceOf[Array[Double]](i) - other(i))
      Math.sqrt(ans)
    }

    //    def editDistString(other: String): Double = {
    //      val matrix = Array.ofDim[Int](coord.asInstanceOf[String].length + 1,
    //        other.length + 1)
    //      for (i <- 0 to coord.asInstanceOf[String].length;
    //           j <- 0 to other.length) {
    //
    //        if (i == 0) {
    //          matrix(i)(j) = j
    //        } else if (j == 0) {
    //          matrix(i)(j) = i
    //        } else {
    //          matrix(i)(j) = tripleMin(matrix(i - 1)(j) + 1,
    //            matrix(i - 1)(j - 1) + (if (coord.asInstanceOf[String](i - 1)
    //              == other(j - 1)) {
    //              0
    //            } else {
    //              1
    //            }),
    //            matrix(i)(j - 1) + 1)
    //        }
    //      }
    //      matrix(coord.asInstanceOf[String].length)(other.length)
    //    }
    //
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
    def editDistString(other: String): Int = {
      val m = coord.asInstanceOf[String].length
      val n = other.length
      val dist = Array.ofDim[Int](m + 1, n + 1)
      (0 to m).foreach { i => dist(i)(0) = i }
      (0 to n).foreach { j => dist(0)(j) = j }
      (1 to m).foreach { i =>
        (1 to n).foreach { j =>
          val cost = if (coord.asInstanceOf[String](i - 1) == other(j - 1)) 0 else 1
          dist(i)(j) = min(min(dist(i - 1)(j) + 1, dist(i)(j - 1) + 1), dist(i - 1)(j - 1) + cost)
        }
      }
      dist(m)(n)
    }

    def editDist(other: Point[String]): Int = {
      val m = coord.asInstanceOf[String].length
      val n = other.coord.length
      val dist = Array.ofDim[Int](m + 1, n + 1)
      (0 to m).foreach { i => dist(i)(0) = i }
      (0 to n).foreach { j => dist(0)(j) = j }
      (1 to m).foreach { i =>
        (1 to n).foreach { j =>
          val cost = if (coord.asInstanceOf[String](i - 1) == other.coord(j - 1)) 0 else 1
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

    val dist =
      if (other.isInstanceOf[Point[Any]]) {
        other.asInstanceOf[Point[Any]].coord match {
          case p: Array[Double] =>
            //            0: Euclidean, 1: L1, 2: word cosine
            if (MchordConfigConstants.MCHORD_DISTANCE_TYPE == 0) {
              euclidDist(other.asInstanceOf[Point[Array[Double]]])
            }
            else if (MchordConfigConstants.MCHORD_DISTANCE_TYPE == 1) {
              L1Dist(other.asInstanceOf[Point[Array[Double]]])
            }
            else {
              cosineDist(other.asInstanceOf[Point[Array[Double]]])
            }
          case p: String =>
            editDist(other.asInstanceOf[Point[String]])
        }
      } else {
        other match {
          case s: String =>
            editDistString(s)
          case a: Array[Double] =>
            if (MchordConfigConstants.MCHORD_DISTANCE_TYPE == 0) {
              euclidDistArray(a)
            }
            else if (MchordConfigConstants.MCHORD_DISTANCE_TYPE == 1) {
              L1DistArray(a)
            }
            else {
              cosineDistArray(a)
            }
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


  //  def -(other: Point[Any]): Point[Any] =
  //  Point[Any](coord.zip(other.coord).map(x => x._1 - x._2))

  //  def setGlobalIndex(index: Int): Unit = {
  //    globalIndex = index
  //  }


  //  def setIDistanceKey(key: Int): Unit = {
  //    iDistanceKey = key
  //  }


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
