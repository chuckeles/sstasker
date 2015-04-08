angular.module("sstasker")

  .controller("welcomeCtrl", ["$state", "$timeout", "welcomeWaitTime", function($state, $timeout, welcomeWaitTime) {
    $timeout(function() {
      $state.go("dashboard");
    }, welcomeWaitTime * 1000);
  }]);
