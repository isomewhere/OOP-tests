package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;
import pages.SearchResultPage;
import pages.WikiPage;


    public class TestRunner extends BaseTest {
        public static void main(String[] args) {
            tests.TestRunner testRunner = new tests.TestRunner();
            testRunner.setUp();

            try {
                WebDriver driver = testRunner.webDriverManager.getDriver();
                GooglePage googlePage = new GooglePage(driver);
                googlePage.open("https://www.google.com");
                googlePage.search("гладиолус");

                SearchResultPage searchResultPage = new SearchResultPage(driver);
                searchResultPage.openSearchResultItem("Гладиолус");

                WikiPage wikiPage = new WikiPage(driver);
                System.out.println("Текущая страница: " + wikiPage.getPageTitle());
            } finally {
                testRunner.tearDown();
            }
        }
    }

