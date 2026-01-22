package hesias.selenium.practices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends hesias.selenium.practices.pages.BasePage {

    private final By firstTitle = By.xpath("/html/body/div[1]/app-root/div/div/app-page/catalog/div/catalog-content/div/div[2]/paginated-products-grid/div/product-tile[1]/a/div[2]/div[1]/product-title/span");
    private final By checkBoxGOG = By.cssSelector("input[class='checkbox__input filter-option__checkbox']");
    private final By clearFilters = By.cssSelector("div[class='filter-clearing-item__wrapper']");
    private final By filterTag   = By.cssSelector("#filterClearingItemLabel");


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return getCurrentUrl().contains("https://www.gog.com/fr/games");
    }

    public String getFirstGameTitle() {
            return getText(firstTitle);
    }


    public void checkGOG() {
        waitClick(checkBoxGOG).click();
        filterTag.toString().contains("Good old games");
    }

    public void removeFilter() {
        waitClick(clearFilters).click();
    }

}
