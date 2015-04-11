angular.module("sstasker")

  .controller("welcomeCtrl", ["$state", "$timeout", "welcomeWaitTime", function($state, $timeout, welcomeWaitTime) {
    console.log("Welcome state loaded");

    $timeout(function() {
      console.log("Going to the dashboard state");
      $state.go("dashboard");
    }, welcomeWaitTime * 1000);
  }]);
