package chuckeles.sstasker.model.parts;

import chuckeles.sstasker.model.Spaceship;
import chuckeles.sstasker.system.Constants;
import chuckeles.sstasker.system.Holder;
import chuckeles.sstasker.system.Log;

import java.util.List;

/**
 * Generates oxygen on the spaceship. It is unaffected by it's health and produces a constant supply of oxygen.
 * Required energy to function. For this it searches for generator with enough energy. It consumes energy even
 * if it's internal storage is full.
 */
public class OxygenGenerator extends PartWithoutHealth {

  //region Methods

  @Override
  public void Update() {
    if (!Works()) {
      Log.Instance().Log("Oxygen generator updated but it is broken");
      return;
    }

    // decrease reliability
    mReliability *= 0.99;

    // get required energy
    final Holder<Double> energy = new Holder(0.0);
    List<Part> parts = Spaceship.Instance().GetParts();
    parts.forEach(part -> {
      // is generator?
      if (part instanceof Generator) {
        Generator generator = (Generator)part;

        // get energy
        energy.Set(energy.Get() + generator.SubstractEnergy(mConsumption - energy.Get()));
      }
    });

    // generate oxygen
    mOxygen = Math.min(mMaxOxygen, mOxygen + mGeneration * energy.Get() / mConsumption);

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
  public boolean Works() {
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

  /**
   * How much energy the generator requires to function.
   */
  private double mConsumption = 20.0;

  //endregion

}
