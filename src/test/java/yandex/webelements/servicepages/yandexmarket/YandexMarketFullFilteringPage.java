package yandex.webelements.servicepages.yandexmarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by 1 on 21.06.2017.
 */
public class YandexMarketFullFilteringPage extends YandexMarketServicePage {
    private WebDriver webDriver;

    public YandexMarketFullFilteringPage(WebDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    public void performSearchingBySettedConditions(){
        By locator = By.className("button_action_show-filtered");
        waitForLoad(locator);
        webDriver.findElement(locator).click();  // Показать все подходящие
    }

    public void pressClearFiltersButton(){
        By locator = By.className("button_action_n-filter-reset");
        waitForLoad(locator);
        webDriver.findElement(locator).click();   // Сбросить фильтры
    }

    public void pressCancelAndReturnButton(){
        By locator = By.className("button_action_cancel-return");
        waitForLoad(locator);
        webDriver.findElement(locator).click(); // Отменить и вернуться
    }
}
