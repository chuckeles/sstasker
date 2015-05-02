/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />

interface ITypeCtrlScope extends ng.IScope {
  type: string;
  next : Function;
}

angular.module("newTaskApp")

  .controller("TypeCtrl", function TypeCtrl(
    $scope : ITypeCtrlScope,
    $state : ng.ui.IStateService) {
    console.log("Type state loaded");

    $scope.next = function() {
      if (!$scope.type)
        return;

      console.log("Selected task type: " + $scope.type);
      $state.go($scope.type);
    };
  });
