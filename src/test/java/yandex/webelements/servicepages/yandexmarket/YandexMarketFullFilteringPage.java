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

    public void clickShowAppropriateButton(){
        webDriver.findElement(By.className("button_action_show-filtered")).click();  // Показать все подходящие
    }

    public void clickClearFiltersButton(){
        webDriver.findElement(By.className("button_action_n-filter-reset")).click();   // Сбросить фильтры
    }

    public void clickCancelAndReturnButton(){
        webDriver.findElement(By.className("button_action_cancel-return")).click(); // Отменить и вернуться
    }


}
