package chuckeles.sstasker.system;

/**
 * Java - Javascript interface
 */
public class JSInterface {

  public void log(String text) {
    Log.Instance().Log(text);
  }

  public void exit() {
    System.exit(0); // TODO: Handle more intelligently
  }

}
