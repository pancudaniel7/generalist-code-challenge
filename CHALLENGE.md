# Code Challenge

## Prerequisites

- Docker installed
- Have a github account

## Challenge Description

For this challenge you will need to be able to implement a microservice that connects to a MySQL instance and exposes a RESTful API.
In the reposiotry you will find a docker compose file that contains a MySQL service, after starting the database you will notice two tables STUDIO and GAMES, this tables will have a predefined set of data. <br>
Try to implement the following service functionalities:

- At the bootstrap of microservice create 3 more Studios entities and 6 games, the new games should respect many to one relation with the studios where one game should have just one studio but one studio can have multiple games.
- During the run of the microservice the application should choose randomly a game entity and update the rating column with a value between 1 and 5 seconds, this updates should be created to be triggered automaticlly at any 5 seconds by the microservice.
- Implement CRUD REST endpoints for game entity.
- The create game endpoint should be able to create the game but with a random float value between 1 and 5.
- Implement an endpoint where we can receive all games but also be able to filter games by studio.
- Implement studio delete enpoint, the games of that studio should also be deleted.

## Constrains
- The project could be written in Kotlin or other similar languages.
- Respect a layer directory structure (not a feature or type one) where you will following packages directories: controller, service, component, model and utils.
- Implement integration tests just for the CRUD game endpoints, the rest of the endpoints will be manual tested using Postman.
- The microservice should be added to the Docker network where the MySQL is running.

## Best Score

For the best challenge score we will take a look at:
- Complete microservice implementation
- Language code standards
- Clean code
- Solid priciples
- Basic design patterns
- Reusable code
- Test coverage
- Usage of a framework or libraries
- RESTful services
- Documentation
