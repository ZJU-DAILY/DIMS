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

package org.apache.spark.sql.catalyst.expressions.amds

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.IntType
import org.apache.spark.sql.catalyst.expressions.amds.common.AMDSConfigConstants

import java.util.Locale
import org.apache.spark.sql.catalyst.expressions.{BinaryExpression, Expression, UnaryExpression, UnsafeArrayData, UnsafeRow}
import org.apache.spark.sql.catalyst.expressions.amds.common.metric.AMDSSimilarity
import org.apache.spark.sql.catalyst.expressions.amds.common.shape.{Point, Rectangle}
import org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback
import org.apache.spark.sql.types.{ArrayType, BooleanType, DataType, DoubleType, IntegerType, StringType}
import org.apache.spark.unsafe.types.UTF8String

case class AMDSSimilarityExpression(function: AMDSSimilarityFunction,
                                    met1: Expression, met2: Expression)
  extends BinaryExpression with CodegenFallback {

  override def left: Expression = met1

  override def right: Expression = met2

  override def dataType: DataType = DoubleType

  override def nullSafeEval(m1: Any, m2: Any): Any = {
    val metric1 = m1 match {
      case t: Point[Any] => t
      case uad: UnsafeRow => AMDSSimilarityExpression.
        getPoints(uad, uad.asInstanceOf[UnsafeArrayData])
    }
    val metric2 = m2 match {
      case t: Point[Any] => t
      case uad: UnsafeRow => AMDSSimilarityExpression.
        getPoints(uad, uad.asInstanceOf[UnsafeArrayData])
    }
    AMDSSimilarity.EUCLIDistance.evalWithPoint(metric1, metric2)
  }
}

object AMDSSimilarityExpression {
  def getPoints(rawData: Any): Point[Any] = {
    //    val cc = rawData.getStruct(1, 0)
    //    val ee = array.get(0, DoubleType)

    //    if (AMDSConfigConstants.DATA_TYPE == 1) {
    //      val origin = rawData.getString(1)
    //      val metric = rawData.getArray(2).toDoubleArray
    //      val pivots = rawData.getArray(3).toArray(StringType)
    //        .map((p: UTF8String) => Point[Any](p.toString, null))
    //      Point[Any](origin, metric, pivots)
    //    }
    //    else {
    //      val origin = rawData.getArray(1).toDoubleArray
    //      val metric = rawData.getArray(2).toDoubleArray
    //      val pivots = rawData.getArray(3).toDoubleArray
    //        .grouped(AMDSConfigConstants.DIMENSION).toArray
    //        .map((p: Array[Double]) => Point[Any](p, null))
    //      Point[Any](origin, metric, pivots)
    //    }
    //    rawData match {
    //      case uad: UnsafeArrayData => Point(uad.toDoubleArray, null)
    //      case uad: String => Point(uad.toString, null)
    //    }
    if (AMDSConfigConstants.DATA_TYPE == 0) {
      Point(rawData.asInstanceOf[UnsafeRow].getArray(1).toDoubleArray, null)
    } else {
      Point(rawData.asInstanceOf[UnsafeRow].getString(1), null)
    }

  }
}

case class AMDSSimilarityWithKNNExpression(similarity: AMDSSimilarityExpression,
                                           count: Int)
  extends UnaryExpression with CodegenFallback {

  override def child: Expression = similarity

  override def dataType: DataType = BooleanType

  override def nullSafeEval(left: Any): Any = {
    throw new NotImplementedError()
  }
}

sealed abstract class AMDSSimilarityFunction {
  def sql: String
}

object AMDSSimilarityFunction {
  case object EUCLID extends AMDSSimilarityFunction {
    override def sql: String = "EUCLID"
  }

  def apply(typ: String): AMDSSimilarityFunction =
    typ.toLowerCase(Locale.ROOT).replace("_", "") match {
      case "euclid" => EUCLID
      case _ =>
        val supported = Seq("dtw")
        throw new IllegalArgumentException(s"Unsupported metric similarity function '$typ'. " +
          "Supported metric similarity functions include: "
          + supported.mkString("'", "', '", "'") + ".")
    }
}

case class AMDSSimilarityRangeExpression(similarity: Expression,
                                         center: Point[Any], radius: Double)
  extends UnaryExpression with CodegenFallback {

  override def child: Expression = similarity

  override def dataType: DataType = BooleanType

  override def nullSafeEval(input: Any): Any = {
    val point = AMDSSimilarityExpression.getPoints(
      input.asInstanceOf[UnsafeRow], input.asInstanceOf[UnsafeRow].asInstanceOf[UnsafeArrayData])
    point.minDist(center) <= radius
  }
}
case class AMDSDeleteExpression(similarity: Expression, center: Point[Any])
  extends UnaryExpression with CodegenFallback {

  override def child: Expression = similarity

  override def dataType: DataType = BooleanType

  override def nullSafeEval(input: Any): Any = {
    val point = AMDSSimilarityExpression.getPoints(
      input.asInstanceOf[UnsafeRow], input.asInstanceOf[UnsafeRow].asInstanceOf[UnsafeArrayData])
    point
  }
}