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

package org.apache.spark.sql.catalyst.expressions.mchord.common


object MchordConfigConstants {
  // basic
  val THRESHOLD_LIMIT = 100.0
  val SAMPLE_SIZE: Long = 1L * 3 * 1024 * 1024

  // global
  var GLOBAL_INDEXED_PIVOT_COUNT: Int = 200


  // load balancing
  val BALANCING_MIN_SAMPLE_SIZE = 1000

  val iDistanceConstant = 100000

  // Mchord

  // knn
  var KNN = 8
  var RANGE = 100d

  // BPlusTree
  val BPlusTreeOrder = 100
  var DATA_TYPE = 1

  // Distance function 0: Euclidean, 1: L1, 2: word cosine
  var MCHORD_DISTANCE_TYPE = 0
  /*
  def loadFromConfig(confFile: String): Unit = {
    val conf = ConfigFactory.load(confFile)

    GLOBAL_NUM_PARTITIONS = conf.getInt("global_num_partitions")
    GLOBAL_INDEXED_PIVOT_COUNT = conf.getInt("global_indexed_pivot_count")
    GLOBAL_PIVOT_NUM_PARTITIONS = conf.getInt("global_pivot_num_partitions")

    LOCAL_NUM_PARTITIONS = conf.getInt("local_num_partitions")
    LOCAL_INDEXED_PIVOT_COUNT = conf.getInt("local_indexed_pivot_count")
    LOCAL_PIVOT_NUM_PARTITIONS = conf.getInt("local_pivot_num_partitions")
    LOCAL_CELL_SIZE = conf.getDouble("local_cell_size")
    LOCAL_CELL_THRESHOLD = conf.getDouble("local_cell_threshold")
    LOCAL_MIN_NODE_SIZE = conf.getInt("locla_min_node_size")

    BALANCING_PERCENTILE = conf.getDouble("balancing_percentile")
    BALANCING_SAMPLE_RATE = conf.getDouble("balancing_sample_rate")
    BALANCING_SAMPLE_SIZE = conf.getInt("balancing_sample_size")
  }
  */
}
