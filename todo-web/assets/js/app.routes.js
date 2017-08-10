
(function() {
    angular.module("todoApp")
    .config(["$routeProvider", initRoutes]);

    function initRoutes($routeProvider) {
      $routeProvider
        .when('/', {
          templateUrl: 'views/list.html',
        })
        .when('/list', {
          templateUrl: 'views/list.html',
        })
        .when('/new', {
          templateUrl: 'views/new.html',
        })
        .when('/edit/:id', {
          templateUrl: 'views/new.html',
        })
        .otherwise({
          redirectTo: '/'
        });   
    }
})();