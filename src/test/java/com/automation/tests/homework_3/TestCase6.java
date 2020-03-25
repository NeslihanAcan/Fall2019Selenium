package com.automation.tests.homework_3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase6 {
    /*
    Test case #6
Step 1. Go to "https://www.tempmailaddress.com/" Step 2. Copy and save email as a string.
Step 3. Then go to “https://practice- cybertekschool.herokuapp.com”
Step 4. And click on “Sign Up For Mailing List". Step 5. Enter any valid name.
Step 6. Enter email from the Step 2.
Step 7. Click Sign Up
Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
Step 9. Navigate back to the “https:// www.tempmailaddress.com/”
Step 10. Verify that you’ve received an email from
“do-not-reply@practice.cybertekschool.com”
Step 11. Click on that email to open it.
Step 12. Verify that email is from: “do-not- reply@practice.cybertekschool.com”
Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
     */



    private WebDriver driver;
    private By emailBy=By.id("email");
    private By fullNameBy=By.name("full_name");
    private By messageBy=By.xpath("//h3[text()='Thank you for signing up. Click the button below to return to the home page.']");
    private String mailUrl="https://www.tempmailaddress.com/";

    @Test
    public void TestCase_6(){

        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        driver.get(mailUrl);
        String getEmail= driver.findElement(emailBy).getText();
        BrowserUtils.wait(2);

       driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");

       driver.findElement(By.cssSelector("[href='/sign_up']")).click();
        BrowserUtils.wait(2);

       driver.findElement(fullNameBy).sendKeys("Neslihan Acan");

       driver.findElement(By.name("email")).sendKeys(getEmail);

       driver.findElement(By.cssSelector("button[type='submit']")).click();
        BrowserUtils.wait(2);

       WebElement message =driver.findElement(messageBy);
       Assert.assertTrue(message.isDisplayed());
       BrowserUtils.wait(3);

       driver.findElement(By.id("wooden_spoon")).click();

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        BrowserUtils.wait(3);

       String actual= driver.findElement(By.xpath("//tbody[@id='schranka']/tr[1]/td[1]")).getText().trim();
       String expected="do-not-reply@practice.cybertekschool.com";
       Assert.assertEquals(actual,expected);
        BrowserUtils.wait(3);

        driver.findElement(By.className("from")).click();

      String actual2= driver.findElement(By.id("odesilatel")).getText();
      String expected2="do-not-reply@practice.cybertekschool.com";
      Assert.assertEquals(actual2,expected2);
      BrowserUtils.wait(3);

        String actual3=driver.findElement(By.id("predmet")).getText();
       String expected3="Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actual3,expected3);

      driver.quit();







    }
}
