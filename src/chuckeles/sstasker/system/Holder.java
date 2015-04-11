package chuckeles.sstasker.system;

/**
 * Holds a single variable.
 * http://eclipsesource.com/blogs/2013/08/19/mutable-variable-capture-in-anonymous-java-classes/
 *
 * @param <Type> Variable type
 */
public class Holder<Type> {

  //region Constructor

  /**
   * Create new holder.
   *
   * @param value Value for the variable
   */
  public Holder(Type value) {
    mVariable = value;
  }

  //endregion

  // ------

  //region Methods

  /**
   * Set the variable.
   *
   * @param value New value
   */
  public void Set(Type value) {
    mVariable = value;
  }

  //region Getters

  /**
   * Get the variable.
   *
   * @return The variable
   */
  public Type Get() {
    return mVariable;
  }

  //endregion

  //endregion

  // ------

  //region Fields

  /**
   * The variable.
   */
  private Type mVariable;

  //endregion

}
