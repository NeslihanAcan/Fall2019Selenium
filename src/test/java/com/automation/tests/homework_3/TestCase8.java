package com.automation.tests.homework_3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase8 {

    /*
    Test case #8
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. And click on “Autocomplete”.
Step 3. Enter “United States of America” into country input box.
Step 4. Verify that following message is displayed: “You selected: United States of America”
     */

    private WebDriver driver;

    @Test
    public void testCase8 (){

        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);


        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);

        //Step 2. And click on “Autocomplete”.
        driver.findElement(By.cssSelector("[href='/autocomplete']")).click();
        BrowserUtils.wait(2);

        //Step 3. Enter “United States of America” into country input box.
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("input[type='button']")).click();
        BrowserUtils.wait(2);

        //Step 4. Verify that following message is displayed: “You selected: United States of America”

        WebElement message=driver.findElement(By.id("result"));
        Assert.assertTrue(message.isDisplayed());

        driver.quit();
    }
}
