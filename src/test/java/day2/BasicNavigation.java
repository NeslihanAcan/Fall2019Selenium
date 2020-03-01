package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        //in selenium everything starts  from WebDriver interface
        driver.get("http://google.com");//to open website


    }
}
