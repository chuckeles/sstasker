package chuckeles.sstasker.system;

import java.util.Date;

/**
 * Writes messages to console and the log file. Singleton.
 */
// TODO: Add support for the log file
public class Log {

  //region Methods

  /**
   * Get the singleton instance.
   *
   * @return Log instance
   */
  public static Log Instance() {
    if (mInstance == null)
      mInstance = new Log();

    return mInstance;
  }

  /**
   * Shortcut for WriteTime and WriteLn.
   *
   * @param text String to log
   * @see #WriteTime()
   * @see #WriteLn(String)
   */
  public Log Log(String text) {
    WriteTime().WriteLn(text);

    return this;
  }

  /**
   * Log a string.
   *
   * @param text String to log
   */
  public Log Write(String text) {
    System.out.print(text);

    return this;
  }

  /**
   * Write a new line to the log.
   */
  public Log WriteLn() {
    System.out.println();

    return this;
  }

  /**
   * Log a string and add a new line.
   *
   * @param text String to log
   */
  public Log WriteLn(String text) {
    Write(text);
    WriteLn();

    return this;
  }

  /**
   * Log current system time. Writes it in this format: "[h:m:s] ". Uses new Date.
   *
   * @see Date
   */
  public Log WriteTime() {
    Date currentTime = new Date();

    Write("[" + currentTime.getHours() + ":" + currentTime.getMinutes() + ":" + currentTime.getSeconds() + "] ");
    // TODO: Don't use deprecated methods, use different formatting method

    return this;
  }

  //endregion

  // ------

  //region Fields

  /**
   * Singleton instance.
   */
  private static Log mInstance;

  //endregion

}
