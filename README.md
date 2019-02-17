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
```
export GIPHY_API_KEY={insert giphy api key here}
mvn clean install docker:build
cd giphy-search-rest-api
mvn docker:run
```