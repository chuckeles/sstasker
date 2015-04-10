angular.module("sstasker")

  .controller("dashboardCtrl", ["$scope", function($scope) {
    console.log("Dashboard state loaded");

    $scope.viewClass = "dashboard full flex";

    console.log("Requesting the task list");
    if (window.$java)
      $scope.taskList = window.$java.GetTaskList();
    else
      console.log("No $java object!")
  }])
