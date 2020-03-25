package com.automation.tests.day13;

import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverTest {

@Test
    public void googleTest(){
   // Driver.getDriver() Returns driver
    Driver.getDriver().get("http://google.com");
    Assert.assertEquals(Driver.getDriver(),"Google");

    Driver.closeDriver();
}
}
