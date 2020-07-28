package ru.yandexmarket;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    WebDriver chromeDriver;

    @BeforeEach
    public void startBrowser(){
        System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER"));
        chromeDriver=new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(7, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

    }

    @AfterEach
    public void closeBellTest(){
        chromeDriver.quit();
    }
}
