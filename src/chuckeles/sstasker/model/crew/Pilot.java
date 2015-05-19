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
public class Pilot extends Cosmonaut {

  //region Constructor

  /**
   * Create new pilot.
   *
   * @param name The name of the pilot
   */
  public Pilot(String name) {
    super(name);
  }

  //endregion

  // ------

  //region Methods

  @Override
  public void Update() {
    if (!mAlive) {
      UpdateLog.Instance().WriteLn("Pilot " + GetName() + " je **mŕtvy**");
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
      Log.Instance().Log("Pilot " + GetName() + " has DIED!!! [no oxygen]");
      UpdateLog.Instance().WriteLn("Pilot " + GetName() + " **ZOMREL**!!! [došiel mu kyslík]");
    }

    if (mAlive) {
      // control the wheels
      Spaceship.Instance().GetParts().forEach(part -> {
        if (part instanceof Wheel) {
          ((Wheel)part).Control();
          UpdateLog.Instance().WriteLn("Pilot " + GetName() + " ovláda W.H.E.E.L.");
        }
      });

      Log.Instance().Log("Pilot " + GetName() + " updated, oxygen level: " + (int) (GetOxygen() / Constants.MAX_OXYGEN_COSMONAUT * 100) + "%");
      UpdateLog.Instance().WriteLn("Pilot " + GetName() + " bol aktualizovaný, kyslík: " + (int) (GetOxygen() / Constants.MAX_OXYGEN_COSMONAUT * 100) + "%");
    }
  }

  @Override
  public void Repair(Generator generator) {
    if (!mAlive) {
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " by rád aj niečo opravoval, ale je mŕtvy");
      return;
    }

    Log.Instance().Log("Pilot " + GetName() + " can't repair anything");
    UpdateLog.Instance().WriteLn("Vyzerá snáď pilot " + GetName() + " ako opravár? Také ponižujúce...");
  }

  @Override
  public void Repair(OxygenGenerator oxygenGenerator) {
    if (!mAlive) {
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " by rád aj niečo opravoval, ale je mŕtvy");
      return;
    }

    Log.Instance().Log("Pilot " + GetName() + " can't repair anything");
    UpdateLog.Instance().WriteLn("Vyzerá snáď pilot " + GetName() + " ako opravár? Také ponižujúce...");
  }

  @Override
  public void Repair(Wheel wheel) {
    if (!mAlive) {
      UpdateLog.Instance().WriteLn("Inžinier " + GetName() + " by rád aj niečo opravoval, ale je mŕtvy");
      return;
    }

    Log.Instance().Log("Pilot " + GetName() + " can't repair anything");
    UpdateLog.Instance().WriteLn("Vyzerá snáď pilot " + GetName() + " ako opravár? Také ponižujúce...");
  }

  //region Getters

  @Override
  public String GetDescription() {
    return "Pilot je úplný génius, aspoň teda pokiaľ ide o všetky tie tlačítka, ktoré sa nachádzajú " +
        "na W.H.E.E.L. Strávil stovky hodín v simulátore a vie ovládať vesmírnu loď dokonale.";
  }

  @Override
  public String GetType() {
    return "Pilot";
  }

  //endregion

  //endregion

}
