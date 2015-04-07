package chuckeles.sstasker.system;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The SSTasker Application.
 */
public class SSApplication extends Application {

  /**
   * Start the SSTasker application.
   *
   * @param primaryStage Main stage
   */
  @Override
  public void start(Stage primaryStage) {

    // set up main stage
    mPrimaryStage = primaryStage;
    mPrimaryStage.setTitle("SSTasker");
    mPrimaryStage.setMinWidth(400);
    mPrimaryStage.setMinHeight(300);

  }

  // ------

  /**
   * Application's main stage.
   */
  private Stage mPrimaryStage;

}
