/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
angular.module("newTaskApp").controller("TypeCtrl", function TypeCtrl($scope) {
    console.log("Type state loaded");
    $scope.next = function () {
        console.log("Selected: " + $scope.type);
    };
});
//# sourceMappingURL=type.js.map