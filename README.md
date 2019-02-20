# giphy-search-app
Demo fronted app to search for gifs with the Giphy API

[![Build Status](https://api.travis-ci.com/slfotg/giphy-search-app.svg?branch=master)](https://travis-ci.com/slfotg/giphy-search-app)
[![Alert Status](https://sonarcloud.io/api/project_badges/measure?project=com.github.slfotg%3Agiphy-search-app&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.github.slfotg%3Agiphy-search-app)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=com.github.slfotg%3Agiphy-search-app&metric=bugs)](https://sonarcloud.io/dashboard?id=com.github.slfotg%3Agiphy-search-app)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.github.slfotg%3Agiphy-search-app&metric=coverage)](https://sonarcloud.io/dashboard?id=com.github.slfotg%3Agiphy-search-app)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=com.github.slfotg%3Agiphy-search-app&metric=sqale_index)](https://sonarcloud.io/dashboard?id=com.github.slfotg%3Agiphy-search-app)

## Requirements
- Java JDK 1.8+
- Maven 3.3+
- Docker CE 18+
- [Giphy Api Key](https://developers.giphy.com/dashboard/?create=true)

## Quickstart
*Note:* You will need your own private developer key from [Giphy](https://developers.giphy.com/dashboard/?create=true) and will need to be set as an environment variable called GIPHY_API_KEY
```
export GIPHY_API_KEY={insert giphy api key here}
mvn clean install 
mvn docker:build 
mvn docker:run
```

Open a browser and navigate to [http://localhost:18080](http://localhost:18080)

## Developer Setup
This setup keeps a database alive all the time and allows access to the app at various ports
- MySQL at port 3306 with giphy_user:giphyPassword
- Web app at port 8080
- REST api at port 8081

First build the project
```
export GIPHY_API_KEY={insert giphy api key here}
mvn clean install 
mvn docker:build
```

Next start the MySQL database (Docker instructions below)

Manual database scripts can be found in giphy-search-db/scripts
```
docker run -d -p 3306:3306 --name=giphy-db --restart=always slfotg/giphy-search-db:0.0.1-SNAPSHOT
```

Start the rest-api project with the local profile

Command line: (GIPHY_API_KEY environment variable must be set)
```
java -jar -Dspring.profiles.active=local giphy-search-rest-api/target/giphy-search-rest-api-0.0.1-SNAPSHOT.jar
```

or you can start it from your favorite IDE with the local profile selected and making sure GIPHY_API_KEY environment variable is set in the IDE run configuration

Then start the web project
```
java -jar -Dspring.profiles.active=local giphy-search-web/target/giphy-search-web-0.0.1-SNAPSHOT.jar
```
