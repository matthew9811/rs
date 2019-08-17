FROM 99taxis/mini-java8
VOLUME /tmp
ADD /target/rs-0.0.4.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 317

