package hesias.selenium.practices.tests;

import hesias.selenium.practices.pages.HomePage;
import hesias.selenium.practices.pages.SearchResultsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest{

    @Test
    public void testSearchCyberpunk() {
        HomePage homePage =new HomePage(driver);
        homePage.open();
        homePage.searchGame("Cyberpunk");

        // Vérification URL
        assertTrue(
                driver.getCurrentUrl().contains("Cyberpunk"),
                "L'URL ne contient pas 'Cyberpunk'"
        );
    }

    @Test
    public void testSearchBindingOf() {
        HomePage homePage =new HomePage(driver);
        homePage.open();
        homePage.searchGame("Binding of").isDisplayed();

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        // Vérification affichage page résultats
        assertTrue(
                resultsPage.isDisplayed(),
                "La page de résultats n'est pas affichée"
        );
    }

    @Test
    public void testFirstResultContainsWitcher() {
        HomePage homePage =new HomePage(driver);
        homePage.open();
        homePage.searchGame("Witcher");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        // Vérification affichage page résultats
        assertTrue(
                resultsPage.getFirstGameTitle().contains("Witcher"),
                "Le premier résultat ne contient pas 'Witcher'"
        );
    }

    @Test
    public void testFilterGoodOldGames() {
        HomePage homePage =new HomePage(driver);
        homePage.open();
        homePage.searchGame("Cyberpunk");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        resultsPage.checkGOG();

    }

    @Test
    public void testRemoveFilter() {
        HomePage homePage =new HomePage(driver);
        homePage.open();
        homePage.searchGame("Cyberpunk");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        resultsPage.checkGOG();
        resultsPage.removeFilter();

    }


}
