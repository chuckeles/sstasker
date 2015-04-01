package chuckeles.sstasker.system;

import java.lang.System;
import java.util.Date;

/**
 * Created by Martin on 20.03.2015.
 *
 * Writes messages to console and the log file. Singleton.
 */
public class Log {

  private Log() {}

  // ---

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
   * Log current system time.
   */
  public Log WriteTime() {
    Date currentTime = new Date();

    Write("[" + currentTime.getHours() + ":" + currentTime.getMinutes() + ":" + currentTime.getSeconds() + "] ");
    // TODO: Don't use deprecated methods, use different formatting method

    return this;
  }

  // ---

  /**
   * Singleton instance.
   */
  private static Log mInstance;

}
