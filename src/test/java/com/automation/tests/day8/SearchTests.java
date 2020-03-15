package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest() {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        //since every search item has a tag name <h3>
        //it's the easiest way to collect all of them
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems) {
            String var = searchItem.getText();
            //if there is a text - print it
            if (!var.isEmpty()) {
                System.out.println(var.toLowerCase());
                //verify that every search result contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }

    @Test(description = "Search for java book on amazon")
    public void amazonSearchTest() {
        driver.get("http://amazon.com");
        driver.manage().window().maximize();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(5);

        List<WebElement> searchItems = driver.findElements(By.tagName("h2"));

        searchItems.get(0).click();
        BrowserUtils.wait(3);

        WebElement productTitle = driver.findElement(By.id("ebooksProductTitle"));
        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));
    }

    @Test
    public void LogInTest(){

        driver.get("http://practice.cybertekschool.com/");
    }





    @BeforeMethod
    public void setup(){
        //setup webdriver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        //close browser and destroy webdriver object
        driver.quit();
    }

}