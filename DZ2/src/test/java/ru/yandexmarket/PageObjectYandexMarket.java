package ru.yandexmarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.ArrayList;

public class PageObjectYandexMarket {

    private WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;


    private String selectorSearchField = "//input[@id=\"header-search\"]";
    private String selectorSearchButton = "//button[@type='submit']";
    private String selectorSearchItem = "article";

    private List<WebElement> listOfWebElement;

    public PageObjectYandexMarket(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        this.chromeDriver.get("https://market.yandex.ru/");
    }

    public List<WebElement> getListOfWebElement(){
        return  listOfWebElement;
    }

    public void doSearch(String query){
        searchField = chromeDriver.findElement(By.xpath(selectorSearchField));
        searchButton = chromeDriver.findElement(By.xpath(selectorSearchButton));
        searchField.click();
        searchField.sendKeys(query);
        searchButton.click();
    }

    public void refreshListElements(){
        listOfWebElement = chromeDriver.findElements(By.xpath(selectorSearchItem));
    }


}
