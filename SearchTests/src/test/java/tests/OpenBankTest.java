package tests;

import base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.OpenBankPage;
import java.util.Map;


public class OpenBankTest extends BaseTest {

    private static OpenBankPage openBankPage;

    @BeforeAll
    public static void set() {
        openBankPage = new OpenBankPage();
    }

    @Owner("Igor")
    @Feature("Проверка курсов валют")
    @ParameterizedTest(name = "Тестирование курса валют для {0}")
    @ValueSource(strings = {"USD", "EUR"})
    void testCurrencyRates(String currency) {
        runCurrencyTest(currency);
    }

    @Step("Запуск теста на получение курсов валют для {currency}")
    void runCurrencyTest(String currency) {
        System.out.println("Запуск теста на получение курсов валют для: " + currency);
        open("https://open.ru");

        Map<String, Double> rates = openBankPage.getCurrencyRates(currency);
        boolean isSaleGreater = openBankPage.validateRatesAndCheckSaleGreater(rates, currency);
        System.out.println("Курс продажи больше курса покупки для " + currency + ": " + isSaleGreater);
    }
}