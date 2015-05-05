/// <reference path="def/angular.d.ts" />

class TaskInfo {
  type : string;
  part : number;
}

angular.module("newTaskApp")

  .value("taskInfo", new TaskInfo());