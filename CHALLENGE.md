# Code Challenge

## Prerequisites

- Docker installed
- Have a GitHub account

## Challenge Description

For this challenge, you will need to be able to implement a microservice that connects to a MySQL instance and exposes a RESTful API.
In the repository you will find a docker-compose file that contains a MySQL service, after starting the database you will notice two tables, STUDIO and GAME, these tables will have a predefined set of data. <br>
Try to implement the following service functionalities:

- (Required) Implement create and delete endpoints for the game entity. The create game endpoint should insert the game in the database but with a random decimal value between 1 and 5.
- (Required) Write integration tests for creating the endpoint.
- (Required) Add microservice to the docker network where MySQL is running.
- (Optional) Implement an endpoint where we can receive all games and filter games by the studio.
- (Optional) Implement studio delete endpoint (the games of that studio should also be deleted).
- (Optional) While the microservice is operating, it should automatically select a random game entity and update the rating column with a decimal value between 1 to 5. The microservice should be programmed to trigger these updates every 5 seconds without manual intervention.

## Constrains

- The project could be written in Kotlin or other similar languages.
- Respect layer directory structure (not a feature or type one) where you will use the following package directories: controller, repository, service, component, model, and utils.
- Fork the repository and invite daniel@pragma.gg to review the implementation.

## Higher Score

For a higher score, we will look at:
- Complete microservice implementation
- Write isolated integration tests
- Language code standards
- Clean code
- SOLID principles
- Basic design patterns
- Code reusability
- Testing best practices
- Usage of a framework or libraries
- RESTful services
- Git best practices
- Documentation (README.md and utils functions)

## Notes

- We are not brain-hunting people, instead, we are looking for passionate people that can integrate with our teams, if you have any questions please get in touch with us at daniel@pragma.gg
