FROM openjdk:11

WORKDIR /PetStoreAMG-v1.0.11

COPY ./target/swagger-spring-1.0.0.jar /PetStoreAMG-v1.0.11/swagger-spring-1.0.0.jar
COPY ./PetStoreAMG-v1.0.11.yml /PetStoreAMG-v1.0.11/PetStoreAMG-v1.0.11.yml

EXPOSE 8080

CMD ["java", "-jar", "/PetStoreAMG-v1.0.11/swagger-spring-1.0.0.jar"]