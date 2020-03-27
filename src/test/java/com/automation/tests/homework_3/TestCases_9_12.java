package com.automation.tests.homework_3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCases_9_12 {

    private WebDriver driver;
    private By statusCodesBy=By.cssSelector("[href='/status_codes']");

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(statusCodesBy).click();
    }
    /*
    Test case #9
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “200”.
Step 4. Verify that following message is displayed: “This page returned a 200 status code”
     */
    /*
    Test case #10
Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “301”.
Step 4. Verify that following message is displayed: “This page returned a 301 status code”
     */
    /*
    Test case #11
Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “404”.
Step 5. Verify that following message is displayed: “This page returned a 404 status code”
     */
    /*
    Test case #12
Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “500”.
Step 5. Verify that following message is displayed: “This page returned a 500 status code”
     */

    @Test(description = "Verify that expected message is displayed",dataProvider = "testData")
    public void test(String locators,String messages){
       driver.findElement(By.cssSelector(locators)).click();
        BrowserUtils.wait(2);
        String message=driver.findElement(By.xpath("//h3/following-sibling::p")).getText();
        BrowserUtils.wait(2);
        Assert.assertTrue(message.contains(messages));


    }
    @DataProvider(name="testData")
    public Object [][] testData(){
        return new Object[][]{{"[href='status_codes/200']","This page returned a 200 status code"},
                              {"[href='status_codes/301']","This page returned a 301 status code"},
                               {"[href='status_codes/404']","This page returned a 404 status code"},
                              {"[href='status_codes/500']","This page returned a 500 status code"}};
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
