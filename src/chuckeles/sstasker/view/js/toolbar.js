angular.module("sstasker")

  .controller("toolbarCtrl", ["$scope", function($scope) {
  }])

  .directive("toolbar", function() {
    return {

      templateUrl: "html/toolbar.html",
      restrict: "E",
      controller: "toolbarCtrl"

    }
  });
