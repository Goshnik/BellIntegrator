package Selenide.PageObjects;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class YaMarketSearchResult {

    private String selectorSearchItem = "//article//h3/a[@title]";

    public ElementsCollection results(){
        return $$(By.xpath(selectorSearchItem));
    }
}
