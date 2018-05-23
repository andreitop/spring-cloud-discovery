@ECHO OFF
start java -jar -Dspring.profiles.active=peer1 -Xmx192m ../simple-server/target/simple-server-1.0-SNAPSHOT.jar
start java -jar -Dspring.profiles.active=peer2 -Xmx192m ../simple-server/target/simple-server-1.0-SNAPSHOT.jar
start java -jar -Dspring.profiles.active=peer3 -Xmx192m ../simple-server/target/simple-server-1.0-SNAPSHOT.jar