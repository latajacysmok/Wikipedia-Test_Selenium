package org.wikipedia.config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum WebDriverType {
    FIREFOX {
        @Override
        public WebDriver create() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    },
    CHROME {
        @Override
        public WebDriver create() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    },
    IE {
        @Override
        public WebDriver create() {
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        }
    };

    public abstract WebDriver create();//funckja abstrakcyjna nie posiada ciała funkcji;
}
