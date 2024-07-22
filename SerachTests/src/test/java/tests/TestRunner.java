package tests;

import base.BaseTest;
import configuration.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.GooglePage;
import pages.SearchResultPage;
import pages.WikiPage;

class TestRunner extends BaseTest {
    static GooglePage googlePage;
    static SearchResultPage searchResultPage;
    static WikiPage wikiPage;

    @BeforeAll
    public static void setUp() {
        new BaseTest().startBrowser();

        googlePage = new GooglePage(WebDriverManager.getDriver());
        searchResultPage = new SearchResultPage(WebDriverManager.getDriver());
        wikiPage = new WikiPage(WebDriverManager.getDriver());
    }

    @Test
    void runTest() {

        open("https://www.google.com");

        googlePage.search("гладиолус");

        searchResultPage.openSearchResultItem("Википедия");

        wikiPage.assertWikiPageTitle();
    }
}