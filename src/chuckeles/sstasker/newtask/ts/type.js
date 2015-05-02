/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
angular.module("newTaskApp").controller("TypeCtrl", function TypeCtrl($scope, $state) {
    console.log("Type state loaded");
    $scope.next = function () {
        if (!$scope.type)
            return;
        console.log("Selected task type: " + $scope.type);
        $state.go($scope.type);
    };
});
//# sourceMappingURL=type.js.map