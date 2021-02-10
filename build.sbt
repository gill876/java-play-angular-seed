name := """java-play-angular-seed"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean).settings(
  watchSources ++= (baseDirectory.value / "ui/src" ** "*").get
)

scalaVersion := "2.12.8"

libraryDependencies += guice

// To enable the database plug-in, add jdbc in your build dependencies :
libraryDependencies += jdbc

// Test Database
libraryDependencies += "com.h2database" % "h2" % "1.4.199"

// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.12.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "3.1.6" % Test

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))

//MySQL support
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"

// More stuff
libraryDependencies += "org.avaje" % "ebean" % "2.7.3"
libraryDependencies += "javax.persistence" % "persistence-api" % "1.0.2"
libraryDependencies += "com.google.code.gson" % "gson" % "2.2.4"
