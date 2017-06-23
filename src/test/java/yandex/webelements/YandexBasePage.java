package yandex.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import yandex.constants.YandexStartPageConsts;

import java.util.function.Predicate;

/**
 * Created by 1 on 20.06.2017.
 */
public class YandexBasePage {
//    protected final int pageLoadingLimitInSeconds = 90;
    private WebDriver webDriver;

    public YandexBasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        if (!webDriver.getCurrentUrl().isEmpty() && !webDriver.getCurrentUrl().contains(YandexStartPageConsts.YANDEX_DOMAIN)) {
            throw new IllegalStateException("This is not the yandex page");
        }
    }

    protected void waitForLoad(WebDriver driver)  {     //11 check it!!!
        new WebDriverWait(driver, 90).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

    }

    protected void waitForLoad(By locator)  {

        (new WebDriverWait(webDriver, 90))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }


//    protected WebElement waitForElement(WebDriver driver, By locator) {
//        return new WebDriverWait(driver, 90).until(ExpectedConditions.elementToBeClickable(locator));
//    }

//    protected void waitForJavaScript(WebDriver driver) {
//        new WebDriverWait(driver, 90).until(driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState")
//                .equals("complete")
//        );
//    }
//
//    protected void waitElementByLocator(By locator)
//    {
//        (new WebDriverWait(webDriver, 90))
//                .until(ExpectedConditions.elementToBeClickable(locator));
//
//        (new WebDriverWait(webDriver, 90))
//                .until(ExpectedConditions.presenceOfElementLocated(locator));
//
//            new
//                ExpectedCondition<Boolean>() {
//                    public Boolean apply(WebDriver driver) {
//                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
//                    }
//                };
//        // get the "Add Item" element
//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(addItem));
//
//  trigger the reaload of the page
//        driver.findElement(By.id("...")).click();
//
// wait the element "Add Item" to become stale
//        wait.until(ExpectedConditions.stalenessOf(element));
//
// click on "Add Item" once the page is reloaded
//        wait.until(ExpectedConditions.presenceOfElementLocated(addItem)).click();
//
//    }

//    protected void waitElementByLocator(By locator)
//    {
//        (new WebDriverWait(webDriver, 90))
//                .until(ExpectedConditions.presenceOfElementLocated(locator));
//
//        (new WebDriverWait(webDriver, 90))
//                .until(ExpectedConditions.visibilityOfElementLocated(locator));      //11
//
//
//        WebDriver driver = new AnyDriverYouWant();
//        JavascriptExecutor js;
//        if (driver instanceof JavascriptExecutor) {
//            js = (JavascriptExecutor)driver;
//        } // else throw...
//
// later on...
//        js.executeScript("return document.getElementById('someId');");
//    }

//    public SearchLaptopFacade(WebDriver webDriver){
//        setWebBrowser(webDriver);
//    }
}
