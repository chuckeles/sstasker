package chuckeles.sstasker.model.parts;

import chuckeles.sstasker.model.crew.Cosmonaut;

/**
 * Spaceship part, e. g. and engine, a console, and oxygen generator... Has a reliability, health
 * and whether it is currently functional or not.
 */
public interface Part {

  // region Methods

  /**
   * Update the spaceship part. There's a chance the part will break.
   */
  void Update();

  /**
   * Repair the part, restoring it to functional state.
   */
  void Repair();

  /**
   * Get repaired by a cosmonaut. Visitor pattern.
   * https://sourcemaking.com/design_patterns/visitor
   *
   * @param cosmonaut The cosmonaut to repair the part
   * @see Cosmonaut
   */
  void GetRepaired(Cosmonaut cosmonaut);

  /**
   * Break the part, making it non-functional.
   */
  void Break();

  // region Getters

  /**
   * Get the name of the part.
   *
   * @return Part name
   */
  String GetName();

  /**
   * Get the description of the part.
   *
   * @return The description of the part
   */
  String GetDescription();

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
  boolean Works();

  // endregion

  // endregion

}
