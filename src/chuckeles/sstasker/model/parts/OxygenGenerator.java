package chuckeles.sstasker.model.parts;

import chuckeles.sstasker.model.Spaceship;
import chuckeles.sstasker.model.crew.Cosmonaut;
import chuckeles.sstasker.system.Constants;
import chuckeles.sstasker.system.Holder;
import chuckeles.sstasker.system.Log;
import chuckeles.sstasker.system.UpdateLog;

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
      Log.Instance().Log("Oxygen generator updated but it is broken, oxygen level: " + (int)(mOxygen / mMaxOxygen * 100) + "%");
      UpdateLog.Instance().WriteLn("Generátor kyslíka je pokazený, kyslík: " + (int) (mOxygen / mMaxOxygen * 100) + "%");
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

    // generate oxygen
    mOxygen = Math.min(mMaxOxygen, mOxygen + mGeneration * energy.Get() / mConsumption);

    // break apart horribly
    if (Math.random() > mReliability / Constants.MAX_PART_RELIABILITY)
      Break();

    Log.Instance().Log("Oxygen generator updated," +
        " reliability: " + (int)(mReliability / Constants.MAX_PART_RELIABILITY * 100) + "%" +
        ", oxygen: " + (int)(mOxygen / mMaxOxygen * 100) + "%" +
        ", works: " + mWorks);
    UpdateLog.Instance().WriteLn("Generátor kyslíka aktualizovaný," +
        " spolahlivosť: " + (int) (mReliability / Constants.MAX_PART_RELIABILITY * 100) + "%" +
        ", kyslík: " + (int) (mOxygen / mMaxOxygen * 100) + "%" +
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

  /**
   * Subtract oxygen from the oxygen generator.
   *
   * @param energy How much to substract
   * @return How much oxygen was actually substracted
   */
  public double SubtractOxygen(double energy) {
    double o = Math.min(energy, mOxygen);
    mOxygen -= o;

    return o;
  }

  //region Getters

  public double GetOxygen() {
    return mOxygen;
  }

  @Override
  public String GetName() {
    return "Generátor Kyslíka";
  }

  @Override
  public String GetDescription() {
    return "Tento generátor produkuje kyslík. Kyslík je jedna z najdôležitejších vecí na vesmírnej " +
        "lodi a naši vedci sú skutočne radi, že sa im včas podarilo prísť na to, ako túto látku " +
        "produkovať. Bez nej je všetko živé na lodi odsúdené na zánik. \n\n" +
        "Generátor kyslíka obsahuje malú nádrž s kapacitou **" + mMaxOxygen + " l**. Všetko čo " +
        "spotrebúva kyslík ho ťahá z tejto nádrže. Generátor pri výrobe kyslíka spotrebúva " +
        "**" + mConsumption + " A**, a to i v prípade, keď je nádrž plná. Generátor kyslíka " +
        "túto energiu ťahá z generátora a v prípade nedostatku energie môžu vzniknúť " +
        "fatálne problémy.";
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
