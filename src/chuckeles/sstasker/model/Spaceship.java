package chuckeles.sstasker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The main model of our spaceship. Singleton. Contains the list of tasks, crew members and inventory items.
 */
public class Spaceship {

  private Spaceship() {}

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
   * Get the list of tasks.
   *
   * @return The list of tasks
   */
  public List<Task> GetTasks() {
    return mTasks;
  }

  /**
   * Get the spaceship crew.
   *
   * @return The list of crew members
   */
  public List<Cosmonaut> GetCrew() {
    return mCrew;
  }

  // ------

  /**
   * The singleton instance.
   */
  private static Spaceship mInstance;

  /**
   * The list of tasks.
   */
  private List<Task> mTasks = new ArrayList<>();

  /**
   * The list of crew members.
   */
  private List<Cosmonaut> mCrew = new ArrayList<>();
}
