package hesias.selenium.practices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By buttonSearch = By.cssSelector("a[class='menu-link menu-link--last menu-link--search menu-link--icon']");
    private final By inputSearch = By.cssSelector("input[hook-test='menuSearchInput']");

    private final By homeLink = By.cssSelector("a[href='/fr']");

    private final By sliderLeftButton = By.cssSelector("div[aria-label='Previous slide']");
    private final By sliderBottomIcon = By.xpath("/html/body/div[2]/app-root/div/div/app-page/big-spot-section/section/div/slider-navigation/div/div/div[1]/swiper/div[1]/span[15]");

    private final By firstGameSwipper = By.cssSelector("div[class='swiper-slide swiper-slide-visible swiper-slide-active']");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        goTo(ROOT_URL);
        refuseCookie();
    }

    public SearchResultsPage searchGame(String gameName) {
        waitClick(buttonSearch).click();
        type(inputSearch, gameName + Keys.ENTER);
        return new SearchResultsPage(this.driver);
    }

    public boolean isDisplayed() {
        return getCurrentUrl().equals("https://www.gog.com/fr/");
    }

    public boolean homeLinkExists() {
        return !driver.findElements(homeLink).isEmpty();
    }

    public HomePage changeLanguage(String string) {
        goTo(ROOT_URL.replace("fr", string));
        refuseCookie();
        return this;
    }

    public void useSliderLeft() {
        waitClick(sliderLeftButton).click();
    }
    public void isBottomSliderIconActive() {
        String classAttribute =
                waitUntil(sliderBottomIcon).getAttribute("class");
    }

    public GamePage useFirstSwipper() {
        scrollTo(firstGameSwipper);
        waitClick(firstGameSwipper).click();
        return new GamePage(this.driver);
    }

}
