package chuckeles.sstasker.model.tasks;

import chuckeles.sstasker.model.Spaceship;
import chuckeles.sstasker.model.crew.Engineer;
import chuckeles.sstasker.model.parts.Part;

import java.util.ArrayList;

/**
 * Repair task. This task tells an engineer to repair a broken part.
 *
 * @see Task
 */
public class RepairTask extends Task {

  //region Constructor

  /**
   * Create a new repair task with a default title.
   */
  public RepairTask() {
    super();
  }

  /**
   * Create a new repair task with a title.
   *
   * @param title Task title
   */
  public RepairTask(String title) {
    super(title);
  }

  /**
   * Create a new repair task and initialize it.
   *
   * @param title Task title
   * @param engineer Engineer that will repair the part
   * @param part The part that is supposed to be repaired
   */
  public RepairTask(String title, Engineer engineer, Part part) {
    this(title);

    mEngineers.add(engineer);
    mPart = part;
  }


  //endregion

  //region Methods

  /**
   * Update the task. This makes the engineers try to repair the part.
   */
  @Override
  public void Update() {
    if (mPart == null)
      return;

    // engineers! get to work!
    mEngineers.forEach(engineer -> mPart.GetRepaired(engineer));

    // remove task if successful
    if (mPart.Works())
      Spaceship.Instance().RemoveTask(this);
  }

  /**
   * Add engineer to repair the part.
   *
   * @param engineer Engineer to add
   */
  public void AddEngineer(Engineer engineer) {
    mEngineers.add(engineer);
  }

  /**
   * Set the part.
   *
   * @param part The part to be repaired
   */
  public void SetPart(Part part) {
    mPart = part;
  }

  //region Getters

  /**
   * Get the part.
   *
   * @return The part to be repaired
   */
  public Part GetPart() {
    return mPart;
  }

  //endregion

  //endregion

  //region Fields

  /**
   * List of engineers that are supposed to repair the part.
   */
  private ArrayList<Engineer> mEngineers = new ArrayList<>();

  /**
   * The part that is supposed to be repaired.
   */
  private Part mPart;

  //endregion

}
