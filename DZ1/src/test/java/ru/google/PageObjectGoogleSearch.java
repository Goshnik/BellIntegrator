package ru.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectGoogleSearch {

    private WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;
    private List<WebElement> listOfWebElement;

    private String selectorSearchItem="//div[@class='g']";
    private String selectorNamePage = "//div[@class='g']//h3";
    private String selectorSearchField = "//input[@title = 'Поиск']";
    private String selectorSearchButton = "btnK";

    public PageObjectGoogleSearch(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        this.chromeDriver.get("https://www.google.ru/");
        searchField = chromeDriver.findElement(By.xpath(selectorSearchField));
        searchButton = chromeDriver.findElement(By.name(selectorSearchButton));
    }

    public void doSearch (String searchQuery){
        searchField.click();
        searchField.sendKeys(searchQuery);
        searchButton.click();
    }

    public void refreshListElements(){
        listOfWebElement = chromeDriver.findElements(By.xpath(selectorSearchItem));
    }

    public List<WebElement> getSearchResult(){
        this.listOfWebElement = chromeDriver.findElements(By.xpath(selectorNamePage));
        return listOfWebElement;
    }

    public String getSelectorSearchItem() {
        return selectorSearchItem;
    }

    public String getSelectorNamePage() {
        return selectorNamePage;
    }
}
