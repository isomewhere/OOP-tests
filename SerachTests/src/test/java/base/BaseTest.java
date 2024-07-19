package base;

import configuration.WebDriverManager;
import org.openqa.selenium.WebDriver;



public class BaseTest {
    protected WebDriverManager webDriverManager;
    protected WebDriver driver;

    public BaseTest() {
        webDriverManager = new WebDriverManager();
    }

    public void setUp() {
        webDriverManager.startBrowser();
        driver = WebDriverManager.getDriver(); // Теперь устанавливаем драйвер здесь
    }

    public void tearDown() {
        webDriverManager.closeBrowser();
    }
}
