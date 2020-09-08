package ru.yandex.market;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyStepDef extends Steps {
    @Given("перейти на сайт '(.*)'")
    public void перейти_на_сайт(String url) {
        открытьХром();
        chromeDriver.get(url);
    }


    @Then("Начать поиск по слову '(.*)'")
    public void поисковый_запрос (String name){
        PageObjectYandexMarket yaMarketPO = new PageObjectYandexMarket(chromeDriver);
        WebElement searchField = chromeDriver.findElement(By.xpath("//input[@id=\"header-search\"]"));
        WebElement searchButton = chromeDriver.findElement(By.xpath("//button[@class=\"_1XiEJDPVpk\"]"));
        searchField.click();
        searchField.sendKeys(name);
        searchButton.click();
        yaMarketPO.refreshListElements();
        WebElement pagingButton = null;
        boolean lastPageReached = false;

    }

    @Then("Проверить все результаты на странице")
    public void проверка_результатов(){
        List<WebElement> articles = chromeDriver.findElements(By.xpath("//article//h3/a[@title]"));
        if (articles.stream().allMatch(x->x.getText().contains("iPhone"))){
            Assert.assertTrue(true);
        }
        else{
            WebElement notIphone = articles.stream().filter(x-> !x.getText().contains("iPhone")).findAny().orElse(null);
            System.out.println(notIphone.getText());
            Assert.assertTrue(false);
        }
    }

    @Then("Перейти на следующую страницу")
    public WebElement переход(){
        WebElement pagingButton;
        try {
            pagingButton = chromeDriver.findElement(By.xpath("//a[@aria-label = \"Следующая страница\"]"));
            pagingButton.click();
            return pagingButton;
        } catch (NoSuchElementException noButton){
            System.out.println("Кнопки нет");
            Assert.assertTrue(true);
            return pagingButton = null;
        }
    }


    @Then("закончить работу")
    public void закончить_работу() {
        закрытьХром();
    }
}
