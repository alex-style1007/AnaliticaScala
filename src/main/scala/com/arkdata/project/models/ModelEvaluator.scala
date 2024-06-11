package com.arkdata.project.models

import org.apache.spark.ml.PipelineModel
import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator
import org.apache.spark.sql.DataFrame

object ModelEvaluator{
    def evaluteModel(model:PipelineModel,data:DataFrame): Double={
        val predictions=model.transform(data)
        val evaluator=new BinaryClassificationEvaluator()
            .setLabelCol("label")
            .setRawPredictionCol("prediction")

        evaluator.evaluate(predictions)
    }
}