/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />

interface IJava {
  CreateTask : Function
}

interface IJavaWindow extends Window {
  $java : IJava
}

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

      // create the task
      if ((<IJavaWindow>window).$java) {
        (<IJavaWindow>window).$java.CreateTask(JSON.stringify(taskInfo));
      }
      else {
        console.log("If I had $java, I would create the task, but, well...");
      }

      // go to first state
      $state.go("type");
    };
  });
