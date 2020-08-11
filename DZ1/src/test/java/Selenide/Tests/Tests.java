package Selenide.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
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
    @Description(value = "тестирование поискового запроса в Google \"Гладиолус\"")
    public void testSearchResultCount(){
        open("https://www.google.ru/");
        $(By.name("q")).setValue("Гладиолус").pressEnter();
        $$(By.xpath("//div[@class='g']")).shouldHave(sizeGreaterThanOrEqual(3));
    }

    @Test
    @Description(value = "проверка наличия результата \"Гладиолус — Википедия\"")
    public void testWikiPage(){
        open("https://www.google.ru/");
        $(By.name("q")).setValue("Гладиолус").pressEnter();
        ElementsCollection searchResults = $$(By.xpath("//div[@class='g']//h3"));
        Assertions.assertTrue(searchResults.findBy(text("Гладиолус — Википедия")).exists(), "Искомый результат не найден");
    }

}
