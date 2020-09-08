package ru.yandexmarket;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Tests extends WebDriverSettings{


    @Test
    @Description(value = "Ищём не айфоны при поисковом запросе \"iPhone\"")
    public void testSearchResult(){
        PageObjectYandexMarket YaMarketPO = new PageObjectYandexMarket(chromeDriver);
        YaMarketPO.doSearch("iPhone");
        YaMarketPO.refreshListElements();
        WebElement pagingButton = null;
        boolean lastPageReached = false;
        while (lastPageReached == false){
            Steps.listOfPhones(chromeDriver);
            pagingButton = Steps.pagingSearch(chromeDriver, pagingButton);

            if (pagingButton == null){
                lastPageReached = true;
            }
            YaMarketPO.refreshListElements();
        }
        Assertions.assertTrue(true);
    }
}
