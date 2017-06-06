val projectName: String = "MonsterTruckBot"

val displayName: String = "Monster Truck Bot"

val projectVersion: String = "0.0.1"

val logbackVersion: String = "1.2.1"

lazy val commonDependencies = Seq(
    "com.typesafe.play" %% "anorm" % "2.5.3",
    "com.typesafe" % "config" % "1.3.1"
)

lazy val botDependencies = Seq(
    "ch.qos.logback" % "logback-core" % logbackVersion,
    "ch.qos.logback" % "logback-classic" % logbackVersion
)

lazy val commonSettings = Seq(
    scalaVersion := "2.11.8",
    version := projectVersion,
    isSnapshot := version.value.toLowerCase.contains("snapshot") || version.value.startsWith("0"),
    crossPaths := false,
    autoAPIMappings := true,
    apiMappings += (scalaInstance.value.libraryJar -> url(s"http://www.scala-lang.org/api/${scalaVersion.value}/")),
    libraryDependencies ++= commonDependencies,
    resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)

lazy val botSettings = Seq(
    libraryDependencies ++= botDependencies
)

lazy val root = (project in file(".")).settings(
    commonSettings,
    name := projectName
)

lazy val discord = (project in file("discord")).settings(commonSettings, botSettings).dependsOn(common)

lazy val twitch = (project in file("twitch")).settings(commonSettings, botSettings).dependsOn(common)

lazy val website = (project in file("website")).settings(commonSettings).dependsOn(common).enablePlugins(PlayScala)

lazy val common = (project in file("common")).settings(commonSettings).settings(
    buildInfoKeys := Seq[BuildInfoKey]("name" -> projectName, "displayName" -> displayName, version, scalaVersion, sbtVersion)
).enablePlugins(BuildInfoPlugin)
        