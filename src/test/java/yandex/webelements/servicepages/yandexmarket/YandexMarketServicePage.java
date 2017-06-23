package yandex.webelements.servicepages.yandexmarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import yandex.constants.YandexMarketConsts;
import yandex.webelements.servicepages.YandexServicePage;

import java.util.List;

/**
 * Created by 1 on 20.06.2017.
 */
public class YandexMarketServicePage extends YandexServicePage {
    private WebDriver webDriver;

    public YandexMarketServicePage(WebDriver webDriver)
    {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public List<WebElement> getSearchResultList() {
        waitForLoad(webDriver);
        return webDriver.findElements(By.xpath("//span[contains(@class,\"snippet-card__header-text\")]"));
    }

    public void performSearchingBySettedConditions(){
        waitForLoad(webDriver);
        webDriver.findElement(By.xpath("//button [span [.=\"" + YandexMarketConsts.ACCEPT_BUTTON_ON_FILTER + "]]")).click();
    }

    public void openFilteringPage(){

        By locator = By.linkText(YandexMarketConsts.SHOW_ALL_FILTER_CONDITIONS);
        waitForLoad(locator);
        webDriver.findElement(locator).click();
    }

    public void performSearchingProductItemByName(String productName) {
        waitForLoad(webDriver);
        webDriver.findElement(By.id("header-search")).sendKeys(productName);
        webDriver.findElement(By.xpath("//button [span [.=\"" + YandexMarketConsts.SEARCH + "\"]]")).click();
    }

    public void setPriceInSearchFilter(String fromPrice, String toPrice)
    {
        waitForLoad(webDriver);
        if (fromPrice != null && !fromPrice.isEmpty())   {
            WebElement fromPriceField= webDriver.findElement(By.id("glf-pricefrom-var"));
            fromPriceField.click();
            fromPriceField.sendKeys(fromPrice);
        }

        if (toPrice != null && !toPrice.isEmpty()) {
            WebElement toPriceField = webDriver.findElement(By.id("glf-priceto-var"));
            toPriceField.click();
            toPriceField.sendKeys(toPrice);
        }
    }

    public void checkBySearchCondition(String searchParameter){
        waitForLoad(webDriver);
        webDriver.findElement(By.xpath("//label[text()=\"" + searchParameter + "\"]")).click(); // checkboxes
    }

    // e.g. Компьютеры
    public void openProductCategoryCatalog(String nameOfCategory)
    {
        By locator = By.linkText(nameOfCategory);
        waitForLoad(locator);
        webDriver.findElement(locator).click();
    }

     //e.g. Ноутбуки
    public void openProductTypeCatalog(String typeOfProduct)
    {
        By locator = By.xpath("//a[text()=\"" + YandexMarketConsts.LAPTOPS + "\" and contains(@class,\"catalog-menu__list-item\")]");
        waitForLoad(webDriver);
        webDriver.findElement(locator).findElement(locator).click();
    }
}
