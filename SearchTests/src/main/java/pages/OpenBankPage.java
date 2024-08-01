package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OpenBankPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(OpenBankPage.class);

    @Step("Получение курсов валют для {currency}")
    public Map<String, Double> getCurrencyRates(String currency) {
        $(".CurrencyExchange_currency-exchange-wrapper__K_gc4").scrollIntoView(true);
        $(".CurrencyExchange_currency-exchange-header__0yk9x h2 span").shouldBe(Condition.visible);

        ElementsCollection currencyRows = $$(".CurrencyExchangeFilterContent_currency-exchange-filter-content-column-wrapper__AzUkf");

        Map<String, Double> currencyMap = new HashMap<>();
        int[] columnIndexes = resolveColumnIndexes(currency);

        currencyRows.forEach(row -> {
            String[] cells = row.getText().split("\\s+");
            currencyMap.put("Банк покупает " + currency, Double.parseDouble(cells[columnIndexes[0]]));
            currencyMap.put("Банк продает " + currency, Double.parseDouble(cells[columnIndexes[1]]));
        });

        logCurrencyRates(currency, currencyMap);

        return currencyMap;
    }
    @Step("На валидацию курсов и проверка, если продажа больше покупки для {currency}")
    public boolean validateRatesAndCheckSaleGreater(Map<String, Double> rates, String currency) {
        return isSaleGreaterThanPurchase(
                rates.getOrDefault("Банк продает " + currency, -1.0),
                rates.getOrDefault("Банк покупает " + currency, -1.0)
        );
    }

    @Step("Проверка если продажа больше покупки")
    public boolean isSaleGreaterThanPurchase(double saleRate, double purchaseRate) {
        return saleRate > purchaseRate;
    }

    private int[] resolveColumnIndexes(String currency) {
        return switch (currency) {
            case "USD" -> new int[]{5, 6};
            case "EUR" -> new int[]{8, 9};
            default -> throw new IllegalArgumentException("Неподдерживаемая валюта: " + currency);
        };
    }

    private void logCurrencyRates(String currency, Map<String, Double> currencyMap) {
        Supplier<String> message = () -> currencyMap.isEmpty() ?
                String.format("Курсы валют не найдены для валюты: %s", currency) :
                String.format("Полученные курсы валют для %s: %s", currency, currencyMap.toString());
        if (currencyMap.isEmpty()) {
            logger.warn(message);
        } else {
            logger.info(message);
        }
    }
}


