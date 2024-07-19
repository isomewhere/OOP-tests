package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void openSearchResultItem(String title) {
        driver.findElement(By.partialLinkText(title)).click();
    }
}