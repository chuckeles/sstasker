package chuckeles.sstasker.model.parts;

import chuckeles.sstasker.system.Constants;

/**
 * A part of spaceship. This part's function is unaffected by it's health.
 */
public abstract class PartWithoutHealth implements Part {

  //region Methods

  //region Getters

  @Override
  public double GetHealth() {
    return Constants.MAX_PART_HEALTH;
  }

  //endregion

  //endregion

}
