/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />

interface IJava {
  GetCrew : Function
}

interface IJavaWindow extends Window {
  $java : IJava
}

class Cosmonaut {
  constructor(public name : string, public description : string, public type : string = "Engineer", public oxygen : number = 1) {}
}

interface ICrewCtrlScope extends ng.IScope {
  next : Function;
  crew : Array<Cosmonaut>;
  selected : Array<boolean>;
}

angular.module("newTaskApp")

  .controller("CrewCtrl", function CrewCtrl(
    $scope : ICrewCtrlScope,
    $state : ng.ui.IStateService,
    taskInfo : TaskInfo,
    $rootScope) {
    console.log("Crew state loaded");
    $rootScope.history++;

    $scope.next = function() {
      taskInfo.members = [];
      for (var i = 0; i < $scope.selected.length; ++i)
        if ($scope.selected[i])
          taskInfo.members.push(i);

      $state.go("details");
    };

    $scope.crew = [];
    $scope.selected = [];
    console.log("Requesting the crew list");
    if ((<IJavaWindow>window).$java) {
      $scope.crew = JSON.parse((<IJavaWindow>window).$java.GetCrew());
    }
    else {
      console.log("No $java object!");
      console.log("Adding placeholders");

      $scope.crew = [
        new Cosmonaut("Steve", "lol"),
        new Cosmonaut("Chuckeles", "Maestro")
      ];
    }
    for (var i = 0; i < $scope.crew.length; ++i)
      $scope.selected[i] = false;
  });