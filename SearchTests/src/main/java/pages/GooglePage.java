package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GooglePage extends BasePage {


    public GooglePage(WebDriver driver) {
        super(driver);
    }

    @Step("Начинается поиск для запроса: {query}")
    public void search(String query) {
        log("Начинается поиск для запроса: " + query);
        driver.findElement(By.name("q")).sendKeys(query + "\n");
        log("Запрос '" + query + "' отправлен.");
    }
}

