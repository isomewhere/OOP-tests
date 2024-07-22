package base;

import configuration.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;


public class BaseTest {

    public void open(String url) {
        WebDriver driver = WebDriverManager.getDriver();
        driver.get("https://www.google.com");
    }

    @AfterEach
    public void tearDown() {
        WebDriverManager.closeBrowser();
    }
}
