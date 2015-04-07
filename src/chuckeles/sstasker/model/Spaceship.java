package chuckeles.sstasker.model;

import chuckeles.sstasker.model.task.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The main model of our spaceship. Singleton. Contains the list of tasks, crew members and inventory items.
 */
public class Spaceship {

  private Spaceship() {
    // testing
    mTasks.addAll(new Task("Task 1"), new Task("Task 2"));
  }

  // ------

  /**
   * Get singleton instance.
   *
   * @return Singleton instance
   */
  public static Spaceship Instance() {
    if (mInstance == null)
      mInstance = new Spaceship();

    return mInstance;
  }

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
   * The singleton instance.
   */
  private static Spaceship mInstance;

  /**
   * The list of tasks.
   */
  private ObservableList mTasks = FXCollections.observableArrayList();
}
