package Selenide.Tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import ru.yandexmarket.CustomUtils;


import static com.codeborne.selenide.Selenide.*;

public class Steps {

    @Step("Шаг 1 — получение и изучение списка элементов")
    public static void listOfPhonesStream0(){
        ElementsCollection articles = $$(By.xpath("//article//h3/a[@title]"));
        System.out.println(articles.isEmpty());
        for (int i = 0; i < articles.size(); i++){
            SelenideElement temp = articles.get(i);
            if (temp.getText().contains("iPhone")){
                continue;
            }
            else{
                System.out.println(articles.get(i).getText());
                Selenide.Tests.CustomUtils.wrongPhoneMessage();
                Assertions.assertTrue(false);
            }
        }
        Assertions.assertTrue(true);
    }


    @Step("Шаг 1 — получение и изучение списка элементов")
    public static void listOfPhones(){
        ElementsCollection articles = $$(By.xpath("//article//h3/a[@title]"));
        for (int i = 0; i < articles.size(); i++){
            SelenideElement temp = articles.get(i);
            if (temp.getText().contains("iPhone")){
                continue;
            }
            else{
                System.out.println(articles.get(i).getText());
                Selenide.Tests.CustomUtils.wrongPhoneMessage();
                Assertions.assertTrue(false);
            }
        }
        Assertions.assertTrue(true);
    }

    @Step("Шаг 2 — движение по страницам")
    public static SelenideElement pagingSearchYa(SelenideElement pagingButton){
        try{
            pagingButton = $(By.xpath("//a[@class = '_2prNUdeCKH _3OFYTyXi90']"));
            pagingButton.click();
            return pagingButton;
        } catch (ElementNotFound e){
            System.out.println("Кнопки нет");
            CustomUtils.noPagesMessage();
            Assertions.assertTrue(true);
            return pagingButton = null;
        }
    }
}
