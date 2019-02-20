var app = angular.module("giphyApp", [ "ngSanitize", "ngRoute" ]);
app.config(function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);
    $routeProvider.when("/", {
        templateUrl : "app/views/trending.html",
        controller : "trendingController"
    }).when("/search/:query", {
        templateUrl : "app/views/search.html",
        controller : "searchResultsController"
    }).when("/viewImage/:imageId", {
        templateUrl : "app/views/viewImage.html",
        controller : "viewImageController"
    }).otherwise({
        redirectTo : "/"
    });
});