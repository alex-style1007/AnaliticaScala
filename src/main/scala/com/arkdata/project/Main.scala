package com.arkdata.project

import org.apache.spark.sql.SparkSession
import com.arkdata.project.data.{DataLoader, DataPreprocessor}
import com.arkdata.project.models.{ModelTrainer, ModelEvaluator}

object Main {
  def run(): Unit = {
    val spark = SparkSession.builder.appName("Proyecto Ciencia de datos").getOrCreate()

    val rawData = DataLoader.loadData(spark)
    val preprocessedData = DataPreprocessor.preprocess(rawData)

    val Array(trainingData, testData) = preprocessedData.randomSplit(Array(0.7, 0.3))

    val pipeline = ModelTrainer.trainModel(trainingData)
    val model = pipeline.fit(trainingData)

    val accuracy = ModelEvaluator.evaluateModel(model, testData)
    println(s"Accuracy: $accuracy")

    spark.stop()
  }
}
