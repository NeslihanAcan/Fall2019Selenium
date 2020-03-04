package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IgLogIn {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        Thread.sleep(2000);

        driver.get("https://www.instagram.com/");

        WebElement faceBookLogIn=driver.findElement(By.partialLinkText("Log in"));
        faceBookLogIn.submit();


    }
}
