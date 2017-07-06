package testlaptops;

import org.openqa.selenium.WebDriver;

public interface SearchLaptopInterface {

    public void setWebBrowser(WebDriver browser);
    public WebDriver getWebBrowser();
    public void openYandexMarket();
    public void chooseComputersCategory();
    public void chooseLaptopsCategory();
    public void openFullFiltersPage();
    public void setAppropriateLaptopPrice(String fromPrice, String toPrice);
    public void checkOptions(String[] options);
    public void pressAcceptFilterButton();
    public String getFirstFoundedLaptopName();
    public int getCountOfFoundLaptopsSatisfyingTheConditions();
    public void findLaptopInMarketByName(String laptopName);
}
