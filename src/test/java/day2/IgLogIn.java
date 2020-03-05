package day2;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IgLogIn {
    public static void main(String[] args) throws Exception{

        WebDriver driver= DriverFactory.createDriver("Chrome");

        Thread.sleep(2000);

        driver.get("https://www.instagram.com/");

        WebElement logIn=driver.findElement(By.className("button"));
        logIn.click();


    }
}
