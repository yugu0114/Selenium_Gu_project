package testlaptops; /**
 * Created by 1 on 15.06.2017.
 */

//import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import webbrowser.instances.*;

import static org.junit.Assert.assertEquals;

public class Find_In_YandexMarket_Lenovo_or_HP_Laptop_Which_is_Cheaper_than_30_Test {
    private WebDriver driver;
    private SearchLaptopInterface testFacade;

    @Before
    public void openFFBrowserAndSetItToFullscreen() {
        driver = FirefoxStandaloneBrowser.getInstance();
        driver.manage().window().maximize();
        driver.switchTo();
        testFacade = new SearchLaptopFacade();
        testFacade.setWebBrowser(driver);
    }

    @Test
    public void find_In_YandexMarket_Lenovo_or_HP_Laptop_Which_is_Cheaper_than_30(){
        driver.get("https://market.yandex.ru/catalog/54544/list?hid=91013&glfilter=7893318%3A152981%2C152722&onstock=1&deliveryincluded=0&priceto=30000&local-offers-first=0");

       // testFacade.openYandexMarket();
       // testFacade.chooseComputersCategory();
       // testFacade.chooseLaptopsCategory();
       // testFacade.openFullFiltersPage();
       // testFacade.setAppropriateLaptopPrice("", "30000");
       // testFacade.checkLaptopMarkLenovo();
       // testFacade.checkLaptopMarkHP();
       // testFacade.pressAcceptFilterButton();

        assertEquals(10, testFacade.getCountOfFoundLaptopsSatisfyingTheConditions());

        String rememberFirstElement = testFacade.getFirstFoundedLaptopName();
        testFacade.findLaptopInMarketByName(rememberFirstElement);
        String foundLaptopBySearchingField = testFacade.getFirstFoundedLaptopName();

        assertEquals(rememberFirstElement, foundLaptopBySearchingField);
    }

    @Test
    public void find_In_YandexMarket_Laptop_By_Name_in_Global_Searching(){
        driver.get("https://market.yandex.ru/catalog/54544/list?hid=91013&glfilter=7893318%3A152981%2C152722&onstock=1&deliveryincluded=0&priceto=30000&local-offers-first=0");

        String rememberFirstElement = testFacade.getFirstFoundedLaptopName();
        testFacade.findLaptopInMarketByName(rememberFirstElement);
        String foundLaptopBySearchingField = testFacade.getFirstFoundedLaptopName();

        assertEquals(rememberFirstElement, foundLaptopBySearchingField);
    }

    @After
    public void closeBrowser(){
        driver.close();// quit??
    }

}
