@ECHO OFF
start java -jar -DCLIENT_ID=1 -Xmx192m ../target/simple-client-1.0-SNAPSHOT.jar
start java -jar -DCLIENT_ID=2 -Xmx192m ../target/simple-client-1.0-SNAPSHOT.jar
start java -jar -DCLIENT_ID=3 -Xmx192m ../target/simple-client-1.0-SNAPSHOT.jar