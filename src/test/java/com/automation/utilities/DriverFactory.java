package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    /**
     * Homework will be to improve this method!
     * This method return webdriver object based on browser type
     * If you want to use chrome browser, just provide chrome as a parameter
     * @param browserName
     * @return webdriver object
     */

    public static WebDriver createDriver(String browserName) {
        switch (browserName) {
            case "Chrome":
                return new ChromeDriver();
            case "FireFox":
                return new FirefoxDriver();
            case "Safari":
                return new SafariDriver();
            case "IE":
                return new InternetExplorerDriver();
            case "Opera":
                return new OperaDriver();
            default:
                throw new WebDriverException("No browser Specified");

        }
    }
}
