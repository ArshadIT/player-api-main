Player Matchmaking API
===================================================================
`player-api` is a directory of gamers and their favorite games to auto match for a centralized app of all games.

### Scope
This api does not provide authentication/authorization for endpoints and uses an in-memory database H2 with some preloaded scripts.
The scripts are located in /resources/data.sql and these will run when the application is run.


### Execute Tests
```bash
mvn test
```

### Package into an executable jar
```bash
mvn package -DskipTests
```
### Run project from command line
```bash
java -jar player-api-0.0.1-SNAPSHOT.jar
```


### Running `player-api`
`player-api` is a `Spring Boot` application that runs on port 8080. 
 
Some example [`curl`] commands:

```bash
curl -X GET http://localhost:8080/api/player/1/game/1/playerlevelinfo
```
```bash
curl -X GET http://localhost:8080/api/search/game/2/playerwithmaxcredits
```
```bash
curl -X GET http://localhost:8080/api/player/2/games
```
```bash
curl -X PUT http://localhost:8080/api/player/1/game/1/assigncredits?creditAmount=12
```



