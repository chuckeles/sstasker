package chuckeles.sstasker.system;

/**
 * Java - Javascript interface
 */
public class JSInterface {

  /**
   * Log the text.
   *
   * @param text Text to load
   */
  public void log(String text) {
    Log.Instance().Log("[webview] " + text);
  }

  /**
   * Exit the application.
   */
  public void exit() {
    System.exit(0); // TODO: Handle more intelligently
  }

}
