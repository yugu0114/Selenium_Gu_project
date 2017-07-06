package yandex.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexBasePage {
    protected final int pageLoadingLimitInSeconds = 90;
    private WebDriver webDriver;

    public YandexBasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    protected void waitForLoad(WebDriver webDriver)  {     //11
        new WebDriverWait(webDriver, pageLoadingLimitInSeconds).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

    }

    protected void waitForLoad(By locator)  {

        (new WebDriverWait(webDriver, pageLoadingLimitInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
