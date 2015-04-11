package chuckeles.sstasker.model;

/**
 * A spaceship crew member. Has a name. This is a base class for more specialized crew members, e. g. an engineer.
 *
 * @see Spaceship
 */
// TODO: Mark abstract
public class Cosmonaut {

  //region Constructor

  /**
   * Create new cosmonaut.
   *
   * @param name The name of the cosmonaut
   */
  public Cosmonaut(String name) {
    mName = name;
  }

  //endregion

  // ------

  //region Methods

  //region Getters

  /**
   * Get the name of the cosmonaut.
   *
   * @return The name of the cosmonaut
   */
  public String GetName() {
    return mName;
  }

  //endregion

  //endregion

  // ------

  //region Fields

  /**
   * The name of the cosmonaut.
   */
  private String mName;

  //endregion

}
