var app = angular.module("giphyApp", [ "ngSanitize", "ngRoute" ]);
app.config(function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);
    $routeProvider.when("/home", {
        templateUrl : "app/views/searchResults.html",
        controller : "trendingController"
    }).when("/home/search/:query", {
        templateUrl : "app/views/searchResults.html",
        controller : "searchResultsController"
    }).when("/home/viewImage/:imageId", {
        templateUrl : "app/views/viewImage.html",
        controller : "viewImageController"
    }).otherwise({
        redirectTo : "/home"
    });
});