import sbt._
import sbt.Defaults.defaultSettings
import Keys._

object MyTestBuild extends Build {

  // Scala version used
  val buildScalaVersion = "2.11.5"

  // Compiler flag
  final val StandardSettings = defaultSettings ++ Seq(
    scalacOptions ++= Seq("-unchecked", "-deprecation"),
    scalaVersion := buildScalaVersion,
    retrieveManaged in ThisBuild := true
  )

  // The default project
  lazy val testMain = Project(
    id = "test",
    base = file("."),
    settings =  StandardSettings ++ Seq(
      description := "Main app",
      libraryDependencies ++= additionalComponents, // See below
      resolvers ++= ExtraResolvers
    )
  )


  // ------------------------------------------
  // Additional components
  // ------------------------------------------

  // To enable a component remove the //
  val additionalComponents =
     scalatraComponents ++
    // apacheHttpComponents ++
    // Seq( scalaz ) ++
    // Seq( pdfBox ) ++
    // Seq( h2DB ) ++
    // Seq( posgresDB ) ++
    Seq( scalafx) ++
    Seq()


  // ------------------------------------------
  // Component versions
  // ------------------------------------------

  // Apache HttpComponents http://hc.apache.org/
  // From http://central.maven.org/maven2/org/apache/httpcomponents/
  // Use: import org.apache.http.client.methods.HttpGet
  lazy val apacheHttpClient = "org.apache.httpcomponents" % "httpclient" % "4.2.2"
  lazy val apacheHttpMime   = "org.apache.httpcomponents" % "httpmime"   % "4.2.2"
  lazy val apacheHttpComponents = Seq( apacheHttpClient, apacheHttpMime )
  lazy val scalafx = "org.scalafx" %% "scalafx" % "8.0.60-R9"
  // Apache PDFBox http://pdfbox.apache.org/
  // From http://repo1.maven.org/maven2/org/apache/pdfbox/pdfbox/
  lazy val pdfBox = "org.apache.pdfbox" % "pdfbox" % "1.8.2"

  // H2DB from http://repo1.maven.org/maven2/com/h2database/h2/
  lazy val h2DB = "com.h2database" % "h2" % "1.3.170" // % "provided"
  
  //swing
  lazy val swing = "org.scala-lang" % "scala-swing" % "2.10+"


  // PostgreSQL from http://repo1.maven.org/maven2/postgresql/postgresql/
  lazy val posgresDB = "postgresql" % "postgresql" % "9.1-901.jdbc4" // % "provided"

  // Scalatra (depends on Akka) from http://oss.sonatype.org/content/groups/scala-tools/org/scalatra/
  lazy val scalatraBase    = "org.scalatra" %% "scalatra" % "2.3.0"
  lazy val scalatraScalate = "org.scalatra" %% "scalatra-scalate" % "2.3.0"
  lazy val scalatraComponents = Seq( scalatraBase, scalatraScalate )

  // Other components
  lazy val akka         = "com.typesafe.akka" %% "akka-actor" % "2.3.9"
  lazy val servlet_api  = "javax.servlet" % "servlet-api" % "2.5" % "provided"
  lazy val jetty        = "org.mortbay.jetty" % "jetty" % "6.1.25" % "container"
  lazy val jopt         = "net.sf.jopt-simple" % "jopt-simple" % "4.4-beta-3"
  lazy val opencsv      = "net.sf.opencsv" % "opencsv" % "2.3" // from Sonatype
  lazy val logback      = "ch.qos.logback" % "logback-classic" % "0.9.26"
  lazy val bouncycastle = "org.bouncycastle"  % "bcprov-jdk16" % "1.46"
  lazy val junitInterf  = "com.novocode" % "junit-interface" % "0.8" % "test->default"
  lazy val jgeocoder    = "net.sourceforge.jgeocoder" % "jgeocoder" % "0.4.1" // needs Drexel repo
  lazy val poi          = "org.apache.poi" % "poi" % "3.8"
  lazy val scalaz       = "org.scalaz" %% "scalaz-core" % "7.1.1"
  lazy val apacheIO     = "commons-io" % "commons-io" % "2.4" // org.apache.commons http://commons.apache.org/io/
  lazy val specs        = "org.scala-tools.testing" %% "specs" % "1.6.5-SNAPSHOT" % "test"
  lazy val scalacheck   = "org.scala-tools.testing" %% "scalacheck" % "1.8-SNAPSHOT" % "test"

  // Additional repos, required by some components
  final val ExtraResolvers = Seq(
    // Similar to Scala-tools.org
    "SonaScalaTools" at "http://oss.sonatype.org/content/groups/scala-tools/"

    // Typesafe repo - needed for Akka, Scalatra
    ,"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

    // Snapshots: the bleeding edge
    ,"snapshots-repo" at "https://oss.sonatype.org/content/repositories/snapshots/"

    // For geocoder jar at http://jgeocoder.sourceforge.net/
    ,"Drexel" at "https://www.cs.drexel.edu/~zl25/maven2/repo"
  )

}
