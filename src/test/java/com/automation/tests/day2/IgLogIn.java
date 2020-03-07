package com.automation.tests.day2;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IgLogIn {
    public static void main(String[] args) throws Exception{

        WebDriver driver= DriverFactory.createDriver("Chrome");

        Thread.sleep(2000);

        driver.get("https://www.instagram.com/");

        WebElement logIn=driver.findElement(By.className("button"));
        logIn.click();


    }
}
