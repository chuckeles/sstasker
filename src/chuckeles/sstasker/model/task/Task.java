package chuckeles.sstasker.model.task;

/**
 * Created by Martin on 20.03.2015.
 *
 * A task with a name and a description. A task can have assigned crew members and inventory items.
 */
public class Task {

  /**
   * Create a task with default title.
   */
  public Task() {}

  /**
   * Create a task with title.
   *
   * @param title Task title
   */
  public Task(String title) {
    this();
    mTitle = title;
  }

  // ---

  /**
   * Set task's description.
   *
   * @param description New description
   */
  public void SetDescription(String description) {
    mDescription = description;
  }

  /**
   * Set task's title.
   *
   * @param title New title
   */
  public void SetTitle(String title) {
    mTitle = title;
  }

  /**
   * Get task's description.
   *
   * @return Task's description
   */
  public String GetDescription() {
    return mDescription;
  }

  /**
   * Get task's title.
   *
   * @return Task's title
   */
  public String GetTitle() {
    return mTitle;
  }

  // ------

  // TODO: Maybe change to JavaFX properties
  // http://code.makery.ch/library/javafx-8-tutorial/part2/

  /**
   * The title of the task.
   */
  String mTitle = "New Task";

  /**
   * The description of the task.
   */
  String mDescription = "";

}
