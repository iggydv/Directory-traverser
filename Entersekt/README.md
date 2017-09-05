# README #

### Entersekt Technical Assessment ###

#### Task: ####

Write a small cross platform application in Java 8 that exposes a RESTful interface on port 8080 and allows a client application to do only one thing: 
obtain the full directory listing of a given directory path on the local filesystem, including all the important File attributes.
Version 1.0

### Requirements ###

For building and running the application you need:

* JDK 1.8
* Maven 3
* Docker version 17.06.1-ce

### Running the application locally ###

There are various ways to run this application.

You can use the Spring Boot Maven plugin like so:
	
	mvn install
	mvn spring-boot:run
	
if you wish to create a .jar file run

	mvn package && java -jar target/gs-spring-boot-docker-0.1.0.jar

### Running Unit tests ###

To run the Junit test, simply run:

	mvn test

### Deploying the application to Docker ###

To build the docker image run

	mvn install dockerfile:build

The repository with the image name will be created

	ignatius/gs-spring-boot-docker
	
And continue to push the file to Dockerhub

	mvn dockerfile:push
	
Then Finally to run the freshly minted Docker image with Spring profiles run this command

	docker run -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 -t ingatius/gs-spring-boot-docker


### Future Work ###

There are many improvements that can be made to this application.

* Cross platform bug fixes

Although this program will run on any platform, the default value of path is currently "." - this works for a windows machine, but
might cause issues on unix platforms. Exception testing and validation testing should aslo be added to properly cater for non-windows
machines.

* Improved Unit Tests

More unit tests can be added to ensure that the application does not break when updating and integrating project. Unit test for cross platform functionality should also be added (testing valid paths for any platform)

* Naming Convention and Application Structure

Naming of Directories/classes/methods/variables and project structure should be re-evaluated and reviewed to ensure that proper Java coding standards are used.
