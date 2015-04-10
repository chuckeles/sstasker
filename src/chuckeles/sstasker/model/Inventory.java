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
 * @see Constants
 */
public class Inventory {

  /**
   * Add new item stack to the inventory.
   *
   * @param stack Stack to add
   * @throws InventoryFullException
   */
  public void Add(ItemStack stack) throws InventoryFullException {
    if (mStacks.size() < Constants.MAX_INVENTORY_SIZE)
      mStacks.add(stack);

    else
      throw new InventoryFullException();
  }

  /**
   * Get the stack list.
   *
   * @return Read-only list of stacks
   */
  public List<ItemStack> GetStacks() {
    return Collections.unmodifiableList(mStacks);
  }

  // ------

  /**
   * The list of stacks.
   */
  private ArrayList<ItemStack> mStacks = new ArrayList<>();

}
