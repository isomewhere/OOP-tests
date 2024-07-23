package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

public class WebDriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
            setDriver();

        return driver;
    }

    private static void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }
}

