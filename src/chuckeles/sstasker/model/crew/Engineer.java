package chuckeles.sstasker.model.crew;

import chuckeles.sstasker.model.Spaceship;
import chuckeles.sstasker.model.parts.OxygenGenerator;
import chuckeles.sstasker.system.Constants;

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
  }

  //endregion

}
