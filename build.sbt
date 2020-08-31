import Dependencies._
lazy val sample = project
  .settings(libraryDependencies ++= Ext.netty.all)
