package chuckeles.sstasker.system;

/**
 * Application-wide constants.
 */
public class Constants {

  //region Fields

  /**
   * Window minimum width.
   */
  public static final int WINDOW_MIN_WIDTH = 1200;

  /**
   * Window minimum height.
   */
  public static final int WINDOW_MIN_HEIGHT = 800;

  /**
   * Default max stack size of an item.
   */
  public static final int MAX_STACK_SIZE = 64;

  /**
   * Max stack size of a heavy item.
   */
  public static final int MAX_HEAVY_STACK_SIZE = 16;

  /**
   * Maximum number of item stacks in the inventory of the spaceship.
   */
  public static final int MAX_INVENTORY_SIZE = 8;

  /**
   * Max health of a spaceship part.
   */
  public static final double MAX_PART_HEALTH = 100.0;

  /**
   * Max reliability of a spaceship part.
   */
  public static final double MAX_PART_RELIABILITY = 100.0;

  /**
   * Max level of oxygen for cosmonauts.
   */
  public static final double MAX_OXYGEN_COSMONAUT = 100.0;

  /**
   * How much oxygen a cosmonaut consumes per update.
   */
  public static final double OXYGEN_CONSUMPTION_COSMONAUT = 10.0;

  //endregion

}
