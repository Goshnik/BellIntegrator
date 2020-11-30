package ru.yandexmarket;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class Steps {

    private static String selectorElement = "//article//h3/a[@title]";
    private static String selectorPagingButton = "//a[@aria-label = \"Следующая страница\"]";


    @Step("Шаг 1 — получение и изучение списка элементов")
    public static void listOfPhones(WebDriver chromeDriver){
        List<WebElement> articles = chromeDriver.findElements(By.xpath(selectorElement));
        if (articles.stream().allMatch(x->x.getText().contains("iPhone"))){
            Assertions.assertTrue(true);
        }
        else{
            WebElement notIphone = articles.stream().filter(x-> !x.getText().contains("iPhone")).findAny().orElse(null);
            System.out.println(notIphone.getText());
            CustomUtils.getScreen(chromeDriver, notIphone);
            CustomUtils.wrongPhoneMessage();
            Assertions.assertTrue(false);
        }
    }

    @Step("Шаг 2 — движение по страницам")
    public static WebElement pagingSearch(WebDriver chromeDriver, WebElement pagingButton){
        try {
            pagingButton = chromeDriver.findElement(By.xpath(selectorPagingButton));
            pagingButton.click();
            return pagingButton;
        } catch (NoSuchElementException noButton){
            System.out.println("Кнопки нет");
            CustomUtils.noPagesMessage();
            Assertions.assertTrue(true);
            return pagingButton = null;
        }
    }
}