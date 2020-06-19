FROM openjdk:8
ADD user-api/target/user-api-0.0.1-SNAPSHOT.jar myapp.jar
CMD ["java", "-jar", "myapp.jar"]