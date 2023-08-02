# Read Me First

This application will allow various REST operations on a simple database, managing a list of games and the studios that produced them.

* games have name, description, a link to the studio and a rating
* studios have name and city

The docker-compose.yml file should do all the magic, and start both the DB and the service.
To run the application without Docker, as a standalone service, just comment the Docker dependency in the build.gradle.kts file.

In application.properties we have all the database connection credentials, so we can connect to any already running MySQL database.

# REST operations
The application is installed on localhost, port 9090

### Games

* GET /games - list of all games
* POST /games - adds new game (from JSON payload)
* GET /games/{id} - get the game with a certain ID
* PUT /games/{id} - replace the game with a certain ID or create a new one, if it that game is not found
* DELETE /games/{id} - delete the game with a certain ID
* GET /games?studioName={studioName} - retrieve a list of all games produced by studio with a certain NAME, or list of all games, if that's not found

### Studios

* GET /studios - list of all studios
* POST /studios - adds new studio (from JSON payload)
* GET /studios/{id} - get the studio with a certain ID
* PUT /studios/{id} - replace the studio with a certain ID or create a new one, if it that studio is not found
* DELETE /studios/{id} - delete the game with a certain ID

# Parallel ratings
Another thread is active while the application is running, that changes the rating of a random game on a 5 second timer.

