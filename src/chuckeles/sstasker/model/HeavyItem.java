package chuckeles.sstasker.model;

import chuckeles.sstasker.system.Constants;

/**
 * Heavy version if a standard item. Can make only smaller stacks.
 *
 * @see Item
 */
public class HeavyItem extends Item {

  //region Constructor

  /**
   * Create new heavy item.
   *
   * @param name Item's name
   */
  public HeavyItem(String name) {
    super(name);
  }

  //endregion

  // ------

  //region Methods

  //region Getters

  /**
   * Get the max size of a stack of this item.
   *
   * @return Max stack size
   */
  @Override
  public int GetMaxStackSize() {
    return Constants.MAX_HEAVY_STACK_SIZE;
  }

  //endregion

  //endregion
}
