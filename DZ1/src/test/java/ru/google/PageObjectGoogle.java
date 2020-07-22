package ru.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectGoogle {
    private WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;
    private List<WebElement> listOfWebElement;

    public List<WebElement> getListOfWebElement(){
        return  listOfWebElement;
    }
    PageObjectGoogle(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        searchField= chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        searchButton = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
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
