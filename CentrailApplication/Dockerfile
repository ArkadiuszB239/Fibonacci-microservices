FROM maven:3.6.3 AS maven

WORKDIR /usr/src/app
COPY . .

RUN mvn package -DskipTests

FROM openjdk:11-jdk
RUN adduser --system --group spring
USER spring:spring

WORKDIR /app
COPY --from=maven /usr/src/app/target/CentalApplication-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java","-jar","/app/CentalApplication-0.0.1-SNAPSHOT.jar"]