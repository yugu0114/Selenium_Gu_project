package testlaptops;

import exceptions.NotSuchServiceException;
import org.openqa.selenium.WebDriver;
import yandex.constants.YandexMarketConsts;
import yandex.constants.YandexStartPageConsts;
import yandex.webelements.YandexStartPage;
import yandex.webelements.servicepages.yandexmarket.YandexMarketFullFilteringPage;
import yandex.webelements.servicepages.yandexmarket.YandexMarketServicePage;

public class SearchLaptopFacade implements SearchLaptopInterface {
    private WebDriver webDriver;
    private YandexStartPage startPage;
    private YandexMarketServicePage marketPage;
    private YandexMarketFullFilteringPage fullFilteringPage;

    public void setWebBrowser(WebDriver browser){
        webDriver = browser;
        if (startPage == null) startPage = new YandexStartPage(webDriver);
        if (marketPage == null) marketPage = new YandexMarketServicePage(webDriver);
    }

    public WebDriver getWebBrowser(){
        return webDriver;
    }

    public void openYandexMarket(){
        try{
           startPage.openYandexMarketService(YandexStartPageConsts.SERVICE_MARKET);
        } catch(NotSuchServiceException ex) {

        }
    }

    public void chooseComputersCategory(){
            marketPage.openProductCategoryCatalog(YandexMarketConsts.COMPUTERS);
    }

    public void chooseLaptopsCategory()  {
            marketPage.openProductTypeCatalog(YandexMarketConsts.LAPTOPS);
    }

    public void openFullFiltersPage(){
            marketPage.openFilteringPage();
            fullFilteringPage = new YandexMarketFullFilteringPage(webDriver);
    }

    public void setAppropriateLaptopPrice(String fromPrice, String toPrice){
            marketPage.setPriceInSearchFilter(fromPrice, toPrice);
    }

    public void checkOptions(String[] options){
          for (String option: options){
              marketPage.checkBySearchCondition(option);
          }
    }

    public void pressAcceptFilterButton(){
            YandexMarketServicePage page = (fullFilteringPage == null ? marketPage : fullFilteringPage);
            page.performSearchingBySettedConditions();
    }

    public String getFirstFoundedLaptopName(){
            return marketPage.getSearchResultList().get(0).getText();
    }

    public int getCountOfFoundLaptopsSatisfyingTheConditions(){
            return marketPage.getSearchResultList().size();
    }

    public void findLaptopInMarketByName(String laptopName){
            marketPage.performSearchingProductItemByName(laptopName);
    }
}
