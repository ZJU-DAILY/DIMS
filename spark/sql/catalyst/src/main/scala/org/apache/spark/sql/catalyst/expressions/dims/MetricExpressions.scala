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

package org.apache.spark.sql.catalyst.expressions.dims

import org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback
import org.apache.spark.sql.catalyst.expressions.dims.common.DIMSConfigConstants
import org.apache.spark.sql.catalyst.expressions.dims.common.metric.DIMSSimilarity
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import org.apache.spark.sql.catalyst.expressions.{BinaryExpression, Expression, UnaryExpression, UnsafeArrayData, UnsafeRow}
import org.apache.spark.sql.types.{BooleanType, DataType, DoubleType}

import java.util.Locale

case class DIMSSimilarityExpression(function: DIMSSimilarityFunction,
                                   met1: Expression, met2: Expression)
  extends BinaryExpression with CodegenFallback {

  override def left: Expression = met1

  override def right: Expression = met2

  override def dataType: DataType = DoubleType

  override def nullSafeEval(m1: Any, m2: Any): Any = {
    val metric1 = m1 match {
      case t: Point[Any] => t
      case uad: UnsafeArrayData => DIMSSimilarityExpression.getPoints(uad)
    }
    val metric2 = m2 match {
      case t: Point[Any] => t
      case uad: UnsafeArrayData => DIMSSimilarityExpression.getPoints(uad)
    }
    DIMSSimilarity.EUCLIDistance.evalWithPoint(metric1, metric2)
  }
}

object DIMSSimilarityExpression {


  def getPoints(rawData: Any): Point[Any] = {
    //    rawData match {
    //      case uad: UnsafeArrayData => Point(uad.toDoubleArray)
    //      case uad: String => Point(uad.toString)
    //    }
    if (DIMSConfigConstants.DATA_TYPE == 0) {
      Point(rawData.asInstanceOf[UnsafeRow].getArray(1).toDoubleArray)
    } else {
      Point(rawData.asInstanceOf[UnsafeRow].getString(1))
    }
  }
}

case class DIMSSimilarityWithKNNExpression(similarity: DIMSSimilarityExpression,
                                          count: Int)
  extends UnaryExpression with CodegenFallback {

  override def child: Expression = similarity

  override def dataType: DataType = BooleanType

  override def nullSafeEval(left: Any): Any = {
    throw new NotImplementedError()
  }
}

sealed abstract class DIMSSimilarityFunction {
  def sql: String
}

object DIMSSimilarityFunction {
  case object EUCLID extends DIMSSimilarityFunction {
    override def sql: String = "EUCLID"
  }


  def apply(typ: String): DIMSSimilarityFunction =
    typ.toLowerCase(Locale.ROOT).replace("_", "") match {
      case "euclid" => EUCLID
      case _ =>
        val supported = Seq("dtw")
        throw new IllegalArgumentException(s"Unsupported metric similarity function '$typ'. " +
          "Supported metric similarity functions include: "
          + supported.mkString("'", "', '", "'") + ".")
    }
}


case class DIMSSimilarityRangeExpression(similarity: Expression,
                                        center: Point[Any], radius: Double)
  extends UnaryExpression with CodegenFallback {

  override def child: Expression = similarity

  override def dataType: DataType = BooleanType

  override def nullSafeEval(input: Any): Any = {
    val point = DIMSSimilarityExpression.getPoints(
      input.asInstanceOf[UnsafeArrayData])
    point.minDist(center) <= radius
  }
}


case class DIMSDeleteExpression(similarity: Expression, center: Point[Any])
  extends UnaryExpression with CodegenFallback {

  override def child: Expression = similarity

  override def dataType: DataType = BooleanType

  override def nullSafeEval(input: Any): Any = {
    val point = DIMSSimilarityExpression.getPoints(
      input.asInstanceOf[UnsafeArrayData])
    point
  }
}

case class DIMSInsertExpression(similarity: Expression, center: Point[Any])
  extends UnaryExpression with CodegenFallback {

  override def child: Expression = similarity

  override def dataType: DataType = BooleanType

  override def nullSafeEval(input: Any): Any = {
    val point = DIMSSimilarityExpression.getPoints(
      input.asInstanceOf[UnsafeArrayData])
    point
  }
}