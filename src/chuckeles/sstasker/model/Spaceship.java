package chuckeles.sstasker.model;

import chuckeles.sstasker.model.crew.Cosmonaut;
import chuckeles.sstasker.model.crew.Engineer;
import chuckeles.sstasker.model.parts.Generator;
import chuckeles.sstasker.model.parts.OxygenGenerator;
import chuckeles.sstasker.model.parts.Part;
import chuckeles.sstasker.system.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The main model of the spaceship. Singleton. Contains the list of spaceship parts, tasks,
 * crew members and inventory items.
 */
public class Spaceship {

  //region Methods

  /**
   * Get singleton instance.
   *
   * @return Singleton instance
   */
  public static Spaceship Instance() {
    if (mInstance == null)
      mInstance = new Spaceship();

    return mInstance;
  }

  /**
   * Initialize the spaceship.
   */
  // TODO: Maybe move to constructor
  public void Initialize() {
    if (!Load())
        InitRandomNew();
  }

  /**
   * Update everything on the spaceship.
   */
  public void Update() {
    Log.Instance().Log("Updating the spaceship");
    mParts.forEach(part -> part.Update());
    mCrew.forEach(cosmonaut -> cosmonaut.Update());
    // TODO: Update tasks

    // command the crew to maintain and repair parts
    // TODO: Remove (must be done via tasks)
    mParts.forEach(part -> {
      if (!part.Works())
        mCrew.forEach(cosmonaut -> {
          if (!part.Works())
            part.GetRepaired(cosmonaut);
        });
    });
  }

  /**
   * Add new part to the spaceship.
   *
   * @param part Part to add
   */
  public void InstallPart(Part part) {
    mParts.add(part);
  }

  /**
   * Load the spaceship from the disk. Returns true if successful or false if the file doesn't exist.
   *
   * @return True if successfully loaded, false otherwise
   */
  private boolean Load() {
    // TODO: Write
    return false;
  }

  /**
   * Initialize random new spaceship. That means generate random list of parts, crew members and inventory items.
   */
  private void InitRandomNew() {
    Log.Instance().Log("Initializing a new random spaceship");

    // TODO: Remove
    // add tasks
    Log.Instance().Log("Adding the maintanance task");
    Task t = new Task("Udržovanie Vesmírnej Lodi");
    t.SetDescription("Naši inžinieri musia automaticky udržovať a opravovať všetky časti lode.");
    mTasks.add(t);

    // add crew
    Log.Instance().Log("Adding crew");
    mCrew.add(new Engineer("Patričko"));
    mCrew.add(new Engineer("Džejky"));
    mCrew.add(new Engineer("Domčo"));
    mCrew.add(new Engineer("Pišta"));
    Log.Instance().Log("Crew added: " + mCrew.toString());

    // add parts
    Log.Instance().Log("Adding parts to spaceship");
    mParts.add(new Generator());
    mParts.add(new OxygenGenerator());
    Log.Instance().Log("Parts added: " + mParts.toString());
  }

  //region Getters

  /**
   * Get the list of tasks.
   *
   * @return The list of tasks
   */
  public ArrayList<Task> GetTasks() {
    return mTasks;
  }

  /**
   * Get the spaceship crew.
   *
   * @return The list of crew members
   */
  public ArrayList<Cosmonaut> GetCrew() {
    return mCrew;
  }

  /**
   * Get the list of spaceship parts.
   *
   * @return Read-only list of parts
   */
  public List<Part> GetParts() {
    return Collections.unmodifiableList(mParts);
  }

  //endregion

  //endregion

  // ------

  //region Fields

  /**
   * The singleton instance.
   */
  private static Spaceship mInstance;

  /**
   * The list of tasks.
   */
  private ArrayList<Task> mTasks = new ArrayList<>();

  /**
   * The list of crew members.
   */
  private ArrayList<Cosmonaut> mCrew = new ArrayList<>();

  /**
   * The spaceship's inventory.
   */
  private Inventory mInventory = new Inventory();

  /**
   * The list of parts.
   */
  private ArrayList<Part> mParts = new ArrayList<>();

  //endregion

}
