angular.module("giphyApp").factory("giphyApi", [ "$http", function($http) {
    var tags = [];

    (function() {
        $http({
            method : "GET",
            url : "/api/tags/" + username,
        }).then(function success(response) {
            console.log(response);
            response.data.forEach(function(tag) {
                tags.push(tag);
            });
        }, function error(response) {
            console.error(response);
            tags = [];
        });
    }());

    return {
        tags : tags,
        addTag : function(tagName) {
            $http({
                method : "POST",
                url : "/api/tags/" + username,
                headers : {
                    "X-CSRF-TOKEN" : token
                },
                data : tagName
            }).then(function success(response) {
                console.log(response);
                tags = response.data;
            }, function error(response) {
                console.error(response);
                tags = [];
            });
        }
    };
} ]);