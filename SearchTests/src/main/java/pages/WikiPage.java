package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class WikiPage extends BasePage {

    public WikiPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка заголовка страницы должна содержать: {expectedTitle}")
    public void assertWikiPageTitle(String expectedTitle) {
        String pageTitle = getPageTitle();
        log("Текущая страница: " + pageTitle);
        System.out.println("Текущая страница: " + pageTitle);

        Assert.assertTrue(pageTitle.contains(expectedTitle), " Not Found");

        log("Проверка успешна, заголовок страницы содержит: " + expectedTitle);
    }
}