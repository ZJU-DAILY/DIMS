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

package org.apache.spark.sql.catalyst.catalog

import org.apache.spark.sql.catalyst.analysis.{FunctionAlreadyExistsException, NoSuchDatabaseException, NoSuchFunctionException, NoSuchTableException}
import org.apache.spark.sql.catalyst.expressions.Expression
import org.apache.spark.sql.types.StructType
import org.apache.spark.util.ListenerBus

/**
 * Interface for the system catalog (of functions, partitions, tables, and databases).
 *
 * This is only used for non-temporary items, and implementations must be thread-safe as they
 * can be accessed in multiple threads. This is an external catalog because it is expected to
 * interact with external systems.
 *
 * Implementations should throw [[NoSuchDatabaseException]] when databases don't exist.
 */
abstract class ExternalCatalog
  extends ListenerBus[ExternalCatalogEventListener, ExternalCatalogEvent] {
  import CatalogTypes.TablePartitionSpec

  protected def requireDbExists(db: String): Unit = {
    if (!databaseExists(db)) {
      throw new NoSuchDatabaseException(db)
    }
  }

  protected def requireTableExists(db: String, table: String): Unit = {
    if (!tableExists(db, table)) {
      throw new NoSuchTableException(db = db, table = table)
    }
  }

  protected def requireFunctionExists(db: String, funcName: String): Unit = {
    if (!functionExists(db, funcName)) {
      throw new NoSuchFunctionException(db = db, func = funcName)
    }
  }

  protected def requireFunctionNotExists(db: String, funcName: String): Unit = {
    if (functionExists(db, funcName)) {
      throw new FunctionAlreadyExistsException(db = db, func = funcName)
    }
  }

  // --------------------------------------------------------------------------
  // Databases
  // --------------------------------------------------------------------------

  final def createDatabase(dbDefinition: CatalogDatabase, ignoreIfExists: Boolean): Unit = {
    val db = dbDefinition.name
    postToAll(CreateDatabasePreEvent(db))
    doCreateDatabase(dbDefinition, ignoreIfExists)
    postToAll(CreateDatabaseEvent(db))
  }

  protected def doCreateDatabase(dbDefinition: CatalogDatabase, ignoreIfExists: Boolean): Unit

  final def dropDatabase(db: String, ignoreIfNotExists: Boolean, cascade: Boolean): Unit = {
    postToAll(DropDatabasePreEvent(db))
    doDropDatabase(db, ignoreIfNotExists, cascade)
    postToAll(DropDatabaseEvent(db))
  }

  protected def doDropDatabase(db: String, ignoreIfNotExists: Boolean, cascade: Boolean): Unit

  /**
   * Alter a database whose name matches the one specified in `dbDefinition`,
   * assuming the database exists.
   *
   * Note: If the underlying implementation does not support altering a certain field,
   * this becomes a no-op.
   */
  def alterDatabase(dbDefinition: CatalogDatabase): Unit

  def getDatabase(db: String): CatalogDatabase

  def databaseExists(db: String): Boolean

  def listDatabases(): Seq[String]

  def listDatabases(pattern: String): Seq[String]

  def setCurrentDatabase(db: String): Unit

  // --------------------------------------------------------------------------
  // Tables
  // --------------------------------------------------------------------------

  final def createTable(tableDefinition: CatalogTable, ignoreIfExists: Boolean): Unit = {
    val db = tableDefinition.database
    val name = tableDefinition.identifier.table
    postToAll(CreateTablePreEvent(db, name))
    doCreateTable(tableDefinition, ignoreIfExists)
    postToAll(CreateTableEvent(db, name))
  }

  protected def doCreateTable(tableDefinition: CatalogTable, ignoreIfExists: Boolean): Unit

  final def dropTable(
      db: String,
      table: String,
      ignoreIfNotExists: Boolean,
      purge: Boolean): Unit = {
    postToAll(DropTablePreEvent(db, table))
    doDropTable(db, table, ignoreIfNotExists, purge)
    postToAll(DropTableEvent(db, table))
  }

  protected def doDropTable(
      db: String,
      table: String,
      ignoreIfNotExists: Boolean,
      purge: Boolean): Unit

  final def renameTable(db: String, oldName: String, newName: String): Unit = {
    postToAll(RenameTablePreEvent(db, oldName, newName))
    doRenameTable(db, oldName, newName)
    postToAll(RenameTableEvent(db, oldName, newName))
  }

  protected def doRenameTable(db: String, oldName: String, newName: String): Unit

  /**
   * Alter a table whose database and name match the ones specified in `tableDefinition`, assuming
   * the table exists. Note that, even though we can specify database in `tableDefinition`, it's
   * used to identify the table, not to alter the table's database, which is not allowed.
   *
   * Note: If the underlying implementation does not support altering a certain field,
   * this becomes a no-op.
   */
  def alterTable(tableDefinition: CatalogTable): Unit

  /**
   * Alter the schema of a table identified by the provided database and table name. The new schema
   * should still contain the existing bucket columns and partition columns used by the table. This
   * method will also update any Spark SQL-related parameters stored as Hive table properties (such
   * as the schema itself).
   *
   * @param db Database that table to alter schema for exists in
   * @param table Name of table to alter schema for
   * @param schema Updated schema to be used for the table (must contain existing partition and
   *               bucket columns)
   */
  def alterTableSchema(db: String, table: String, schema: StructType): Unit

  def getTable(db: String, table: String): CatalogTable

  def getTableOption(db: String, table: String): Option[CatalogTable]

  def tableExists(db: String, table: String): Boolean

  def listTables(db: String): Seq[String]

  def listTables(db: String, pattern: String): Seq[String]

  /**
   * Loads data into a table.
   *
   * @param isSrcLocal Whether the source data is local, as defined by the "LOAD DATA LOCAL"
   *                   HiveQL command.
   */
  def loadTable(
      db: String,
      table: String,
      loadPath: String,
      isOverwrite: Boolean,
      isSrcLocal: Boolean): Unit

  /**
   * Loads data into a partition.
   *
   * @param isSrcLocal Whether the source data is local, as defined by the "LOAD DATA LOCAL"
   *                   HiveQL command.
   */
  def loadPartition(
      db: String,
      table: String,
      loadPath: String,
      partition: TablePartitionSpec,
      isOverwrite: Boolean,
      inheritTableSpecs: Boolean,
      isSrcLocal: Boolean): Unit

  def loadDynamicPartitions(
      db: String,
      table: String,
      loadPath: String,
      partition: TablePartitionSpec,
      replace: Boolean,
      numDP: Int): Unit

  // --------------------------------------------------------------------------
  // Partitions
  // --------------------------------------------------------------------------

  def createPartitions(
      db: String,
      table: String,
      parts: Seq[CatalogTablePartition],
      ignoreIfExists: Boolean): Unit

  def dropPartitions(
      db: String,
      table: String,
      parts: Seq[TablePartitionSpec],
      ignoreIfNotExists: Boolean,
      purge: Boolean,
      retainData: Boolean): Unit

  /**
   * Override the specs of one or many existing table partitions, assuming they exist.
   * This assumes index i of `specs` corresponds to index i of `newSpecs`.
   */
  def renamePartitions(
      db: String,
      table: String,
      specs: Seq[TablePartitionSpec],
      newSpecs: Seq[TablePartitionSpec]): Unit

  /**
   * Alter one or many table partitions whose specs that match those specified in `parts`,
   * assuming the partitions exist.
   *
   * Note: If the underlying implementation does not support altering a certain field,
   * this becomes a no-op.
   */
  def alterPartitions(
      db: String,
      table: String,
      parts: Seq[CatalogTablePartition]): Unit

  def getPartition(db: String, table: String, spec: TablePartitionSpec): CatalogTablePartition

  /**
   * Returns the specified partition or None if it does not exist.
   */
  def getPartitionOption(
      db: String,
      table: String,
      spec: TablePartitionSpec): Option[CatalogTablePartition]

  /**
   * List the names of all partitions that belong to the specified table, assuming it exists.
   *
   * For a table with partition columns p1, p2, p3, each partition name is formatted as
   * `p1=v1/p2=v2/p3=v3`. Each partition column name and value is an escaped path name, and can be
   * decoded with the `ExternalCatalogUtils.unescapePathName` method.
   *
   * The returned sequence is sorted as strings.
   *
   * A partial partition spec may optionally be provided to filter the partitions returned, as
   * described in the `listPartitions` method.
   *
   * @param db database name
   * @param table table name
   * @param partialSpec partition spec
   */
  def listPartitionNames(
      db: String,
      table: String,
      partialSpec: Option[TablePartitionSpec] = None): Seq[String]

  /**
   * List the metadata of all partitions that belong to the specified table, assuming it exists.
   *
   * A partial partition spec may optionally be provided to filter the partitions returned.
   * For instance, if there exist partitions (a='1', b='2'), (a='1', b='3') and (a='2', b='4'),
   * then a partial spec of (a='1') will return the first two only.
   *
   * @param db database name
   * @param table table name
   * @param partialSpec partition spec
   */
  def listPartitions(
      db: String,
      table: String,
      partialSpec: Option[TablePartitionSpec] = None): Seq[CatalogTablePartition]

  /**
   * List the metadata of partitions that belong to the specified table, assuming it exists, that
   * satisfy the given partition-pruning predicate expressions.
   *
   * @param db database name
   * @param table table name
   * @param predicates partition-pruning predicates
   * @param defaultTimeZoneId default timezone id to parse partition values of TimestampType
   */
  def listPartitionsByFilter(
      db: String,
      table: String,
      predicates: Seq[Expression],
      defaultTimeZoneId: String): Seq[CatalogTablePartition]

  // --------------------------------------------------------------------------
  // Functions
  // --------------------------------------------------------------------------

  final def createFunction(db: String, funcDefinition: CatalogFunction): Unit = {
    val name = funcDefinition.identifier.funcName
    postToAll(CreateFunctionPreEvent(db, name))
    doCreateFunction(db, funcDefinition)
    postToAll(CreateFunctionEvent(db, name))
  }

  protected def doCreateFunction(db: String, funcDefinition: CatalogFunction): Unit

  final def dropFunction(db: String, funcName: String): Unit = {
    postToAll(DropFunctionPreEvent(db, funcName))
    doDropFunction(db, funcName)
    postToAll(DropFunctionEvent(db, funcName))
  }

  protected def doDropFunction(db: String, funcName: String): Unit

  final def renameFunction(db: String, oldName: String, newName: String): Unit = {
    postToAll(RenameFunctionPreEvent(db, oldName, newName))
    doRenameFunction(db, oldName, newName)
    postToAll(RenameFunctionEvent(db, oldName, newName))
  }

  protected def doRenameFunction(db: String, oldName: String, newName: String): Unit

  def getFunction(db: String, funcName: String): CatalogFunction

  def functionExists(db: String, funcName: String): Boolean

  def listFunctions(db: String, pattern: String): Seq[String]

  override protected def doPostEvent(
      listener: ExternalCatalogEventListener,
      event: ExternalCatalogEvent): Unit = {
    listener.onEvent(event)
  }
}
