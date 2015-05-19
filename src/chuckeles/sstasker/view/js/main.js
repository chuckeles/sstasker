//@prepros-prepend angular.js
//@prepros-prepend angular-animate.js
//@prepros-prepend angular-ui-router.js
//@prepros-prepend marked.js
//@prepros-prepend angular-marked.js

angular

  .module("sstasker", [
    "ngAnimate",
    "ui.router",
    "hc.marked"
  ])

  .controller("mainCtrl", ["$state", function($state) {
    console.log("AngularJS loaded, going to the welcome state");

    // go to welcome state
    $state.go("welcome");
  }]);

//@prepros-append constants.js

//@prepros-append loader.js
//@prepros-append toolbar.js

//@prepros-append welcome.js
//@prepros-append dashboard.js

//@prepros-append router.js
