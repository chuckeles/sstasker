/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />
interface IJava {
    GetCrew: Function;
}
interface IJavaWindow extends Window {
    $java: IJava;
}
declare class Cosmonaut {
    name: string;
    description: string;
    oxygen: number;
    constructor(name: string, description: string, oxygen?: number);
}
interface ICrewCtrlScope extends ng.IScope {
    next: Function;
    crew: Array<Cosmonaut>;
    member: string;
}
