package testlaptops;

import org.junit.*;
import org.junit.rules.ErrorCollector;
import webbrowser.instances.FirefoxStandaloneBrowser;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by 1 on 24.06.2017.
 */
@FixMethodOrder
public class Find_In_YandexMarket_Laptop_By_Price_and_Trade_Mark_Test {
    private static SearchLaptopInterface testFacade;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void beforeClass() {
        testFacade = new SearchLaptopFacade();
        testFacade.setWebBrowser(FirefoxStandaloneBrowser.getInstance());
    }

    @Test
    public void count_of_HP_and_Lenovo_laptops_which_are_cheaper_than_30000_must_be_10(){
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
        int resultRowsCount = testFacade.getCountOfFoundLaptopsSatisfyingTheConditions();

        collector.checkThat("Count of HP and Lenovo laptops which are cheaper than 30000 isn't 10 -> AR: "+ resultRowsCount,
                resultRowsCount, // actual
                equalTo(10));  //expected
    }

    @Test
    public void checking_global_searching_works_fine_for_laptops(){
        String rememberFirstElementName = testFacade.getFirstFoundedLaptopName();
        testFacade.findLaptopInMarketByName(rememberFirstElementName);
        String foundLaptopBySearchingField = testFacade.getFirstFoundedLaptopName();

        collector.checkThat("Checking global searching works fine for laptops -> AR: "+foundLaptopBySearchingField,
                rememberFirstElementName,
                equalTo(foundLaptopBySearchingField));
    }

    @AfterClass
    public static void afterClass(){
        testFacade.getWebBrowser().quit();// quit??
    }
}
