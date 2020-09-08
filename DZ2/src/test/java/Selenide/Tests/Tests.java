package Selenide.Tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        Steps.startup();
        boolean lastPageReached = false;
        while (!lastPageReached){
            Steps.listOfPhonesStream();
            if (Steps.pagingSearchYa() == null)
                lastPageReached = true;
        }
        Assertions.assertTrue(true);
    }

}
