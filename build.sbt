name := "boilerpipe-api"

scalaVersion := "2.11.7"

version := "0.1.0"

libraryDependencies := Seq(
  "org.apache.derby" % "derby" % "10.4.1.3",
  "com.typesafe.akka" %% "akka-actor" % "2.3.12",
  "com.typesafe.akka" % "akka-stream-experimental_2.11" % "1.0",
  "com.typesafe.akka" % "akka-http-core-experimental_2.11" % "1.0",
  "com.typesafe.akka" % "akka-http-experimental_2.11" % "1.0",
  "com.typesafe.akka" % "akka-http-spray-json-experimental_2.11" % "1.0",
  "io.spray" %%  "spray-json" % "1.3.2",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)

enablePlugins(JavaAppPackaging)
