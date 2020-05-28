package org.wikipedia.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Pattern;

public class PolishWikipediaPage extends PageObject {

    @FindBy(xpath = "//span[@id='main-page-welcome']/strong")
    private WebElement headerPage;

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    public PolishWikipediaPage(WebDriver webDriver) {
        super(webDriver);
//        System.out.println("Dupa1");
//        System.out.println(webDriver.findElement(By.xpath("//span[@id='main-page-welcome']/strong")).getText());
//        System.out.println(webDriver.findElement(By.xpath("//span[@id='main-page-welcome']/strong")).getAttribute("innerHTML"));
//        System.out.println("Dupa2");
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(headerPage, "Witaj w Wikipedii,"));
    }

    public void enterWordToSearchFor(String word){
        searchInput.clear();
        searchInput.sendKeys(word);
    }

    public SearchOfPolishWikipediaPage clickSearchButton(String expectedHeaderText){
        searchButton.click();
        return new SearchOfPolishWikipediaPage(webDriver, expectedHeaderText );
    }
}
