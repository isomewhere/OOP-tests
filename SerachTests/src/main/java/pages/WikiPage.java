package pages;

import org.openqa.selenium.WebDriver;

public class WikiPage extends BasePage {

    public WikiPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
