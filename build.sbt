name := """play-scala-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
//  evolutions,
  guice,
//  jdbc,
  "org.sangria-graphql" %% "sangria-play-json" % "1.0.5",
  "org.sangria-graphql" %% "sangria" % "1.4.2",

  "com.typesafe.play" %% "play-slick" % "4.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "4.0.0",
  "com.github.tototoshi" %% "slick-joda-mapper" % "2.3.0",

  "com.github.tminglei" %% "slick-pg" % "0.18.0",
  "com.github.tminglei" %% "slick-pg_play-json" % "0.18.0",

  "org.postgresql" % "postgresql" % "9.4-1200-jdbc41",

  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test,
  "io.spray" %% "spray-json" % "1.3.5"
)