package ru.google;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.junit.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyStepDef extends Steps {
    @Given("перейти на сайт '(.*)'")
    public void перейти_на_сайт(String url) {
        открытьХром();
        chromeDriver.get(url);
    }

    @Then("Осуществить поиск по запросу '(.*)'")
    public void Осуществить_поиск_по_запросу (String searchQuery){
        PageObjectGoogleSearch googlePO = new PageObjectGoogleSearch(chromeDriver, searchQuery);
        googlePO.refreshListElements();
    }

    @Then("проверить количество результатов больше 3")
    public void Проверка_количества_результатов (){
        List<WebElement> listOfWebElement = chromeDriver.findElements(By.className("g"));
        if (listOfWebElement.size() > 3){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }

    @Then("Проверить отсутствие слова '(.*)' в ссылке на Википедию")
    public void Проверка_названия_страницы(String name){
        List<WebElement> searchResultList = chromeDriver.findElements(By.xpath("//div[@class='g']//h3"));
        if (searchResultList.stream().anyMatch(x->x.getText().contains(name))){
            Assert.assertFalse(false);
        }
        else {
            Assert.assertFalse(true);
        }

    }

    @Then("закончить работу")
    public void закончить_работу() {
        закрытьХром();
    }


}
