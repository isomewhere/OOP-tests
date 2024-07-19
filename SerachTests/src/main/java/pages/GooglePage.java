package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage extends BasePage {
    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void search(String query) {
        driver.findElement(By.name("q")).sendKeys(query + "\n");
    }
}