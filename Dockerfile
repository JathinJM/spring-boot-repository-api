FROM openjdk
ADD target/springbootrestapi.jar springbootrestapi.jar
EXPOSE 7010:7010
ENTRYPOINT ["java", "-jar", "/springbootrestapi.jar"]