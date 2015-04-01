package chuckeles.sstasker.model.task;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Martin on 01.04.2015.
 *
 * The main model of our spaceship. Contains the list of tasks, crew members and inventory items.
 */
public class Spaceship {

  /**
   * Get the task list.
   *
   * @return The observable task list
   */
  public ObservableList GetTasks() {
    return mTasks;
  }

  // ------

  /**
   * The list of tasks.
   */
  private ObservableList mTasks = FXCollections.observableArrayList();
}
