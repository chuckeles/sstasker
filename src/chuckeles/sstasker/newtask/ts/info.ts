/// <reference path="def/angular.d.ts" />

class TaskInfo {
  type : string;
  part : number;
  member : number;

  title : string;
  description : string;
}

angular.module("newTaskApp")

  .value("taskInfo", new TaskInfo());