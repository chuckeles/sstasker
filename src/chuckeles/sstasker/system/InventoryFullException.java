package chuckeles.sstasker.system;

import chuckeles.sstasker.model.Inventory;

/**
 * Exception thrown when the spaceship's inventory is full and someone tried to insert more items into it.
 *
 * @see Inventory
 */
public class InventoryFullException extends Exception {

  //region Constructor

  public InventoryFullException() {
    super("Inventory is full");
  }

  //endregion

}
