package tests;

import base.BaseTest;
import configuration.WebDriverManager;
import org.junit.jupiter.api.Test;
import pages.GooglePage;
import pages.SearchResultPage;
import pages.WikiPage;


class TestRunner extends BaseTest {

    @Test
    void runTest() {
        WebDriverManager.startBrowser();
        open("https://www.google.com");
        GooglePage googlePage = new GooglePage(WebDriverManager.getDriver());
        googlePage.search("гладиолус");

        SearchResultPage searchResultPage = new SearchResultPage(WebDriverManager.getDriver());
        searchResultPage.openSearchResultItem("Википедия");

        WikiPage wikiPage = new WikiPage(WebDriverManager.getDriver());
        wikiPage.assertWikiPageTitle();
    }
}


