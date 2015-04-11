package chuckeles.sstasker.system;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

/**
 * The webview. Loads and displays the GUI. Used by the Window.
 *
 * @see Window
 */
public class Browser extends Region {

  //region Constructor

  /**
   * Create new browser.
   */
  public Browser() {
    getChildren().add(mBrowser);

    //mWebEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
    //  if (newValue.toString() != "SUCCEEDED")
    //    return;

      JSInterface jsInterface = new JSInterface();
      JSObject window = (JSObject) mWebEngine.executeScript("window");

      window.setMember("$java", jsInterface);

      mWebEngine.executeScript(
        "console.log = function(text) { $java.Log(text); };"
      );
      mWebEngine.executeScript(
        "console.error = function(text) { $java.Log('[error] ' + text); };"
      );
    //});

    Log.Instance().Log("Loading the index.html file");
    mWebEngine.load(Browser.class.getResource("/chuckeles/sstasker/view/index.html").toExternalForm());
  }

  //endregion

  // ------

  //region Methods

  /**
   * Keeps the webview the full size of the window, all the time.
   */
  @Override
  protected void layoutChildren() {
    super.layoutChildren();

    layoutInArea(mBrowser, 0, 0, getWidth(), getHeight(), 0, HPos.CENTER, VPos.CENTER);
  }

  //endregion

  // ------

  //region Fields

  /**
   * The JavaFX webview component.
   */
  private final WebView mBrowser = new WebView();

  /**
   * The webview engine.
   */
  private final WebEngine mWebEngine = mBrowser.getEngine();

  //endregion

}
