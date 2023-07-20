FROM openjdk:8 AS BUILD

COPY . /src
WORKDIR /src
RUN ./gradlew --no-daemon bootJar

FROM openjdk:8

COPY --from=BUILD /src/build/libs/challenge-1.jar /bin/runner/run.jar
WORKDIR /bin/runner
EXPOSE 9090
CMD ["java","-jar","run.jar"]