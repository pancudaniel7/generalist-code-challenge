# Generalist Code Challenge

As part of Pragma's code challenge I've created this application using the following tools and frameworks:
 - IntelliJ
 - Spring + Java 8
 - Docker
 - Postman for testing the APIs

### How to run the application:
1. Execute `gradlew clean build` - to obtain the WAR file
2. Open Terminal and in project's directory run `docker-compose up`

### Description

This product consist of an application which operates with two entities: `Game` and `Studio`.
Between these two entities we have a `OneToMany` relationship, where a Studio can have multiple Games. 
As a result, there are several CRUD operations we can perform:
 - Creating a game - when this is called(via Postman, for example), the rating of the game is generated
by a utility class. This endpoint also has an integration test. 
   - Endpoint: `http://localhost:8080/generalist-code-challenge/api/game/create` - with a json body
 - Deleting a game: 
   - `http://localhost:8080/generalist-code-challenge/api/game/delete/2` - where `2` is the `ID` of the game
 - We can see all games, but also be able to filter matches by the studio
   - `http://localhost:8080/generalist-code-challenge/api/game/view` - view games
   - `http://localhost:8080/generalist-code-challenge/api/game/view/4` - where `4` is the `ID` of the studio to be matched for
 - Delete a studio and it's associated games
   - `http://localhost:8080/generalist-code-challenge/api/studio/delete/4` - where `4` is the `ID` of the studio to be deleted
 - While the microservice operates, it automatically selects a random game entity and update the rating column with a decimal value between 1 and 5.
    The microservice it is programmed to trigger these updates every 5 seconds without manual intervention.

As a production ready(wannabe) application the product has:
 - a certain level of security(only authentication, Cross-Origin Resource Sharing and Cross-Site Request Forgery were disabled for simplicity)
 - logs used org.slf4j.Logger for that
 - metrics - prometheus, available here: `http://localhost:8080/generalist-code-challenge/actuator/prometheus`

###Other notes:
The most challenging(or time-consuming) part was adding the microservice to Docker.