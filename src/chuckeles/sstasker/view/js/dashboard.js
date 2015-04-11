angular.module("sstasker")

  .controller("dashboardCtrl", ["$scope", function($scope) {
    console.log("Dashboard state loaded");

    $scope.viewClass = "dashboard full flex";

    console.log("Requesting the spaceship lists");
    if (window.$java) {
      // $scope.taskList = window.$java.GetTaskList();
      // $scope.crewList = window.$java.GetCrewList();
      $scope.partList = window.$java.GetPartList();
      console.log("Parts: " + $scope.partList);
    }
    else {
      $scope.taskList = [];
      $scope.crewList = [];
      $scope.partList = [];
      console.log("No $java object!");
    }

  }])
