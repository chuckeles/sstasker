/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />
interface IDetailsCtrlScope extends ng.IScope {
    title: string;
    description: string;
    next: Function;
}
