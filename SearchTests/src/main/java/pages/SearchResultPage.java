package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие элемента поиска с заголовком: {title}")
    public void openSearchResultItem(String title) {
//        log("Открытие элемента поиска с заголовком: " + title);
        driver.findElement(By.partialLinkText(title)).click();
    }
}