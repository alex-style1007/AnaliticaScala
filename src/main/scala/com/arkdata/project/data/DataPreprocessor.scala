package com.arkdata.project.data

import org.apache.spark.sql.DataFrame

object DataPreprocessor{
    def preprocessor(data:DataFrame):DataFrame={
        data.na.fill(0).dropDuplicates()
    }
}