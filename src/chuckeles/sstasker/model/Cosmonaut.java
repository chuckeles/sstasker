package chuckeles.sstasker.model;

/**
 * Contains information about a crew member.
 */
// TODO: Mark abstract
public class Cosmonaut {

  /**
   * Create new cosmonaut.
   *
   * @param name The name of the cosmonaut
   */
  public Cosmonaut(String name) {
    mName = name;
  }

  // ------

  /**
   * Get the name of the cosmonaut.
   *
   * @return The name of the cosmonaut
   */
  public String GetName() {
    return mName;
  }

  // ------

  /**
   * Name of the cosmonaut.
   */
  private String mName;

}
