package testlaptops; /**
 * Created by 1 on 15.06.2017.
 */

import org.junit.*;
import org.openqa.selenium.*;
import webbrowser.instances.*;

import static org.junit.Assert.assertEquals;

public class Find_In_YandexMarket_Lenovo_or_HP_Laptop_Which_is_Cheaper_than_30_Test {
    private WebDriver driver;
    private SearchLaptopInterface testFacade = new SearchLaptopFacade();

    @Before
    public void openFFBrowserAndSetItToFullscreen() {
        driver = FirefoxStandaloneBrowser.getInstance();
        driver.manage().window().maximize();
        driver.switchTo();
    }

    @Test
    public void find_In_YandexMarket_Lenovo_or_HP_Laptop_Which_is_Cheaper_than_30(){
        driver.get("http://yandex.ru");
        testFacade.setWebBrowser(driver);
        testFacade.openYandexMarket();
        testFacade.chooseComputersCategory();
        testFacade.chooseLaptopsCategory();
        testFacade.openFullFiltersPage();
        testFacade.setAppropriateLaptopPrice("", "30000");
        testFacade.checkLaptopMarkLenovo();
        testFacade.checkLaptopMarkHP();
        testFacade.pressAcceptFilterButton();

        assertEquals(10, testFacade.getCountOfFoundLaptopsSatisfyingTheConditions());

        String rememberFirstElement = testFacade.getFirstFoundedLaptopName();
        testFacade.findLaptopInMarketByName(rememberFirstElement);
        String foundLaptopBySearchingField = testFacade.getFirstFoundedLaptopName();

        assertEquals(rememberFirstElement, foundLaptopBySearchingField);
    }
}
