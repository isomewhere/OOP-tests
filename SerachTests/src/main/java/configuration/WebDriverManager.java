package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private static WebDriver driver;

    public static void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

