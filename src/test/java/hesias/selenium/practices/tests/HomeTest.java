package hesias.selenium.practices.tests;

import hesias.selenium.practices.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    @Feature("Home action")
    @Description("Test de l'affichage de la page d'accueil")
    public void testHomePageIsDisplayed() {
        HomePage homePage = new HomePage(driver);

        homePage.open();

        assertTrue(homePage.isDisplayed(), "La page d'accueil ne s'affiche pas correctement");
        assertTrue(homePage.homeLinkExists(), "Le lien pour revenir à la page d'accueil n'existe pas");
    }

    @Test
    @Feature("Home action")
    @Description("Test de l'utilisation du slider de la page d'accueil vers la gauche")
    public void testSliderLeft() {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.useSliderLeft();
        homePage.isBottomSliderIconActive();
    }

    @Test
    @Feature("Home action")
    @Description("Test de qqch je sais plus")
    public void testGoToGamePage() {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.useFirstSwipper();
    }


}
