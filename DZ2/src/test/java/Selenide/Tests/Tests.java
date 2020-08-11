package Selenide.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;

public class Tests {

    @BeforeEach
    public void option(){
        Configuration.timeout = 6000;
        Configuration.browser="chrome";
        Configuration.startMaximized=true;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    @Description(value = "Ищём не айфоны при поисковом запросе \"iPhone\"")
    public void testSearchResult(){
        open("https://market.yandex.ru/");
        $(By.xpath("//input[@id=\"header-search\"]")).setValue("iPhone").pressEnter();
        SelenideElement pagingButton = null;
        boolean lastPageReached = false;
        while (lastPageReached == false){
            Steps.listOfPhones();
            pagingButton = Steps.pagingSearchYa(pagingButton);
            if (pagingButton == null){
                lastPageReached = true;
            }
        }
        Assertions.assertTrue(true);
    }

}
