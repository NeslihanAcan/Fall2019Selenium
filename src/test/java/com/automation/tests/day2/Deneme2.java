package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deneme2 {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://facebook.com");

        Thread.sleep(3000);

        WebElement email=driver.findElement(By.id("email"));


        WebElement passWord=driver.findElement(By.id("pass"));


        WebElement Login=driver.findElement(By.id("u_0_b"));


         email.sendKeys("neslihan@hotmail.com");

        Thread.sleep(3000);

        passWord.sendKeys("abcd");

         Login.submit();





    }
}
