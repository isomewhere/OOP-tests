package base;

import configuration.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.findElement(By.name("q")).sendKeys(query + "\n");

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openSearchResultItem("Гладиолус");

        By wikiPage = By.xpath("//*[@id='kp-wp-tab-overview']/div[3]/div/div/div/div/div/div[1]/div/div/span/a/div/div/div/div[1]/span");
        driver.findElement(wikiPage).click();
    }

    public String getPageTitle() {
        return WebDriverManager.getDriver().getTitle();
    }
}