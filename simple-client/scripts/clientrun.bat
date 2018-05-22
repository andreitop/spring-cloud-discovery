@ECHO OFF
start java -jar -DCLIENT_ID=1 -Dcryptostore.path=C:/Work/EPAM/!cloud/spring-cloud-discovery/crypto/valid/client.p12 -Xmx192m ../target/simple-client-1.0-SNAPSHOT.jar
start java -jar -DCLIENT_ID=2 -Dcryptostore.path=C:/Work/EPAM/!cloud/spring-cloud-discovery/crypto/valid/client.p12 -Xmx192m ../target/simple-client-1.0-SNAPSHOT.jar
start java -jar -DCLIENT_ID=3 -Dcryptostore.path=C:/Work/EPAM/!cloud/spring-cloud-discovery/crypto/valid/client.p12 -Xmx192m ../target/simple-client-1.0-SNAPSHOT.jar