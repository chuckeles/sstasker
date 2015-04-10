package chuckeles.sstasker.system;

import chuckeles.sstasker.model.Spaceship;
import chuckeles.sstasker.model.Task;

import java.util.ArrayList;

/**
 * Java - Javascript interface
 */
public class JSInterface {

  /**
   * Log the text.
   *
   * @param text Text to load
   */
  public void Log(String text) {
    Log.Instance().Log("[webview] " + text);
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
  public ArrayList<Task> GetTaskList() {
    return Spaceship.Instance().GetTasks();
  }

}
