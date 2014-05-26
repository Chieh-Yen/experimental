all:
	sbt/sbt package
sbt.jar:
	wget http://repo.typesafe.com/typesafe/ivy-releases/org.scala-sbt/sbt-launch/0.13.2/sbt-launch.jar -O sbt/sbt-launch.jar
