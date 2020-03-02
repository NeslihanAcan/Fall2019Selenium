package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws  Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("http://google.com");
        Thread.sleep(2000);


         //  (By.name("q")--> name="q"
        WebElement search=driver.findElement(By.name("q"));
        //Once we found and element, how to enter text?
        //to enter text, use sendKeys() method
        //how to express Enter after entering the text?
        //use Key.ENTER
        search.sendKeys("Java", Keys.ENTER);

        Thread.sleep(4000);

        WebElement news= driver.findElement(By.linkText("News"));
        Thread.sleep(4000);

        driver.quit();
    }
}
