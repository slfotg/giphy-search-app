angular.module("giphyApp").controller("searchResultsController",
        function($scope, $http, $routeParams) {
            console.log($routeParams.query);

            $scope.page = {
                title : "Search Results: " + $routeParams.query
            };
            $scope.searchRequest = {
                q : $routeParams.query,
                limit : 25,
                offset : 0,
                rating: "g"
            };

            $scope.getSearchResults = function() {
                var searchRequest = angular.copy($scope.searchRequest);

                // Reset the search field
                $scope.searchRequest.query = "";

                // Add to offset for loading more images
                $scope.searchRequest.offset += $scope.searchRequest.limit;
                $http({
                    method : "GET",
                    url : "/v1/gifs/search",
                    params : searchRequest
                }).then(function success(response) {
                    console.log(response);
                    $scope.data = response.data.data;
                }, function error(response) {
                    console.error(response);
                });
            };

            $scope.getSearchResults();
        });