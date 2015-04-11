package chuckeles.sstasker.model.parts;

import chuckeles.sstasker.system.Constants;
import chuckeles.sstasker.system.Log;

/**
 * Generates oxygen on the spaceship. It is unaffected by it's health and produces a constant supply of oxygen.
 * Required energy to function. For this it searches for generator with enough energy. It consumes energy even
 * if it's internal storage is full.
 */
public class OxygenGenerator extends PartWithoutHealth {

  //region Methods

  @Override
  public void Update() {
    // decrease reliability
    mReliability *= 0.99;

    // generate energy
    mOxygen = Math.min(mMaxOxygen, mOxygen + mGeneration);

    // break apart horribly
    if (Math.random() > mReliability / Constants.MAX_PART_RELIABILITY)
      Break();

    Log.Instance().Log("Oxygen generator updated," +
        " reliability: " + (int)(mReliability / Constants.MAX_PART_RELIABILITY * 100) + "%" +
        ", oxygen: " + (int)(mOxygen / mMaxOxygen * 100) + "%" +
        ", works: " + mWorks);
  }

  @Override
  public void Repair() {
    mWorks = true;
  }

  @Override
  public void Break() {
    mWorks = false; // TODO: Dispatch some sort of event
  }

  /**
   * Substract oxygen from the oxygen generator.
   *
   * @param energy How much to substract
   * @return How much oxygen was actually substracted
   */
  public double SubstractOxygen(double energy) {
    double o = Math.min(energy, mOxygen);
    mOxygen -= o;

    return o;
  }

  //region Getters

  public double GetOxygen() {
    return mOxygen;
  }

  @Override
  public double GetReliability() {
    return mReliability;
  }

  @Override
  public boolean IsFunctional() {
    return mWorks;
  }

  //endregion

  //endregion

  // ------

  //region Fields

  /**
   * Whether the oxygen generator works.
   */
  private boolean mWorks = true;

  /**
   * The generator's reliability.
   *
   * @see Constants#MAX_PART_RELIABILITY
   */
  private double mReliability = Constants.MAX_PART_RELIABILITY * 0.9;

  /**
   * Max oxygen level of the internal buffer.
   */
  private final double mMaxOxygen = 500.0;

  /**
   * Generator's internal oxygen buffer.
   */
  private double mOxygen = mMaxOxygen;

  /**
   * Generation base level.
   */
  private double mGeneration = 120.0;

  //endregion

}
