/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
angular.module("newTaskApp").config(function StateConfig($stateProvider) {
    $stateProvider.state("type", {
        templateUrl: "html/type.html",
        controller: "TypeCtrl"
    }).state("repair", {
        templateUrl: "html/repair.html",
        controller: "RepairCtrl"
    }).state("crew", {
        templateUrl: "html/crew.html",
        controller: "CrewCtrl"
    });
}).run(function GoToTypeState($state) {
    $state.go("type");
});
//# sourceMappingURL=states.js.map