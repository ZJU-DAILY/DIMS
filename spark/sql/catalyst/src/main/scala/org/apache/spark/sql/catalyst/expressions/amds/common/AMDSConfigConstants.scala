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

package org.apache.spark.sql.catalyst.expressions.amds.common


object AMDSConfigConstants {
  // basic
  val SAMPLE_SIZE: Long = 1L * 3 * 1024 * 1024
  // rtree
  val SAMPLE_RATE = 0.05
  val MIN_SAMPLE_SIZE: Long = 1L * 1024 * 1024
  val MAX_SAMPLE_SIZE: Long = 2048L * 1024 * 1024
  val GLOBAL_MAX_ENTRIES_PER_NODE = 20
  val LOCAL_MAX_ENTRIES_PER_NODE = 20

  // global
  var GLOBAL_NUM_PARTITIONS = 300
  var GLOBAL_INDEXED_PIVOT_COUNT: Int = 5


  // load balancing
  var BALANCING_PERCENTILE = 0.95
  var BALANCING_SAMPLE_RATE = 0.01
  val BALANCING_MIN_SAMPLE_SIZE = 1000

  // knn
  var KNN = 8
  var RANGE = 100d

  // M-Tree
  val M_TREE_LEAF_ORDER = 30
  var M_TREE_INNER_ORDER = 3
  var DATA_TYPE = 1
  // Distance function 0: Euclidean, 1: L1, 2: word cosine
  var AMDS_DISTANCE_TYPE = 0

}