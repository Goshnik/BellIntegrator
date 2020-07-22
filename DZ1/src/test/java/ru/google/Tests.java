package ru.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tests extends WebDriverSettings{

    @Test
    public void testResultCount(){
        chromeDriver.get("https://www.google.ru/");
        PageObjectGoogle googlePO = new PageObjectGoogle(chromeDriver);
        googlePO.find("Гладиолус");
        googlePO.refreshListElements();

        List<WebElement> listOfWebElement = chromeDriver.findElements(By.className("g"));

        System.out.println(listOfWebElement.size());

        Assertions.assertTrue(listOfWebElement.size() > 3);
    }

    @Test
    public void testWiki(){
        chromeDriver.get("https://www.google.ru/");
        PageObjectGoogle googlePO = new PageObjectGoogle(chromeDriver);
        googlePO.find("Гладиолус");
        googlePO.refreshListElements();

        List<WebElement> listOfWebElement = chromeDriver.findElements(By.xpath("//*[@id=\"rso\"]/div[*]/div/div[1]/a/h3"));

        System.out.println(listOfWebElement.size());

        Assertions.assertTrue(
                googlePO.getListOfWebElement()
                .stream()
                .anyMatch(x->x.getText().contains("Гладиолус — Википедия"))
        );

    }
}
