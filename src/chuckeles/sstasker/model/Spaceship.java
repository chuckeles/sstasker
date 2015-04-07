package chuckeles.sstasker.model;

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

  // ------

  /**
   * The singleton instance.
   */
  private static Spaceship mInstance;
}
