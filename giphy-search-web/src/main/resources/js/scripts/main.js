var app = angular.module("giphyApp", []);

// globals for spring security
var token = $("meta[name='_csrf']")[0].content

app.controller("trendingController", function($scope, $http) {
    $scope.trendingRequest = {
        limit : 25,
        offset : 0
    };
    $scope.executeTrendingSearch = function() {

        var trendingRequest = angular.copy($scope.trendingRequest);
        // Add to offset for loading more images
        $scope.trendingRequest.offset += $scope.trendingRequest.limit;
        $http({
            method : "POST",
            url : "/api/trending",
            headers : {
                "X-CSRF-TOKEN" : token
            },
            data : trendingRequest
        }).then(function success(response) {
            console.log(response);
            $scope.data = response.data.data;
        }, function error(response) {
            $scope.welcome = "Error";
        })
    };

    $scope.executeTrendingSearch();
});

app.controller("searchController", function($scope, $http) {
    $scope.searchRequest = {
        limit : 25,
        offset : 0,
        query : ""
    };
    $scope.executeSearch = function() {

        console.log($scope.searchText);
        var searchRequest = angular.copy($scope.searchRequest);

        // Reset the search field
        $scope.searchRequest.query = "";

        // Add to offset for loading more images
        $scope.searchRequest.offset += $scope.searchRequest.limit;
        $http({
            method : "POST",
            url : "/api/search",
            headers : {
                "X-CSRF-TOKEN" : token
            },
            data : searchRequest
        }).then(function success(response) {
            console.log(response);
            $scope.data = response.data.data;
        }, function error(response) {
            console.error(response);
        })
    };
});