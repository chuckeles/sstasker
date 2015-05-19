package chuckeles.sstasker.model.parts;

import chuckeles.sstasker.model.Spaceship;
import chuckeles.sstasker.model.crew.Cosmonaut;
import chuckeles.sstasker.system.Constants;
import chuckeles.sstasker.system.Holder;
import chuckeles.sstasker.system.Log;
import chuckeles.sstasker.system.UpdateLog;

import java.util.List;

/**
 * The W.H.E.E.L. is used to operate the spaceship.
 */
public class Wheel extends PartWithoutHealth {

  //region Methods

  @Override
  public void Update() {
    if (!Works()) {
      Log.Instance().Log("Wheel updated but it is broken");
      UpdateLog.Instance().WriteLn("W.H.E.E.L. je pokazený");

      // TODO: Damage crew (the ship is uncontrollable!)
      return;
    }

    // decrease reliability
    mReliability *= 0.99;

    // get required energy
    final Holder<Double> energy = new Holder<>(0.0);
    List<Part> parts = Spaceship.Instance().GetParts();
    parts.forEach(part -> {
      // is generator?
      if (part instanceof Generator) {
        Generator generator = (Generator)part;

        // get energy
        energy.Set(energy.Get() + generator.SubtractEnergy(mConsumption - energy.Get()));
      }
    });

    // break apart horribly
    if (Math.random() > mReliability / Constants.MAX_PART_RELIABILITY)
      Break();

    Log.Instance().Log("Wheel updated," +
        " reliability: " + (int)(mReliability / Constants.MAX_PART_RELIABILITY * 100) + "%" +
        ", works: " + mWorks);
    UpdateLog.Instance().WriteLn("W.H.E.E.L. aktualizovaný," +
        " spolahlivosť: " + (int) (mReliability / Constants.MAX_PART_RELIABILITY * 100) + "%" +
        ", funguje: " + (mWorks ? "áno" : "nie"));
  }

  @Override
  public void Repair() {
    mWorks = true;
  }

  @Override
  public void GetRepaired(Cosmonaut cosmonaut) {
    cosmonaut.Repair(this);
  }

  @Override
  public void Break() {
    mWorks = false; // TODO: Dispatch some sort of event
  }

  //region Getters

  @Override
  public String GetName() {
    return "W.H.E.E.L.";
  }

  @Override
  public String GetDescription() {
    return "Takzvaný W.H.E.E.L. je riadiaci systém ktorý sa používa na ovládanie vesmírnej lode. " +
        "Skladá sa hlavne z jedného veľkého otočného \"kolesa\", ktoré je upevnené na ovládacom paneli. " +
        "Na tomto panely sa nachádza snáď milión rôznych gombíkov, ktorým rozumie iba veľmi málo ľudí.";
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
   * Whether the wheel works.
   */
  private boolean mWorks = true;

  /**
   * The wheel's reliability.
   *
   * @see Constants#MAX_PART_RELIABILITY
   */
  private double mReliability = Constants.MAX_PART_RELIABILITY * 0.9;

  /**
   * How much energy the wheel requires to function.
   */
  private double mConsumption = 5.0;

  //endregion

}
