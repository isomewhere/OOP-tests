package tests;

import base.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.GooglePage;
import pages.SearchResultPage;
import pages.WikiPage;




//public class GoogleWikiTest extends BaseTest {
//    static GooglePage googlePage;
//    static SearchResultPage searchResultPage;
//    static WikiPage wikiPage;
//
//    @BeforeAll
//    public void setUp() {
//        googlePage = new GooglePage(driver);
//        searchResultPage = new SearchResultPage(driver);
//        wikiPage = new WikiPage(driver);
//    }
//
//    @Test
//    @Description("Тест для поиска и проверки Wikipedia")
//    void runTest() {
//        open("https://www.google.com");
//        googlePage.search("гладиолус");
//        searchResultPage.openSearchResultItem("Википедия");
//        wikiPage.assertWikiPageTitle("Википедия");
//    }
//}