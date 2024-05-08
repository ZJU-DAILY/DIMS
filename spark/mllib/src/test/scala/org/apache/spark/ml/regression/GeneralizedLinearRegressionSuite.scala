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

package org.apache.spark.ml.regression

import scala.util.Random

import org.apache.spark.SparkFunSuite
import org.apache.spark.ml.classification.LogisticRegressionSuite._
import org.apache.spark.ml.feature.Instance
import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.ml.linalg.{BLAS, DenseVector, Vector, Vectors}
import org.apache.spark.ml.param.{ParamMap, ParamsSuite}
import org.apache.spark.ml.util.{DefaultReadWriteTest, MLTestingUtils}
import org.apache.spark.ml.util.TestingUtils._
import org.apache.spark.mllib.random._
import org.apache.spark.mllib.util.MLlibTestSparkContext
import org.apache.spark.sql.{DataFrame, Row}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.FloatType

class GeneralizedLinearRegressionSuite
  extends SparkFunSuite with MLlibTestSparkContext with DefaultReadWriteTest {

  import testImplicits._

  private val seed: Int = 42
  @transient var datasetGaussianIdentity: DataFrame = _
  @transient var datasetGaussianLog: DataFrame = _
  @transient var datasetGaussianInverse: DataFrame = _
  @transient var datasetBinomial: DataFrame = _
  @transient var datasetPoissonLog: DataFrame = _
  @transient var datasetPoissonLogWithZero: DataFrame = _
  @transient var datasetPoissonIdentity: DataFrame = _
  @transient var datasetPoissonSqrt: DataFrame = _
  @transient var datasetGammaInverse: DataFrame = _
  @transient var datasetGammaIdentity: DataFrame = _
  @transient var datasetGammaLog: DataFrame = _

  override def beforeAll(): Unit = {
    super.beforeAll()

    import GeneralizedLinearRegressionSuite._

    datasetGaussianIdentity = generateGeneralizedLinearRegressionInput(
      intercept = 2.5, coefficients = Array(2.2, 0.6), xMean = Array(2.9, 10.5),
      xVariance = Array(0.7, 1.2), nPoints = 10000, seed, noiseLevel = 0.01,
      family = "gaussian", link = "identity").toDF()

    datasetGaussianLog = generateGeneralizedLinearRegressionInput(
      intercept = 0.25, coefficients = Array(0.22, 0.06), xMean = Array(2.9, 10.5),
      xVariance = Array(0.7, 1.2), nPoints = 10000, seed, noiseLevel = 0.01,
      family = "gaussian", link = "log").toDF()

    datasetGaussianInverse = generateGeneralizedLinearRegressionInput(
      intercept = 2.5, coefficients = Array(2.2, 0.6), xMean = Array(2.9, 10.5),
      xVariance = Array(0.7, 1.2), nPoints = 10000, seed, noiseLevel = 0.01,
      family = "gaussian", link = "inverse").toDF()

    datasetBinomial = {
      val nPoints = 10000
      val coefficients = Array(-0.57997, 0.912083, -0.371077, -0.819866, 2.688191)
      val xMean = Array(5.843, 3.057, 3.758, 1.199)
      val xVariance = Array(0.6856, 0.1899, 3.116, 0.581)

      val testData =
        generateMultinomialLogisticInput(coefficients, xMean, xVariance,
          addIntercept = true, nPoints, seed)

      testData.toDF()
    }

    datasetPoissonLog = generateGeneralizedLinearRegressionInput(
      intercept = 0.25, coefficients = Array(0.22, 0.06), xMean = Array(2.9, 10.5),
      xVariance = Array(0.7, 1.2), nPoints = 10000, seed, noiseLevel = 0.01,
      family = "poisson", link = "log").toDF()

    datasetPoissonLogWithZero = Seq(
      LabeledPoint(0.0, Vectors.dense(18, 1.0)),
      LabeledPoint(1.0, Vectors.dense(12, 0.0)),
      LabeledPoint(0.0, Vectors.dense(15, 0.0)),
      LabeledPoint(0.0, Vectors.dense(13, 2.0)),
      LabeledPoint(0.0, Vectors.dense(15, 1.0)),
      LabeledPoint(1.0, Vectors.dense(16, 1.0))
    ).toDF()

    datasetPoissonIdentity = generateGeneralizedLinearRegressionInput(
      intercept = 2.5, coefficients = Array(2.2, 0.6), xMean = Array(2.9, 10.5),
      xVariance = Array(0.7, 1.2), nPoints = 10000, seed, noiseLevel = 0.01,
      family = "poisson", link = "identity").toDF()

    datasetPoissonSqrt = generateGeneralizedLinearRegressionInput(
      intercept = 2.5, coefficients = Array(2.2, 0.6), xMean = Array(2.9, 10.5),
      xVariance = Array(0.7, 1.2), nPoints = 10000, seed, noiseLevel = 0.01,
      family = "poisson", link = "sqrt").toDF()

    datasetGammaInverse = generateGeneralizedLinearRegressionInput(
      intercept = 2.5, coefficients = Array(2.2, 0.6), xMean = Array(2.9, 10.5),
      xVariance = Array(0.7, 1.2), nPoints = 10000, seed, noiseLevel = 0.01,
      family = "gamma", link = "inverse").toDF()

    datasetGammaIdentity = generateGeneralizedLinearRegressionInput(
      intercept = 2.5, coefficients = Array(2.2, 0.6), xMean = Array(2.9, 10.5),
      xVariance = Array(0.7, 1.2), nPoints = 10000, seed, noiseLevel = 0.01,
      family = "gamma", link = "identity").toDF()

    datasetGammaLog = generateGeneralizedLinearRegressionInput(
      intercept = 0.25, coefficients = Array(0.22, 0.06), xMean = Array(2.9, 10.5),
      xVariance = Array(0.7, 1.2), nPoints = 10000, seed, noiseLevel = 0.01,
      family = "gamma", link = "log").toDF()
  }

  /**
   * Enable the ignored test to export the dataset into CSV format,
   * so we can validate the training accuracy compared with R's glm and glmnet package.
   */
  ignore("export test data into CSV format") {
    datasetGaussianIdentity.rdd.map { case Row(label: Double, features: Vector) =>
      label + "," + features.toArray.mkString(",")
    }.repartition(1).saveAsTextFile(
      "target/tmp/GeneralizedLinearRegressionSuite/datasetGaussianIdentity")
    datasetGaussianLog.rdd.map { case Row(label: Double, features: Vector) =>
      label + "," + features.toArray.mkString(",")
    }.repartition(1).saveAsTextFile(
      "target/tmp/GeneralizedLinearRegressionSuite/datasetGaussianLog")
    datasetGaussianInverse.rdd.map { case Row(label: Double, features: Vector) =>
      label + "," + features.toArray.mkString(",")
    }.repartition(1).saveAsTextFile(
      "target/tmp/GeneralizedLinearRegressionSuite/datasetGaussianInverse")
    datasetBinomial.rdd.map { case Row(label: Double, features: Vector) =>
      label + "," + features.toArray.mkString(",")
    }.repartition(1).saveAsTextFile(
      "target/tmp/GeneralizedLinearRegressionSuite/datasetBinomial")
    datasetPoissonLog.rdd.map { case Row(label: Double, features: Vector) =>
      label + "," + features.toArray.mkString(",")
    }.repartition(1).saveAsTextFile(
      "target/tmp/GeneralizedLinearRegressionSuite/datasetPoissonLog")
    datasetPoissonLogWithZero.rdd.map { case Row(label: Double, features: Vector) =>
      label + "," + features.toArray.mkString(",")
    }.repartition(1).saveAsTextFile(
      "target/tmp/GeneralizedLinearRegressionSuite/datasetPoissonLogWithZero")
    datasetPoissonIdentity.rdd.map { case Row(label: Double, features: Vector) =>
      label + "," + features.toArray.mkString(",")
    }.repartition(1).saveAsTextFile(
      "target/tmp/GeneralizedLinearRegressionSuite/datasetPoissonIdentity")
    datasetPoissonSqrt.rdd.map { case Row(label: Double, features: Vector) =>
      label + "," + features.toArray.mkString(",")
    }.repartition(1).saveAsTextFile(
      "target/tmp/GeneralizedLinearRegressionSuite/datasetPoissonSqrt")
    datasetGammaInverse.rdd.map { case Row(label: Double, features: Vector) =>
      label + "," + features.toArray.mkString(",")
    }.repartition(1).saveAsTextFile(
      "target/tmp/GeneralizedLinearRegressionSuite/datasetGammaInverse")
    datasetGammaIdentity.rdd.map { case Row(label: Double, features: Vector) =>
      label + "," + features.toArray.mkString(",")
    }.repartition(1).saveAsTextFile(
      "target/tmp/GeneralizedLinearRegressionSuite/datasetGammaIdentity")
    datasetGammaLog.rdd.map { case Row(label: Double, features: Vector) =>
      label + "," + features.toArray.mkString(",")
    }.repartition(1).saveAsTextFile(
      "target/tmp/GeneralizedLinearRegressionSuite/datasetGammaLog")
  }

  test("params") {
    ParamsSuite.checkParams(new GeneralizedLinearRegression)
    val model = new GeneralizedLinearRegressionModel("genLinReg", Vectors.dense(0.0), 0.0)
    ParamsSuite.checkParams(model)
  }

  test("generalized linear regression: default params") {
    val glr = new GeneralizedLinearRegression
    assert(glr.getLabelCol === "label")
    assert(glr.getFeaturesCol === "features")
    assert(glr.getPredictionCol === "prediction")
    assert(glr.getFitIntercept)
    assert(glr.getTol === 1E-6)
    assert(!glr.isDefined(glr.weightCol))
    assert(glr.getRegParam === 0.0)
    assert(glr.getSolver == "irls")
    assert(glr.getVariancePower === 0.0)

    // TODO: Construct model directly instead of via fitting.
    val model = glr.setFamily("gaussian").setLink("identity")
      .fit(datasetGaussianIdentity)

    MLTestingUtils.checkCopyAndUids(glr, model)
    assert(model.hasSummary)
    val copiedModel = model.copy(ParamMap.empty)
    assert(copiedModel.hasSummary)
    model.setSummary(None)
    assert(!model.hasSummary)

    assert(model.getFeaturesCol === "features")
    assert(model.getPredictionCol === "prediction")
    assert(model.intercept !== 0.0)
    assert(model.hasParent)
    assert(model.getFamily === "gaussian")
    assert(model.getLink === "identity")
  }

  test("generalized linear regression: gaussian family against glm") {
    /*
       R code:
       f1 <- data$V1 ~ data$V2 + data$V3 - 1
       f2 <- data$V1 ~ data$V2 + data$V3

       data <- read.csv("path", header=FALSE)
       for (formula in c(f1, f2)) {
         model <- glm(formula, family="gaussian", data=data)
         print(as.vector(coef(model)))
       }

       [1] 2.2960999 0.8087933
       [1] 2.5002642 2.2000403 0.5999485

       data <- read.csv("path", header=FALSE)
       model1 <- glm(f1, family=gaussian(link=log), data=data, start=c(0,0))
       model2 <- glm(f2, family=gaussian(link=log), data=data, start=c(0,0,0))
       print(as.vector(coef(model1)))
       print(as.vector(coef(model2)))

       [1] 0.23069326 0.07993778
       [1] 0.25001858 0.22002452 0.05998789

       data <- read.csv("path", header=FALSE)
       for (formula in c(f1, f2)) {
         model <- glm(formula, family=gaussian(link=inverse), data=data)
         print(as.vector(coef(model)))
       }

       [1] 2.3010179 0.8198976
       [1] 2.4108902 2.2130248 0.6086152
     */

    val expected = Seq(
      Vectors.dense(0.0, 2.2960999, 0.8087933),
      Vectors.dense(2.5002642, 2.2000403, 0.5999485),
      Vectors.dense(0.0, 0.23069326, 0.07993778),
      Vectors.dense(0.25001858, 0.22002452, 0.05998789),
      Vectors.dense(0.0, 2.3010179, 0.8198976),
      Vectors.dense(2.4108902, 2.2130248, 0.6086152))

    import GeneralizedLinearRegression._

    var idx = 0
    for ((link, dataset) <- Seq(("identity", datasetGaussianIdentity), ("log", datasetGaussianLog),
      ("inverse", datasetGaussianInverse))) {
      for (fitIntercept <- Seq(false, true)) {
        val trainer = new GeneralizedLinearRegression().setFamily("gaussian").setLink(link)
          .setFitIntercept(fitIntercept).setLinkPredictionCol("linkPrediction")
        val model = trainer.fit(dataset)
        val actual = Vectors.dense(model.intercept, model.coefficients(0), model.coefficients(1))
        assert(actual ~= expected(idx) absTol 1e-4, "Model mismatch: GLM with gaussian family, " +
          s"$link link and fitIntercept = $fitIntercept.")

        val familyLink = FamilyAndLink(trainer)
        model.transform(dataset).select("features", "prediction", "linkPrediction").collect()
          .foreach {
            case Row(features: DenseVector, prediction1: Double, linkPrediction1: Double) =>
              val eta = BLAS.dot(features, model.coefficients) + model.intercept
              val prediction2 = familyLink.fitted(eta)
              val linkPrediction2 = eta
              assert(prediction1 ~= prediction2 relTol 1E-5, "Prediction mismatch: GLM with " +
                s"gaussian family, $link link and fitIntercept = $fitIntercept.")
              assert(linkPrediction1 ~= linkPrediction2 relTol 1E-5, "Link Prediction mismatch: " +
                s"GLM with gaussian family, $link link and fitIntercept = $fitIntercept.")
          }

        idx += 1
      }
    }
  }

  test("generalized linear regression: gaussian family against glmnet") {
    /*
       R code:
       library(glmnet)
       data <- read.csv("path", header=FALSE)
       label = data$V1
       features = as.matrix(data.frame(data$V2, data$V3))
       for (intercept in c(FALSE, TRUE)) {
         for (lambda in c(0.0, 0.1, 1.0)) {
           model <- glmnet(features, label, family="gaussian", intercept=intercept,
                           lambda=lambda, alpha=0, thresh=1E-14)
           print(as.vector(coef(model)))
         }
       }

       [1] 0.0000000 2.2961005 0.8087932
       [1] 0.0000000 2.2130368 0.8309556
       [1] 0.0000000 1.7176137 0.9610657
       [1] 2.5002642 2.2000403 0.5999485
       [1] 3.1106389 2.0935142 0.5712711
       [1] 6.7597127 1.4581054 0.3994266
     */

    val expected = Seq(
      Vectors.dense(0.0, 2.2961005, 0.8087932),
      Vectors.dense(0.0, 2.2130368, 0.8309556),
      Vectors.dense(0.0, 1.7176137, 0.9610657),
      Vectors.dense(2.5002642, 2.2000403, 0.5999485),
      Vectors.dense(3.1106389, 2.0935142, 0.5712711),
      Vectors.dense(6.7597127, 1.4581054, 0.3994266))

    var idx = 0
    for (fitIntercept <- Seq(false, true);
         regParam <- Seq(0.0, 0.1, 1.0)) {
      val trainer = new GeneralizedLinearRegression().setFamily("gaussian")
        .setFitIntercept(fitIntercept).setRegParam(regParam)
      val model = trainer.fit(datasetGaussianIdentity)
      val actual = Vectors.dense(model.intercept, model.coefficients(0), model.coefficients(1))
      assert(actual ~= expected(idx) absTol 1e-4, "Model mismatch: GLM with gaussian family, " +
        s"fitIntercept = $fitIntercept and regParam = $regParam.")

      idx += 1
    }
  }

  test("generalized linear regression: binomial family against glm") {
    /*
       R code:
       f1 <- data$V1 ~ data$V2 + data$V3 + data$V4 + data$V5 - 1
       f2 <- data$V1 ~ data$V2 + data$V3 + data$V4 + data$V5
       data <- read.csv("path", header=FALSE)

       for (formula in c(f1, f2)) {
         model <- glm(formula, family="binomial", data=data)
         print(as.vector(coef(model)))
       }

       [1] -0.3560284  1.3010002 -0.3570805 -0.7406762
       [1]  2.8367406 -0.5896187  0.8931655 -0.3925169 -0.7996989

       for (formula in c(f1, f2)) {
         model <- glm(formula, family=binomial(link=probit), data=data)
         print(as.vector(coef(model)))
       }

       [1] -0.2134390  0.7800646 -0.2144267 -0.4438358
       [1]  1.6995366 -0.3524694  0.5332651 -0.2352985 -0.4780850

       for (formula in c(f1, f2)) {
         model <- glm(formula, family=binomial(link=cloglog), data=data)
         print(as.vector(coef(model)))
       }

       [1] -0.2832198  0.8434144 -0.2524727 -0.5293452
       [1]  1.5063590 -0.4038015  0.6133664 -0.2687882 -0.5541758
     */
    val expected = Seq(
      Vectors.dense(0.0, -0.3560284, 1.3010002, -0.3570805, -0.7406762),
      Vectors.dense(2.8367406, -0.5896187, 0.8931655, -0.3925169, -0.7996989),
      Vectors.dense(0.0, -0.2134390, 0.7800646, -0.2144267, -0.4438358),
      Vectors.dense(1.6995366, -0.3524694, 0.5332651, -0.2352985, -0.4780850),
      Vectors.dense(0.0, -0.2832198, 0.8434144, -0.2524727, -0.5293452),
      Vectors.dense(1.5063590, -0.4038015, 0.6133664, -0.2687882, -0.5541758))

    import GeneralizedLinearRegression._

    var idx = 0
    for ((link, dataset) <- Seq(("logit", datasetBinomial), ("probit", datasetBinomial),
      ("cloglog", datasetBinomial))) {
      for (fitIntercept <- Seq(false, true)) {
        val trainer = new GeneralizedLinearRegression().setFamily("binomial").setLink(link)
          .setFitIntercept(fitIntercept).setLinkPredictionCol("linkPrediction")
        val model = trainer.fit(dataset)
        val actual = Vectors.dense(model.intercept, model.coefficients(0), model.coefficients(1),
          model.coefficients(2), model.coefficients(3))
        assert(actual ~= expected(idx) absTol 1e-4, "Model mismatch: GLM with binomial family, " +
          s"$link link and fitIntercept = $fitIntercept.")

        val familyLink = FamilyAndLink(trainer)
        model.transform(dataset).select("features", "prediction", "linkPrediction").collect()
          .foreach {
            case Row(features: DenseVector, prediction1: Double, linkPrediction1: Double) =>
              val eta = BLAS.dot(features, model.coefficients) + model.intercept
              val prediction2 = familyLink.fitted(eta)
              val linkPrediction2 = eta
              assert(prediction1 ~= prediction2 relTol 1E-5, "Prediction mismatch: GLM with " +
                s"binomial family, $link link and fitIntercept = $fitIntercept.")
              assert(linkPrediction1 ~= linkPrediction2 relTol 1E-5, "Link Prediction mismatch: " +
                s"GLM with binomial family, $link link and fitIntercept = $fitIntercept.")
          }

        idx += 1
      }
    }
  }

  test("generalized linear regression: poisson family against glm") {
    /*
       R code:
       f1 <- data$V1 ~ data$V2 + data$V3 - 1
       f2 <- data$V1 ~ data$V2 + data$V3

       data <- read.csv("path", header=FALSE)
       for (formula in c(f1, f2)) {
         model <- glm(formula, family="poisson", data=data)
         print(as.vector(coef(model)))
       }

       [1] 0.22999393 0.08047088
       [1] 0.25022353 0.21998599 0.05998621

       data <- read.csv("path", header=FALSE)
       for (formula in c(f1, f2)) {
         model <- glm(formula, family=poisson(link=identity), data=data)
         print(as.vector(coef(model)))
       }

       [1] 2.2929501 0.8119415
       [1] 2.5012730 2.1999407 0.5999107

       data <- read.csv("path", header=FALSE)
       for (formula in c(f1, f2)) {
         model <- glm(formula, family=poisson(link=sqrt), data=data)
         print(as.vector(coef(model)))
       }

       [1] 2.2958947 0.8090515
       [1] 2.5000480 2.1999972 0.5999968
     */
    val expected = Seq(
      Vectors.dense(0.0, 0.22999393, 0.08047088),
      Vectors.dense(0.25022353, 0.21998599, 0.05998621),
      Vectors.dense(0.0, 2.2929501, 0.8119415),
      Vectors.dense(2.5012730, 2.1999407, 0.5999107),
      Vectors.dense(0.0, 2.2958947, 0.8090515),
      Vectors.dense(2.5000480, 2.1999972, 0.5999968))

    import GeneralizedLinearRegression._

    var idx = 0
    for ((link, dataset) <- Seq(("log", datasetPoissonLog), ("identity", datasetPoissonIdentity),
      ("sqrt", datasetPoissonSqrt))) {
      for (fitIntercept <- Seq(false, true)) {
        val trainer = new GeneralizedLinearRegression().setFamily("poisson").setLink(link)
          .setFitIntercept(fitIntercept).setLinkPredictionCol("linkPrediction")
        val model = trainer.fit(dataset)
        val actual = Vectors.dense(model.intercept, model.coefficients(0), model.coefficients(1))
        assert(actual ~= expected(idx) absTol 1e-4, "Model mismatch: GLM with poisson family, " +
          s"$link link and fitIntercept = $fitIntercept.")

        val familyLink = FamilyAndLink(trainer)
        model.transform(dataset).select("features", "prediction", "linkPrediction").collect()
          .foreach {
            case Row(features: DenseVector, prediction1: Double, linkPrediction1: Double) =>
              val eta = BLAS.dot(features, model.coefficients) + model.intercept
              val prediction2 = familyLink.fitted(eta)
              val linkPrediction2 = eta
              assert(prediction1 ~= prediction2 relTol 1E-5, "Prediction mismatch: GLM with " +
                s"poisson family, $link link and fitIntercept = $fitIntercept.")
              assert(linkPrediction1 ~= linkPrediction2 relTol 1E-5, "Link Prediction mismatch: " +
                s"GLM with poisson family, $link link and fitIntercept = $fitIntercept.")
          }

        idx += 1
      }
    }
  }

  test("generalized linear regression: poisson family against glm (with zero values)") {
    /*
       R code:
       f1 <- data$V1 ~ data$V2 + data$V3 - 1
       f2 <- data$V1 ~ data$V2 + data$V3

       data <- read.csv("path", header=FALSE)
       for (formula in c(f1, f2)) {
         model <- glm(formula, family="poisson", data=data)
         print(as.vector(coef(model)))
       }
       [1] -0.0457441 -0.6833928
       [1] 1.8121235  -0.1747493  -0.5815417
     */
    val expected = Seq(
      Vectors.dense(0.0, -0.0457441, -0.6833928),
      Vectors.dense(1.8121235, -0.1747493, -0.5815417))

    import GeneralizedLinearRegression._

    var idx = 0
    val link = "log"
    val dataset = datasetPoissonLogWithZero
    for (fitIntercept <- Seq(false, true)) {
      val trainer = new GeneralizedLinearRegression().setFamily("poisson").setLink(link)
        .setFitIntercept(fitIntercept).setLinkPredictionCol("linkPrediction")
      val model = trainer.fit(dataset)
      val actual = Vectors.dense(model.intercept, model.coefficients(0), model.coefficients(1))
      assert(actual ~= expected(idx) absTol 1e-4, "Model mismatch: GLM with poisson family, " +
        s"$link link and fitIntercept = $fitIntercept (with zero values).")
      idx += 1
    }
  }

  test("generalized linear regression: gamma family against glm") {
    /*
       R code:
       f1 <- data$V1 ~ data$V2 + data$V3 - 1
       f2 <- data$V1 ~ data$V2 + data$V3

       data <- read.csv("path", header=FALSE)
       for (formula in c(f1, f2)) {
         model <- glm(formula, family="Gamma", data=data)
         print(as.vector(coef(model)))
       }

       [1] 2.3392419 0.8058058
       [1] 2.3507700 2.2533574 0.6042991

       data <- read.csv("path", header=FALSE)
       for (formula in c(f1, f2)) {
         model <- glm(formula, family=Gamma(link=identity), data=data)
         print(as.vector(coef(model)))
       }

       [1] 2.2908883 0.8147796
       [1] 2.5002406 2.1998346 0.6000059

       data <- read.csv("path", header=FALSE)
       for (formula in c(f1, f2)) {
         model <- glm(formula, family=Gamma(link=log), data=data)
         print(as.vector(coef(model)))
       }

       [1] 0.22958970 0.08091066
       [1] 0.25003210 0.21996957 0.06000215
     */
    val expected = Seq(
      Vectors.dense(0.0, 2.3392419, 0.8058058),
      Vectors.dense(2.3507700, 2.2533574, 0.6042991),
      Vectors.dense(0.0, 2.2908883, 0.8147796),
      Vectors.dense(2.5002406, 2.1998346, 0.6000059),
      Vectors.dense(0.0, 0.22958970, 0.08091066),
      Vectors.dense(0.25003210, 0.21996957, 0.06000215))

    import GeneralizedLinearRegression._

    var idx = 0
    for ((link, dataset) <- Seq(("inverse", datasetGammaInverse),
      ("identity", datasetGammaIdentity), ("log", datasetGammaLog))) {
      for (fitIntercept <- Seq(false, true)) {
        val trainer = new GeneralizedLinearRegression().setFamily("Gamma").setLink(link)
          .setFitIntercept(fitIntercept).setLinkPredictionCol("linkPrediction")
        val model = trainer.fit(dataset)
        val actual = Vectors.dense(model.intercept, model.coefficients(0), model.coefficients(1))
        assert(actual ~= expected(idx) absTol 1e-4, "Model mismatch: GLM with gamma family, " +
          s"$link link and fitIntercept = $fitIntercept.")

        val familyLink = FamilyAndLink(trainer)
        model.transform(dataset).select("features", "prediction", "linkPrediction").collect()
          .foreach {
            case Row(features: DenseVector, prediction1: Double, linkPrediction1: Double) =>
              val eta = BLAS.dot(features, model.coefficients) + model.intercept
              val prediction2 = familyLink.fitted(eta)
              val linkPrediction2 = eta
              assert(prediction1 ~= prediction2 relTol 1E-5, "Prediction mismatch: GLM with " +
                s"gamma family, $link link and fitIntercept = $fitIntercept.")
              assert(linkPrediction1 ~= linkPrediction2 relTol 1E-5, "Link Prediction mismatch: " +
                s"GLM with gamma family, $link link and fitIntercept = $fitIntercept.")
          }

        idx += 1
      }
    }
  }

  test("generalized linear regression: tweedie family against glm") {
    /*
      R code:
      library(statmod)
      df <- as.data.frame(matrix(c(
        1.0, 1.0, 0.0, 5.0,
        0.5, 1.0, 1.0, 2.0,
        1.0, 1.0, 2.0, 1.0,
        2.0, 1.0, 3.0, 3.0), 4, 4, byrow = TRUE))

      f1 <- V1 ~ -1 + V3 + V4
      f2 <- V1 ~ V3 + V4

      for (f in c(f1, f2)) {
        for (lp in c(0, 1, -1))
          for (vp in c(1.6, 2.5)) {
            model <- glm(f, df, family = tweedie(var.power = vp, link.power = lp))
            print(as.vector(coef(model)))
          }
      }
      [1] 0.1496480 -0.0122283
      [1] 0.1373567 -0.0120673
      [1] 0.3919109 0.1846094
      [1] 0.3684426 0.1810662
      [1] 0.1759887 0.2195818
      [1] 0.1108561 0.2059430
      [1] -1.3163732  0.4378139  0.2464114
      [1] -1.4396020  0.4817364  0.2680088
      [1] -0.7090230  0.6256309  0.3294324
      [1] -0.9524928  0.7304267  0.3792687
      [1] 2.1188978 -0.3360519 -0.2067023
      [1] 2.1659028 -0.3499170 -0.2128286
    */
    val datasetTweedie = Seq(
      Instance(1.0, 1.0, Vectors.dense(0.0, 5.0)),
      Instance(0.5, 1.0, Vectors.dense(1.0, 2.0)),
      Instance(1.0, 1.0, Vectors.dense(2.0, 1.0)),
      Instance(2.0, 1.0, Vectors.dense(3.0, 3.0))
    ).toDF()

    val expected = Seq(
      Vectors.dense(0, 0.149648, -0.0122283),
      Vectors.dense(0, 0.1373567, -0.0120673),
      Vectors.dense(0, 0.3919109, 0.1846094),
      Vectors.dense(0, 0.3684426, 0.1810662),
      Vectors.dense(0, 0.1759887, 0.2195818),
      Vectors.dense(0, 0.1108561, 0.205943),
      Vectors.dense(-1.3163732, 0.4378139, 0.2464114),
      Vectors.dense(-1.439602, 0.4817364, 0.2680088),
      Vectors.dense(-0.709023, 0.6256309, 0.3294324),
      Vectors.dense(-0.9524928, 0.7304267, 0.3792687),
      Vectors.dense(2.1188978, -0.3360519, -0.2067023),
      Vectors.dense(2.1659028, -0.349917, -0.2128286))

    import GeneralizedLinearRegression._

    var idx = 0
    for (fitIntercept <- Seq(false, true);
         linkPower <- Seq(0.0, 1.0, -1.0);
         variancePower <- Seq(1.6, 2.5)) {
      val trainer = new GeneralizedLinearRegression().setFamily("tweedie")
        .setFitIntercept(fitIntercept).setLinkPredictionCol("linkPrediction")
        .setVariancePower(variancePower).setLinkPower(linkPower)
      val model = trainer.fit(datasetTweedie)
      val actual = Vectors.dense(model.intercept, model.coefficients(0), model.coefficients(1))
      assert(actual ~= expected(idx) absTol 1e-4, "Model mismatch: GLM with tweedie family, " +
        s"linkPower = $linkPower, fitIntercept = $fitIntercept " +
        s"and variancePower = $variancePower.")

      val familyLink = FamilyAndLink(trainer)
      model.transform(datasetTweedie).select("features", "prediction", "linkPrediction").collect()
        .foreach {
          case Row(features: DenseVector, prediction1: Double, linkPrediction1: Double) =>
            val eta = BLAS.dot(features, model.coefficients) + model.intercept
            val prediction2 = familyLink.fitted(eta)
            val linkPrediction2 = eta
            assert(prediction1 ~= prediction2 relTol 1E-5, "Prediction mismatch: GLM with " +
              s"tweedie family, linkPower = $linkPower, fitIntercept = $fitIntercept " +
              s"and variancePower = $variancePower.")
            assert(linkPrediction1 ~= linkPrediction2 relTol 1E-5, "Link Prediction mismatch: " +
              s"GLM with tweedie family, linkPower = $linkPower, fitIntercept = $fitIntercept " +
              s"and variancePower = $variancePower.")
        }
      idx += 1
    }
  }

  test("generalized linear regression: tweedie family against glm (default power link)") {
    /*
      R code:
      library(statmod)
      df <- as.data.frame(matrix(c(
        1.0, 1.0, 0.0, 5.0,
        0.5, 1.0, 1.0, 2.0,
        1.0, 1.0, 2.0, 1.0,
        2.0, 1.0, 3.0, 3.0), 4, 4, byrow = TRUE))
      var.power <- c(0, 1, 2, 1.5)
      f1 <- V1 ~ -1 + V3 + V4
      f2 <- V1 ~ V3 + V4
      for (f in c(f1, f2)) {
        for (vp in var.power) {
          model <- glm(f, df, family = tweedie(var.power = vp))
          print(as.vector(coef(model)))
        }
      }
      [1] 0.4310345 0.1896552
      [1] 0.15776482 -0.01189032
      [1] 0.1468853 0.2116519
      [1] 0.2282601 0.2132775
      [1] -0.5158730  0.5555556  0.2936508
      [1] -1.2689559  0.4230934  0.2388465
      [1] 2.137852 -0.341431 -0.209090
      [1] 1.5953393 -0.1884985 -0.1106335
    */
    val datasetTweedie = Seq(
      Instance(1.0, 1.0, Vectors.dense(0.0, 5.0)),
      Instance(0.5, 1.0, Vectors.dense(1.0, 2.0)),
      Instance(1.0, 1.0, Vectors.dense(2.0, 1.0)),
      Instance(2.0, 1.0, Vectors.dense(3.0, 3.0))
    ).toDF()

    val expected = Seq(
      Vectors.dense(0, 0.4310345, 0.1896552),
      Vectors.dense(0, 0.15776482, -0.01189032),
      Vectors.dense(0, 0.1468853, 0.2116519),
      Vectors.dense(0, 0.2282601, 0.2132775),
      Vectors.dense(-0.515873, 0.5555556, 0.2936508),
      Vectors.dense(-1.2689559, 0.4230934, 0.2388465),
      Vectors.dense(2.137852, -0.341431, -0.20909),
      Vectors.dense(1.5953393, -0.1884985, -0.1106335))

    import GeneralizedLinearRegression._

    var idx = 0
    for (fitIntercept <- Seq(false, true)) {
      for (variancePower <- Seq(0.0, 1.0, 2.0, 1.5)) {
        val trainer = new GeneralizedLinearRegression().setFamily("tweedie")
          .setFitIntercept(fitIntercept).setLinkPredictionCol("linkPrediction")
          .setVariancePower(variancePower)
        val model = trainer.fit(datasetTweedie)
        val actual = Vectors.dense(model.intercept, model.coefficients(0), model.coefficients(1))
        assert(actual ~= expected(idx) absTol 1e-4, "Model mismatch: GLM with tweedie family, " +
          s"fitIntercept = $fitIntercept and variancePower = $variancePower.")

        val familyLink = FamilyAndLink(trainer)
        model.transform(datasetTweedie).select("features", "prediction", "linkPrediction").collect()
          .foreach {
            case Row(features: DenseVector, prediction1: Double, linkPrediction1: Double) =>
              val eta = BLAS.dot(features, model.coefficients) + model.intercept
              val prediction2 = familyLink.fitted(eta)
              val linkPrediction2 = eta
              assert(prediction1 ~= prediction2 relTol 1E-5, "Prediction mismatch: GLM with " +
                s"tweedie family, fitIntercept = $fitIntercept " +
                s"and variancePower = $variancePower.")
              assert(linkPrediction1 ~= linkPrediction2 relTol 1E-5, "Link Prediction mismatch: " +
                s"GLM with tweedie family, fitIntercept = $fitIntercept " +
                s"and variancePower = $variancePower.")
          }
        idx += 1
      }
    }
  }

  test("generalized linear regression: intercept only") {
    /*
      R code:

      library(statmod)
      y <- c(1.0, 0.5, 0.7, 0.3)
      w <- c(1, 2, 3, 4)
      for (fam in list(gaussian(), poisson(), binomial(), Gamma(), tweedie(1.6))) {
        model1 <- glm(y ~ 1, family = fam)
        model2 <- glm(y ~ 1, family = fam, weights = w)
        print(as.vector(c(coef(model1), coef(model2))))
      }
      [1] 0.625 0.530
      [1] -0.4700036 -0.6348783
      [1] 0.5108256 0.1201443
      [1] 1.600000 1.886792
      [1] 1.325782 1.463641
     */

    val dataset = Seq(
      Instance(1.0, 1.0, Vectors.zeros(0)),
      Instance(0.5, 2.0, Vectors.zeros(0)),
      Instance(0.7, 3.0, Vectors.zeros(0)),
      Instance(0.3, 4.0, Vectors.zeros(0))
    ).toDF()

    val expected = Seq(0.625, 0.530, -0.4700036, -0.6348783, 0.5108256, 0.1201443,
      1.600000, 1.886792, 1.325782, 1.463641)

    import GeneralizedLinearRegression._

    var idx = 0
    for (family <- Seq("gaussian", "poisson", "binomial", "gamma", "tweedie")) {
      for (useWeight <- Seq(false, true)) {
        val trainer = new GeneralizedLinearRegression().setFamily(family)
        if (useWeight) trainer.setWeightCol("weight")
        if (family == "tweedie") trainer.setVariancePower(1.6)
        val model = trainer.fit(dataset)
        val actual = model.intercept
        assert(actual ~== expected(idx) absTol 1E-3, "Model mismatch: intercept only GLM with " +
          s"useWeight = $useWeight and family = $family.")
        assert(model.coefficients === new DenseVector(Array.empty[Double]))
        idx += 1
      }
    }

    // throw exception for empty model
    val trainer = new GeneralizedLinearRegression().setFitIntercept(false)
    withClue("Specified model is empty with neither intercept nor feature") {
      intercept[IllegalArgumentException] {
        trainer.fit(dataset)
      }
    }
  }

  test("glm summary: gaussian family with weight") {
    /*
       R code:

       A <- matrix(c(0, 1, 2, 3, 5, 7, 11, 13), 4, 2)
       b <- c(17, 19, 23, 29)
       w <- c(1, 2, 3, 4)
       df <- as.data.frame(cbind(A, b))
     */
    val datasetWithWeight = Seq(
      Instance(17.0, 1.0, Vectors.dense(0.0, 5.0).toSparse),
      Instance(19.0, 2.0, Vectors.dense(1.0, 7.0)),
      Instance(23.0, 3.0, Vectors.dense(2.0, 11.0)),
      Instance(29.0, 4.0, Vectors.dense(3.0, 13.0))
    ).toDF()
    /*
       R code:

       model <- glm(formula = "b ~ .", family="gaussian", data = df, weights = w)
       summary(model)

       Deviance Residuals:
           1       2       3       4
       1.920  -1.358  -1.109   0.960

       Coefficients:
                   Estimate Std. Error t value Pr(>|t|)
       (Intercept)   18.080      9.608   1.882    0.311
       V1             6.080      5.556   1.094    0.471
       V2            -0.600      1.960  -0.306    0.811

       (Dispersion parameter for gaussian family taken to be 7.68)

           Null deviance: 202.00  on 3  degrees of freedom
       Residual deviance:   7.68  on 1  degrees of freedom
       AIC: 18.783

       Number of Fisher Scoring iterations: 2

       residuals(model, type="pearson")
              1         2         3         4
       1.920000 -1.357645 -1.108513  0.960000

       residuals(model, type="working")
          1     2     3     4
       1.92 -0.96 -0.64  0.48

       residuals(model, type="response")
          1     2     3     4
       1.92 -0.96 -0.64  0.48
     */
    val trainer = new GeneralizedLinearRegression()
      .setWeightCol("weight")

    val model = trainer.fit(datasetWithWeight)

    val coefficientsR = Vectors.dense(Array(6.080, -0.600))
    val interceptR = 18.080
    val devianceResidualsR = Array(1.920, -1.358, -1.109, 0.960)
    val pearsonResidualsR = Array(1.920000, -1.357645, -1.108513, 0.960000)
    val workingResidualsR = Array(1.92, -0.96, -0.64, 0.48)
    val responseResidualsR = Array(1.92, -0.96, -0.64, 0.48)
    val seCoefR = Array(5.556, 1.960, 9.608)
    val tValsR = Array(1.094, -0.306, 1.882)
    val pValsR = Array(0.471, 0.811, 0.311)
    val dispersionR = 7.68
    val nullDevianceR = 202.00
    val residualDevianceR = 7.68
    val residualDegreeOfFreedomNullR = 3
    val residualDegreeOfFreedomR = 1
    val aicR = 18.783

    assert(model.hasSummary)
    val summary = model.summary
    assert(summary.isInstanceOf[GeneralizedLinearRegressionTrainingSummary])

    val devianceResiduals = summary.residuals()
      .select(col("devianceResiduals"))
      .collect()
      .map(_.getDouble(0))
    val pearsonResiduals = summary.residuals("pearson")
      .select(col("pearsonResiduals"))
      .collect()
      .map(_.getDouble(0))
    val workingResiduals = summary.residuals("working")
      .select(col("workingResiduals"))
      .collect()
      .map(_.getDouble(0))
    val responseResiduals = summary.residuals("response")
      .select(col("responseResiduals"))
      .collect()
      .map(_.getDouble(0))

    assert(model.coefficients ~== coefficientsR absTol 1E-3)
    assert(model.intercept ~== interceptR absTol 1E-3)
    devianceResiduals.zip(devianceResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    pearsonResiduals.zip(pearsonResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    workingResiduals.zip(workingResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    responseResiduals.zip(responseResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    summary.coefficientStandardErrors.zip(seCoefR).foreach{ x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    summary.tValues.zip(tValsR).foreach{ x => assert(x._1 ~== x._2 absTol 1E-3) }
    summary.pValues.zip(pValsR).foreach{ x => assert(x._1 ~== x._2 absTol 1E-3) }
    assert(summary.dispersion ~== dispersionR absTol 1E-3)
    assert(summary.nullDeviance ~== nullDevianceR absTol 1E-3)
    assert(summary.deviance ~== residualDevianceR absTol 1E-3)
    assert(summary.residualDegreeOfFreedom === residualDegreeOfFreedomR)
    assert(summary.residualDegreeOfFreedomNull === residualDegreeOfFreedomNullR)
    assert(summary.aic ~== aicR absTol 1E-3)
    assert(summary.solver === "irls")

    val summary2: GeneralizedLinearRegressionSummary = model.evaluate(datasetWithWeight)
    assert(summary.predictions.columns.toSet === summary2.predictions.columns.toSet)
    assert(summary.predictionCol === summary2.predictionCol)
    assert(summary.rank === summary2.rank)
    assert(summary.degreesOfFreedom === summary2.degreesOfFreedom)
    assert(summary.residualDegreeOfFreedom === summary2.residualDegreeOfFreedom)
    assert(summary.residualDegreeOfFreedomNull === summary2.residualDegreeOfFreedomNull)
    assert(summary.nullDeviance === summary2.nullDeviance)
    assert(summary.deviance === summary2.deviance)
    assert(summary.dispersion === summary2.dispersion)
    assert(summary.aic === summary2.aic)
  }

  test("glm summary: binomial family with weight") {
    /*
       R code:

       A <- matrix(c(0, 1, 2, 3, 5, 2, 1, 3), 4, 2)
       b <- c(1, 0.5, 1, 0)
       w <- c(1, 2.0, 0.3, 4.7)
       df <- as.data.frame(cbind(A, b))
     */
    val datasetWithWeight = Seq(
      Instance(1.0, 1.0, Vectors.dense(0.0, 5.0).toSparse),
      Instance(0.5, 2.0, Vectors.dense(1.0, 2.0)),
      Instance(1.0, 0.3, Vectors.dense(2.0, 1.0)),
      Instance(0.0, 4.7, Vectors.dense(3.0, 3.0))
    ).toDF()

    /*
       R code:

       model <- glm(formula = "b ~ . -1", family="binomial", data = df, weights = w)
       summary(model)

       Deviance Residuals:
             1        2        3        4
        0.2404   0.1965   1.2824  -0.6916

       Coefficients:
          Estimate Std. Error z value Pr(>|z|)
       x1  -1.6901     1.2764  -1.324    0.185
       x2   0.7059     0.9449   0.747    0.455

       (Dispersion parameter for binomial family taken to be 1)

           Null deviance: 8.3178  on 4  degrees of freedom
       Residual deviance: 2.2193  on 2  degrees of freedom
       AIC: 5.9915

       Number of Fisher Scoring iterations: 5

       residuals(model, type="pearson")
              1         2         3         4
       0.171217  0.197406  2.085864 -0.495332

       residuals(model, type="working")
              1         2         3         4
       1.029315  0.281881 15.502768 -1.052203

       residuals(model, type="response")
              1          2          3          4
       0.028480  0.069123  0.935495 -0.049613
    */
    val trainer = new GeneralizedLinearRegression()
      .setFamily("Binomial")
      .setWeightCol("weight")
      .setFitIntercept(false)

    val model = trainer.fit(datasetWithWeight)

    val coefficientsR = Vectors.dense(Array(-1.690134, 0.705929))
    val interceptR = 0.0
    val devianceResidualsR = Array(0.2404, 0.1965, 1.2824, -0.6916)
    val pearsonResidualsR = Array(0.171217, 0.197406, 2.085864, -0.495332)
    val workingResidualsR = Array(1.029315, 0.281881, 15.502768, -1.052203)
    val responseResidualsR = Array(0.02848, 0.069123, 0.935495, -0.049613)
    val seCoefR = Array(1.276417, 0.944934)
    val tValsR = Array(-1.324124, 0.747068)
    val pValsR = Array(0.185462, 0.455023)
    val dispersionR = 1.0
    val nullDevianceR = 8.3178
    val residualDevianceR = 2.2193
    val residualDegreeOfFreedomNullR = 4
    val residualDegreeOfFreedomR = 2
    val aicR = 5.991537

    val summary = model.summary
    val devianceResiduals = summary.residuals()
      .select(col("devianceResiduals"))
      .collect()
      .map(_.getDouble(0))
    val pearsonResiduals = summary.residuals("pearson")
      .select(col("pearsonResiduals"))
      .collect()
      .map(_.getDouble(0))
    val workingResiduals = summary.residuals("working")
      .select(col("workingResiduals"))
      .collect()
      .map(_.getDouble(0))
    val responseResiduals = summary.residuals("response")
      .select(col("responseResiduals"))
      .collect()
      .map(_.getDouble(0))

    assert(model.coefficients ~== coefficientsR absTol 1E-3)
    assert(model.intercept ~== interceptR absTol 1E-3)
    devianceResiduals.zip(devianceResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    pearsonResiduals.zip(pearsonResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    workingResiduals.zip(workingResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    responseResiduals.zip(responseResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    summary.coefficientStandardErrors.zip(seCoefR).foreach{ x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    summary.tValues.zip(tValsR).foreach{ x => assert(x._1 ~== x._2 absTol 1E-3) }
    summary.pValues.zip(pValsR).foreach{ x => assert(x._1 ~== x._2 absTol 1E-3) }
    assert(summary.dispersion ~== dispersionR absTol 1E-3)
    assert(summary.nullDeviance ~== nullDevianceR absTol 1E-3)
    assert(summary.deviance ~== residualDevianceR absTol 1E-3)
    assert(summary.residualDegreeOfFreedom === residualDegreeOfFreedomR)
    assert(summary.residualDegreeOfFreedomNull === residualDegreeOfFreedomNullR)
    assert(summary.aic ~== aicR absTol 1E-3)
    assert(summary.solver === "irls")
  }

  test("glm summary: poisson family with weight") {
    /*
       R code:

       A <- matrix(c(0, 1, 2, 3, 5, 7, 11, 13), 4, 2)
       b <- c(2, 8, 3, 9)
       w <- c(1, 2, 3, 4)
       df <- as.data.frame(cbind(A, b))
     */
    val datasetWithWeight = Seq(
      Instance(2.0, 1.0, Vectors.dense(0.0, 5.0).toSparse),
      Instance(8.0, 2.0, Vectors.dense(1.0, 7.0)),
      Instance(3.0, 3.0, Vectors.dense(2.0, 11.0)),
      Instance(9.0, 4.0, Vectors.dense(3.0, 13.0))
    ).toDF()
    /*
       R code:

       model <- glm(formula = "b ~ .", family="poisson", data = df, weights = w)
       summary(model)

       Deviance Residuals:
              1         2         3         4
       -0.28952   0.11048   0.14839  -0.07268

       Coefficients:
                   Estimate Std. Error z value Pr(>|z|)
       (Intercept)   6.2999     1.6086   3.916 8.99e-05 ***
       V1            3.3241     1.0184   3.264  0.00110 **
       V2           -1.0818     0.3522  -3.071  0.00213 **
       ---
       Signif. codes:  0 '***' 0.001 '**' 0.01 '*' 0.05 '.' 0.1 ' ' 1

       (Dispersion parameter for poisson family taken to be 1)

           Null deviance: 15.38066  on 3  degrees of freedom
       Residual deviance:  0.12333  on 1  degrees of freedom
       AIC: 41.803

       Number of Fisher Scoring iterations: 3

       residuals(model, type="pearson")
                 1           2           3           4
       -0.28043145  0.11099310  0.14963714 -0.07253611

       residuals(model, type="working")
                 1           2           3           4
       -0.17960679  0.02813593  0.05113852 -0.01201650

       residuals(model, type="response")
                1          2          3          4
       -0.4378554  0.2189277  0.1459518 -0.1094638
     */
    val trainer = new GeneralizedLinearRegression()
      .setFamily("Poisson")
      .setWeightCol("weight")
      .setFitIntercept(true)

    val model = trainer.fit(datasetWithWeight)

    val coefficientsR = Vectors.dense(Array(3.3241, -1.0818))
    val interceptR = 6.2999
    val devianceResidualsR = Array(-0.28952, 0.11048, 0.14839, -0.07268)
    val pearsonResidualsR = Array(-0.28043145, 0.11099310, 0.14963714, -0.07253611)
    val workingResidualsR = Array(-0.17960679, 0.02813593, 0.05113852, -0.01201650)
    val responseResidualsR = Array(-0.4378554, 0.2189277, 0.1459518, -0.1094638)
    val seCoefR = Array(1.0184, 0.3522, 1.6086)
    val tValsR = Array(3.264, -3.071, 3.916)
    val pValsR = Array(0.00110, 0.00213, 0.00009)
    val dispersionR = 1.0
    val nullDevianceR = 15.38066
    val residualDevianceR = 0.12333
    val residualDegreeOfFreedomNullR = 3
    val residualDegreeOfFreedomR = 1
    val aicR = 41.803

    val summary = model.summary
    val devianceResiduals = summary.residuals()
      .select(col("devianceResiduals"))
      .collect()
      .map(_.getDouble(0))
    val pearsonResiduals = summary.residuals("pearson")
      .select(col("pearsonResiduals"))
      .collect()
      .map(_.getDouble(0))
    val workingResiduals = summary.residuals("working")
      .select(col("workingResiduals"))
      .collect()
      .map(_.getDouble(0))
    val responseResiduals = summary.residuals("response")
      .select(col("responseResiduals"))
      .collect()
      .map(_.getDouble(0))

    assert(model.coefficients ~== coefficientsR absTol 1E-3)
    assert(model.intercept ~== interceptR absTol 1E-3)
    devianceResiduals.zip(devianceResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    pearsonResiduals.zip(pearsonResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    workingResiduals.zip(workingResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    responseResiduals.zip(responseResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    summary.coefficientStandardErrors.zip(seCoefR).foreach{ x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    summary.tValues.zip(tValsR).foreach{ x => assert(x._1 ~== x._2 absTol 1E-3) }
    summary.pValues.zip(pValsR).foreach{ x => assert(x._1 ~== x._2 absTol 1E-3) }
    assert(summary.dispersion ~== dispersionR absTol 1E-3)
    assert(summary.nullDeviance ~== nullDevianceR absTol 1E-3)
    assert(summary.deviance ~== residualDevianceR absTol 1E-3)
    assert(summary.residualDegreeOfFreedom === residualDegreeOfFreedomR)
    assert(summary.residualDegreeOfFreedomNull === residualDegreeOfFreedomNullR)
    assert(summary.aic ~== aicR absTol 1E-3)
    assert(summary.solver === "irls")
  }

  test("glm summary: gamma family with weight") {
    /*
       R code:

       A <- matrix(c(0, 1, 2, 3, 5, 7, 11, 13), 4, 2)
       b <- c(2, 8, 3, 9)
       w <- c(1, 2, 3, 4)
       df <- as.data.frame(cbind(A, b))
     */
    val datasetWithWeight = Seq(
      Instance(2.0, 1.0, Vectors.dense(0.0, 5.0).toSparse),
      Instance(8.0, 2.0, Vectors.dense(1.0, 7.0)),
      Instance(3.0, 3.0, Vectors.dense(2.0, 11.0)),
      Instance(9.0, 4.0, Vectors.dense(3.0, 13.0))
    ).toDF()
    /*
       R code:

       model <- glm(formula = "b ~ .", family="Gamma", data = df, weights = w)
       summary(model)

       Deviance Residuals:
              1         2         3         4
       -0.26343   0.05761   0.12818  -0.03484

       Coefficients:
                   Estimate Std. Error t value Pr(>|t|)
       (Intercept) -0.81511    0.23449  -3.476    0.178
       V1          -0.72730    0.16137  -4.507    0.139
       V2           0.23894    0.05481   4.359    0.144

       (Dispersion parameter for Gamma family taken to be 0.07986091)

           Null deviance: 2.937462  on 3  degrees of freedom
       Residual deviance: 0.090358  on 1  degrees of freedom
       AIC: 23.202

       Number of Fisher Scoring iterations: 4

       residuals(model, type="pearson")
                 1           2           3           4
       -0.24082508  0.05839241  0.13135766 -0.03463621

       residuals(model, type="working")
                 1            2            3            4
       0.091414181 -0.005374314 -0.027196998  0.001890910

       residuals(model, type="response")
                1          2          3          4
       -0.6344390  0.3172195  0.2114797 -0.1586097
     */
    val trainer = new GeneralizedLinearRegression()
      .setFamily("Gamma")
      .setWeightCol("weight")

    val model = trainer.fit(datasetWithWeight)

    val coefficientsR = Vectors.dense(Array(-0.72730, 0.23894))
    val interceptR = -0.81511
    val devianceResidualsR = Array(-0.26343, 0.05761, 0.12818, -0.03484)
    val pearsonResidualsR = Array(-0.24082508, 0.05839241, 0.13135766, -0.03463621)
    val workingResidualsR = Array(0.091414181, -0.005374314, -0.027196998, 0.001890910)
    val responseResidualsR = Array(-0.6344390, 0.3172195, 0.2114797, -0.1586097)
    val seCoefR = Array(0.16137, 0.05481, 0.23449)
    val tValsR = Array(-4.507, 4.359, -3.476)
    val pValsR = Array(0.139, 0.144, 0.178)
    val dispersionR = 0.07986091
    val nullDevianceR = 2.937462
    val residualDevianceR = 0.090358
    val residualDegreeOfFreedomNullR = 3
    val residualDegreeOfFreedomR = 1
    val aicR = 23.202

    val summary = model.summary
    val devianceResiduals = summary.residuals()
      .select(col("devianceResiduals"))
      .collect()
      .map(_.getDouble(0))
    val pearsonResiduals = summary.residuals("pearson")
      .select(col("pearsonResiduals"))
      .collect()
      .map(_.getDouble(0))
    val workingResiduals = summary.residuals("working")
      .select(col("workingResiduals"))
      .collect()
      .map(_.getDouble(0))
    val responseResiduals = summary.residuals("response")
      .select(col("responseResiduals"))
      .collect()
      .map(_.getDouble(0))

    assert(model.coefficients ~== coefficientsR absTol 1E-3)
    assert(model.intercept ~== interceptR absTol 1E-3)
    devianceResiduals.zip(devianceResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    pearsonResiduals.zip(pearsonResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    workingResiduals.zip(workingResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    responseResiduals.zip(responseResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    summary.coefficientStandardErrors.zip(seCoefR).foreach{ x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    summary.tValues.zip(tValsR).foreach{ x => assert(x._1 ~== x._2 absTol 1E-3) }
    summary.pValues.zip(pValsR).foreach{ x => assert(x._1 ~== x._2 absTol 1E-3) }
    assert(summary.dispersion ~== dispersionR absTol 1E-3)
    assert(summary.nullDeviance ~== nullDevianceR absTol 1E-3)
    assert(summary.deviance ~== residualDevianceR absTol 1E-3)
    assert(summary.residualDegreeOfFreedom === residualDegreeOfFreedomR)
    assert(summary.residualDegreeOfFreedomNull === residualDegreeOfFreedomNullR)
    assert(summary.aic ~== aicR absTol 1E-3)
    assert(summary.solver === "irls")
  }

  test("glm summary: tweedie family with weight") {
    /*
      R code:

      library(statmod)
      df <- as.data.frame(matrix(c(
        1.0, 1.0, 0.0, 5.0,
        0.5, 2.0, 1.0, 2.0,
        1.0, 3.0, 2.0, 1.0,
        0.0, 4.0, 3.0, 3.0), 4, 4, byrow = TRUE))

      model <- glm(V1 ~ -1 + V3 + V4, data = df, weights = V2,
          family = tweedie(var.power = 1.6, link.power = 0))
      summary(model)

      Deviance Residuals:
            1        2        3        4
       0.6210  -0.0515   1.6935  -3.2539

      Coefficients:
         Estimate Std. Error t value Pr(>|t|)
      V3  -0.4087     0.5205  -0.785    0.515
      V4  -0.1212     0.4082  -0.297    0.794

      (Dispersion parameter for Tweedie family taken to be 3.830036)

          Null deviance: 20.702  on 4  degrees of freedom
      Residual deviance: 13.844  on 2  degrees of freedom
      AIC: NA

      Number of Fisher Scoring iterations: 11

      residuals(model, type="pearson")
           1           2           3           4
      0.7383616 -0.0509458  2.2348337 -1.4552090
      residuals(model, type="working")
           1            2            3            4
      0.83354150 -0.04103552  1.55676369 -1.00000000
      residuals(model, type="response")
           1            2            3            4
      0.45460738 -0.02139574  0.60888055 -0.20392801
     */
    val datasetWithWeight = Seq(
      Instance(1.0, 1.0, Vectors.dense(0.0, 5.0)),
      Instance(0.5, 2.0, Vectors.dense(1.0, 2.0)),
      Instance(1.0, 3.0, Vectors.dense(2.0, 1.0)),
      Instance(0.0, 4.0, Vectors.dense(3.0, 3.0))
    ).toDF()

    val trainer = new GeneralizedLinearRegression()
      .setFamily("tweedie")
      .setVariancePower(1.6)
      .setLinkPower(0.0)
      .setWeightCol("weight")
      .setFitIntercept(false)

    val model = trainer.fit(datasetWithWeight)
    val coefficientsR = Vectors.dense(Array(-0.408746, -0.12125))
    val interceptR = 0.0
    val devianceResidualsR = Array(0.621047, -0.051515, 1.693473, -3.253946)
    val pearsonResidualsR = Array(0.738362, -0.050946, 2.234834, -1.455209)
    val workingResidualsR = Array(0.833541, -0.041036, 1.556764, -1.0)
    val responseResidualsR = Array(0.454607, -0.021396, 0.608881, -0.203928)
    val seCoefR = Array(0.520519, 0.408215)
    val tValsR = Array(-0.785267, -0.297024)
    val pValsR = Array(0.514549, 0.794457)
    val dispersionR = 3.830036
    val nullDevianceR = 20.702
    val residualDevianceR = 13.844
    val residualDegreeOfFreedomNullR = 4
    val residualDegreeOfFreedomR = 2

    val summary = model.summary

    val devianceResiduals = summary.residuals()
      .select(col("devianceResiduals"))
      .collect()
      .map(_.getDouble(0))
    val pearsonResiduals = summary.residuals("pearson")
      .select(col("pearsonResiduals"))
      .collect()
      .map(_.getDouble(0))
    val workingResiduals = summary.residuals("working")
      .select(col("workingResiduals"))
      .collect()
      .map(_.getDouble(0))
    val responseResiduals = summary.residuals("response")
      .select(col("responseResiduals"))
      .collect()
      .map(_.getDouble(0))

    assert(model.coefficients ~== coefficientsR absTol 1E-3)
    assert(model.intercept ~== interceptR absTol 1E-3)
    devianceResiduals.zip(devianceResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    pearsonResiduals.zip(pearsonResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    workingResiduals.zip(workingResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    responseResiduals.zip(responseResidualsR).foreach { x =>
      assert(x._1 ~== x._2 absTol 1E-3) }

    summary.coefficientStandardErrors.zip(seCoefR).foreach{ x =>
      assert(x._1 ~== x._2 absTol 1E-3) }
    summary.tValues.zip(tValsR).foreach{ x => assert(x._1 ~== x._2 absTol 1E-3) }
    summary.pValues.zip(pValsR).foreach{ x => assert(x._1 ~== x._2 absTol 1E-3) }

    assert(summary.dispersion ~== dispersionR absTol 1E-3)
    assert(summary.nullDeviance ~== nullDevianceR absTol 1E-3)
    assert(summary.deviance ~== residualDevianceR absTol 1E-3)
    assert(summary.residualDegreeOfFreedom === residualDegreeOfFreedomR)
    assert(summary.residualDegreeOfFreedomNull === residualDegreeOfFreedomNullR)
    assert(summary.solver === "irls")
  }

  test("glm handle collinear features") {
    val collinearInstances = Seq(
      Instance(1.0, 1.0, Vectors.dense(1.0, 2.0)),
      Instance(2.0, 1.0, Vectors.dense(2.0, 4.0)),
      Instance(3.0, 1.0, Vectors.dense(3.0, 6.0)),
      Instance(4.0, 1.0, Vectors.dense(4.0, 8.0))
    ).toDF()
    val trainer = new GeneralizedLinearRegression()
    val model = trainer.fit(collinearInstances)
    // to make it clear that underlying WLS did not solve analytically
    intercept[UnsupportedOperationException] {
      model.summary.coefficientStandardErrors
    }
    intercept[UnsupportedOperationException] {
      model.summary.pValues
    }
    intercept[UnsupportedOperationException] {
      model.summary.tValues
    }
  }

  test("read/write") {
    def checkModelData(
        model: GeneralizedLinearRegressionModel,
        model2: GeneralizedLinearRegressionModel): Unit = {
      assert(model.intercept === model2.intercept)
      assert(model.coefficients.toArray === model2.coefficients.toArray)
    }

    val glr = new GeneralizedLinearRegression()
    testEstimatorAndModelReadWrite(glr, datasetPoissonLog,
      GeneralizedLinearRegressionSuite.allParamSettings,
      GeneralizedLinearRegressionSuite.allParamSettings, checkModelData)
  }

  test("should support all NumericType labels and weights, and not support other types") {
    val glr = new GeneralizedLinearRegression().setMaxIter(1)
    MLTestingUtils.checkNumericTypes[
        GeneralizedLinearRegressionModel, GeneralizedLinearRegression](
      glr, spark, isClassification = false) { (expected, actual) =>
        assert(expected.intercept === actual.intercept)
        assert(expected.coefficients === actual.coefficients)
      }
  }

  test("glm accepts Dataset[LabeledPoint]") {
    val context = spark
    import context.implicits._
    new GeneralizedLinearRegression()
      .setFamily("gaussian")
      .fit(datasetGaussianIdentity.as[LabeledPoint])
  }

  test("generalized linear regression: regularization parameter") {
    /*
      R code:

      a1 <- c(0, 1, 2, 3)
      a2 <- c(5, 2, 1, 3)
      b <- c(1, 0, 1, 0)
      data <- as.data.frame(cbind(a1, a2, b))
      df <- suppressWarnings(createDataFrame(data))

      for (regParam in c(0.0, 0.1, 1.0)) {
        model <- spark.glm(df, b ~ a1 + a2, regParam = regParam)
        print(as.vector(summary(model)$aic))
      }

      [1] 12.88188
      [1] 12.92681
      [1] 13.32836
     */
    val dataset = Seq(
      LabeledPoint(1, Vectors.dense(5, 0)),
      LabeledPoint(0, Vectors.dense(2, 1)),
      LabeledPoint(1, Vectors.dense(1, 2)),
      LabeledPoint(0, Vectors.dense(3, 3))
    ).toDF()
    val expected = Seq(12.88188, 12.92681, 13.32836)

    var idx = 0
    for (regParam <- Seq(0.0, 0.1, 1.0)) {
      val trainer = new GeneralizedLinearRegression()
        .setRegParam(regParam)
        .setLabelCol("label")
        .setFeaturesCol("features")
      val model = trainer.fit(dataset)
      val actual = model.summary.aic
      assert(actual ~= expected(idx) absTol 1e-4, "Model mismatch: GLM with regParam = $regParam.")
      idx += 1
    }
  }

  test("evaluate with labels that are not doubles") {
    // Evaulate with a dataset that contains Labels not as doubles to verify correct casting
    val dataset = Seq(
      Instance(17.0, 1.0, Vectors.dense(0.0, 5.0).toSparse),
      Instance(19.0, 1.0, Vectors.dense(1.0, 7.0)),
      Instance(23.0, 1.0, Vectors.dense(2.0, 11.0)),
      Instance(29.0, 1.0, Vectors.dense(3.0, 13.0))
    ).toDF()

    val trainer = new GeneralizedLinearRegression()
      .setMaxIter(1)
    val model = trainer.fit(dataset)
    assert(model.hasSummary)
    val summary = model.summary

    val longLabelDataset = dataset.select(col(model.getLabelCol).cast(FloatType),
      col(model.getFeaturesCol))
    val evalSummary = model.evaluate(longLabelDataset)
    // The calculations below involve pattern matching with Label as a double
    assert(evalSummary.nullDeviance === summary.nullDeviance)
    assert(evalSummary.deviance === summary.deviance)
    assert(evalSummary.aic === summary.aic)
  }
}

object GeneralizedLinearRegressionSuite {

  /**
   * Mapping from all Params to valid settings which differ from the defaults.
   * This is useful for tests which need to exercise all Params, such as save/load.
   * This excludes input columns to simplify some tests.
   */
  val allParamSettings: Map[String, Any] = Map(
    "family" -> "poisson",
    "link" -> "log",
    "fitIntercept" -> true,
    "maxIter" -> 2,  // intentionally small
    "tol" -> 0.8,
    "regParam" -> 0.01,
    "predictionCol" -> "myPrediction",
    "variancePower" -> 1.0)

  def generateGeneralizedLinearRegressionInput(
      intercept: Double,
      coefficients: Array[Double],
      xMean: Array[Double],
      xVariance: Array[Double],
      nPoints: Int,
      seed: Int,
      noiseLevel: Double,
      family: String,
      link: String): Seq[LabeledPoint] = {

    val rnd = new Random(seed)
    def rndElement(i: Int) = {
      (rnd.nextDouble() - 0.5) * math.sqrt(12.0 * xVariance(i)) + xMean(i)
    }
    val (generator, mean) = family match {
      case "gaussian" => (new StandardNormalGenerator, 0.0)
      case "poisson" => (new PoissonGenerator(1.0), 1.0)
      case "gamma" => (new GammaGenerator(1.0, 1.0), 1.0)
    }
    generator.setSeed(seed)

    (0 until nPoints).map { _ =>
      val features = Vectors.dense(coefficients.indices.map(rndElement).toArray)
      val eta = BLAS.dot(Vectors.dense(coefficients), features) + intercept
      val mu = link match {
        case "identity" => eta
        case "log" => math.exp(eta)
        case "sqrt" => math.pow(eta, 2.0)
        case "inverse" => 1.0 / eta
      }
      val label = mu + noiseLevel * (generator.nextValue() - mean)
      // Return LabeledPoints with DenseVector
      LabeledPoint(label, features)
    }
  }
}
