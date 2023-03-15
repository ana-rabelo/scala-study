name := "lab02"

version := "0.1"

scalaVersion := "3.2.2"

scalacOptions ++= Seq("-source:future", "-indent", "-rewrite")

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.15"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"

wartremoverErrors ++= Warts.allBut(Wart.Any, Wart.Equals, Wart.Nothing,
  Wart.Overloading, Wart.Recursion, Wart.StringPlusAny,
  Wart.ToString, Wart.TripleQuestionMark)