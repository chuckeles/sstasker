/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />

interface ITypeCtrlScope extends ng.IScope {
  type: String;
  next : Function;
}

angular.module("newTaskApp")

  .controller("TypeCtrl", function TypeCtrl($scope : ITypeCtrlScope) {
    console.log("Type state loaded");

    $scope.next = function() {
      console.log("Selected: " + $scope.type);
    };
  });
