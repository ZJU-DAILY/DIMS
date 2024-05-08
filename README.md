DIMS: Distributed Index for Similarity Search in Metric Spaces
===========================================

## Introduction

DIMS is a distributed Index for similarity search in metric spaces, which support efficient metric range query and metric k nearest neighbour query. DIMS builds effective global index, medium index, and local index with three-stage partition strategy to capture the unique characteristics of various data and ensure balanced workload. In addition, we propose concurrent search methods that support efficient distributed similarity search, and leverage filtering and validation techniques to avoid unnecessary distance computations. Furthermore, we devise cost-based optimization model to strike the balance between computation cost and communication cost. 

Development
---------------

We recommend using IntelliJ for development and following the [official guide](http://spark.apache.org/developer-tools.html) for setting up the IDE. Here are the steps to follow:

- Add `hadoop-2.6`, `hive-provided`, `hive-thriftserver`, and `yarn` to `Profiles` in View > Tool Windows > Maven Projects.
- Select **Reimport All Maven Projects** and **Generate Sources and Update Folders For All Projects**.
- Rebuild the entire project, which will initially fail. This step is important to proceed to the next steps.
- Marking the generated sources is also essential for successful builds. To do this, navigate to File > Project Structure > Project Settings > Modules and mark the relevant sources as the source.
    - Go to File > Project Structure > Project Settings > Modules. Find `spark-streaming-flume-sink`, and mark `target/scala-2.11/src_managed/main/compiled_avro` as source. (Click on the Sources on the top to mark)
    - Go to File > Project Structure > Project Settings > Modules. Find `spark-hive-thriftserver`, and mark `src/gen/java` as source. (Click on the Sources on the top to mark)
- Rebuild the entire project again, and it should work correctly. If there are any compilation errors because some classes cannot be found, go back to the previous step and mark the corresponding sources if they are not included.

Examples
---------------

[DIMSDataFrameExample](spark/examples/src/main/scala/org/apache/spark/examples/sql/dims/DIMSDataFrameExample.scala) for how to use DataFrame for metric similarity search

## Source Code Path

The main code for this project is located in the following directories:

- Spark SQL Catalyst
  - /spark/sql/catalyst/src/main/scala/org/apache/spark/sql/catalyst/expressions/dims

- Spark SQL Core
  - /spark/sql/core/src/main/scala/org/apache/spark/sql/execution/dims

- Spark Example
  - /spark/examples/src/main/scala/org/apache/spark/examples/sql/dims


## Compared algorithms

| __Algorithm__ | __Paper__                                                    | __Year__ |
| ------------- | ------------------------------------------------------------ | -------- |
|  M-tree    | M-tree: An Efficient Access Method for Similarity Search in Metric Spaces                 |   1997  |
| M-index       | Metric Index: An efficient and scalable solution for precise and approximate similarity search | 2011     |
| AMDS          | Distributed k-Nearest Neighbor Queries in Metric Spaces      | 2018     |
| D-HNSW     | Efficient and Robust Approximate Nearest Neighbor Search Using Hierarchical Navigable Small World Graphs                     |  2020        |

## Datasets

Statistics of the datasets used.

| __Dataset__ | Card.      | __Dim__. | Dis. Metric      | Link                                          |
| ----------- | ---------- | -------- | ---------------- | --------------------------------------------- |
| Words       | 611,756    | 1~34     | Edit Dis         | https://mobyproject.org                 |
| T-Loc       | 10M | 2        | $L_{2}$-norm     | http://www.vldb.org/pvldb/vol12/p99-ghosh.pdf |
| Vec         |  0.1M    | 300      | $L_{2}$-norm      | https://www.kaggle.com/datasets/rtatman/pretrained-word-vectors-for-spanish              |
| Color       | 1M  | 282      | $L_{1}$-norm     | http://cophir.isti.cnr.it/                    |
| Deep       | 50M  | 100      | $L_{2}$-norm     | https://big-ann-benchmarks.com/neurips21.html             |

The dataset file is in txt format and can optionally be read from HDFS in a cluster environment or from local directory examples/src/main/resources/ in standalone mode. Each row in the dataset represents one piece of data, and every dimension within each row is split by spaces. For example, see /spark/examples/src/main/resources/mpeg_example.txt.
