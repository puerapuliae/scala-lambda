javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
scalaVersion := "2.12.6"

lazy val root = (project in file(".")).
  settings(
    name := "lambda-demo",
    version := "1.0",
    scalaVersion := "2.11.4",
    retrieveManaged := true,
    libraryDependencies ++= Seq(
      "com.amazonaws" % "aws-lambda-java-core" % "1.2.0",
      "com.amazonaws" % "aws-lambda-java-log4j2" % "1.1.0",
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "0.29.3" % Compile, 
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "0.29.3" % Provided,
    )
  )

assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case _                             => MergeStrategy.first
}