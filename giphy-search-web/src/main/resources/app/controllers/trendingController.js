angular.module("giphyApp").controller("trendingController",
        function($scope, $http) {
            $scope.page = {
                title : "Trending Gifs"
            };
            $scope.trendingRequest = {
                limit : 25,
                offset : 0
            };
            $scope.executeTrendingSearch = function() {

                var trendingRequest = angular.copy($scope.trendingRequest);
                // Add to offset for loading more images
                $scope.trendingRequest.offset += $scope.trendingRequest.limit;
                $http({
                    method : "GET",
                    url : "/v1/gifs/trending",
                    params : trendingRequest
                }).then(function success(response) {
                    console.log(response);
                    $scope.data = response.data.data;
                }, function error(response) {
                    $scope.welcome = "Error";
                })
            };

            $scope.executeTrendingSearch();
        });