FROM openjdk:11-jdk as build
WORKDIR /workspace/app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN chmod +x mvnw
RUN ./mvnw install -DskipTests


FROM openjdk:11-jdk
RUN adduser --system --group spring
USER spring:spring
COPY --from=build /workspace/app/target/Worker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]