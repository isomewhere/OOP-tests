package tests;

import base.BaseTest;
import configuration.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;
import pages.SearchResultPage;
import pages.WikiPage;

class TestRunner extends BaseTest {
    static GooglePage googlePage;
    static SearchResultPage searchResultPage;
    static WikiPage wikiPage;


    @BeforeAll
    public static void setUp() {
        WebDriverManager.open();
        WebDriver driver = WebDriverManager.getDriver();
        googlePage = new GooglePage(driver);
        searchResultPage = new SearchResultPage(driver);
        wikiPage = new WikiPage(driver);
    }

    @Test
    void runTest() {

        open("https://www.google.com");

        googlePage.search("гладиолус");

        searchResultPage.openSearchResultItem("Википедия");

        wikiPage.assertWikiPageTitle();
    }
}