package webbrowser.instances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by 1 on 20.06.2017.
 */
public class ChromeStandaloneBrowser {
    private static volatile WebDriver instance;

    private ChromeStandaloneBrowser() {
    }

    public static WebDriver getInstance() {
        if (instance == null) {
            instance = new ChromeDriver();
        }
        return instance;
    }
}
