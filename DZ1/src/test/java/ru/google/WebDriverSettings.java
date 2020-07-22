package ru.google;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    WebDriver chromeDriver;

    public WebDriverSettings() {
    }

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        this.chromeDriver = new ChromeDriver();
        this.chromeDriver.manage().window().maximize();
        this.chromeDriver.manage().timeouts().pageLoadTimeout(40L, TimeUnit.SECONDS);
        this.chromeDriver.manage().timeouts().setScriptTimeout(40L, TimeUnit.SECONDS);
        this.chromeDriver.manage().timeouts().implicitlyWait(40L, TimeUnit.SECONDS);
    }

    @AfterEach
    public void after() {
        this.chromeDriver.quit();
    }
}
