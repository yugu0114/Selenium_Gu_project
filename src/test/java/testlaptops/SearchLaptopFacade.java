package testlaptops;

import exceptions.NotSuchServiceException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import yandex.constants.YandexMarketComputersConsts;
import yandex.constants.YandexMarketConsts;
import yandex.constants.YandexStartPageConsts;
import yandex.webelements.YandexStartPage;
import yandex.webelements.servicepages.yandexmarket.YandexMarketFullFilteringPage;
import yandex.webelements.servicepages.yandexmarket.YandexMarketServicePage;

/**
 * Created with IntelliJ IDEA.
 * User: yugu0114
 * Date: 21.06.17
 * Time: 15:28
 * To change this template use File | Settings | File Templates.
 */
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

    public void openYandexMarket(){
        try{
           startPage.openYandexMarketService(YandexStartPageConsts.SERVICE_MARKET);
        } catch(NotSuchServiceException ex) {

        }
    }

    public void chooseComputersCategory(){
//        try{
            marketPage.openProductCategoryCatalog(YandexMarketConsts.COMPUTERS);
//        } catch(Exception ex) {
//
//        }
    }

    public void chooseLaptopsCategory()  {
//        try{

            marketPage.openProductTypeCatalog(YandexMarketConsts.LAPTOPS);
//        } catch(Exception ex) {
//
//        }
    }
    public void openFullFiltersPage(){
//        try{
            marketPage.openFilteringPage();
            fullFilteringPage = new YandexMarketFullFilteringPage(webDriver);
//        } catch(Exception ex) {
//
//        }
    }

    public void setAppropriateLaptopPrice(String fromPrice, String toPrice){
//        try{
            YandexMarketServicePage page = (fullFilteringPage == null ? marketPage : fullFilteringPage);
            page.setPriceInSearchFilter(fromPrice, toPrice);
//        } catch(Exception ex) {
//
//        }
    }

    public void checkLaptopMarkLenovo(){
//        try{
            YandexMarketServicePage page = (fullFilteringPage == null ? marketPage : fullFilteringPage);//11!! нашли кмоп с помощью расширенного поиска вренулись на ноутбуки, то fullmultiplepage ,будет не налл. нужна лоогическая проверка!
            page.checkBySearchCondition(YandexMarketComputersConsts.LENOVO);

//        } catch(Exception ex) {
//
//        }
    }

    public void checkLaptopMarkHP(){
//        try{
            YandexMarketServicePage page = (fullFilteringPage == null ? marketPage : fullFilteringPage);
            page.checkBySearchCondition(YandexMarketComputersConsts.HP);

//        } catch(Exception ex) {

//        }
    }

    //...

    public void pressAcceptFilterButton(){
//        try{
            YandexMarketServicePage page = (fullFilteringPage == null ? marketPage : fullFilteringPage);
            page.performSearchingBySettedConditions();
//        } catch(Exception ex) {
//
//        }
    }

    public String getFirstFoundedLaptopName(){
//        try{
            return marketPage.getSearchResultList().get(0).getText();
//        } catch(Exception ex) {
//            //...
//            return "";
//        }
    }

    public int getCountOfFoundLaptopsSatisfyingTheConditions(){
//        try{
            return marketPage.getSearchResultList().size();
//        } catch(Exception ex) {
            //...
//            return 0;
//        }
    }

    public void findLaptopInMarketByName(String laptopName){
//        try{
            YandexMarketServicePage page = (fullFilteringPage == null ? marketPage : fullFilteringPage);
            page.performSearchingProductItemByName(laptopName);
//        } catch(Exception ex) {
//
//        }
    }
}
