/**
 * Created by 1 on 15.06.2017.
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class Find_In_YandexMarket_Lenovo_or_HP_Laptop_Which_is_Cheaper_than_30_Test {
    private final String yandexUrl = "http://yandex.ru";
    private WebDriver webDriver;
    private FindProductInYandexMarket findProductHelper = new FindProductInYandexMarketHelper();

    protected void setGeckoDriverToSystemProperty(){
        System.setProperty("webdriver.gecko.driver","src\\resources\\geckoDrivers\\geckodriver64.exe"); // because I use Selenium 3.x
    }

    protected void openBrowserInFullscreenModeAndGoToYandexStartPage(){
        webDriver.manage().window().maximize();
        webDriver.switchTo();
        webDriver.get(yandexUrl);
    }

    @Before
    public void openFFBrowser() throws IOException {
        setGeckoDriverToSystemProperty();
        findProductHelper.setBrowserForTest("Firefox");
        webDriver = findProductHelper.getWebDriverInstance();    //11 check that link is copied
        openBrowserInFullscreenModeAndGoToYandexStartPage();
    }

    @After
    public void closeBrowser() throws IOException {
        webDriver.quit();
    }

    @Test
    public void find_In_YandexMarket_Lenovo_or_HP_Laptop_Which_is_Cheaper_than_30(){
        findProductHelper.navigateIntoYandexService("Маркет");
        findProductHelper.chooseProductCategory("Компьютеры");
        findProductHelper.chooseCatalogOfProducts("Ноутбуки");
        findProductHelper.setPriceInSearchFilter(null, "30000");
        findProductHelper.checkSearchParameter(new String[]{"Lenovo", "HP"});
        findProductHelper.pressAcceptButton();
        //Assert(10, findProductHelper.getCountOfResultsRows());
        findProductHelper.rememberFirstElement();
       // findProductHelper.setfindProductHelper.getRememberedFirstElement()
    }
}
