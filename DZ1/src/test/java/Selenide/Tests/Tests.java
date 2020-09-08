package Selenide.Tests;

import Selenide.PageObjects.GoogleMainPage;
import Selenide.PageObjects.GoogleSearchResult;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

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
        GoogleMainPage google = open("https://www.google.ru/",GoogleMainPage.class);
        GoogleSearchResult resultingSearch = google.search("Гладиолус");
        Assertions.assertTrue($$(By.xpath(resultingSearch.getSelectorSearchItem())).size() >= 3);
    }

    @Test
    @Description(value = "проверка наличия результата \"Гладиолус — Википедия\"")
    public void testWikiPage(){
        GoogleMainPage google = open("https://www.google.ru/",GoogleMainPage.class);
        GoogleSearchResult resultingSearch = google.search("Гладиолус");
        ElementsCollection searchResults = $$(By.xpath(resultingSearch.getSelectorSearchItem()));
        Assertions.assertTrue(searchResults.findBy(text("Гладиолус — Википедия")).exists(), "Искомый результат не найден");
    }

}
