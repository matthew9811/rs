FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD /target/rs-0.0.3-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]