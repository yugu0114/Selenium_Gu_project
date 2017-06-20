import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by 1 on 18.06.2017.
 */
public class FindHtmlElementsInUI {
    private static WebDriver webDriver;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver(){
        if (webDriver == null)
            webDriver = new FirefoxDriver(); //by default

        return webDriver;
    }

    public WebElement findLinkByDataId(String nameOfService)
    {
        return webDriver.findElement(By.xpath("//a[@data-id=\"" + nameOfService + "\"]"));
    }

    public WebElement findChildLinkInParentListItemByDataDepartmentParameter(String nameOfCategory)
    {
        return webDriver.findElement(By.xpath("//li[@data-department=\"" + nameOfCategory + "\"]/a[@class=\"link topmenu__link\"]"));
    }

    public WebElement findLinkByText(String nameOfCatalog)
    {
         return webDriver.findElement(By.linkText(nameOfCatalog));
    }

    public WebElement findLinkByLabelTextInRelativeLabel(String searchParameter)
    {
        return webDriver.findElement(By.xpath("//label[text()=\"" + searchParameter + "\"]"));
    }

    public WebElement findInputFieldById(String id)
    {
        return webDriver.findElement(By.id(id));
    }

    public List<WebElement> findSpanByCSSClass(String classname)
    {
        return webDriver.findElements(By.className(classname));
    }

    public WebElement findButtonByText(String buttonLabel)
    {
        return webDriver.findElement(By.xpath("//button [span [.=\"" + buttonLabel + "\"]]"));
    }
}
