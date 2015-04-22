angular.module("sstasker")

  .controller("dashboardCtrl", ["$scope", "$timeout", function($scope, $timeout) {
    console.log("Dashboard state loaded");

    $scope.viewClass = "dashboard full flex";

    $scope.details = null;
    $scope.show = function(item) {
      if (item)
        $scope.details = item;
      else
        $scope.details = null;
    }

    $scope.update = function() {
      // request update
      if (window.$java) {
        console.log("Requesting an update");
        window.$java.Update();
      }
      else
        console.log("No $java object!");

      // update lists
      $scope.getLists();
      $scope.details = null;

      // show toast
      var toast = document.getElementById("updateToast");
      toast.classList.add("active");
      $timeout(function() {
        toast.classList.remove("active");
      }, 4000);

      // show update log
      $scope.details = {
        title: "Log Aktualizácií"
      };
      if (window.$java) {
        console.log("Requesting the update log");
        $scope.details.description = "";
        JSON.parse(window.$java.GetUpdateLog()).forEach(function(line) {
          $scope.details.description += line + "\n";
        });
      }
      else
        $scope.details.description = "update log\ncoooool";
    };

    $scope.exit = function() {
      if (window.$java) {
        console.log("Requesting an exit");
        window.$java.Exit();
      }
      else
        console.log("No $java object!");
    };

    $scope.getLists = function() {
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

        console.log("No $java object!");
        console.log("Adding some placeholders");
        $scope.tasks = [{
          title: "New task " + Math.floor(Math.random() * 10 + 1),
          description:
            "# Testing... Testing...\n\n" +
            "Using **markdown**!"
        }];
        $scope.crew = [{
          name: "Dzejky",
          description: "Filthy cosmonaut",
          oxygen: Math.random()
        }];
        $scope.parts = [{
          name: "Generator",
          description:
            "Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. Very long description.",
          health: Math.random(),
          reliability: Math.random(),
          works: Math.random() > 0.5
        }];

      }
    };
    $scope.getLists();

  }])
