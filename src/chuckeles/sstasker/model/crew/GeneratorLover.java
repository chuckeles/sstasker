package chuckeles.sstasker.model.crew;

import chuckeles.sstasker.model.Spaceship;
import chuckeles.sstasker.model.parts.Generator;
import chuckeles.sstasker.model.parts.OxygenGenerator;
import chuckeles.sstasker.system.Constants;
import chuckeles.sstasker.system.Log;
import chuckeles.sstasker.system.UpdateLog;

/**
 * Generator lover. Can only repair the generator, nothing else.
 */
public class GeneratorLover extends Engineer {

  //region Constructor

  /**
   * Create new generator lover.
   *
   * @param name The name of the generator lover
   */
  public GeneratorLover(String name) {
    super(name);
  }

  //endregion

  // ------

  //region Methods

  @Override
  public void Update() {
    if (!mAlive) {
      UpdateLog.Instance().WriteLn("Milovník generátorov " + GetName() + " je **mŕtvy**");
      return;
    }

    // lower oxygen
    SubtractOxygen(Constants.OXYGEN_CONSUMPTION_COSMONAUT);

    // get oxygen from generators
    Spaceship.Instance().GetParts().forEach(part -> {
      if (part instanceof OxygenGenerator) {
        OxygenGenerator oxygenGenerator = (OxygenGenerator)part;
        // get oxygen
        AddOxygen(oxygenGenerator.SubtractOxygen(Constants.MAX_OXYGEN_COSMONAUT - GetOxygen()));
      }
    });

    if (GetOxygen() <= 0.01) {
      // kill
      mAlive = false;

      // log
      Log.Instance().Log("Generator lover " + GetName() + " has DIED!!! [no oxygen]");
      UpdateLog.Instance().WriteLn("Milovník generátorov " + GetName() + " **ZOMREL**!!! [došiel mu kyslík]");
    }

    if (mAlive) {
      Log.Instance().Log("Generator lover " + GetName() + " updated, oxygen level: " + (int) (GetOxygen() / Constants.MAX_OXYGEN_COSMONAUT * 100) + "%");
      UpdateLog.Instance().WriteLn("Milovník generátorov " + GetName() + " bol aktualizovaný, kyslík: " + (int) (GetOxygen() / Constants.MAX_OXYGEN_COSMONAUT * 100) + "%");
    }
  }

  @Override
  public void Repair(Generator generator) {
    // try to repair the generator
    if (Math.random() < 0.02) {
      generator.Repair();
      Log.Instance().Log("Generator lover " + GetName() + " repaired the generator");
      UpdateLog.Instance().WriteLn("Milovník generátorov " + GetName() + " po mnohých pokusoch nejak " +
          "pozliepal a rozbehal generátor");
    }
    else {
      Log.Instance().Log("Generator lover " + GetName() + " tried to repair the generator but failed miserably");
      UpdateLog.Instance().WriteLn("Milovník generátorov " + GetName() + " skúsil opraviť generátor ale " +
          "vôbec mu to nevydalo");
    }
  }

  @Override
  public void Repair(OxygenGenerator oxygenGenerator) {
    Log.Instance().Log("Generator lover " + GetName() + " refuses to touch anything else than a generator");
    UpdateLog.Instance().WriteLn("Milovník generátorov " + GetName() + " sa odmieta čo i len pozrieť na generátor " +
        "kyslíka, miluje predsa iba generátor, nič iné");
  }

  //region Getters

  @Override
  public String GetDescription() {
    return "Milovník generátorov je seriózny maniak do generátorov. Celý život študoval, ako fungujú (preto teraz " +
        "nemá žiadnych známych). Aj keď ešte presne nevie, ako **generátor** produkuje elektrinu, dokáže ho " +
        "už aspoň za **určitých podmienok opraviť**. Pri tomto procese môže ale zázračne miznúť veľa kafé, čipsy " +
        "a červené drôty!";
  }

  @Override
  public String GetType() {
    return "GeneratorLover";
  }

  //endregion

  //endregion

}
