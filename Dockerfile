FROM openjdk:11 AS BUILD

COPY . /src
WORKDIR /src
RUN ./gradlew --no-daemon bootJar

FROM openjdk:11

COPY --from=BUILD /src/build/libs/challenge-1.jar /bin/runner/run.jar
WORKDIR /bin/runner
EXPOSE 9090
ENTRYPOINT ["java","-jar","run.jar"]