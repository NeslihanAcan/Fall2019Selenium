package com.automation.tests.homework_3;

import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

      @Test
    public void testCase7(){

          driver= DriverFactory.createDriver("chrome");

          //Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
          driver.get("https://practice-cybertekschool.herokuapp.com");

          //Step 2. And click on “File Upload"
          driver.findElement(By.cssSelector("[href='/upload']")).click();

          //Step 3. Upload any file with .txt extension from your computer.
        WebElement upload= driver.findElement(By.id("file-upload"));

        // String filePath = System.getProperty("user.dir")+"/pom.xml";
      String filePath=System.getProperty("User/neslihanacan/Desktop/Screen Shot 2020-03-20 at 1.44.05 PM.png");
      upload.sendKeys(filePath);


      }
}
