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
  constructor(public name : string, public description : string, public oxygen : number = 1) {}
}

interface ICrewCtrlScope extends ng.IScope {
  next : Function;
  crew : Array<Cosmonaut>;
  member : string;
}

angular.module("newTaskApp")

  .controller("CrewCtrl", function CrewCtrl(
    $scope : ICrewCtrlScope,
    $state : ng.ui.IStateService,
    taskInfo : TaskInfo) {
    console.log("Crew state loaded");

    $scope.member = null;
    $scope.next = function() {
      if (!$scope.member)
        return;

      taskInfo.member = parseInt($scope.member);
      $state.go("details");
    };

    $scope.crew = [];
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
  });