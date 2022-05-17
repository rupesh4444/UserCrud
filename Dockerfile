#base image containing java runtime
FROM openjdk:11-slim as build

#Information about who maintains the image
MAINTAINER Rupesh Kumar

#Adding the application jar to the container
COPY target/crud-0.0.1-SNAPSHOT.jar crud-0.0.1-SNAPSHOT.jar

#Executing the application
ENTRYPOINT ["java","-jar","/crud-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
