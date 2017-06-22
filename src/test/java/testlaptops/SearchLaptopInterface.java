package testlaptops;

import exceptions.NotSuchServiceException;
import org.openqa.selenium.WebDriver;
import yandex.constants.YandexMarketComputersConsts;
import yandex.constants.YandexMarketConsts;
import yandex.constants.YandexStartPageConsts;
import yandex.webelements.servicepages.yandexmarket.YandexMarketServicePage;

/**
 * Created by 1 on 21.06.2017.
 */
public interface SearchLaptopInterface {

    public void setWebBrowser(WebDriver browser);
    public void openYandexMarket();
    public void chooseComputersCategory();
    public void chooseLaptopsCategory();
    public void openFullFiltersPage();
    public void setAppropriateLaptopPrice(String fromPrice, String toPrice);
    public void checkLaptopMarkLenovo();
    public void checkLaptopMarkHP();
    //...
    public void pressAcceptFilterButton();
    public String getFirstFoundedLaptopName();
    public int getCountOfFoundLaptopsSatisfyingTheConditions();
    public void findLaptopInMarketByName(String laptopName);
}
