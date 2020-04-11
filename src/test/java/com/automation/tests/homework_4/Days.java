package com.automation.tests.homework_4;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

/*DAYS
1. go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
2. Randomly select a checkbox. As soon as you check any day, print the name of the day
and uncheck immediately.
After you check and uncheck Friday for the third time, exit the program.
NOTE: Remember some checkboxes are not selectable. You need to find a way to ignore them
when they are randomly selected. It has to be dynamic. Do not hard code Saturday and Sunday.
Use values of certain attributes.*/
public class Days {


    private WebDriver driver;

    private String url="http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox";

    private By daysBy=By.className("gwt-CheckBox");

    @BeforeMethod
    public void start(){
       driver= DriverFactory.createDriver("chrome");
        BrowserUtils.wait(3);
    }
    @Test
    public void daysTest(){
        driver.get(url);
        BrowserUtils.wait(3);
        List<WebElement>checkBox=driver.findElements(daysBy);
        int count=0;
        Random random=new Random();
        BrowserUtils.wait(3);

        while(count<3){
            int randomDay=random.nextInt(7);
            if(checkBox.get(randomDay).findElement(By.tagName("input")).isEnabled()){
                checkBox.get(randomDay).click();
                BrowserUtils.wait(1);
                System.out.println(checkBox.get(randomDay).getText());
                checkBox.get(randomDay).click();
                if(checkBox.get(randomDay).getText().equalsIgnoreCase("friday")){
                    count++;
                }
            }

        }

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}