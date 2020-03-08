package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

//Here we selected option to in website.

            WebDriver driver = DriverFactory.createDriver("chrome");
            driver.get("http://practice.cybertekschool.com/dropdown");
            BrowserUtils.wait(3);
            //create a webelement object for drop-down first
            WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
            //provide weblement object into constructor
            Select selectSimpleDropdown = new Select(simpleDropdown);
            //select by visible text
            selectSimpleDropdown.selectByVisibleText("Option 2");
            BrowserUtils.wait(3);
            //and select option 1
            selectSimpleDropdown.selectByVisibleText("Option 1");
            //select you DOB
            Select selectYear = new Select(driver.findElement(By.id("year")));
            Select selectMonth = new Select(driver.findElement(By.id("month")));
            Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("2003");
        selectMonth.selectByVisibleText("February");
        selectDay.selectByVisibleText("3");
            BrowserUtils.wait(3);

            //select all month one by one
        List<WebElement>months=selectMonth.getOptions();
        for(WebElement eachMonths: months){
            String monthName=eachMonths.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);

        }
        BrowserUtils.wait(3);
       Select selectState= new Select(driver.findElement(By.id("state")));
       selectState.selectByVisibleText("District Of Columbia");
       String selected=selectState.getFirstSelectedOption().getText();
       if(selected.equals("District Of Columbia")){
           System.out.println("Test passed!!!");
       }else{
           System.out.println("Test failed!!!");
       }

       List<WebElement>states=selectState.getOptions();
       for(WebElement stateOption:states){
           System.out.println(stateOption.getText());
       }

            BrowserUtils.wait(3);
            driver.quit();
        }
    }