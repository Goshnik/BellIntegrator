package ru.google;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class Tests extends WebDriverSettings{


    @Test
    @Description(value = "тестирование поискового запроса в Google \"Гладиолус\"")
    public void testSearchQuery(){
        PageObjectGoogleSearch googlePO = Steps.doGoogleSearch(chromeDriver, "Гладиолус");
        Steps.checkResultAmount(chromeDriver, googlePO);
    }

    @Test
    @Description(value = "проверка наличия результата \"Гладиолус — Википедия\"")
    public void testWiki(){
        Steps.doGoogleSearch(chromeDriver, "Гладиолус");
        Steps.checkContainsName(chromeDriver, "Гладиолус — Википедия");
    }

    @Test
    public void dasdsada(){
        chromeDriver.get("https://selenium.dev");
        System.out.println(chromeDriver.getCurrentUrl());
        
    }
}
