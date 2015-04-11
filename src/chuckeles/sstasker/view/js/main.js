//@prepros-prepend angular.js
//@prepros-prepend angular-animate.js
//@prepros-prepend angular-ui-router.js

angular.module("sstasker", ["ngAnimate", "ui.router"])

  .controller("mainCtrl", ["$state", function($state) {
    console.log("AngularJS loaded, going to the welcome state");

    // go to welcome state
    $state.go("welcome"); // TODO: Change back to welcome
  }]);

//@prepros-append constants.js

//@prepros-append loader.js
//@prepros-append toolbar.js

//@prepros-append welcome.js
//@prepros-append dashboard.js

//@prepros-append router.js
