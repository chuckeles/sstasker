package chuckeles.sstasker.model.parts;

import chuckeles.sstasker.system.Constants;

/**
 * A part of spaceship. This part's function is affected by it's health. The lower the health, the lower
 * the productivity / effectiveness / ...
 */
public abstract class PartWithHealth implements Part {

  //region Methods

  @Override
  public void Update() {
    // lower the health
    mHealth -= 1.0; // TODO: Substract based on current reliability

    // if 0, break
    if (mHealth < 0.01)
      Break();
  }

  /**
   * Add health to the part. The health cannot exceed the max health.
   *
   * @param health Health to add
   * @see Constants#MAX_PART_HEALTH
   */
  public void AddHealth(double health) {
    SetHealth(mHealth + health);
  }

  /**
   * Set health of the part. The health cannot exceed the max health.
   *
   * @param health Health to set
   * @see Constants#MAX_PART_HEALTH
   */
  public void SetHealth(double health) {
    mHealth = Math.max(0, Math.min(Constants.MAX_PART_HEALTH, health));
  }

  //region Getters

  @Override
  public double GetHealth() {
    return mHealth;
  }

  //endregion

  //endregion

  // ------

  //region Fields

  /**
   * The part's health.
   *
   * @see Constants#MAX_PART_HEALTH
   */
  private double mHealth = Constants.MAX_PART_HEALTH;

  //endregion

}
