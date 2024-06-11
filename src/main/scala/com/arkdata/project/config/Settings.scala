package com.arkdata.project.config

import com.typesafe.config.{Config, ConfigFactory}

object Settings{
    private val config: Config = ConfigFactory.load()

    val dataPath: String = config.getString("data.path")
    val modelPath: String = config.getString("model.path")
}