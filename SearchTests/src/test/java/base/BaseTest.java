package base;

import configuration.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    protected static WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverManager.getDriver();

        System.out.println("WebDriver инициализирован успешно.");
    }

//    @Step("Открытие URL: {url}")
    public void open(String url) {
        if (driver != null) {
            System.out.println("Открытие URL: " + url);
            driver.get(url);
        } else
            throw new IllegalStateException("WebDriver не инициализирован. Убедитесь, что метод setUp() был вызван.");

    }

    @AfterEach
    public void tearDown() {
        System.out.println("Закрытие браузера...");
        WebDriverManager.closeBrowser();
    }
}


//    protected WebDriver getDriverInstance() {
//        return driver;
//    }


