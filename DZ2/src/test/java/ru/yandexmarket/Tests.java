package ru.yandexmarket;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tests extends WebDriverSettings{

    @Test
    @Description(value = "Ищём не айфоны при поисковом запросе \"iPhone\"")
    public void testSearchResult(){
        PageObjectYandexMarket yaMarketPO = new PageObjectYandexMarket(chromeDriver);
        WebElement searchField = chromeDriver.findElement(By.xpath("//input[@id=\"header-search\"]"));
        WebElement searchButton = chromeDriver.findElement(By.xpath("//button[@class=\"_1XiEJDPVpk\"]"));
        searchField.click();
        searchField.sendKeys("iPhone");
        searchButton.click();
        yaMarketPO.refreshListElements();
        WebElement pagingButton = null;
        boolean lastPageReached = false;
        while (lastPageReached == false){
            Steps.listOfPhones(chromeDriver);
            pagingButton = Steps.pagingSearch(chromeDriver, pagingButton);

            if (pagingButton == null){
                lastPageReached = true;
            }
            yaMarketPO.refreshListElements();
        }
    }
}
