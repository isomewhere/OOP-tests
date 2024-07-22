package base;

import configuration.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;



public class BaseTest {

    public void open (String url) {
    WebDriver driver = WebDriverManager.getDriver();
    driver.get(url);
    }

    public void startBrowser() {
        WebDriverManager.startBrowser();
    }
    @AfterEach
    public void tearDown() {
        WebDriverManager.closeBrowser();
    }
}
