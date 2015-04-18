angular.module("sstasker")

  .controller("dashboardCtrl", ["$scope", function($scope) {
    console.log("Dashboard state loaded");

    $scope.viewClass = "dashboard full flex";

    $scope.details = null;
    $scope.show = function(item) {
      if (item)
        $scope.details = item;
      else
        $scope.details = null;
    }

    console.log("Requesting the spaceship lists");
    if (window.$java) {

      // request data from the app
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

      console.log("Add some placeholders");
      $scope.tasks = [{
        title: "New task",
        description:
          "# Testing... Testing...\n\n" +
          "Using **markdown**!"
      }];
      $scope.crew = [{
        name: "Dzejky",
        description: "Filthy cosmonaut"
      }];
      $scope.parts = [{
        name: "Generator",
        description:
          "Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description.",
        health: 100,
        reliability: 96,
        works: false
      }];
      console.log("No $java object!");

    }

  }])
