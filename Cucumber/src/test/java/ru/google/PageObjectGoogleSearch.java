package ru.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PageObjectGoogleSearch {


    private String selectorSearchItem="//div[@class='g']";
    private List<WebElement> webSearchItem = new ArrayList<>();
    private WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;
    private List<WebElement> listOfWebElement;

    public List<WebElement> getListOfWebElement(){
        return  listOfWebElement;
    }

    public PageObjectGoogleSearch(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        searchField= chromeDriver.findElement(By.xpath("//input[@title = 'Поиск']"));
        searchButton = chromeDriver.findElement(By.name("btnK"));
    }


    public PageObjectGoogleSearch(WebDriver chromeDriver, String search){
        this.chromeDriver=chromeDriver;
        this.chromeDriver.get("https://www.google.ru/search?q="+search);
        webSearchItem = chromeDriver.findElements(By.xpath(selectorSearchItem));
    }


    public void find (String searchQuery){
        searchField.click();
        searchField.sendKeys(searchQuery);
        searchButton.click();
    }

    public void refreshListElements(){
        listOfWebElement = chromeDriver.findElements(By.className("g"));
    }
}