package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikiPage extends BasePage {
    public WikiPage(WebDriver driver) {
        super(driver);
    }

    private final By wikiPage = By.xpath("//*[@id=\"kp-wp-tab-overview\"]/div[3]/div/div/div/div/div/div[1]/div/div/span/a/h3");

    public void enterWikiPage() {
        driver.findElement(wikiPage).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
