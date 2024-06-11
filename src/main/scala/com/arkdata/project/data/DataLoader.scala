package com.arkdata.project.data

import org.apache.spark.sql.{DataFrame,SparkSession}
import com.arkdata.project.config.Settings

object DataLoader{
    def loadData(spark: SparkSession): DataFrame= {
        spark.read.option("header","true").csv(Settings.dataPath)
    }
}