package hesias.selenium.practices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkPage extends BasePage {

    private final By footerCareerOpportunities = By.cssSelector("li[hook-test='footerCareerOpportunities']");

    public WorkPage(WebDriver driver) {
        super(driver);
    }

    public WorkPage goToJobOfferInput(){
            scrollTo(footerCareerOpportunities);
            waitClick(footerCareerOpportunities).click();
            return new WorkPage(this.driver);

    }
}
