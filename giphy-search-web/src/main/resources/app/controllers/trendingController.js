angular.module("giphyApp").controller("trendingController",
        function($scope, $http) {
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