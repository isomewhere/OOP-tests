package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

public class WebDriverManager {
    private static final Logger logger = Logger.getLogger(WebDriverManager.class.getName());
    private static WebDriver driver;

    public static void open() {
        System.setProperty("webdriver.chrome.driver", "src/main/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Браузер открыт и развернут на полный экран.");
    }

    public static WebDriver getDriver() {

        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            logger.info("Браузер закрыт.");
        }
    }
}

