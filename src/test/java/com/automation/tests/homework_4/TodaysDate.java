package com.automation.tests.homework_4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.LocalDate;


public class TodaysDate {
    /**
     * TODAYS DATE
     * 1. go to http://practice.cybertekschool.com/dropdown
     * 2. verify that dropdowns under Select your date of birth display current year, month, day
     */

    private WebDriver driver;

    private String url="http://practice.cybertekschool.com/dropdown";
    private By yearBy=By.id("year");
    private By monthBy=By.id("month");
    private By dayBy=By.id("day");

    @AfterMethod
    public void setup(){

        driver= DriverFactory.createDriver("chrome");
        driver.get(url);
        BrowserUtils.wait(3);
    }
    @Test(dataProvider ="Dropdown")
    public void todaysDateTest(String dropName, String actualData) {

        BrowserUtils.wait(3);
        String expectedData=new Select(driver.findElement(By.id(dropName))).getFirstSelectedOption().getText().toLowerCase();
        Assert.assertEquals(actualData.toLowerCase(),expectedData);

    }
        @DataProvider(name = "Dropdown")
         public Object [][] testData(){
            return new Object [][]{
                    {"year",String.valueOf(LocalDate.now().getYear())},
                    {"month",String.valueOf(LocalDate.now().getMonth())},
                    {"day",String.valueOf(LocalDate.now().getDayOfMonth())}

            };
    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();

    }
}
