package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pages.OpenBankPage;
import java.util.Map;


public class OpenBankTest extends BaseTest {
    private OpenBankPage openBankPage;

    @BeforeEach
    public void setUp() {
        super.setUp();

        openBankPage = new OpenBankPage(driver);
    }

    @Test
    void testCurrencyRates() {
        System.out.println("Запуск теста на получение курсов валют...");
        open("https://open.ru");

        Map<String, Double> rates = openBankPage.getCurrencyRates();
        boolean isSaleGreater = openBankPage.validateRatesAndCheckSaleGreater(rates);
        System.out.println("Курс продажи больше курса покупки: " + isSaleGreater);
        Assertions.assertTrue(isSaleGreater, "Курс продажи должен быть больше курса покупки");
    }
}
