angular.module("sstasker", ["ui.router"])

  .controller("mainCtrl", ["$state", function($state) {
    // go to welcome state
    $state.go("welcome");
  }]);

//@prepros-append constants.js

//@prepros-append loader.js
//@prepros-append welcome.js

//@prepros-append router.js
