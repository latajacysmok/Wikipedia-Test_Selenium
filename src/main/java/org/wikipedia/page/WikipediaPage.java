package org.wikipedia.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WikipediaPage extends PageObject{

    @FindBy(tagName = "h1")
    private WebElement headerPage;

    @FindBy(xpath = "//a[@id='js-link-box-pl']/strong[1]")
    private WebElement plButton;

    public WikipediaPage(WebDriver webDriver) {
        super(webDriver);
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(headerPage, "Wikipedia"));
    }

    public PolishWikipediaPage choiceOfPolishWikipediaButton(){
        plButton.click();
        return new PolishWikipediaPage(webDriver);
    }
}
