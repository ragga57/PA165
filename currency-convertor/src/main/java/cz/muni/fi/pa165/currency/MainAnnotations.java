package cz.muni.fi.pa165.currency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Currency;

public class MainAnnotations {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("cz.muni.fi.pa165");


        Currency CZK = Currency.getInstance("CZK");
        Currency EUR = Currency.getInstance("EUR");
        ExchangeRateTable exchangeRateTable = new ExchangeRateTableImpl();
        CurrencyConvertor currencyConvertor = new CurrencyConvertorImpl(exchangeRateTable);
        System.out.println(currencyConvertor.convert(EUR, CZK, new BigDecimal("1")));
    }
}
