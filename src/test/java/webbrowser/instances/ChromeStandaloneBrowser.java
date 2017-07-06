package webbrowser.instances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeStandaloneBrowser {
    private static volatile WebDriver instance;

    private ChromeStandaloneBrowser(){}

    public static WebDriver getInstance(){
        if (instance == null) {
            System.setProperty("webdriver.chrome.driver","src\\resources\\geckoDrivers\\chromedriver.exe"); // because I use Selenium 3.x
            instance = new ChromeDriver();
        }

        return instance;
    }
}