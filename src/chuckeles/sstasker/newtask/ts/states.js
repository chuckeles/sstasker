/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
angular.module("newTaskApp").config(function ($stateProvider) {
    $stateProvider.state("type", {
        templateUrl: "html/type.html"
    });
}).run(function ($state) {
    $state.go("type");
});
//# sourceMappingURL=states.js.map