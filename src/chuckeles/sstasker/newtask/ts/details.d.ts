/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />
interface IJava {
    CreateTask: Function;
}
interface IJavaWindow extends Window {
    $java: IJava;
}
interface IDetailsCtrlScope extends ng.IScope {
    title: string;
    description: string;
    next: Function;
}
