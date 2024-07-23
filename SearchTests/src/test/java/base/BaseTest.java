package base;

import configuration.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;




public class BaseTest {
    protected WebDriver driver;
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    public BaseTest() {
        this.driver = WebDriverManager.getDriver();
    }

    @Step("Открытие URL: {url}")
    public void open(String url) {
        log("Открытие URL: " + url);
        driver.get(url);

    }
    protected void log(String message) {
        logger.info(message);
    }


    @AfterEach
    public void tearDown() {
        WebDriverManager.closeBrowser();
    }
}
