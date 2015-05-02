/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />

angular.module("newTaskApp")

  .controller("RepairCtrl", function RepairCtrl(
    $scope : ng.IScope,
    $state : ng.ui.IStateService) {
    console.log("Repair state loaded");
  });
