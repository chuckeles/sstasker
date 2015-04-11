package chuckeles.sstasker.model;

/**
 * Spaceship part, e. g. and engine, a console, and oxygen generator... Has a reliability, health
 * and whether it is currently functional or not.
 */
public interface SpaceshipPart {

  /**
   * Update the spaceship part. There's a chance the part will break.
   */
  void Update();

  /**
   * Get the reliability of the part, that is the chance that the part will not break.
   *
   * @return The reliability of the part
   */
  double GetReliability();

  /**
   * Get the health of the part. Parts that have lower health will be less productive and will be
   * more prone to breaking.
   *
   * @return The health of the part
   */
  double GetHealth();

  /**
   * Get if the part is functional and not broken.
   *
   * @return True if the part is functional, false if broken
   */
  boolean IsFunctional();

}
