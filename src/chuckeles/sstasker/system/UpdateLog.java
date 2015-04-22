package chuckeles.sstasker.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An update log. Spaceship's things write things here when updated.
 */
public class UpdateLog {

  private UpdateLog() {}

  //region Methods

  /**
   * Get the singleton instance.
   *
   * @return Singleton instance
   */
  public static UpdateLog Instance() {
    if (mInstance == null)
      mInstance = new UpdateLog();

    return mInstance;
  }

  /**
   * Log a string.
   *
   * @param text String to log
   */
  public UpdateLog Write(String text) {
    mCurrentLine += text;

    return this;
  }

  /**
   * Write a new line to the log.
   */
  public UpdateLog WriteLn() {
    mLog.add(mCurrentLine);
    mCurrentLine = "";

    return this;
  }

  /**
   * Log a string and add a new line.
   *
   * @param text String to log
   */
  public UpdateLog WriteLn(String text) {
    Write(text);
    WriteLn();

    return this;
  }

  /**
   * Clear the log.
   *
   * @return
   */
  public UpdateLog Clear() {
    mLog.clear();

    return this;
  }

  //region Getters

  /**
   * Get the list of strings.
   *
   * @return List of strings
   */
  public List<String> GetLog() {
    return Collections.unmodifiableList(mLog);
  }

  //endregion

  //endregion

  //region Fields

  /**
   * Singleton instance.
   */
  private static UpdateLog mInstance;

  /**
   * The line we are currently writing to.
   */
  private String mCurrentLine = "";

  /**
   * The log, list of strings.
   */
  private ArrayList<String> mLog = new ArrayList<>();

  //endregion

}
