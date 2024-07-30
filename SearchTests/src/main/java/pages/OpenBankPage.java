package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.*;


public class OpenBankPage extends BasePage {

    public OpenBankPage(WebDriver driver) {
        super(driver);
    }

    public Map<String, Double> getCurrencyRates() {
        $(".CurrencyExchange_currency-exchange-wrapper__K_gc4").scrollIntoView(true);
        $(".CurrencyExchange_currency-exchange-header__0yk9x h2 span").shouldBe(Condition.visible);

        ElementsCollection currencyRows = $$(" .CurrencyExchangeFilterContent_currency-exchange-filter-content-column-wrapper__AzUkf");

        Map<String, Double> currencyMap = new HashMap<>();
        currencyRows.forEach(row -> {
            String text = row.getText();
            String[] cells = text.split("\\s+");

            if (cells.length >= 9) {
                try {
                    double purchaseRateEUR = Double.parseDouble(cells[5]);
                    double saleRateEUR = Double.parseDouble(cells[8]);
                    currencyMap.put("Банк покупает EUR", purchaseRateEUR);
                    currencyMap.put("Банк продает EUR", saleRateEUR);
                } catch (NumberFormatException e) {
                    logger.severe("Ошибка парсинга курсов: " + e.getMessage());
                }
            }
        });
        System.out.println("Полученные курсы валют: " + currencyMap);
        return currencyMap;
    }

    public boolean validateRatesAndCheckSaleGreater(Map<String, Double> rates) {
        Double saleRate = rates.get("Банк продает EUR");
        Double purchaseRate = rates.get("Банк покупает EUR");

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
