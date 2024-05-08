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

package org.apache.spark.ml.classification

import com.github.fommil.netlib.BLAS

import org.apache.spark.{SparkException, SparkFunSuite}
import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.param.ParamsSuite
import org.apache.spark.ml.regression.DecisionTreeRegressionModel
import org.apache.spark.ml.tree.LeafNode
import org.apache.spark.ml.tree.impl.TreeTests
import org.apache.spark.ml.util.{DefaultReadWriteTest, MLTestingUtils}
import org.apache.spark.ml.util.TestingUtils._
import org.apache.spark.mllib.regression.{LabeledPoint => OldLabeledPoint}
import org.apache.spark.mllib.tree.{EnsembleTestHelper, GradientBoostedTrees => OldGBT}
import org.apache.spark.mllib.tree.configuration.{Algo => OldAlgo}
import org.apache.spark.mllib.tree.loss.LogLoss
import org.apache.spark.mllib.util.MLlibTestSparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row}
import org.apache.spark.util.Utils

/**
 * Test suite for [[GBTClassifier]].
 */
class GBTClassifierSuite extends SparkFunSuite with MLlibTestSparkContext
  with DefaultReadWriteTest {

  import testImplicits._
  import GBTClassifierSuite.compareAPIs

  // Combinations for estimators, learning rates and subsamplingRate
  private val testCombinations =
    Array((10, 1.0, 1.0), (10, 0.1, 1.0), (10, 0.5, 0.75), (10, 0.1, 0.75))

  private var data: RDD[LabeledPoint] = _
  private var trainData: RDD[LabeledPoint] = _
  private var validationData: RDD[LabeledPoint] = _
  private val eps: Double = 1e-5
  private val absEps: Double = 1e-8

  override def beforeAll() {
    super.beforeAll()
    data = sc.parallelize(EnsembleTestHelper.generateOrderedLabeledPoints(numFeatures = 10, 100), 2)
      .map(_.asML)
    trainData =
      sc.parallelize(EnsembleTestHelper.generateOrderedLabeledPoints(numFeatures = 20, 120), 2)
        .map(_.asML)
    validationData =
      sc.parallelize(EnsembleTestHelper.generateOrderedLabeledPoints(numFeatures = 20, 80), 2)
        .map(_.asML)
  }

  test("params") {
    ParamsSuite.checkParams(new GBTClassifier)
    val model = new GBTClassificationModel("gbtc",
      Array(new DecisionTreeRegressionModel("dtr", new LeafNode(0.0, 0.0, null), 1)),
      Array(1.0), 1, 2)
    ParamsSuite.checkParams(model)
  }

  test("GBTClassifier: default params") {
    val gbt = new GBTClassifier
    assert(gbt.getLabelCol === "label")
    assert(gbt.getFeaturesCol === "features")
    assert(gbt.getPredictionCol === "prediction")
    assert(gbt.getRawPredictionCol === "rawPrediction")
    assert(gbt.getProbabilityCol === "probability")
    val df = trainData.toDF()
    val model = gbt.fit(df)
    model.transform(df)
      .select("label", "probability", "prediction", "rawPrediction")
      .collect()
    intercept[NoSuchElementException] {
      model.getThresholds
    }
    assert(model.getFeaturesCol === "features")
    assert(model.getPredictionCol === "prediction")
    assert(model.getRawPredictionCol === "rawPrediction")
    assert(model.getProbabilityCol === "probability")
    assert(model.hasParent)

    MLTestingUtils.checkCopyAndUids(gbt, model)
  }

  test("setThreshold, getThreshold") {
    val gbt = new GBTClassifier

    // default
    withClue("GBTClassifier should not have thresholds set by default.") {
      intercept[NoSuchElementException] {
        gbt.getThresholds
      }
    }

    // Set via thresholds
    val gbt2 = new GBTClassifier
    val threshold = Array(0.3, 0.7)
    gbt2.setThresholds(threshold)
    assert(gbt2.getThresholds === threshold)
  }

  test("thresholds prediction") {
    val gbt = new GBTClassifier
    val df = trainData.toDF()
    val binaryModel = gbt.fit(df)

    // should predict all zeros
    binaryModel.setThresholds(Array(0.0, 1.0))
    val binaryZeroPredictions = binaryModel.transform(df).select("prediction").collect()
    assert(binaryZeroPredictions.forall(_.getDouble(0) === 0.0))

    // should predict all ones
    binaryModel.setThresholds(Array(1.0, 0.0))
    val binaryOnePredictions = binaryModel.transform(df).select("prediction").collect()
    assert(binaryOnePredictions.forall(_.getDouble(0) === 1.0))


    val gbtBase = new GBTClassifier
    val model = gbtBase.fit(df)
    val basePredictions = model.transform(df).select("prediction").collect()

    // constant threshold scaling is the same as no thresholds
    binaryModel.setThresholds(Array(1.0, 1.0))
    val scaledPredictions = binaryModel.transform(df).select("prediction").collect()
    assert(scaledPredictions.zip(basePredictions).forall { case (scaled, base) =>
      scaled.getDouble(0) === base.getDouble(0)
    })

    // force it to use the predict method
    model.setRawPredictionCol("").setProbabilityCol("").setThresholds(Array(0, 1))
    val predictionsWithPredict = model.transform(df).select("prediction").collect()
    assert(predictionsWithPredict.forall(_.getDouble(0) === 0.0))
  }

  test("GBTClassifier: Predictor, Classifier methods") {
    val rawPredictionCol = "rawPrediction"
    val predictionCol = "prediction"
    val labelCol = "label"
    val featuresCol = "features"
    val probabilityCol = "probability"

    val gbt = new GBTClassifier().setSeed(123)
    val trainingDataset = trainData.toDF(labelCol, featuresCol)
    val gbtModel = gbt.fit(trainingDataset)
    assert(gbtModel.numClasses === 2)
    val numFeatures = trainingDataset.select(featuresCol).first().getAs[Vector](0).size
    assert(gbtModel.numFeatures === numFeatures)

    val blas = BLAS.getInstance()

    val validationDataset = validationData.toDF(labelCol, featuresCol)
    val results = gbtModel.transform(validationDataset)
    // check that raw prediction is tree predictions dot tree weights
    results.select(rawPredictionCol, featuresCol).collect().foreach {
      case Row(raw: Vector, features: Vector) =>
        assert(raw.size === 2)
        val treePredictions = gbtModel.trees.map(_.rootNode.predictImpl(features).prediction)
        val prediction = blas.ddot(gbtModel.numTrees, treePredictions, 1, gbtModel.treeWeights, 1)
        assert(raw ~== Vectors.dense(-prediction, prediction) relTol eps)
    }

    // Compare rawPrediction with probability
    results.select(rawPredictionCol, probabilityCol).collect().foreach {
      case Row(raw: Vector, prob: Vector) =>
        assert(raw.size === 2)
        assert(prob.size === 2)
        // Note: we should check other loss types for classification if they are added
        val predFromRaw = raw.toDense.values.map(value => LogLoss.computeProbability(value))
        assert(prob(0) ~== predFromRaw(0) relTol eps)
        assert(prob(1) ~== predFromRaw(1) relTol eps)
        assert(prob(0) + prob(1) ~== 1.0 absTol absEps)
    }

    // Compare prediction with probability
    results.select(predictionCol, probabilityCol).collect().foreach {
      case Row(pred: Double, prob: Vector) =>
        val predFromProb = prob.toArray.zipWithIndex.maxBy(_._1)._2
        assert(pred == predFromProb)
    }

    // force it to use raw2prediction
    gbtModel.setRawPredictionCol(rawPredictionCol).setProbabilityCol("")
    val resultsUsingRaw2Predict =
      gbtModel.transform(validationDataset).select(predictionCol).as[Double].collect()
    resultsUsingRaw2Predict.zip(results.select(predictionCol).as[Double].collect()).foreach {
      case (pred1, pred2) => assert(pred1 === pred2)
    }

    // force it to use probability2prediction
    gbtModel.setRawPredictionCol("").setProbabilityCol(probabilityCol)
    val resultsUsingProb2Predict =
      gbtModel.transform(validationDataset).select(predictionCol).as[Double].collect()
    resultsUsingProb2Predict.zip(results.select(predictionCol).as[Double].collect()).foreach {
      case (pred1, pred2) => assert(pred1 === pred2)
    }

    // force it to use predict
    gbtModel.setRawPredictionCol("").setProbabilityCol("")
    val resultsUsingPredict =
      gbtModel.transform(validationDataset).select(predictionCol).as[Double].collect()
    resultsUsingPredict.zip(results.select(predictionCol).as[Double].collect()).foreach {
      case (pred1, pred2) => assert(pred1 === pred2)
    }
  }

  test("GBT parameter stepSize should be in interval (0, 1]") {
    withClue("GBT parameter stepSize should be in interval (0, 1]") {
      intercept[IllegalArgumentException] {
        new GBTClassifier().setStepSize(10)
      }
    }
  }

  test("Binary classification with continuous features: Log Loss") {
    val categoricalFeatures = Map.empty[Int, Int]
    testCombinations.foreach {
      case (maxIter, learningRate, subsamplingRate) =>
        val gbt = new GBTClassifier()
          .setMaxDepth(2)
          .setSubsamplingRate(subsamplingRate)
          .setLossType("logistic")
          .setMaxIter(maxIter)
          .setStepSize(learningRate)
          .setSeed(123)
        compareAPIs(data, None, gbt, categoricalFeatures)
    }
  }

  test("Checkpointing") {
    val tempDir = Utils.createTempDir()
    val path = tempDir.toURI.toString
    sc.setCheckpointDir(path)

    val categoricalFeatures = Map.empty[Int, Int]
    val df: DataFrame = TreeTests.setMetadata(data, categoricalFeatures, numClasses = 2)
    val gbt = new GBTClassifier()
      .setMaxDepth(2)
      .setLossType("logistic")
      .setMaxIter(5)
      .setStepSize(0.1)
      .setCheckpointInterval(2)
      .setSeed(123)
    val model = gbt.fit(df)

    MLTestingUtils.checkCopyAndUids(gbt, model)

    sc.checkpointDir = None
    Utils.deleteRecursively(tempDir)
  }

  test("should support all NumericType labels and not support other types") {
    val gbt = new GBTClassifier().setMaxDepth(1)
    MLTestingUtils.checkNumericTypes[GBTClassificationModel, GBTClassifier](
      gbt, spark) { (expected, actual) =>
        TreeTests.checkEqual(expected, actual)
      }
  }

  // TODO: Reinstate test once runWithValidation is implemented   SPARK-7132
  /*
  test("runWithValidation stops early and performs better on a validation dataset") {
    val categoricalFeatures = Map.empty[Int, Int]
    // Set maxIter large enough so that it stops early.
    val maxIter = 20
    GBTClassifier.supportedLossTypes.foreach { loss =>
      val gbt = new GBTClassifier()
        .setMaxIter(maxIter)
        .setMaxDepth(2)
        .setLossType(loss)
        .setValidationTol(0.0)
      compareAPIs(trainData, None, gbt, categoricalFeatures)
      compareAPIs(trainData, Some(validationData), gbt, categoricalFeatures)
    }
  }
  */

  test("Fitting without numClasses in metadata") {
    val df: DataFrame = TreeTests.featureImportanceData(sc).toDF()
    val gbt = new GBTClassifier().setMaxDepth(1).setMaxIter(1)
    gbt.fit(df)
  }

  test("extractLabeledPoints with bad data") {
    def getTestData(labels: Seq[Double]): DataFrame = {
      labels.map { label: Double => LabeledPoint(label, Vectors.dense(0.0)) }.toDF()
    }

    val gbt = new GBTClassifier().setMaxDepth(1).setMaxIter(1)
    // Invalid datasets
    val df1 = getTestData(Seq(0.0, -1.0, 1.0, 0.0))
    withClue("Classifier should fail if label is negative") {
      val e: SparkException = intercept[SparkException] {
        gbt.fit(df1)
      }
      assert(e.getMessage.contains("currently only supports binary classification"))
    }
    val df2 = getTestData(Seq(0.0, 0.1, 1.0, 0.0))
    withClue("Classifier should fail if label is not an integer") {
      val e: SparkException = intercept[SparkException] {
        gbt.fit(df2)
      }
      assert(e.getMessage.contains("currently only supports binary classification"))
    }
    val df3 = getTestData(Seq(0.0, 2.0, 1.0, 0.0))
    withClue("Classifier should fail if label is >= 2") {
      val e: SparkException = intercept[SparkException] {
        gbt.fit(df3)
      }
      assert(e.getMessage.contains("currently only supports binary classification"))
    }
  }

  /////////////////////////////////////////////////////////////////////////////
  // Tests of feature importance
  /////////////////////////////////////////////////////////////////////////////
  test("Feature importance with toy data") {
    val numClasses = 2
    val gbt = new GBTClassifier()
      .setImpurity("Gini")
      .setMaxDepth(3)
      .setMaxIter(5)
      .setSubsamplingRate(1.0)
      .setStepSize(0.5)
      .setSeed(123)

    // In this data, feature 1 is very important.
    val data: RDD[LabeledPoint] = TreeTests.featureImportanceData(sc)
    val categoricalFeatures = Map.empty[Int, Int]
    val df: DataFrame = TreeTests.setMetadata(data, categoricalFeatures, numClasses)

    val importances = gbt.fit(df).featureImportances
    val mostImportantFeature = importances.argmax
    assert(mostImportantFeature === 1)
    assert(importances.toArray.sum === 1.0)
    assert(importances.toArray.forall(_ >= 0.0))
  }

  /////////////////////////////////////////////////////////////////////////////
  // Tests of model save/load
  /////////////////////////////////////////////////////////////////////////////

  test("model save/load") {
    def checkModelData(
        model: GBTClassificationModel,
        model2: GBTClassificationModel): Unit = {
      TreeTests.checkEqual(model, model2)
      assert(model.numFeatures === model2.numFeatures)
    }

    val gbt = new GBTClassifier()
    val rdd = TreeTests.getTreeReadWriteData(sc)

    val allParamSettings = TreeTests.allParamSettings ++ Map("lossType" -> "logistic")

    val continuousData: DataFrame =
      TreeTests.setMetadata(rdd, Map.empty[Int, Int], numClasses = 2)
    testEstimatorAndModelReadWrite(gbt, continuousData, allParamSettings,
      allParamSettings, checkModelData)
  }
}

private object GBTClassifierSuite extends SparkFunSuite {

  /**
   * Train 2 models on the given dataset, one using the old API and one using the new API.
   * Convert the old model to the new format, compare them, and fail if they are not exactly equal.
   */
  def compareAPIs(
      data: RDD[LabeledPoint],
      validationData: Option[RDD[LabeledPoint]],
      gbt: GBTClassifier,
      categoricalFeatures: Map[Int, Int]): Unit = {
    val numFeatures = data.first().features.size
    val oldBoostingStrategy =
      gbt.getOldBoostingStrategy(categoricalFeatures, OldAlgo.Classification)
    val oldGBT = new OldGBT(oldBoostingStrategy, gbt.getSeed.toInt)
    val oldModel = oldGBT.run(data.map(OldLabeledPoint.fromML))
    val newData: DataFrame = TreeTests.setMetadata(data, categoricalFeatures, numClasses = 2)
    val newModel = gbt.fit(newData)
    // Use parent from newTree since this is not checked anyways.
    val oldModelAsNew = GBTClassificationModel.fromOld(
      oldModel, newModel.parent.asInstanceOf[GBTClassifier], categoricalFeatures,
      numFeatures, numClasses = 2)
    TreeTests.checkEqual(oldModelAsNew, newModel)
    assert(newModel.numFeatures === numFeatures)
    assert(oldModelAsNew.numFeatures === numFeatures)
  }
}
