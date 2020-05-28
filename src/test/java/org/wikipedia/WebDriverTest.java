package org.wikipedia;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.wikipedia.config.WebDriverType;
import org.wikipedia.page.PolishWikipediaPage;
import org.wikipedia.page.SearchOfPolishWikipediaPage;
import org.wikipedia.page.WikipediaPage;

public class WebDriverTest {
    @Test
    public void shouldOpenChromeBrawser() {
        WebDriver webDriver = WebDriverType.CHROME.create();
        webDriver.get("https://www.wikipedia.org/");
        WikipediaPage wikipediaPage = new WikipediaPage(webDriver);
        PolishWikipediaPage polishWikipediaPage = wikipediaPage.choiceOfPolishWikipediaButton();
        polishWikipediaPage.enterWordToSearchFor("Pingwin");
        SearchOfPolishWikipediaPage searchOfPolishWikipediaPage = polishWikipediaPage.clickSearchButton("Pingwin");
        webDriver.quit();
    }
}
