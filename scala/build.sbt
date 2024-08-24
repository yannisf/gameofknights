import Dependencies._

ThisBuild / scalaVersion     := "2.13.14"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "knights",
    libraryDependencies += munit % Test,
    assembly / mainClass := Some("example.GameOfKnights"),
    assembly / assemblyJarName := "gameofknights.jar",
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
