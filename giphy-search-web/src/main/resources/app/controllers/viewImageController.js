angular.module("giphyApp").controller("viewImageController",
        function($scope, $http, $routeParams) {
            $scope.page = {
                title : "Image"
            };
            $scope.image = {};
            console.log($routeParams.imageId);
            $http({
                method : "GET",
                url : "/api/image/" + $routeParams.imageId
            }).then(function success(response) {
                console.log(response);
                $scope.image.title = response.data.data.title;
                $scope.image.src = response.data.data.images.original.url;
            }, function error(response) {
                console.error(response);
            });
        });