package org.wikipedia.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchOfPolishWikipediaPage extends PageObject {

    @FindBy(tagName = "h1")
    private WebElement headerPage;

    public SearchOfPolishWikipediaPage(WebDriver webDriver, String expectedHeaderText) {
        super(webDriver);
        ExpectedCondition<Boolean> waiterForHeader = driver->headerPage.getText().contains(expectedHeaderText);//lambda czyli strzalka(->)
        //oraz metoda interfejsu funkcyjnego, dziedziczy po Function, pierwszy argument jest nadpisany i jest to WebDriver
        webDriverWait.until(waiterForHeader);
    }
}
