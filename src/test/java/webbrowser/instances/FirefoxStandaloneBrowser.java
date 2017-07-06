package webbrowser.instances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
