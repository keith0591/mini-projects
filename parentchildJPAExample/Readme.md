How to run:

This is maven project. Go to the directory containing the pom.xml for this project. It should be the same directory which contains this file.

Run mvn sping-boot:run

It will start up the server at 8080 which can be changed in the application.properties file.
It will automatically set up the H2 database instance and initialize it with the load script data.sql in the resources folder.
The management ui for the h2 instance is at http://localhost:8080/h2-console/.
Note: use jdbc url as : jdbc:h2:mem:testdb

Hit the endpoints in the controller to get the results.
