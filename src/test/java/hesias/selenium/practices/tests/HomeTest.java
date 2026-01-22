package hesias.selenium.practices.tests;

import hesias.selenium.practices.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    public void testHomePageIsDisplayed() {
        HomePage homePage = new HomePage(driver);

        homePage.open();

        assertTrue(homePage.isDisplayed(), "La page d'accueil ne s'affiche pas correctement");
        assertTrue(homePage.homeLinkExists(), "Le lien pour revenir à la page d'accueil n'existe pas");
    }

    @Test
    public void testSliderLeft() {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.useSliderLeft();
        homePage.isBottomSliderIconActive();
    }

    @Test
    public void testGoToGamePage() {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.useFirstSwipper();
    }


}
