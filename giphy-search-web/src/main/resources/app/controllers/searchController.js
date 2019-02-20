angular.module("giphyApp").controller("searchController",
        function($scope, $sanitize, $location) {
            $scope.q = "";
            $scope.executeSearch = function() {
                var query = $sanitize($scope.q)
                console.log("Searching for: " + $scope.q);
                $location.url("/home/search/" + query);
            };
        });