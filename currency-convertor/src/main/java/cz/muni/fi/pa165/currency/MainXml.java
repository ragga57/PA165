package cz.muni.fi.pa165.currency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;

public class MainXml {

    public static void main(String[] args) {

        springXmlContext();
        Currency CZK = Currency.getInstance("CZK");
        Currency EUR = Currency.getInstance("EUR");
        ExchangeRateTable exchangeRateTable = new ExchangeRateTableImpl();
        CurrencyConvertor currencyConvertor = new CurrencyConvertorImpl(exchangeRateTable);
        //System.out.println(currencyConvertor.convert(EUR, CZK, new BigDecimal("1")));



    }
    private static void springXmlContext() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        CurrencyConvertorImpl currencyConvertor
                = applicationContext.getBean(CurrencyConvertorImpl.class);

    }
    /*
    private static void springAnnotationContext() {

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("cz.muni.fi.pa165");

        CurrencyConvertorImpl currencyConvertor
                = applicationContext.getBean(CurrencyConvertorImpl.class);

        //System.err.println(productService.getAllProducts());

    }

     */
}
