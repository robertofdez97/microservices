FROM openjdk:12
VOLUME CMD[/tmp]
EXPOSE 8888
ADD ./target/configServer-0.0.1-SNAPSHOT.jar config-server.jar
ENTRYPOINT ["java", "-jar", "/config-server.jar"]