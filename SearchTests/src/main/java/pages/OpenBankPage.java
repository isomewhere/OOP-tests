package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OpenBankPage extends BasePage {

    public Map<String, Double> getCurrencyRates(String currency) {
        $(".CurrencyExchange_currency-exchange-wrapper__K_gc4").scrollIntoView(true);
        $(".CurrencyExchange_currency-exchange-header__0yk9x h2 span").shouldBe(Condition.visible);

        ElementsCollection currencyRows = $$(".CurrencyExchangeFilterContent_currency-exchange-filter-content-column-wrapper__AzUkf");

        Map<String, Double> currencyMap = new HashMap<>();

        currencyRows.forEach(row -> {
            String text = row.getText();
            String[] cells = text.split("\\s+");

            int purchaseColumnIndex;
            int saleColumnIndex;

            if ("USD".equals(currency)) {
                purchaseColumnIndex = 5;
                saleColumnIndex = 6;
            } else if ("EUR".equals(currency)) {
                purchaseColumnIndex = 8;
                saleColumnIndex = 9;
            } else {
                return;
            }

            try {
                double purchaseRate = Double.parseDouble(cells[purchaseColumnIndex]);
                double saleRate = Double.parseDouble(cells[saleColumnIndex]);

                currencyMap.put("Банк покупает " + currency, purchaseRate);
                currencyMap.put("Банк продает " + currency, saleRate);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка парсинга курсов: " + e.getMessage());
            }
        });

        if (currencyMap.isEmpty()) {
            System.err.println("Курсы валют не найдены для валюты: " + currency);
        } else {
            System.out.println("Полученные курсы валют для " + currency + ": " + currencyMap);
        }

        return currencyMap;
    }

    public boolean validateRatesAndCheckSaleGreater(Map<String, Double> rates, String currency) {
        Double saleRate = rates.get("Банк продает " + currency);
        Double purchaseRate = rates.get("Банк покупает " + currency);

        if (saleRate == null || purchaseRate == null) {
            throw new IllegalArgumentException("Одно из значений курса не было найдено. " +
                    "Курсы: saleRate = " + saleRate + ", purchaseRate = " + purchaseRate);
        }

        return isSaleGreaterThanPurchase(saleRate, purchaseRate);
    }

    public boolean isSaleGreaterThanPurchase(double saleRate, double purchaseRate) {
        return saleRate > purchaseRate;
    }
}

