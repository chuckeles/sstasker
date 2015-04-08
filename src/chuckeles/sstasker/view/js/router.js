angular.module("sstasker")

  .config(["$stateProvider", function($stateProvider) {

    $stateProvider

      .state("welcome", {

        templateUrl: "html/welcome.html"

      });

  }]);
