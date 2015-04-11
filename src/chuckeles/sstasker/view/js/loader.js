angular.module("sstasker")

  .directive("loader", function() {
    return {

      templateUrl: "html/loader.html",
      restrict: "E"

    }
  });
