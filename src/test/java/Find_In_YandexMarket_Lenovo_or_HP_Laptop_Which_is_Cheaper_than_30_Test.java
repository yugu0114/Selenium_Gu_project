/**
 * Created by 1 on 15.06.2017.
 */

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webbrowser.instances.FirefoxStandaloneBrowser;
import yandex.webelements.YandexStartPage;
import yandex.webelements.servicepages.yandexmarket.YandexMarketServicePage;

public class Find_In_YandexMarket_Lenovo_or_HP_Laptop_Which_is_Cheaper_than_30_Test {
    private WebDriver driver;
 //   private static int waitingTimeInSeconds;

    @Before
    public void openFFBrowserAndSetItToFullscreen() {
        driver = FirefoxStandaloneBrowser.getInstance();
        driver.manage().window().maximize();
     //   waitingTimeInSeconds = 90;
    }

//    public static WebElement waitElementByLocator(By locator)
//    {
//         return (new WebDriverWait(webDriver, waitingTimeInSeconds))
//                    .until(ExpectedConditions.presenceOfElementLocated(locator));
//    }

    @Test
    public void find_In_YandexMarket_Lenovo_or_HP_Laptop_Which_is_Cheaper_than_30(){
        try {
            driver.get("http://yandex.ru");

            YandexStartPage yandexStartPage = new YandexStartPage(driver);
            YandexMarketServicePage yandexMarketServicePage = (YandexMarketServicePage) yandexStartPage.navigateIntoYandexService("Маркет");
           //checking
            yandexMarketServicePage.chooseProductCategory("Компьютеры");
            yandexMarketServicePage.chooseProductType("Ноутбуки");
            yandexMarketServicePage.get

        } catch (Exception e){

        }

//        findProductHelper.navigateIntoYandexService("Маркет");
//        findProductHelper.chooseProductCategory("Компьютеры");
//        findProductHelper.chooseCatalogOfProducts("Ноутбуки");
//        findProductHelper.setPriceInSearchFilter(null, "30000");
//        findProductHelper.checkSearchParameter(new String[]{"Lenovo", "HP"});
//        findProductHelper.pressAcceptButton();
//        //Assert(10, findProductHelper.getCountOfResultsRows());
//        findProductHelper.rememberFirstElement();
//       // findProductHelper.setfindProductHelper.getRememberedFirstElement()
    }
}
