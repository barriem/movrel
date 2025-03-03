val Http4sVersion          = "0.23.27"
val CirceVersion           = "0.14.9"
val MunitVersion           = "1.0.0"
val LogbackVersion         = "1.5.6"
val MunitCatsEffectVersion = "2.0.0"
val ScalaTagsVersion       = "0.13.1"
val ScalaTagsHttp4sVersion = "0.25.2"

lazy val root = (project in file("."))
  .settings(
    organization := "org.bcm",
    name         := "movrel",
    version      := "0.0.1-SNAPSHOT",
    scalaVersion := "3.3.3",
    libraryDependencies ++= Seq(
      "org.http4s"    %% "http4s-ember-server" % Http4sVersion,
      "org.http4s"    %% "http4s-ember-client" % Http4sVersion,
      "org.http4s"    %% "http4s-circe"        % Http4sVersion,
      "org.http4s"    %% "http4s-dsl"          % Http4sVersion,
      "org.http4s"    %% "http4s-scalatags"    % ScalaTagsHttp4sVersion,
      "com.lihaoyi"   %% "scalatags"           % ScalaTagsVersion,
      "org.scalameta" %% "munit"               % MunitVersion           % Test,
      "org.typelevel" %% "munit-cats-effect"   % MunitCatsEffectVersion % Test,
      "ch.qos.logback" % "logback-classic"     % LogbackVersion         % Runtime
    ),
    assembly / assemblyMergeStrategy := {
      case "module-info.class" => MergeStrategy.discard
      case x                   => (assembly / assemblyMergeStrategy).value.apply(x)
    }
  )
