package chuckeles.sstasker.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The SSTasker window mainly for displaying the webview. Singleton.
 */
public class Window extends Application {

  //region Methods

  /**
   * Get the singleton instance.
   *
   * @return Singleton instance
   */
  public static Window Instance() {
    return mInstance;
  }

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

    // initialize new task window
    Log.Instance().Log("Initializing the new task window");
    InitNewTaskWindow();

    // show the window
    Log.Instance().Log("Showing the scene");
    mPrimaryStage.show();

  }

  /**
   * Initialize the new task window.
   */
  public void InitNewTaskWindow() {
    // set up stage
    mNewTaskStage.setTitle("SSTasker - Nová úloha");
    mNewTaskStage.setMinWidth(Constants.WINDOW_NEW_TASK_MIN_WIDTH);
    mNewTaskStage.setMaxHeight(Constants.WINDOW_NEW_TASK_MIN_HEIGHT);

    // set up scene
    final Scene scene = new Scene(mNewTaskBrowser, Constants.WINDOW_NEW_TASK_MIN_WIDTH, Constants.WINDOW_NEW_TASK_MIN_HEIGHT);
    mNewTaskStage.setScene(scene);
  }

  /**
   * Show the new task window.
   */
  public void ShowNewTaskWindow() {
    mNewTaskStage.show();
  }

  /**
   * Close the new task window.
   */
  public void CloseNewTaskWindow() {
    mNewTaskStage.hide();
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
  private Browser mBrowser = new Browser("/chuckeles/sstasker/view/index.html");

  /**
   * The stage for the new task window.
   */
  private Stage mNewTaskStage = new Stage();

  /**
   * The browser for the new task window.
   */
  private Browser mNewTaskBrowser = new Browser("/chuckeles/sstasker/newtask/index.html");

  //endregion

}
