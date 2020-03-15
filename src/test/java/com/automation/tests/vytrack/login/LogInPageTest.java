package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LogInPageTest {
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsernameBy(By usernameBy) {
        this.usernameBy = usernameBy;
    }

    public void setPasswordBy(By passwordBy) {
        this.passwordBy = passwordBy;
    }

    private WebDriver driver;
    private String URL="https://qa2.vytrack.com/user/login";
    private String userName="storemanager85";
    private String password="UserUser123";
    private By usernameBy=By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By warningMessageBy=By.cssSelector("[class='alert alert-error']>div");



    @Test(description = "Verify that warning message displays when user enters invalid username")
    public void invalidUserName(){
    driver.findElement(usernameBy).sendKeys("invalidusername");
    driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement=driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected="Invalid user name or password.";
        String actual=warningElement.getText();
        assertEquals(actual,expected);
    }
    @Test(description = "Loin as store manager and verify that title is equals to Dashboard")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password,Keys.ENTER);
        BrowserUtils.wait(3);

        String expected="Dashboard";
        String actual=driver.getTitle();
        assertEquals(actual,expected,"Page title is not correct!");
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }



    @AfterMethod
    public void teardown(){
        //if wedriver object alive
        if(driver!=null){
            //close browser,close session
            driver.quit();
            //destroy driver object for sure
            driver=null;
        }

    }
}
