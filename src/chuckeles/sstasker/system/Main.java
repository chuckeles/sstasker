package chuckeles.sstasker.system;

import javafx.application.Application;

/**
 * Created by Martin on 01.04.2015.
 *
 * This class contains the main method.
 */
public class Main {

  /**
   * Application entry point.
   *
   * @param args Console arguments
   */
  public static void main(String[] args) {

    Log.Instance().Log("SSTasker is starting");

    Application.launch(SSTasker.class, args);

    Log.Instance().Log("SSTasker is ending");

  }

}
