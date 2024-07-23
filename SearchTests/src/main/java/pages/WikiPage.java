package pages;



import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;




public class WikiPage extends BasePage {

    public WikiPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка заголовка страницы должна содержать: {expectedTitle}")
    public void assertWikiPageTitle(String expectedTitle) {
        String pageTitle = getPageTitle();
        log("Текущая страница: " + pageTitle);
        System.out.println("Текущая страница: " + pageTitle);

        Assertions.assertTrue(pageTitle.contains(expectedTitle), "Заголовок страницы не содержит ожидаемое значение: " + expectedTitle);

        log("Проверка заголовка страницы должна содержать: " + expectedTitle);
    }
}