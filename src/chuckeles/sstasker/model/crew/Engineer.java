package chuckeles.sstasker.model.crew;

import chuckeles.sstasker.model.Spaceship;
import chuckeles.sstasker.model.parts.Generator;
import chuckeles.sstasker.model.parts.OxygenGenerator;
import chuckeles.sstasker.system.Constants;
import chuckeles.sstasker.system.Log;
import chuckeles.sstasker.system.UpdateLog;

/**
 * An engineer. Is more skilled in fixing and building parts.
 */
public class Engineer extends Cosmonaut {

  //region Constructor

  /**
   * Create new engineer.
   *
   * @param name The name of the engineer
   */
  public Engineer(String name) {
    super(name);
  }

  //endregion

  // ------

  //region Methods

  @Override
  public void Update() {
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

    // TODO: Kill if no oxygen

    Log.Instance().Log("Engineer " + GetName() + " updated, oxygen level: " + (int)(GetOxygen() / Constants.MAX_OXYGEN_COSMONAUT * 100) + "%");
    UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " bol aktualizovaný, kyslík: " + (int) (GetOxygen() / Constants.MAX_OXYGEN_COSMONAUT * 100) + "%");
  }

  @Override
  public void Repair(Generator generator) {
    Log.Instance().Log("Engineer " + GetName() + " would like to repair the Generator but doesn't even" +
        " know how it works");
    UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " nepozná generátor a preto ho nevie opraviť");
  }

  @Override
  public void Repair(OxygenGenerator oxygenGenerator) {
    // try to repair the oxygen generator
    // TODO: Change, will involve more conditions, e. g. skill
    if (Math.random() < 0.1) {
      oxygenGenerator.Repair();
      Log.Instance().Log("Engineer " + GetName() + " repaired the oxygen generator");
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " opravil generátor kyslíka");
    }
    else {
      Log.Instance().Log("Engineer " + GetName() + " tried to repair the oxygen generator but failed miserably");
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " skúsil opraviť generátor kyslíka ale " +
          "nejak mu to nevydalo");
    }
  }

  //region Getters

  @Override
  public String GetDescription() {
    return "Kozmonaut, inžinier. Tento kozmonaut má za sebou seriózne veľa rokov strávených nad knihami, " +
        "pri svetle sviečky a so šálkou čersvého zeleného čaja. Inžinieri sú obvykle veľmi chytrí, ale ani ten " +
        "najskúsenejší inžinier nepozná všetky súčiastky na vesmírnej lodi. \n\n" +
        "Inžinieri sú dobrí v udržiavaní a opravovaní častí vesmírnej lode. Bohužiaľ ani ten najlepší inžinier " +
        "**nevie opraviť generátor**. Inžinieri sú tiež dosť neschopní čo sa týka pilotovania vesmírnej lodi.";
  }

  @Override
  public String GetType() {
    return "Engineer";
  }

  //endregion

  //endregion

}
