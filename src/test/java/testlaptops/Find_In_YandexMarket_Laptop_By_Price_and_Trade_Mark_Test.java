package testlaptops;

import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import webbrowser.instances.BrowserConsts;
import webbrowser.instances.ChromeStandaloneBrowser;
import webbrowser.instances.FirefoxStandaloneBrowser;
import webbrowser.instances.IEStandaloneBrowser;
import yandex.constants.YandexMarketComputersConsts;

import java.util.Arrays;
import java.util.NoSuchElementException;


@FixMethodOrder
@RunWith(Parameterized.class)
@Features("Yandex Market")
@Stories("Test searching laptops")
public class Find_In_YandexMarket_Laptop_By_Price_and_Trade_Mark_Test {
    private static SearchLaptopInterface testFacade;

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {BrowserConsts.FIREFOX, "", "30000", new String[]{YandexMarketComputersConsts.HP, YandexMarketComputersConsts.LENOVO}},
                {BrowserConsts.FIREFOX, "20000", "25000", new String[]{YandexMarketComputersConsts.DELL, YandexMarketComputersConsts.ACER}}
        });
    }

    private String testInBrowser;
    private String priceFrom;
    private String priceTo;
    private String[] options;

    public Find_In_YandexMarket_Laptop_By_Price_and_Trade_Mark_Test(String browserName, String priceFrom, String priceTo, String[] options) {
        this.testInBrowser = browserName;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.options = options;
    }

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void beforeClass() {
        testFacade = new SearchLaptopFacade();
    }

    public void openBrowser() {
        try{
            switch (testInBrowser){
                case BrowserConsts.FIREFOX:
                    testFacade.setWebBrowser(FirefoxStandaloneBrowser.getInstance());
                    break;
                case BrowserConsts.IE:
                    testFacade.setWebBrowser(IEStandaloneBrowser.getInstance());
                    break;
                case BrowserConsts.CHROME:
                    testFacade.setWebBrowser(ChromeStandaloneBrowser.getInstance());
                    break;
                default:
                    testFacade.setWebBrowser(FirefoxStandaloneBrowser.getInstance());
                    break;
            }

            testFacade.getWebBrowser().manage().window().maximize();
            testFacade.getWebBrowser().switchTo();

        }catch(SessionNotCreatedException e){

        }
    }

    @Title("First check: check if searching results equals to 10")
    @Test
    public void count_of_HP_and_Lenovo_laptops_which_are_cheaper_than_30000_must_be_10(){
      try {
          openBrowser();

          testFacade.getWebBrowser().navigate().to("https://yandex.ru");
          testFacade.openYandexMarket();
          testFacade.chooseComputersCategory();
          testFacade.chooseLaptopsCategory();
          testFacade.openFullFiltersPage();
          testFacade.setAppropriateLaptopPrice(priceFrom, priceTo);
          testFacade.checkOptions(options);
          testFacade.pressAcceptFilterButton();
          int resultRowsCount = testFacade.getCountOfFoundLaptopsSatisfyingTheConditions();

          Assert.assertEquals("Count of laptops (" + options.toString()+" and price between "+ priceFrom+", "+priceTo+") in result tests isn't 10. Results: " + resultRowsCount,
                  resultRowsCount, // actual
                  10);  //expected
      } catch (SessionNotCreatedException exception){
        Assert.fail(exception.getMessage());
      } catch (NoSuchElementException exception){
        Assert.fail(exception.getMessage());
      } catch (UnreachableBrowserException exception){
        Assert.fail(exception.getMessage());
      } catch (TimeoutException exception){
        Assert.fail(exception.getMessage());
      } catch (WebDriverException exception){
        Assert.fail(exception.getMessage());
      } catch (Exception exception){
        Assert.fail(exception.getMessage());
      }
    }

    @Title("Second check: check if searching by filter and global searching returns the same item")
    @Test
    public void checking_global_searching_works_fine_for_laptops(){
        String rememberFirstElementName = testFacade.getFirstFoundedLaptopName();
        testFacade.findLaptopInMarketByName(rememberFirstElementName);
        String foundLaptopBySearchingField = testFacade.getFirstFoundedLaptopName();

        Assert.assertEquals("Checking global searching works fine for laptops. Results: " + foundLaptopBySearchingField,
                 rememberFirstElementName,
                 foundLaptopBySearchingField);
    }

    @AfterClass
    public static void afterClass(){
        testFacade.getWebBrowser().quit();
    }
}
