import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by 1 on 18.06.2017.
 */
public interface FindProductInYandexMarket {

    public void navigateIntoYandexService(String nameOfService);
    public void chooseProductCategory(String nameOfCategory);
    public void chooseCatalogOfProducts(String nameOfCatalog);
    public void setPriceInSearchFilter(String fromPrice, String toPrice);
    public void checkSearchParameter(String[] searchParameter);
    public void pressAcceptButton();
    public void rememberFirstElement();
    public int getCountOfResultsRows();
    public WebElement getRememberedFirstElement();
    public void setBrowserForTest(String webBrowserName);
    public WebDriver getWebDriverInstance();
}
