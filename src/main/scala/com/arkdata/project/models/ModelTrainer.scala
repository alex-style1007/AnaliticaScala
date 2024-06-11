package com.arkdata.project.models

import org.apache.spark.sql.DataFrame
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.Pipeline

object ModelTrainer {
  def trainModel(data: DataFrame): Pipeline = {
    val assembler = new VectorAssembler()
      .setInputCols(Array("feature1", "feature2"))
      .setOutputCol("features")

    val lr = new LogisticRegression()
      .setLabelCol("label")
      .setFeaturesCol("features")

    new Pipeline().setStages(Array(assembler, lr))
  }
}
