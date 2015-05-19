/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />
angular.module("newTaskApp").controller("DetailsCtrl", function DetailsCtrl($scope, $state, taskInfo, $rootScope) {
    console.log("Details state loaded");
    $rootScope.history++;
    $scope.title = "";
    $scope.description = "";
    $scope.next = function () {
        if (!$scope.title || !$scope.description)
            return;
        taskInfo.title = $scope.title;
        taskInfo.description = $scope.description;
        // create the task
        if (window.$java) {
            window.$java.CreateTask(JSON.stringify(taskInfo));
        }
        else {
            console.log("If I had $java, I would create the task, but, well...");
        }
        // go to first state
        $state.go("type");
    };
});
//# sourceMappingURL=details.js.map