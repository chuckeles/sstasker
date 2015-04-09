angular.module("sstasker")

  .controller("toolbarCtrl", ["$scope", function($scope) {
    $scope.exit = function() {
      if (window.java) {
        console.log("Requesting an exit");
        window.java.exit();
      } else
        console.log("No java object...");
    }
  }])

  .directive("toolbar", function() {
    return {

      templateUrl: "html/toolbar.html",
      restrict: "E",
      controller: "toolbarCtrl"

    }
  });
