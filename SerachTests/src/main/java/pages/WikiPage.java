package pages;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class WikiPage extends BasePage {
    public WikiPage(WebDriver driver) {
        super(driver);
    }

    public void assertWikiPageTitle() {
        String pageTitle = getPageTitle();
        System.out.println("Текущая страница: " + pageTitle);
        Assert.assertEquals("Википедия", pageTitle);
    }
}