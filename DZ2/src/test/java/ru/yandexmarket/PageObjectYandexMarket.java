package ru.yandexmarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.ArrayList;

public class PageObjectYandexMarket {
    private WebDriver chromeDriver;
    private List<WebElement> listOfWebElement;

    public List<WebElement> getListOfWebElement(){
        return  listOfWebElement;
    }

    public PageObjectYandexMarket(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        this.chromeDriver.get("https://market.yandex.ru/");
    }

    public void refreshListElements(){
        listOfWebElement = chromeDriver.findElements(By.xpath("article"));
    }

}
