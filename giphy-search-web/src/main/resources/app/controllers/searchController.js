angular.module("giphyApp").controller("searchController",
        function($scope, $sanitize, $location) {
            $scope.query = "";
            $scope.executeSearch = function() {
                $location.url("/search/" + $sanitize($scope.query))
            };
        });