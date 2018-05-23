@ECHO OFF
start java -jar -Dspring.profiles.active=zone1 -Xmx192m ../simple-client/target/simple-client-1.0-SNAPSHOT.jar
start java -jar -Dspring.profiles.active=zone2 -Xmx192m ../simple-client/target/simple-client-1.0-SNAPSHOT.jar
start java -jar -Dspring.profiles.active=zone3 -Xmx192m ../simple-client/target/simple-client-1.0-SNAPSHOT.jar