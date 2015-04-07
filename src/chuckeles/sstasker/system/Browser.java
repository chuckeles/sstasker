package chuckeles.sstasker.system;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * The webview. Loads and displays the GUI. Used by the Window.
 *
 * @see Window
 */
public class Browser extends Region {

  /**
   * Create new browser.
   */
  public Browser() {
    getChildren().add(mBrowser);

    Log.Instance().Log("Loading the index.html file");
    mWebEngine.load(Browser.class.getResource("/chuckeles/sstasker/view/index.html").toExternalForm());
  }

  // ------

  /**
   * Keeps the webview the full size of the window, every time.
   */
  @Override
  protected void layoutChildren() {
    super.layoutChildren();

    layoutInArea(mBrowser, 0, 0, getWidth(), getHeight(), 0, HPos.CENTER, VPos.CENTER);
  }

  // ------

  /**
   * The JavaFX webview component.
   */
  private final WebView mBrowser = new WebView();

  /**
   * The webview engine.
   */
  private final WebEngine mWebEngine = mBrowser.getEngine();

}