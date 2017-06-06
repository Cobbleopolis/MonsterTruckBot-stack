enablePlugins(PlayScala)

unmanagedResourceDirectories in Test += baseDirectory(_ / "target/web/public/test").value

resolvers ++= Seq(
    Resolver.jcenterRepo,
    "jitpack" at "https://jitpack.io"
)

libraryDependencies ++= Seq(jdbc, cache, ws, specs2 % Test)

libraryDependencies ++= Seq(
    "org.postgresql" % "postgresql" % "42.0.0.jre7",
    "org.webjars" %% "webjars-play" % "2.5.0",
    "com.adrianhurt" %% "play-bootstrap" % "1.1-P25-B3" exclude("org.webjars", "bootstrap"),
    "org.webjars.npm" % "bootstrap-sass" % "3.3.7",
    "org.webjars.bower" % "font-awesome-sass" % "4.6.2",
    "ws.securesocial" %% "securesocial" % "3.0-M7",
    "com.github.marcospereira" %% "play-hocon-i18n" % "0.0.2"
)

scalaVersion := "2.11.8"