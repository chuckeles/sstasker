/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />

angular.module("newTaskApp")

  .config(function StateConfig($stateProvider : ng.ui.IStateProvider) {

    $stateProvider

      .state("type", {
        templateUrl: "html/type.html",
        controller: "TypeCtrl"
      })

      .state("repair", {
        templateUrl: "html/repair.html",
        controller: "RepairCtrl"
      });

  })

  .run(function GoToTypeState($state : ng.ui.IStateService) {
    $state.go("type");
  });
