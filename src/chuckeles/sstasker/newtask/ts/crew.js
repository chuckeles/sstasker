/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />
var Cosmonaut = (function () {
    function Cosmonaut(name, description, oxygen) {
        if (oxygen === void 0) { oxygen = 1; }
        this.name = name;
        this.description = description;
        this.oxygen = oxygen;
    }
    return Cosmonaut;
})();
angular.module("newTaskApp").controller("CrewCtrl", function CrewCtrl($scope, $state, taskInfo) {
    console.log("Crew state loaded");
    $scope.member = null;
    $scope.next = function () {
        if (!$scope.member)
            return;
        taskInfo.member = parseInt($scope.member);
        $state.go("details");
    };
    $scope.crew = [];
    console.log("Requesting the crew list");
    if (window.$java) {
        $scope.crew = JSON.parse(window.$java.GetCrew());
    }
    else {
        console.log("No $java object!");
        console.log("Adding placeholders");
        $scope.crew = [
            new Cosmonaut("Steve", "lol"),
            new Cosmonaut("Chuckeles", "Maestro")
        ];
    }
});
//# sourceMappingURL=crew.js.map