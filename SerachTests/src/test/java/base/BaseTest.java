package base;

import configuration.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;
import pages.SearchResultPage;

public class BaseTest {
    public void setUp() {
        WebDriverManager.startBrowser();
    }

    public void tearDown() {
        WebDriverManager.closeBrowser();
    }

    public void googleSearchPage(String query) {
        WebDriver driver = WebDriverManager.getDriver();
        driver.get("https://www.google.com");
        GooglePage googlePage = new GooglePage(driver);
        googlePage.search(query);

        SearchResultPage searchResultPage = new SearchResultPage(driver);

        searchResultPage.openSearchResultItem("Википедия");

    }

    public String getPageTitle() {
        return WebDriverManager.getDriver().getTitle();
    }
}