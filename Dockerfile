FROM maven:3.9.3-sapmachine-11 AS build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN mvn  dependency:resolve

COPY src src
RUN mvn install -D skipTests
RUN mkdir -p target/dependency && cd target/dependency && jar -xf ../*.jar

FROM eclipse-temurin:11-jdk-alpine
VOLUME /tmp

ARG DEPENDENCY=/workspace/app/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

EXPOSE 8080

CMD ["sh", "-c", "exec java -cp app:app/lib/* ru.doctorixx.vacationpaycalculator.DemoApplication"]