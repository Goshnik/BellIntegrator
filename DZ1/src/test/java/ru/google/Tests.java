package ru.google;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class Tests extends WebDriverSettings{


    @Test
    @Description(value = "тестирование поискового запроса в Google \"Гладиолус\"")
    public void testSearchQuery(){
        Steps.doGoogleSearch(chromeDriver, "Гладиолус");
        Steps.checkResultAmount(chromeDriver);
    }

    @Test
    @Description(value = "проверка наличия результата \"Гладиолус — Википедия\"")
    public void testWiki(){
        Steps.doGoogleSearch(chromeDriver, "Гладиолус");
        Steps.checkContainsName(chromeDriver, "Гладиолус — Википедия");
    }
}
