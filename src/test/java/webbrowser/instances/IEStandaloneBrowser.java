package webbrowser.instances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by 1 on 20.06.2017.
 */
public class IEStandaloneBrowser {
    private static volatile WebDriver instance;

    private IEStandaloneBrowser() {
    }

    public static WebDriver getInstance() {
        if (instance == null) {
            instance = new InternetExplorerDriver();
        }
        return instance;
    }
}
