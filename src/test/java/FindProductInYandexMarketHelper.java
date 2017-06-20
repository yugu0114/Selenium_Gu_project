/**
 * Created by 1 on 15.06.2017.
 */
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FindProductInYandexMarketHelper extends FindHtmlElementsInUI implements FindProductInYandexMarket {
    WebElement firstElement;

    public void setBrowserForTest(String webBrowserName){
        switch (webBrowserName){
            case "Chrome":
                setWebDriver(new ChromeDriver());
                break;
            case "Firefox":
                setWebDriver(new FirefoxDriver());
                break;
            case "IE":
                setWebDriver(new InternetExplorerDriver());
                break;
            default:
                setWebDriver(new FirefoxDriver());
                break;
        }
    }

    public WebDriver getWebDriverInstance(){
        return getWebDriver();
    }

    public void navigateIntoYandexService(String nameOfService)
    {
        findLinkByText(nameOfService).click();    //Маркет
    }

    public void chooseProductCategory(String nameOfCategory)
    {
        findLinkByText(nameOfCategory).click();  //Компьютеры
    }

    public void chooseCatalogOfProducts(String nameOfCatalog)
    {
        findLinkByText(nameOfCatalog).click();        //Ноутбуки
    }

    public void setPriceInSearchFilter(String fromPrice, String toPrice)
    {
        if (!fromPrice.isEmpty())   {
           // WebElement fromPriceField= webDriver.findElement(By.id("glf-pricefrom-var"));
            WebElement fromPriceField= findInputFieldById(fromPrice);
            fromPriceField.click();
            fromPriceField.sendKeys(fromPrice);
        }

        if (!toPrice.isEmpty()) {
          //  WebElement toPriceField = webDriver.findElement(By.id("glf-priceto-var"));
            WebElement toPriceField= findInputFieldById(toPrice);
            toPriceField.click();
            toPriceField.sendKeys(toPrice);
        }
    }

    public void checkSearchParameter(String[] searchParameter)
    {
        for (String searchItem : searchParameter) {
            findLinkByLabelTextInRelativeLabel(searchItem).click();
        }
    }

    public void pressAcceptButton(){
        findButtonByText("Применить");
    }

    public int getCountOfResultsRows()
    {
        return findSpanByCSSClass("snippet-card__header-text").size();//11
    }

    public void rememberFirstElement(){
        firstElement = findSpanByCSSClass("snippet-card__header-text").get(0);
    }

    public WebElement getRememberedFirstElement(){
         return firstElement;
    }
}
