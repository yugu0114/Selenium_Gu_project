package yandex.webelements.servicepages.yandexmarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import yandex.constants.YandexMarketConsts;
import yandex.webelements.servicepages.YandexServicePage;

import java.util.List;

/**
 * Created by 1 on 20.06.2017.
 */
public class YandexMarketServicePage extends YandexServicePage {

    private WebDriver webDriver;
    private WebElement resultTable;
    private List<WebElement> resultTableRows;
    private WebElement filterMenu;

    public YandexMarketServicePage(WebDriver webDriver)
    {
        super(webDriver);
        this.webDriver = webDriver;

        resultTable = this.webDriver.findElement(By.className("n-filter-applied-results"));
        if (resultTable != null) resultTableRows = resultTable.findElements(By.className("snippet-card__header-text"));

        filterMenu = this.webDriver.findElement(By.className("n-filter-panel-aside__content"));
    }

    public List<WebElement> getSearchResultList() {
        return resultTableRows;
    }

    public void pressAcceptFilterButton(){
        filterMenu.findElement(By.xpath("//button [span [.=\"" + YandexMarketConsts.ACCEPT_BUTTON_ON_FILTER + "]]")).click();
    }

    public YandexMarketFullFilteringPage openAndReturnFilteringPage(){
        filterMenu.findElement(By.linkText(YandexMarketConsts.SHOW_ALL_FILTER_CONDITIONS)).click();
        return new YandexMarketFullFilteringPage(webDriver);
    }

    public void findTheProductItemByName(String productName) {
        webDriver.findElement(By.id("header-search")).sendKeys(productName);
        webDriver.findElement(By.xpath("//button [span [.=\"" + YandexMarketConsts.SEARCH + "\"]]")).click();
    }

    public void setPriceInSearchFilter(String fromPrice, String toPrice)
    {
        if (!fromPrice.isEmpty())   {
            WebElement fromPriceField= webDriver.findElement(By.id("glf-pricefrom-var"));
            fromPriceField.click();
            fromPriceField.sendKeys(fromPrice);
        }

        if (!toPrice.isEmpty()) {
            WebElement toPriceField = webDriver.findElement(By.id("glf-priceto-var"));
            toPriceField.click();
            toPriceField.sendKeys(toPrice);
        }
    }

    public void checkBySearchCondition(String searchParameter){
        webDriver.findElement(By.xpath("//label[text()=\"" + searchParameter + "\"]")).click(); // checkboxes
    }

    public void chooseProductCategory(String nameOfCategory)
    {
        webDriver.findElement(By.xpath("//li[@data-department=\"" + nameOfCategory + "\"]/a[@class=\"link topmenu__link\"]")).click();  //Компьютеры
    }

    public void chooseProductType(String typeOfProduct)
    {
        webDriver.findElement(By.linkText(typeOfProduct)).click();        //Ноутбуки
    }
}
