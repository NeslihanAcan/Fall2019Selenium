package com.automation.tests.homework_3;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCases_1_5 {

    private WebDriver driver;
    private By registrationForm = By.linkText("Registration Form");
    private By DOB=By.name("birthday");
    private String invalidDob = "30/05/2000";
    private By warningMessage = By.xpath("//small[@data-bv-result='INVALID']");
    private By cPlusPlus = By.xpath("//label[text()='C++']");
    private By java=By.xpath("//label[text()='Java']");
    private By javaScript=By.xpath("//label[text()='JavaScript']");
    private By firstName=By.name("firstname");
    private By warning=By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']");
    private By lastName=By.name("lastname");
    private By lastNameWarning=By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']");
    private By userName=By.name("username");
    private By email=By.name("email");
    private By passWord=By.name("password");
    private By phoneNum=By.name("phone");
    private By gender=By.cssSelector("input[value='female']");
    private By selectJava=By.id("inlineCheckbox2");
    private By signUp=By.cssSelector("button[id='wooden_spoon']");
    private By successMessage=By.xpath("//h4[@class='alert-heading']/following-sibling::p");



    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");


    }


    /*
    Test case #1
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter “wrong_dob” into date of birth input
box.
Step 4. Verify that warning message is displayed:
“The date of birth is not valid”
     */
    @Test(description = "Verify that warning message displays when user enters invalid username")
    public void invalidDob(){//Test case #1
        BrowserUtils.wait(3);
        driver.findElement(registrationForm).click();
        driver.findElement(DOB).sendKeys(invalidDob, Keys.ENTER);
        BrowserUtils.wait(3);
        String expected="The date of birth is not valid";
        String actual=driver.findElement(warningMessage).getText();
        BrowserUtils.wait(3);
        Assert.assertEquals(actual,expected);

    }
    /*
    Test case #2
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Verify that following options for
programming languages are displayed: c++, java,
JavaScript
     */
    @Test(description = "Verify that following options for" +
            "programming languages are displayed: c++, java," +
           "JavaScript")
    public void displayedLanguages(){
        driver.findElement(registrationForm).click();

    WebElement langCPlusPlus=driver.findElement(cPlusPlus);
    WebElement langJava=driver.findElement(java);
    WebElement langJavaScript=driver.findElement(javaScript);

    Assert.assertTrue(langCPlusPlus.isDisplayed());
     Assert.assertTrue(langJava.isDisplayed());
    Assert.assertTrue(langJavaScript.isDisplayed());

   }
   /*
   Test case #3
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into first
name input box.
Step 4. Verify that warning message is displayed:
“first name must be more than 2 and less than 64
characters long”
    */
   @Test(description = "Verify that warning message is displayed")
   public void warningMessage(){

       BrowserUtils.wait(3);
       driver.findElement(registrationForm).click();
       driver.findElement(firstName).sendKeys("N");

       WebElement warningg=driver.findElement(warning);

       Assert.assertTrue(warningg.isDisplayed());

   }
   /*
   Test case #4
Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into last
name input box.
Step 4. Verify that warning message is displayed:
“The last name must be more than 2 and less than
64 characters long”
    */
   @Test
   public void lastNameWarning(){
       driver.findElement(registrationForm).click();
       driver.findElement(lastName).sendKeys("A");

       WebElement warning=driver.findElement(lastNameWarning);

       Assert.assertTrue(warning.isDisplayed());
   }
/*
Test case #5
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter any valid first name.
Step 4. Enter any valid last name.
Step 5. Enter any valid user name.
Step 6. Enter any valid password.
Step 7. Enter any valid phone number.
Step 8. Select gender.
Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is
displayed: “You've successfully completed
registration!”
 */
   @Test
   public void completeRegistration(){

       driver.findElement(registrationForm).click();
       driver.findElement(firstName).sendKeys("Neslihan");
       driver.findElement(lastName).sendKeys("Acan");
       BrowserUtils.wait(2);
       driver.findElement(userName).sendKeys("Neslihan");
       BrowserUtils.wait(2);
       driver.findElement(email).sendKeys("neslihan@shortmail.com");
       driver.findElement(passWord).sendKeys("abcd1234");
       driver.findElement(phoneNum).sendKeys("218-123-3456");
       BrowserUtils.wait(2);
       driver.findElement(gender).click();
       driver.findElement(DOB).sendKeys("12/23/2000");
       BrowserUtils.wait(2);
       Select departmentSelect=new Select(driver.findElement(By.name("department")));
       departmentSelect.selectByValue("DA");

       Select jobTitle=new Select(driver.findElement(By.name("job_title")));
       jobTitle.selectByVisibleText("SDET");

       driver.findElement(selectJava).click();
       driver.findElement(signUp).click();

      WebElement messsage= driver.findElement(successMessage);

      Assert.assertTrue(messsage.isDisplayed());






   }



    @AfterMethod
    public void tearDown() {

         driver.quit();

    }
}