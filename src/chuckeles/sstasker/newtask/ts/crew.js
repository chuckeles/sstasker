/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />
var Cosmonaut = (function () {
    function Cosmonaut(name, description, type, oxygen) {
        if (type === void 0) { type = "Engineer"; }
        if (oxygen === void 0) { oxygen = 1; }
        this.name = name;
        this.description = description;
        this.type = type;
        this.oxygen = oxygen;
    }
    return Cosmonaut;
})();
angular.module("newTaskApp").controller("CrewCtrl", function CrewCtrl($scope, $state, taskInfo) {
    console.log("Crew state loaded");
    $scope.next = function () {
        taskInfo.members = [];
        for (var i = 0; i < $scope.selected.length; ++i)
            if ($scope.selected[i])
                taskInfo.members.push(i);
        $state.go("details");
    };
    $scope.crew = [];
    $scope.selected = [];
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
    for (var i = 0; i < $scope.crew.length; ++i)
        $scope.selected[i] = false;
});
//# sourceMappingURL=crew.js.map