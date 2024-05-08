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

import org.apache.spark.sql.catalyst.expressions.dims.DIMSSimilarityFunction

import org.apache.spark.sql.catalyst.expressions.dims.common.DIMSConfigConstants
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point

import scala.reflect.ClassTag

object PointDistance {
  //  def eval(v: Point[Any]): Double = {
  //    math.sqrt(v.coord.map(x => x * x).sum)
  //  }
}

trait DIMSSimilarity extends Serializable {

  def updateDistance(distanceAccu: Double, newDistance: Double): Double

  def evalWithPoint(t1: Point[Any], t2: Point[Any]): Double

  def evalWithPoint(t1: Array[Double], t2: Array[Double]): Double

}

object DIMSSimilarity {
  def getDistanceFunction(function: DIMSSimilarityFunction):
  DIMSSimilarity = function match {
    case DIMSSimilarityFunction.EUCLID => DIMSSimilarity.EUCLIDistance

  }

  object EUCLIDistance extends DIMSSimilarity {
    //    private final val MAX_COST = Array.fill[Double](1, 1)(DIMSConfigConstants.THRESHOLD_LIMIT)

    override def evalWithPoint(t1: Point[Any], t2: Point[Any]): Double = {
      t1.minDist(t2)
    }

    override def evalWithPoint(t1: Array[Double], t2: Array[Double]): Double = {
      var ans = 0.0
      for (i <- t1.indices)
        ans += (t1(i) - t2(i)) * (t1(i) - t2(i))
      Math.sqrt(ans)
    }


    override def updateDistance(distanceAccu: Double, newDistance: Double): Double = {
      distanceAccu + newDistance
    }
  }

  //  def evalWithMetric(p1: Point, p2: Point): Double = {
  //    var ans = 0.0
  //    for (i <- p1.coord.indices)
  //      ans += (p1.coord(i) - p2.coord(i)) * (p1.coord(i) - p2.coord(i))
  //    Math.sqrt(ans)
  //  }

}
