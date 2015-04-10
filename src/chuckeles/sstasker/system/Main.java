package chuckeles.sstasker.system;

import chuckeles.sstasker.model.Spaceship;
import javafx.application.Application;

/**
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
    Log.Instance().WriteLn();

    Log.Instance().Log("Initializing the spaceship");
    Spaceship.Instance().Initialize();

    Log.Instance().Log("Launching the application");
    Application.launch(Window.class, args);

    Log.Instance().WriteLn();
    Log.Instance().Log("SSTasker is ending");

  }

}
