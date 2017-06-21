package testfacades;

import exceptions.NotSuchServiceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import yandex.constants.YandexMarketComputersConsts;
import yandex.constants.YandexMarketConsts;
import yandex.constants.YandexStartPageConsts;
import yandex.webelements.YandexStartPage;
import yandex.webelements.servicepages.yandexmarket.YandexMarketFullFilteringPage;
import yandex.webelements.servicepages.yandexmarket.YandexMarketServicePage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yugu0114
 * Date: 21.06.17
 * Time: 15:28
 * To change this template use File | Settings | File Templates.
 */
public class SearchLaptopFacade {
    private WebDriver webDriver;
    private YandexStartPage startPage;
    private YandexMarketServicePage marketPage;
    private YandexMarketFullFilteringPage fullFilteringPage;

    public void chooseLaptopsCategory(){
        try{
            marketPage = (YandexMarketServicePage) startPage.navigateIntoAndReturnYandexService(YandexStartPageConsts.SERVICE_MARKET);
            marketPage.chooseProductCategory(YandexMarketConsts.COMPUTERS);
            marketPage.chooseProductType(YandexMarketConsts.LAPTOPS);
            fullFilteringPage = marketPage.openAndReturnFilteringPage();
        } catch(NotSuchServiceException ex) {

        }
    }

    public void openFullFiltersPage(){
        try{
            fullFilteringPage = marketPage.openAndReturnFilteringPage();

        } catch(Exception ex) {

        }
    }

    public void setAppropriateLaptopPrice(String fromPrice, String toPrice){
        try{
            fullFilteringPage.setPriceInSearchFilter(null, "30000");

        } catch(Exception ex) {

        }
    }

    public void checkLaptopMarkLenovo(String fromPrice, String toPrice){
        try{
            fullFilteringPage.checkBySearchCondition(YandexMarketComputersConsts.LENOVO);

        } catch(Exception ex) {

        }
    }

    public void checkLaptopMarkHP(String fromPrice, String toPrice){
        try{
            fullFilteringPage.checkBySearchCondition(YandexMarketComputersConsts.LENOVO);

        } catch(Exception ex) {

        }
    }

    //...

    public void performSearchingBySettedConditions(){
        try{
            fullFilteringPage.pressAcceptFilterButton();
        } catch(Exception ex) {

        }
    }

    public String getFirstFoundedLaptopName(){
        try{
            return fullFilteringPage.getSearchResultList().get(0).getText();
        } catch(Exception ex) {
            //...
            return "";
        }
    }

    public void getCountOfFoundLaptopsSatisfyingTheConditions(){
        try{
            fullFilteringPage.getSearchResultList().size();
        } catch(Exception ex) {

        }
    }

    public void findLaptopInMarketByName(String laptopName){
        try{
            fullFilteringPage.findTheProductItemByName(laptopName);
        } catch(Exception ex) {

        }
    }
}
