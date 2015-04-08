package chuckeles.sstasker.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The SSTasker Application.
 */
public class Window extends Application {

  /**
   * Start the SSTasker application.
   *
   * @param primaryStage Main stage
   */
  @Override
  public void start(Stage primaryStage) throws Exception {

    // set up main stage
    Log.Instance().Log("Setting up the primary stage");
    mPrimaryStage = primaryStage;
    mPrimaryStage.setTitle("SSTasker");
    mPrimaryStage.setMinWidth(Constants.WINDOW_MIN_WIDTH);
    mPrimaryStage.setMinHeight(Constants.WINDOW_MIN_HEIGHT);

    // set up scene
    Log.Instance().Log("Creating the main scene");
    final Scene scene = new Scene(mBrowser, Constants.WINDOW_MIN_WIDTH, Constants.WINDOW_MIN_HEIGHT);
    mPrimaryStage.setScene(scene);
    Log.Instance().Log("Showing the scene");
    mPrimaryStage.show();

  }

  // ------

  /**
   * Application's main stage.
   */
  private Stage mPrimaryStage;

  /**
   * My webview component.
   */
  private Browser mBrowser = new Browser();

}
