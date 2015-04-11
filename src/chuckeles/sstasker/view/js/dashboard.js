angular.module("sstasker")

  .controller("dashboardCtrl", ["$scope", function($scope) {
    console.log("Dashboard state loaded");

    $scope.viewClass = "dashboard full flex";

    console.log("Requesting the spaceship lists");
    if (window.$java) {
      $scope.tasks = JSON.parse(window.$java.GetTasks());
      $scope.crew = JSON.parse(window.$java.GetCrew());
      $scope.parts = JSON.parse(window.$java.GetParts());
      console.log("Got them, sizes: " +
        $scope.tasks.length + ", " +
        $scope.crew.length + ", " +
        $scope.parts.length
      );
    }
    else {
      $scope.tasks = [{
        title: "New task",
        description: "Testing... Testing..."
      }];
      $scope.crew = [{
        name: "Dzejky"
      }];
      $scope.parts = [{
        name: "Generator",
        health: 100,
        reliability: 96,
        works: false
      }];
      console.log("No $java object!");
    }

  }])
