package chuckeles.sstasker.controller;

import chuckeles.sstasker.model.task.Spaceship;
import chuckeles.sstasker.model.task.Task;
import chuckeles.sstasker.system.Log;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

/**
 * Created by Martin on 01.04.2015. Is it a joke?
 *
 * The controller for the dashboard view.
 */
public class DashboardCtrl {

  /**
   * Called automatically after the dashboard has been initialized.
   */
  @FXML
  private void initialize() {
    Log.Instance().Log("Dashboard initialized");

    // link view items
    taskList.setItems(Spaceship.Instance().GetTasks());

    // set factories
    taskList.setCellFactory(listView -> new ListCell<Task>() {
      @Override
      protected void updateItem(Task item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null)
          setText(item.GetTitle());
      }
    });
  }

  // ------

  /**
   * Task list.
   */
  @FXML
  private ListView taskList;

}
