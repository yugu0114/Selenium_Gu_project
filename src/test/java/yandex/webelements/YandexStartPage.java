package yandex.webelements;

import exceptions.NotSuchServiceException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import yandex.constants.YandexStartPageConsts;
import yandex.webelements.servicepages.yandexmarket.YandexMarketServicePage;
import yandex.webelements.servicepages.YandexServicePage;

/**
 * Created by 1 on 20.06.2017.
 */
public class YandexStartPage extends YandexBasePage {
    private WebDriver webDriver;

    public YandexStartPage(WebDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    public void openYandexMarketService(String nameOfService) throws NotSuchServiceException
    {
        By locator = By.linkText(YandexStartPageConsts.SERVICE_MARKET);
        waitForLoad(locator);
        webDriver.findElement(locator).click();    //Маркет
    }
}
