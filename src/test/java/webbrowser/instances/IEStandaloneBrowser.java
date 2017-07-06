package webbrowser.instances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEStandaloneBrowser {
    private static volatile WebDriver instance;

    private IEStandaloneBrowser() {
    }

    public static WebDriver getInstance() {
        if (instance == null) {
            System.setProperty("webdriver.ie.driver","src\\resources\\geckoDrivers\\IEDriverServer.exe"); // because I use Selenium 3.x
            instance = new InternetExplorerDriver();
        }
        return instance;
    }
}
