package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().version("79").setup();
            return new ChromeDriver();

        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        }else if(browserName.equalsIgnoreCase("opera")){
          WebDriverManager.operadriver();
            return new OperaDriver();
        }else if(browserName.equalsIgnoreCase("edge")){
            return new EdgeDriver();
        }else{
            throw  new WebDriverException("Browser not specified");
        }
    }

}
