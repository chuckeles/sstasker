/// <reference path="def/angular.d.ts" />

angular.module(
  "newTaskApp",
  [
    "ngAnimate",
    "ui.router"
  ])

  .controller("mainCtrl", function mainCtrl($scope, $rootScope) {
    $rootScope.history = 0;
    $scope.back = function() {
      if ($rootScope.history > 0) {
        history.go(-1);
        $rootScope.history--;
      }
    };
  });
