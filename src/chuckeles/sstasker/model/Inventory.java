package chuckeles.sstasker.model;

import chuckeles.sstasker.system.Constants;
import chuckeles.sstasker.system.InventoryFullException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An inventory of items. It is a essentially an ArrayList, but limited in size by the constant MAX_INVENTORY_SIZE.
 *
 * @see ArrayList
 * @see Constants#MAX_INVENTORY_SIZE
 */
public class Inventory {

  //region Methods

  /**
   * Add new item stack to the inventory.
   *
   * @param stack Stack to add
   * @throws InventoryFullException When the inventory is already full
   */
  public void Add(ItemStack stack) throws InventoryFullException {
    if (mStacks.size() < Constants.MAX_INVENTORY_SIZE)
      mStacks.add(stack);

    else
      throw new InventoryFullException();
  }

  //region Getters

  /**
   * Get the stack list.
   *
   * @return Read-only list of stacks
   */
  public List<ItemStack> GetStacks() {
    return Collections.unmodifiableList(mStacks);
  }

  //endregion

  //endregion

  // ------

  //region Fields

  /**
   * The list of stacks.
   */
  private ArrayList<ItemStack> mStacks = new ArrayList<>();

  //endregion

}
