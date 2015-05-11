/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />
interface ITypeCtrlScope extends ng.IScope {
    type: string;
    next: Function;
}
