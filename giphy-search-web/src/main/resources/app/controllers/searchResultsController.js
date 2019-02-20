angular.module("giphyApp").controller("searchResultsController",
        function($scope, $http, $routeParams) {
            console.log($routeParams.query);

            $scope.page = {
                title : "Search Results: " + $routeParams.query
            };
            $scope.searchRequest = {
                query : $routeParams.query,
                limit : 25,
                offset : 0
            };

            $scope.getSearchResults = function() {
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
                });
            };

            $scope.getSearchResults();
        });