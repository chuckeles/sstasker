package chuckeles.sstasker.model.crew;

import chuckeles.sstasker.model.Spaceship;
import chuckeles.sstasker.model.parts.Generator;
import chuckeles.sstasker.model.parts.OxygenGenerator;
import chuckeles.sstasker.model.parts.Wheel;
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
    if (!mAlive) {
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " je **mŕtvy**");
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
      Log.Instance().Log("Engineer " + GetName() + " has DIED!!! [no oxygen]");
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " **ZOMREL**!!! [došiel mu kyslík]");
    }

    if (mAlive) {
      Log.Instance().Log("Engineer " + GetName() + " updated, oxygen level: " + (int) (GetOxygen() / Constants.MAX_OXYGEN_COSMONAUT * 100) + "%");
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " bol aktualizovaný, kyslík: " + (int) (GetOxygen() / Constants.MAX_OXYGEN_COSMONAUT * 100) + "%");
    }
  }

  @Override
  public void Repair(Generator generator) {
    if (!mAlive) {
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " by rád niečo opravoval, ale je mŕtvy");
      return;
    }

    Log.Instance().Log("Engineer " + GetName() + " would like to repair the generator but doesn't even" +
        " know how it works");
    UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " nepozná generátor a preto ho nevie opraviť");
  }

  @Override
  public void Repair(OxygenGenerator oxygenGenerator) {
    if (!mAlive) {
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " by rád niečo opravoval, ale je mŕtvy");
      return;
    }

    // try to repair the oxygen generator
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

  @Override
  public void Repair(Wheel wheel) {
    if (!mAlive) {
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " by rád niečo opravoval, ale je mŕtvy");
      return;
    }

    // try to repair the wheel
    if (Math.random() < 0.3) {
      wheel.Repair();
      Log.Instance().Log("Engineer " + GetName() + " repaired the wheel");
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " opravil W.H.E.E.L.");
    }
    else {
      Log.Instance().Log("Engineer " + GetName() + " tried to repair the wheel but failed miserably");
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " skúsil opraviť W.H.E.E.L. ale " +
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
