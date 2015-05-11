/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />
var Part = (function () {
    function Part(name, description, health, reliability, works) {
        if (health === void 0) { health = 1; }
        if (reliability === void 0) { reliability = 1; }
        if (works === void 0) { works = true; }
        this.name = name;
        this.description = description;
        this.health = health;
        this.reliability = reliability;
        this.works = works;
    }
    return Part;
})();
angular.module("newTaskApp").controller("RepairCtrl", function RepairCtrl($scope, $state, taskInfo) {
    console.log("Repair state loaded");
    $scope.part = null;
    $scope.next = function () {
        if (!$scope.part)
            return;
        taskInfo.part = parseInt($scope.part);
        $state.go("crew");
    };
    $scope.parts = [];
    console.log("Requesting the part list");
    if (window.$java) {
        $scope.parts = JSON.parse(window.$java.GetParts());
    }
    else {
        console.log("No $java object!");
        console.log("Adding placeholders");
        $scope.parts = [
            new Part("Generator", "Makes energy", Math.random(), Math.random(), Math.random() > .5),
            new Part("Generator", "Makes tons of energy", Math.random(), Math.random(), Math.random() > .5),
            new Part("Oxygen Generator", "Makes oxygen", Math.random(), Math.random(), Math.random() > .5),
            new Part("Cool Oxygen Generator", "Makes poison", Math.random(), Math.random(), Math.random() > .5)
        ];
    }
});
//# sourceMappingURL=repair.js.map