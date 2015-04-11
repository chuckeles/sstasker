angular.module("sstasker")

  .controller("dashboardCtrl", ["$scope", function($scope) {
    console.log("Dashboard state loaded");

    $scope.viewClass = "dashboard full flex";

    console.log("Requesting the spaceship lists");
    if (window.$java) {
      $scope.taskList = JSON.parse(window.$java.GetTasks());
      $scope.crewList = JSON.parse(window.$java.GetCrew());
      $scope.partList = JSON.parse(window.$java.GetParts());
      console.log("Got them, sizes: " +
        $scope.taskList.length + ", " +
        $scope.crewList.length + ", " +
        $scope.partList.length
      );
    }
    else {
      $scope.taskList = [];
      $scope.crewList = [];
      $scope.partList = [];
      console.log("No $java object!");
    }

  }])
