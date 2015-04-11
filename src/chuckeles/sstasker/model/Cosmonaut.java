package chuckeles.sstasker.model;

import chuckeles.sstasker.system.Constants;

/**
 * A spaceship crew member. Has a name. This is a base class for more specialized crew members, e. g. an engineer.
 *
 * @see Spaceship
 */
public abstract class Cosmonaut {

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

  /**
   * Updates the cosmonaut. Lowers the oxygen level if there's no oxygen generator around and
   * kills cosmonaut if the oxygen level is 0.
   */
  public abstract void Update();

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

  /**
   * Oxygen level of this cosmonaut.
   *
   * @see Constants#MAX_OXYGEN_COSMONAUT
   */
  private double mOxygen = Constants.MAX_OXYGEN_COSMONAUT;

  //endregion

}
