package com.automation.tests.homework_3;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private WebDriver driver;
    private By registrationForm = By.linkText("Registration Form");
    private By DOB=By.name("birthday");
    private String invalidDob = "30/05/2000";
    private By warningMessage = By.xpath("//small[@data-bv-result='INVALID']");
    private By displayedLanguageC=By.xpath("//label[contains(text(),'C++')]");
    private By displayedLanguageJava=By.xpath("//label[contains(text(),'Java')]");
    private By displayedLanguageJavaScript=By.xpath("//label[contains(text(),'Java')]");

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
    @Test(description = "Verify that following options for" +
            "programming languages are displayed: c++, java," +
            "JavaScript")
    public void displayedLanguages(){

    }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");


    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }
}