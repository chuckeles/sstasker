package chuckeles.sstasker.system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Martin on 01.04.2015.
 *
 * The SSTasker Application.
 */
public class SSTasker extends Application {

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

    // load the root layout
    try {
      FXMLLoader loader = new FXMLLoader(SSTasker.class.getResource("/chuckeles/sstasker/view/Window.fxml"));
      mWindow = (BorderPane)loader.load();
    }
    catch (IOException e) {
      Log.Instance().Log(e.getMessage());
    }

    // show the scene
    mPrimaryStage.setScene(new Scene(mWindow));
    mPrimaryStage.show();

  }

  // ------

  /**
   * Application's main stage.
   */
  private Stage mPrimaryStage;
  /**
   * Main border pane which is the window for the application.
   */
  private BorderPane mWindow;

}
