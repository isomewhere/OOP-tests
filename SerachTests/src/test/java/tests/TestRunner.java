package tests;

import base.BaseTest;
import configuration.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SearchResultPage;


class TestRunner extends BaseTest {

    @Test
    void runTest() {
        setUp();

        googleSearchPage("гладиолус");

        SearchResultPage searchResultPage = new SearchResultPage(WebDriverManager.getDriver());
        searchResultPage.openSearchResultItem("Википедия");

        String pageTitle = searchResultPage.getPageTitle();
        System.out.println("Текущая страница: " + pageTitle);


        Assertions.assertEquals("Википедия", pageTitle);


    }
}


