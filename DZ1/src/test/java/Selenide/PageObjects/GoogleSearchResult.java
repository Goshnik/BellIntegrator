package Selenide.PageObjects;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchResult {

    private String selectorSearchItem = "//div[@class='g']";

    public ElementsCollection results(){
        return $$(By.xpath(this.selectorSearchItem));
    }

    public String getSelectorSearchItem() {
        return selectorSearchItem;
    }
}
