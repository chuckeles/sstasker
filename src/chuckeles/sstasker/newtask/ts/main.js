/// <reference path="def/angular.d.ts" />
angular.module("newTaskApp", [
    "ngAnimate",
    "ui.router"
]).controller("mainCtrl", function mainCtrl($scope) {
    $scope.back = function () {
        history.go(-1);
    };
});
//# sourceMappingURL=main.js.map