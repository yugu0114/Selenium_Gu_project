package testlaptops;

import org.junit.*;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.core.IsEqual.equalTo;
import webbrowser.instances.*;


/**
 * Created by 1 on 24.06.2017.
 */
public class Find_In_YandexMarket_Laptop_By_Price_and_Trade_Mark_Test {
    private static SearchLaptopInterface testFacade;

    @Rule
    public ErrorCollector collector= new ErrorCollector();

    @BeforeClass
    public static void beforeClass() {
        testFacade = new SearchLaptopFacade();
        testFacade.setWebBrowser(FirefoxStandaloneBrowser.getInstance());
    }

    @Test
    public void test1(){
        testFacade.getWebBrowser().manage().window().maximize();
        testFacade.getWebBrowser().switchTo();
        testFacade.getWebBrowser().navigate().to("https://yandex.ru");
        testFacade.openYandexMarket();
        testFacade.chooseComputersCategory();
        testFacade.chooseLaptopsCategory();
        testFacade.openFullFiltersPage();
        testFacade.setAppropriateLaptopPrice("", "30000");
        testFacade.checkLaptopMarkLenovo();
        testFacade.checkLaptopMarkHP();
        testFacade.pressAcceptFilterButton();

        collector.checkThat("Count of HP and Lenovo laptops which are cheaper than 30000 must be 10.",
                testFacade.getCountOfFoundLaptopsSatisfyingTheConditions(), // actual
                equalTo(10));                                                      //expected
    }

    @Test
    public void test2(){
        String rememberFirstElementName = testFacade.getFirstFoundedLaptopName();
        testFacade.findLaptopInMarketByName(rememberFirstElementName);
        String foundLaptopBySearchingField = testFacade.getFirstFoundedLaptopName();

        collector.checkThat("Checking global searching works fine for laptops.",
                rememberFirstElementName,
                equalTo(foundLaptopBySearchingField));
    }

    @AfterClass
    public static void afterClass(){
        testFacade.getWebBrowser().quit();// quit??
    }
}
