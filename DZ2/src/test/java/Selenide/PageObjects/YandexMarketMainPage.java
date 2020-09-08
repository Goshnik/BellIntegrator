package Selenide.PageObjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class YandexMarketMainPage {

    private String selectorSearchField = "//input[@id=\"header-search\"]";

    public YaMarketSearchResult search(String query){
        $(By.xpath(selectorSearchField)).setValue(query).pressEnter();
        return page(YaMarketSearchResult.class);
    }


}
