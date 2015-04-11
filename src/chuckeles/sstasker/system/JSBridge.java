package chuckeles.sstasker.system;

import chuckeles.sstasker.model.Spaceship;
import netscape.javascript.JSObject;

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
    System.exit(0); // TODO: Handle more intelligently
  }

  /**
   * Get the list of tasks.
   *
   * @return Task list
   */
  public JSObject[] GetTaskList() {
    return (JSObject[])Spaceship.Instance().GetTasks().toArray();
  }

  /**
   * Get the list of crew members.
   *
   * @return Crew list
   */
  public JSObject[] GetCrewList() {
    return (JSObject[])Spaceship.Instance().GetCrew().toArray();
  }

  /**
   * Get the list of parts.
   *
   * @return Part list
   */
  public JSObject[] GetPartList() {
    return (JSObject[])Spaceship.Instance().GetParts().toArray();
  }

  //endregion

}
