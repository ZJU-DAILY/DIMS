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
package org.apache.spark.sql.execution.dims.partition.local

import org.apache.spark.Partitioner
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point

case class KeyPartitioner(num: Int) extends Partitioner {

  override def numPartitions: Int = num

  override def getPartition(key: Any): Int = {
    key match {
      case (id: Int, point: Point[Any]) => id
      case (id: Int) => id
      case _ => throw new IllegalArgumentException("Invalid key")

    }
  }
}

