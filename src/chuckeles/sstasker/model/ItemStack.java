package chuckeles.sstasker.model;

/**
 * A stack of items. That is more items of the same type that only take one inventory slot.
 *
 * @see Item
 */
public class ItemStack {

  /**
   * Create new stack of items. Will contain only one item.
   *
   * @param item Stack item
   */
  public ItemStack(Item item) {
    this(item, 1);
  }

  /**
   * Create new stack of items.
   *
   * @param item Stack item
   * @param number Number of items
   */
  public ItemStack(Item item, int number) {
    mItem = item;
    mNumber = number;
  }

  // ------

  /**
   * The item of this stack.
   */
  private Item mItem;

  /**
   * The number of items in this stack.
   */
  private int mNumber;
}
