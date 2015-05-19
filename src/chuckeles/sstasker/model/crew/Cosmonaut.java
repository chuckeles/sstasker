package chuckeles.sstasker.model.crew;

import chuckeles.sstasker.model.Spaceship;
import chuckeles.sstasker.model.parts.Generator;
import chuckeles.sstasker.model.parts.OxygenGenerator;
import chuckeles.sstasker.model.parts.Wheel;
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
   *
   * @see Constants#OXYGEN_CONSUMPTION_COSMONAUT
   */
  public abstract void Update();

  /**
   * Increase oxygen level.
   *
   * @param oxygen Oxygen to add
   */
  protected void AddOxygen(double oxygen) {
    mOxygen = Math.min(Constants.MAX_OXYGEN_COSMONAUT, mOxygen + oxygen);
  }

  /**
   * Subtract oxygen from the cosmonaut.
   *
   * @param oxygen How much to subtract
   */
  public void SubtractOxygen(double oxygen) {
    mOxygen = Math.max(0.0, mOxygen - oxygen);
  }

  //region Repair

  /**
   * Make the cosmonaut try to repair a generator, which is super hard, almost impossible.
   *
   * @param generator Target generator
   * @see Generator
   */
  public abstract void Repair(Generator generator);

  /**
   * Make the cosmonaut repair an oxygen generator.
   *
   * @param oxygenGenerator Target oxygen generator
   * @see OxygenGenerator
   */
  public abstract void Repair(OxygenGenerator oxygenGenerator);

  /**
   * Make the cosmonaut repair a wheel.
   *
   * @param wheel Wheel to repair
   * @see Wheel
   */
  public abstract void Repair(Wheel wheel);

  //endregion

  //region Getters

  /**
   * Get the name of the cosmonaut.
   *
   * @return The name of the cosmonaut
   */
  public String GetName() {
    return mName;
  }

  /**
   * Get the description of the cosmonaut.
   *
   * @return The description of the cosmonaut
   */
  public abstract String GetDescription();

  /**
   * Get the type of the cosmonaut.
   *
   * @return Type as a string
   */
  public abstract String GetType();

  /**
   * Get the oxygen level of the cosmonaut.
   *
   * @return Oxygen level
   */
  public double GetOxygen() {
    return mOxygen;
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

  /**
   * Whether the cosmonaut is currently alive.
   */
  protected boolean mAlive = true;

  //endregion

}
