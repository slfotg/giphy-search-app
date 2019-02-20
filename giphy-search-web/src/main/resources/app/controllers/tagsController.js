angular.module("giphyApp").controller("tagsController",
        function($scope, giphyApi) {
            $scope.tags = giphyApi.tags;
            $scope.addTag = function() {
                giphyApi.addTag("newTag");
            }
        });