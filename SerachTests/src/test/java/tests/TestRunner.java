package tests;

import base.BaseTest;
import org.junit.After;
import org.junit.Before;
import pages.GooglePage;
import pages.WikiPage;

public class TestRunner extends BaseTest {

    private WikiPage wikiPage;

    @Before
    public void setUp() {
        super.setUp();
        wikiPage = new WikiPage(driver);
    }

    @org.junit.Test
    public void runTest() {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.open("https://www.google.com");
        googlePage.search("гладиолус");

        wikiPage.enterWikiPage();

        System.out.println("Текущая страница: " + wikiPage.getPageTitle());
    }

    @After
    public void tearDown() {
        super.tearDown();
    }
}


