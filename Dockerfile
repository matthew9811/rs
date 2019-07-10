FROM java:8
VOLUME /tmp
ADD scm.jar app.jar
EXPOSE 317
ENTRYPOINT [ "java", "-jar", "/app.jar" ]