# Analitica de datos con Scala

Este proyecto de ciencia de datos en Scala utiliza Apache Spark para el procesamiento de datos y la construccion de modelos de machine learning. El proyecto esta estructurado y empaquetado utilizando SBT (Simple Build Tool)

## Estructura del Proyecto
la estructura del proyecto es la siguiente:
### Archivos Principales

- *build.sbt*: Archivo de configuración de SBT.
- *project/plugins.sbt*: Archivo de configuración de plugins de SBT.
- *src/main/resources/application.conf*: Archivo de configuración para rutas de datos y modelos.
- *src/main/scala/com/tuempresa/tuprojecto/App.scala*: Punto de entrada de la aplicación.
- *src/main/scala/com/tuempresa/tuprojecto/config/Settings.scala*: Configuraciones del proyecto.
- *src/main/scala/com/tuempresa/tuprojecto/data/DataLoader.scala*: Carga de datos.
- *src/main/scala/com/tuempresa/tuprojecto/data/DataPreprocessor.scala*: Preprocesamiento de datos.
- *src/main/scala/com/tuempresa/tuprojecto/models/ModelTrainer.scala*: Entrenamiento del modelo.
- *src/main/scala/com/tuempresa/tuprojecto/models/ModelEvaluator.scala*: Evaluación del modelo.
- *src/main/scala/com/tuempresa/tuprojecto/utils/Utils.scala*: Funciones auxiliares.
- *src/main/scala/com/tuempresa/tuprojecto/Main.scala*: Coordinación del flujo principal del proyecto.

## Configuración

### build.sbt

```scala
name := "TuProyecto"

version := "1.0"

scalaVersion := "2.13.10"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.1.2",
  "org.apache.spark" %% "spark-sql" % "3.1.2",
  "org.apache.spark" %% "spark-mllib" % "3.1.2",
  "com.typesafe" % "config" % "1.4.1"
)

mainClass in assembly := Some("com.tuempresa.tuprojecto.App")

assemblyJarName in assembly := "tuprojecto-assembly.jar"

lazy val root = (project in file("."))
  .settings(
    assembly / mainClass := Some("com.tuempresa.tuprojecto.App")
  )

enablePlugins(AssemblyPlugin)
```

### project/plugins.sbt

```scala
addSbtPlugin("com.eed3si9n" % "sbt-assembly"% "1.1.0")
```

### application.conf

```Hocon
data{
    path= "ruta de los datos"
}

model{
    path= "ruta para guardar el modelo"
}
```

## Compilacion y Empaquetado

1. Compilar el proyecto:
```sh
sbt clean compile
```
2. Empaquetar el proyecto:

```sh
sbt assembly
```

el comando *sbt assembly* creara un archivo JAR en el directorio que incluira todas las dependencias necesarias

## Ejecución del proyecto
Para ejecutar el archivo JAR empaquetado,usa el siguiente comando:
```sh
java -jar "ruta del archivo jar"
```
