angular.module("sstasker", ["ui.router"])

  .controller("mainCtrl", ["$state", function($state) {

    // go to welcome state
    $state.go("welcome");
    
  }]);

//@prepros-append loader.js
//@prepros-append router.js
