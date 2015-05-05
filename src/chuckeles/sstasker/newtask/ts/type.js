/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />
angular.module("newTaskApp").controller("TypeCtrl", function TypeCtrl($scope, $state, taskInfo) {
    console.log("Type state loaded");
    $scope.next = function () {
        if (!$scope.type)
            return;
        console.log("Selected task type: " + $scope.type);
        taskInfo.type = $scope.type;
        $state.go($scope.type);
    };
});
//# sourceMappingURL=type.js.map