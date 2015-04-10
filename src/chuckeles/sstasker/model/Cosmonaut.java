package chuckeles.sstasker.model;

/**
 * A spaceship crew member. Has a name. This is a base class for more specialized crew members, e. g. an engineer.
 *
 * @see Spaceship
 */
// TODO: Mark abstract
public class Cosmonaut {

  /**
   * Create new cosmonaut.
   *
   * @param name The name of the cosmonaut
   */
  public Cosmonaut(String name) {
    mName = name;
  }

  // ------

  /**
   * Get the name of the cosmonaut.
   *
   * @return The name of the cosmonaut
   */
  public String GetName() {
    return mName;
  }

  // ------

  /**
   * The name of the cosmonaut.
   */
  private String mName;

}
