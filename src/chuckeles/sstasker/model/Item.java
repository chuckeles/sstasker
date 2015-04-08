package chuckeles.sstasker.model;

import chuckeles.sstasker.system.Constants;

/**
 * Contains information about an item in spaceship's inventory.
 */
public class Item {

  /**
   * Create new item.
   *
   * @param name Item's name
   */
  public Item(String name) {
    mName = name;
  }

  // ------

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

  // ------

  /**
   * The name of the item.
   */
  private String mName;

}
