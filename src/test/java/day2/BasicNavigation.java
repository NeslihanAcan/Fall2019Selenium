package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {
        //to start selenium script we need:
        //setup webdriver (browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        //in selenium everything starts  from WebDriver interface
        //ChromeDriver extends RemoteWebDriver --> implements WebDriver
        driver.get("http://google.com");//to open website

        Thread.sleep(3000);//for demo , wait 3 seconds
        //Returns page title
        //you can also see it as tab name, in the browser
        String title= driver.getTitle(); //returns <title>Some title</title> text
        String expectedTitle="Google";
        System.out.println(title);
        if(expectedTitle.equals(title)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED!!");
        }


         driver.close();// to close browser
        //browser can not close it self.

    }
}
