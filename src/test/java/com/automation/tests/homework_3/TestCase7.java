package com.automation.tests.homework_3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7 {

    /*
    Test case #7
Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
Step 2. And click on “File Upload".
Step 3. Upload any file with .txt extension from your computer.
Step 4. Click “Upload” button.
Step 5. Verify that subject is: “File Uploaded!” Step 6. Verify that uploaded file name is displayed.
Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading. Run this method against “Choose File” button.
     */

      private WebDriver driver;

      @BeforeMethod
      public void setup(){
          driver= DriverFactory.createDriver("chrome");
          //Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
          driver.get("https://practice-cybertekschool.herokuapp.com");
          driver.manage().window().maximize();
          BrowserUtils.wait(3);
      }
      @Test
    public void testCase7(){

          //Step 2. And click on “File Upload"
          driver.findElement(By.cssSelector("[href='/upload']")).click();
          BrowserUtils.wait(2);

          //Step 3. Upload any file with .txt extension from your computer.
         WebElement upload=driver.findElement(By.id("file-upload"));
          BrowserUtils.wait(4);

         // String filePath=System.getProperty("Users/neslihanacan/Desktop/abc");
         upload.sendKeys("/Users/neslihanacan/Desktop/Test cases 2-1 (1).pdf");
          BrowserUtils.wait(2);


          //Step 4. Click “Upload” button.
         driver.findElement(By.cssSelector("input[class='button']")).click();
          BrowserUtils.wait(3);


      //Step 5. Verify that subject is: “File Uploaded!” Step 6. Verify that uploaded file name is displayed.

          WebElement verify=driver.findElement(By.id("uploaded-files"));
          Assert.assertTrue(verify.isDisplayed());

      }
      @AfterMethod
    public void teardown(){
          driver.quit();
      }
}
