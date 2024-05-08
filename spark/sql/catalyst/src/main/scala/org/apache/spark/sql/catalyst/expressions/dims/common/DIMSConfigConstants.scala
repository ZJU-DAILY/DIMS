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

package org.apache.spark.sql.catalyst.expressions.dims.common

object DIMSConfigConstants {


  val GLOBAL_INDEXED_PIVOT_COUNT = 100
  var PIVOT_INDEX: Int = 10000
  //  val SAMPLE_RATE = 0.05
  val SAMPLE_SIZE: Long = 1L * 3 * 1024 * 1024
  //  val MAX_SAMPLE_SIZE: Long = 2048L * 1024 * 1024

  // BPlusTree
  var BPlusTreeOrder = 30
  var GlobalBPlusTreeOrder = 30

  // M-Tree
  var M_TREE_LEAF_ORDER = 300
  var M_TREE_INNER_ORDER = 8
  var LOCAL_M_TREE_LEAF_ORDER = 30
  var LOCAL_M_TREE_INNER_ORDER = 3
  var DIMS_MODE = 3
  var DATA_TYPE = 0
  // knn
  var KNN = 8
  var RANGE = 300d
  // Distance function 0: Euclidean, 1: L1, 2: word cosine
  var DIMS_DISTANCE_TYPE = 1

  val DIMS4_LOCAL_PARTITION = 700
}
