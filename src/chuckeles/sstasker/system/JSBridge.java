package chuckeles.sstasker.system;

import chuckeles.sstasker.model.Spaceship;
import chuckeles.sstasker.model.crew.Engineer;
import chuckeles.sstasker.model.tasks.RepairTask;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Bridge between Java and Javascript.
 */
public class JSBridge {

  //region Methods

  /**
   * Log the text.
   *
   * @param text Text to load
   * @see Log
   */
  public void Log(String text) {
    Log.Instance().Log("[webview] " + text);
  }

  /**
   * Update the spaceship.
   */
  public void Update() {
    Spaceship.Instance().Update();
  }

  /**
   * Exit the application.
   */
  public void Exit() {
    Window.Close();
  }

  /**
   * Show the new task.
   */
  public void NewTask() {
    Log.Instance().Log("Showing the new task window");
    Window.Instance().ShowNewTaskWindow();
  }

  /**
   * Create new task.
   *
   * @param taskInfo Info collected in the new task window
   */
  public void CreateTask(String taskInfo) {
    Window.Instance().HideNewTask();
    Log.Instance().Log("Got the task info: " + taskInfo);

    // convert to object
    JSONObject taskInfoObject = new JSONObject(taskInfo);

    // create task by type
    switch (taskInfoObject.getString("type")) {

    case "repair":
      RepairTask task = new RepairTask(taskInfoObject.getString("title"));
      task.SetDescription(taskInfoObject.getString("description"));
      task.SetPart(Spaceship.Instance().GetParts().get(taskInfoObject.getInt("part")));

      JSONArray crew = taskInfoObject.getJSONArray("members");
      for (int i = 0; i < crew.length(); ++i)
        task.AddEngineer((Engineer)Spaceship.Instance().GetCrew().get(crew.getInt(i)));

      Spaceship.Instance().AddTask(task);
      break;

    default:
      throw new IllegalArgumentException("Unknown type of the task");

    }
  }

  //region Getters

  /**
   * Get the log of the last update cycle of the spaceship.
   *
   * @return Update log
   */
  public String GetUpdateLog() {
    JSONArray a = new JSONArray();

    UpdateLog.Instance().GetLog().forEach(a::put);

    return a.toString();
  }

  /**
   * Get the list of tasks.
   *
   * @return JSON array of tasks
   */
  public String GetTasks() {
    JSONArray a = new JSONArray();

    Spaceship.Instance().GetTasks().forEach(task -> a.put(
        new JSONObject()
            .put("title", task.GetTitle())
            .put("description", task.GetDescription())
    ));

    return a.toString();
  }

  /**
   * Get the list of crew members.
   *
   * @return JSON array of crew members
   */
  public String GetCrew() {
    JSONArray a = new JSONArray();

    Spaceship.Instance().GetCrew().forEach(member -> a.put(
        new JSONObject()
            .put("name", member.GetName())
            .put("description", member.GetDescription())
            .put("type", member.GetType())
            .put("oxygen", member.GetOxygen() / Constants.MAX_OXYGEN_COSMONAUT)
    ));

    return a.toString();
  }

    /**
     * Get the list of parts.
     *
     * @return JSON array of parts
     */
  public String GetParts() {
    JSONArray a = new JSONArray();

    Spaceship.Instance().GetParts().forEach(part -> a.put(
        new JSONObject()
            .put("name", part.GetName())
            .put("description", part.GetDescription())
            .put("health", part.GetHealth() / Constants.MAX_PART_HEALTH)
            .put("reliability", part.GetReliability() / Constants.MAX_PART_RELIABILITY)
            .put("works", part.Works())
    ));

    return a.toString();
  }

  //endregion

  //endregion

}
