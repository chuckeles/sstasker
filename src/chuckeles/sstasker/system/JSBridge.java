package chuckeles.sstasker.system;

import chuckeles.sstasker.model.Spaceship;
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

  //region Getters

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
