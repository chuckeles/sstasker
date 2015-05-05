/// <reference path="def/angular.d.ts" />
/// <reference path="def/angular-ui-router.d.ts" />
/// <reference path="info.d.ts" />
interface IJava {
    GetParts: Function;
}
interface IJavaWindow extends Window {
    $java: IJava;
}
interface IPart {
    name: string;
    description: string;
    health: number;
    reliability: number;
    works: boolean;
}
interface IRepairCtrlScope extends ng.IScope {
    parts: Array<IPart>;
    part: string;
    next: Function;
}
declare class Part implements IPart {
    name: string;
    description: string;
    health: number;
    reliability: number;
    works: boolean;
    constructor(name: string, description: string, health?: number, reliability?: number, works?: boolean);
}
