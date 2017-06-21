package webbrowser.instances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by 1 on 20.06.2017.
 */
public class FirefoxStandaloneBrowser {
    private static volatile WebDriver instance;

    private FirefoxStandaloneBrowser(){}

    public static WebDriver getInstance(){
        if (instance == null) {
            System.setProperty("webdriver.gecko.driver","src\\resources\\geckoDrivers\\geckodriver64.exe"); // because I use Selenium 3.x
            instance = new FirefoxDriver();
        }

        return instance;
    }
}
