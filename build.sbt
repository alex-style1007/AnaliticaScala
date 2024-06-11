import Dependencies._

ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "Manejo_de_datos",
    libraryDependencies ++= Seq(
        "org.apache.spark" %% "spark-core" % "3.2.0",
        "org.apache.spark" %% "spark-sql" % "3.2.0",
        "org.apache.spark" %% "spark-mllib" % "3.2.0" % "runtime"
    ),
    libraryDependencies += munit % Test
  )
