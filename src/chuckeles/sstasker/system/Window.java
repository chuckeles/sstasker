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
    mPrimaryStage = primaryStage;
    mPrimaryStage.setTitle("SSTasker");
    mPrimaryStage.setMinWidth(400);
    mPrimaryStage.setMinHeight(300);

    // set up scene
    final Scene scene = new Scene(mBrowser, 400, 300);
    mPrimaryStage.setScene(scene);
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
