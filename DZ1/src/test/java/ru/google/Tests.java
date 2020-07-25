package ru.google;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tests extends WebDriverSettings{

    @Test
    @Description(value = "тестирование поискового запроса в Google \"Гладиолус\"")
    public void testSearchQuery(){
        PageObjectGoogleSearch googlePO = new PageObjectGoogleSearch(chromeDriver, "Гладиолус");
        googlePO.refreshListElements();
        List<WebElement> listOfWebElement = chromeDriver.findElements(By.xpath("//div[@class='g']//h3"));

        Steps.checkResultAmount(chromeDriver);
        Steps.checkContainsName(chromeDriver, "Гладиолус — Википедия");
    }
}
