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

package org.apache.spark.sql.catalyst.expressions.mchord


import java.util.Locale
import org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback
import org.apache.spark.sql.catalyst.expressions.mchord.common.MchordConfigConstants
import org.apache.spark.sql.catalyst.expressions.mchord.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.mchord.common.metric.MetricSimilarity
import org.apache.spark.sql.catalyst.expressions.{BinaryExpression, Expression, UnaryExpression, UnsafeArrayData, UnsafeRow}
import org.apache.spark.sql.types.{ArrayType, BooleanType, DataType, DoubleType, IntegerType, StringType}
import org.apache.spark.unsafe.types.UTF8String

case class MetricSimilarityExpression(function: MetricSimilarityFunction,
                                      met1: Expression, met2: Expression)
  extends BinaryExpression with CodegenFallback {

  override def left: Expression = met1

  override def right: Expression = met2

  override def dataType: DataType = DoubleType

  override def nullSafeEval(m1: Any, m2: Any): Any = {
    val metric1 = m1 match {
      case t: Point[Any] => t
      case uad: UnsafeRow => MetricSimilarityExpression.getPoints(uad)
    }
    val metric2 = m2 match {
      case t: Point[Any] => t
      case uad: UnsafeRow => MetricSimilarityExpression.getPoints(uad)
    }
    MetricSimilarity.EUCLIDistance.evalWithPoint(metric1, metric2)
  }
}

object MetricSimilarityExpression {


  //  def getPoint(rawData: UnsafeArrayData): Array[Double] = {
  //
  //    rawData.toDoubleArray()
  //    //    (0 until rawData.numElements()).map(i =>
  //    //      rawData.getArray(i).toDouble).toArray
  //  }

  def getPoints(rawData: Any): Point[Any] = {
    //    if (MchordConfigConstants.DATA_TYPE == 1) {
    //      val metric = rawData.getString(1)
    //      Point[Any](metric)
    //    }
    //    else {
    //      val metric = rawData.getArray(1).toDoubleArray
    //      val pivots = rawData.getArray(2).toDoubleArray
    //        .grouped(MchordConfigConstants.DIMENSION).toArray
    //        .map((p: Array[Double]) => Point[Any](p, null))
    //      val minDist = rawData.getDouble(3)
    //      val minDistIndex = rawData.getInt(4)
    //      val iDistConst = rawData.getInt(5)
    //      Point[Any](metric, pivots, minDist, minDistIndex, iDistConst)
    //    }
    //    rawData match {
    //      case uad: UnsafeArrayData => Point(uad.toDoubleArray)
    //      case uad: String => Point(uad.toString)
    //    }
    if (MchordConfigConstants.DATA_TYPE == 0) {
      Point(rawData.asInstanceOf[UnsafeRow].getArray(1).toDoubleArray)
    } else {
      Point(rawData.asInstanceOf[UnsafeRow].getString(1))
    }
  }
}

case class MetricSimilarityWithKNNExpression(similarity: MetricSimilarityExpression,
                                             count: Int)
  extends UnaryExpression with CodegenFallback {

  override def child: Expression = similarity

  override def dataType: DataType = BooleanType

  override def nullSafeEval(left: Any): Any = {
    throw new NotImplementedError()
  }
}

sealed abstract class MetricSimilarityFunction {
  def sql: String
}

object MetricSimilarityFunction {
  case object EUCLID extends MetricSimilarityFunction {
    override def sql: String = "EUCLID"
  }


  def apply(typ: String): MetricSimilarityFunction =
    typ.toLowerCase(Locale.ROOT).replace("_", "") match {
      case "euclid" => EUCLID
      case _ =>
        val supported = Seq("dtw")
        throw new IllegalArgumentException(s"Unsupported metric similarity function '$typ'. " +
          "Supported metric similarity functions include: "
          + supported.mkString("'", "', '", "'") + ".")
    }
}



case class MetricSimilarityRangeExpression(similarity: Expression,
                                           center: Point[Any], radius: Double)
  extends UnaryExpression with CodegenFallback {

  override def child: Expression = similarity

  override def dataType: DataType = BooleanType

  override def nullSafeEval(input: Any): Any = {
    val point = MetricSimilarityExpression.getPoints(
      input.asInstanceOf[UnsafeRow])
    point.minDist(center) <= radius
  }
}
case class MetricDeleteExpression(similarity: Expression,
                                           center: Point[Any])
  extends UnaryExpression with CodegenFallback {

  override def child: Expression = similarity

  override def dataType: DataType = BooleanType

  override def nullSafeEval(input: Any): Any = {
    val point = MetricSimilarityExpression.getPoints(
      input.asInstanceOf[UnsafeRow])
    point
  }
}