package base;

import configuration.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;



public class BaseTest {
    protected WebDriver driver;

    public BaseTest() {
        this.driver = WebDriverManager.getDriver();
    }

    public void open(String url) {
        driver.get(url);
    }

    @AfterEach
    public void tearDown() {
        WebDriverManager.closeBrowser();
    }
}
