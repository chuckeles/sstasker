package chuckeles.sstasker.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The SSTasker window mainly for displaying the webview.
 */
public class Window extends Application {

  //region Methods

  /**
   * Start the SSTasker application.
   *
   * @param primaryStage Main stage
   * @see Browser
   */
  @Override
  public void start(Stage primaryStage) throws Exception {

    // set the instance
    mInstance = this;

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

    // show the window
    Log.Instance().Log("Showing the scene");
    mPrimaryStage.show();

  }

  /**
   * Close the application window.
   */
  public static void Close() {
    mInstance.mPrimaryStage.close();
  }

  //endregion

  // ------

  //region Fields

  /**
   * Current instance of the window.
   */
  private static Window mInstance;

  /**
   * Application's main stage.
   */
  private Stage mPrimaryStage;

  /**
   * My webview component.
   */
  private Browser mBrowser = new Browser();

  //endregion

}
