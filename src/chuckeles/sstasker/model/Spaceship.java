package chuckeles.sstasker.model;

import chuckeles.sstasker.model.crew.Cosmonaut;
import chuckeles.sstasker.model.crew.Engineer;
import chuckeles.sstasker.model.crew.GeneratorLover;
import chuckeles.sstasker.model.crew.Pilot;
import chuckeles.sstasker.model.parts.Generator;
import chuckeles.sstasker.model.parts.OxygenGenerator;
import chuckeles.sstasker.model.parts.Part;
import chuckeles.sstasker.model.parts.Wheel;
import chuckeles.sstasker.model.tasks.Task;
import chuckeles.sstasker.system.Log;
import chuckeles.sstasker.system.UpdateLog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The main model of the spaceship. Singleton. Contains the list of spaceship parts, tasks,
 * crew members and inventory items.
 */
public class Spaceship {

  private Spaceship() {}

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

    UpdateLog.Instance()
        .Clear()
        .WriteLn("Aktualizujem vesmírnu loď")
        .WriteLn();

    mParts.forEach(Part::Update);
    mCrew.forEach(Cosmonaut::Update);
    mTasks.forEach(Task::Update);

    UpdateLog.Instance()
        .WriteLn()
        .WriteLn("Loď aktualizovaná");

    Log.Instance().Log("Removing tasks");
    mTasksToRemove.forEach(task -> mTasks.remove(task));
    mTasksToRemove.clear();
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

    // add crew
    Log.Instance().Log("Adding crew");
    mCrew.add(new Pilot("Džejky"));
    mCrew.add(new Engineer("Patričko"));
    mCrew.add(new Engineer("Domčo"));
    mCrew.add(new GeneratorLover("Pišta"));
    Log.Instance().Log("Crew added: " + mCrew.toString());

    // add parts
    Log.Instance().Log("Adding parts to spaceship");

    for (int i = 0, imax = (int)(Math.random() * 4) + 1; i < imax; ++i)
      mParts.add(new Generator());
    for (int i = 0, imax = (int)(Math.random() * 2) + 1; i < imax; ++i)
      mParts.add(new OxygenGenerator());

    mParts.add(new Wheel());

    Log.Instance().Log("Parts added: " + mParts.toString());
  }

  /**
   * Add new task.
   *
   * @param task Task to add
   */
  public void AddTask(Task task) {
    mTasks.add(task);
  }

  /**
   * Remove a task. The task will be remove in the end of the update.
   *
   * @param task Task to remove
   * @see #Update()
   */
  public void RemoveTask(Task task) {
    mTasksToRemove.add(task);
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
   * Internal list of tasks to remove.
   */
  private ArrayList<Task> mTasksToRemove = new ArrayList<>();

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
