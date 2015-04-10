angular.module("sstasker", ["ngAnimate", "ui.router"])

  .controller("mainCtrl", ["$state", function($state) {
    console.log("AngularJS loaded, going to the welcome state");

    // go to welcome state
    $state.go("dashboard"); // TODO: Change back to welcome
  }]);

//@prepros-append constants.js

//@prepros-append loader.js
//@prepros-append toolbar.js

//@prepros-append welcome.js
//@prepros-append dashboard.js

//@prepros-append router.js
