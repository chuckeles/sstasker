/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />

interface IDetailsCtrlScope extends ng.IScope {
  title : string;
  description : string;
  next : Function;
}

angular.module("newTaskApp")

  .controller("DetailsCtrl", function DetailsCtrl(
    $scope : IDetailsCtrlScope,
    $state : ng.ui.IStateService,
    taskInfo : TaskInfo) {
    console.log("Details state loaded");

    $scope.title = "";
    $scope.description = "";
    $scope.next = function() {
      if (!$scope.title || !$scope.description)
        return;

      taskInfo.title = $scope.title;
      taskInfo.description = $scope.description;

      console.log(taskInfo);
    };
  });
