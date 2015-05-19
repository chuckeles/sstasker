/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />


interface IJava {
  GetParts : Function
}

interface IJavaWindow extends Window {
  $java : IJava
}

interface IPart {
  name : string;
  description : string;

  health : number;
  reliability : number;
  works : boolean;
}

interface IRepairCtrlScope extends ng.IScope {
  parts : Array<IPart>;
  part : string;
  next : Function;
}

class Part implements IPart {
  constructor(
    public name : string,
    public description : string,
    public health : number = 1,
    public reliability : number = 1,
    public works : boolean = true) {}
}

angular.module("newTaskApp")

  .controller("RepairCtrl", function RepairCtrl(
    $scope : IRepairCtrlScope,
    $state : ng.ui.IStateService,
    taskInfo : TaskInfo,
    $rootScope) {
    console.log("Repair state loaded");
    $rootScope.history++;

    $scope.part = null;
    $scope.next = function () {
      if (!$scope.part)
        return;

      taskInfo.part = parseInt($scope.part);
      $state.go("crew");
    };

    $scope.parts = [];
    console.log("Requesting the part list");
    if ((<IJavaWindow>window).$java) {
      $scope.parts = JSON.parse((<IJavaWindow>window).$java.GetParts());
    }
    else {
      console.log("No $java object!");
      console.log("Adding placeholders");

      $scope.parts = [
        new Part(
          "Generator",
          "Makes energy",
          Math.random(),
          Math.random(),
          Math.random() > .5),
        new Part(
          "Generator",
          "Makes tons of energy",
          Math.random(),
          Math.random(),
          Math.random() > .5),
        new Part(
          "Oxygen Generator",
          "Makes oxygen",
          Math.random(),
          Math.random(),
          Math.random() > .5),new Part(
          "Cool Oxygen Generator",
          "Makes poison",
          Math.random(),
          Math.random(),
          Math.random() > .5)
      ];
    }
  });
