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

package org.apache.spark.sql.catalyst.json

import java.io.Writer

import com.fasterxml.jackson.core._

import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.SpecializedGetters
import org.apache.spark.sql.catalyst.util.{ArrayData, DateTimeUtils, MapData}
import org.apache.spark.sql.types._

private[sql] class JacksonGenerator(
    schema: StructType,
    writer: Writer,
    options: JSONOptions) {
  // A `ValueWriter` is responsible for writing a field of an `InternalRow` to appropriate
  // JSON data. Here we are using `SpecializedGetters` rather than `InternalRow` so that
  // we can directly access data in `ArrayData` without the help of `SpecificMutableRow`.
  private type ValueWriter = (SpecializedGetters, Int) => Unit

  // `ValueWriter`s for all fields of the schema
  private val rootFieldWriters: Array[ValueWriter] = schema.map(_.dataType).map(makeWriter).toArray
  // `ValueWriter` for array data storing rows of the schema.
  private val arrElementWriter: ValueWriter = (arr: SpecializedGetters, i: Int) => {
    writeObject(writeFields(arr.getStruct(i, schema.length), schema, rootFieldWriters))
  }

  private val gen = new JsonFactory().createGenerator(writer).setRootValueSeparator(null)

  private def makeWriter(dataType: DataType): ValueWriter = dataType match {
    case NullType =>
      (row: SpecializedGetters, ordinal: Int) =>
        gen.writeNull()

    case BooleanType =>
      (row: SpecializedGetters, ordinal: Int) =>
        gen.writeBoolean(row.getBoolean(ordinal))

    case ByteType =>
      (row: SpecializedGetters, ordinal: Int) =>
        gen.writeNumber(row.getByte(ordinal))

    case ShortType =>
      (row: SpecializedGetters, ordinal: Int) =>
        gen.writeNumber(row.getShort(ordinal))

    case IntegerType =>
      (row: SpecializedGetters, ordinal: Int) =>
        gen.writeNumber(row.getInt(ordinal))

    case LongType =>
      (row: SpecializedGetters, ordinal: Int) =>
        gen.writeNumber(row.getLong(ordinal))

    case FloatType =>
      (row: SpecializedGetters, ordinal: Int) =>
        gen.writeNumber(row.getFloat(ordinal))

    case DoubleType =>
      (row: SpecializedGetters, ordinal: Int) =>
        gen.writeNumber(row.getDouble(ordinal))

    case StringType =>
      (row: SpecializedGetters, ordinal: Int) =>
        gen.writeString(row.getUTF8String(ordinal).toString)

    case TimestampType =>
      (row: SpecializedGetters, ordinal: Int) =>
        val timestampString =
          options.timestampFormat.format(DateTimeUtils.toJavaTimestamp(row.getLong(ordinal)))
        gen.writeString(timestampString)

    case DateType =>
      (row: SpecializedGetters, ordinal: Int) =>
        val dateString =
          options.dateFormat.format(DateTimeUtils.toJavaDate(row.getInt(ordinal)))
        gen.writeString(dateString)

    case BinaryType =>
      (row: SpecializedGetters, ordinal: Int) =>
        gen.writeBinary(row.getBinary(ordinal))

    case dt: DecimalType =>
      (row: SpecializedGetters, ordinal: Int) =>
        gen.writeNumber(row.getDecimal(ordinal, dt.precision, dt.scale).toJavaBigDecimal)

    case st: StructType =>
      val fieldWriters = st.map(_.dataType).map(makeWriter)
      (row: SpecializedGetters, ordinal: Int) =>
        writeObject(writeFields(row.getStruct(ordinal, st.length), st, fieldWriters))

    case at: ArrayType =>
      val elementWriter = makeWriter(at.elementType)
      (row: SpecializedGetters, ordinal: Int) =>
        writeArray(writeArrayData(row.getArray(ordinal), elementWriter))

    case mt: MapType =>
      val valueWriter = makeWriter(mt.valueType)
      (row: SpecializedGetters, ordinal: Int) =>
        writeObject(writeMapData(row.getMap(ordinal), mt, valueWriter))

    // For UDT values, they should be in the SQL type's corresponding value type.
    // We should not see values in the user-defined class at here.
    // For example, VectorUDT's SQL type is an array of double. So, we should expect that v is
    // an ArrayData at here, instead of a Vector.
    case t: UserDefinedType[_] =>
      makeWriter(t.sqlType)

    case _ =>
      (row: SpecializedGetters, ordinal: Int) =>
        val v = row.get(ordinal, dataType)
        sys.error(s"Failed to convert value $v (class of ${v.getClass}}) " +
          s"with the type of $dataType to JSON.")
  }

  private def writeObject(f: => Unit): Unit = {
    gen.writeStartObject()
    f
    gen.writeEndObject()
  }

  private def writeFields(
      row: InternalRow, schema: StructType, fieldWriters: Seq[ValueWriter]): Unit = {
    var i = 0
    while (i < row.numFields) {
      val field = schema(i)
      if (!row.isNullAt(i)) {
        gen.writeFieldName(field.name)
        fieldWriters(i).apply(row, i)
      }
      i += 1
    }
  }

  private def writeArray(f: => Unit): Unit = {
    gen.writeStartArray()
    f
    gen.writeEndArray()
  }

  private def writeArrayData(
      array: ArrayData, fieldWriter: ValueWriter): Unit = {
    var i = 0
    while (i < array.numElements()) {
      if (!array.isNullAt(i)) {
        fieldWriter.apply(array, i)
      } else {
        gen.writeNull()
      }
      i += 1
    }
  }

  private def writeMapData(
      map: MapData, mapType: MapType, fieldWriter: ValueWriter): Unit = {
    val keyArray = map.keyArray()
    val valueArray = map.valueArray()
    var i = 0
    while (i < map.numElements()) {
      gen.writeFieldName(keyArray.get(i, mapType.keyType).toString)
      if (!valueArray.isNullAt(i)) {
        fieldWriter.apply(valueArray, i)
      } else {
        gen.writeNull()
      }
      i += 1
    }
  }

  def close(): Unit = gen.close()

  def flush(): Unit = gen.flush()

  /**
   * Transforms a single `InternalRow` to JSON object using Jackson
   *
   * @param row The row to convert
   */
  def write(row: InternalRow): Unit = writeObject(writeFields(row, schema, rootFieldWriters))

  /**
   * Transforms multiple `InternalRow`s to JSON array using Jackson
   *
   * @param array The array of rows to convert
   */
  def write(array: ArrayData): Unit = writeArray(writeArrayData(array, arrElementWriter))

  def writeLineEnding(): Unit = gen.writeRaw('\n')
}
