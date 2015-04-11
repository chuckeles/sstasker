package chuckeles.sstasker.model;

import chuckeles.sstasker.system.Constants;

/**
 * An item, usually contained in a stack in the spaceship's inventory.
 *
 * @see Inventory
 */
public class Item {

  //region Constructor

  /**
   * Create new item.
   *
   * @param name Item's name
   */
  public Item(String name) {
    mName = name;
  }

  //endregion

  // ------

  //region Methods

  //region Getters

  /**
   * Get the item's name.
   *
   * @return Item's name
   */
  public String GetName() {
    return mName;
  }

  /**
   * Get the max size of a stack of the item.
   *
   * @return Max size of a stack
   */
  public int GetMaxStackSize() {
    return Constants.MAX_STACK_SIZE;
  }

  //endregion

  //endregion

  // ------

  //region Fields

  /**
   * The name of the item.
   */
  private String mName;

  //endregion

}
