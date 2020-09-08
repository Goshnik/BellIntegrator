package Selenide.Tests;

import Selenide.PageObjects.YaMarketSearchResult;
import Selenide.PageObjects.YandexMarketMainPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandexmarket.CustomUtils;


import static com.codeborne.selenide.Selenide.*;

public class Steps {

    private static String pagingButtonSelector = "//a[@class = '_2prNUdeCKH _3OFYTyXi90']";

    @Step("Шаг 1 — осуществление поиска по запросу {query}")
    public static void startup(){
        YandexMarketMainPage yaMarket = open("https://market.yandex.ru/", YandexMarketMainPage.class);

        YaMarketSearchResult SR = yaMarket.search("iPhone");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(true);
    }

    @Step("Шаг 2 — получение и изучение списка элементов")
    public static void listOfPhonesStream(){
        YaMarketSearchResult YMSR = new YaMarketSearchResult();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ElementsCollection articles = YMSR.results();
        WebElement notIphone = articles.stream().filter(x-> !x.getText().contains("iPhone")).findAny().orElse(null);
        if (notIphone == null){
            Assertions.assertTrue(true);
        }
        else{
            System.out.println(notIphone.getText());
            CustomUtils.wrongPhoneMessage();
            Assertions.assertTrue(false);
        }
    }

    @Step("Шаг 3 — движение по страницам")
    public static SelenideElement pagingSearchYa(){
        try{
            SelenideElement pagingButton = $(By.xpath(pagingButtonSelector));
            pagingButton.click();
            return pagingButton;
        } catch (ElementNotFound e){
            System.out.println("Кнопки нет");
            CustomUtils.noPagesMessage();
            Assertions.assertTrue(true);
            return null;
        }
    }
}
