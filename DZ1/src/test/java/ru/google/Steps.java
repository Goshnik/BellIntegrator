package ru.google;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Steps {

    @Step("Шаг 1. Проверка количества результатов больше 3")
    public static void checkResultAmount(WebDriver chromeDriver){
        List<WebElement> listOfWebElement = chromeDriver.findElements(By.className("g"));
        if (listOfWebElement.size() > 3){
            Assertions.assertTrue(true);
        }
        else {
            CustomUtils.getScreen(chromeDriver);
            Assertions.assertTrue(false);
        }
    }

    @Step("Шаг 2. Проверка наличия имени: {name}")
    public static void checkContainsName(WebDriver chromeDriver, String name){
        List<WebElement> searchResultList = chromeDriver.findElements(By.xpath("//div[@class='g']//h3"));

        if (searchResultList.stream().anyMatch(x->x.getText().contains(name))){
            CustomUtils.getScreen(chromeDriver);
            Assertions.assertFalse(true);
        }
        else {
            CustomUtils.getScreen(chromeDriver);
            Assertions.assertFalse(false);
        }
    }
}
