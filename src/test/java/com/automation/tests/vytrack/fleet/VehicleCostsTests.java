package com.automation.tests.vytrack.fleet;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehicleCostsPage;
import com.automation.pages.fleet.VehiclesPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VehicleCostsTests extends AbstractTestBase {


    @Test(dataProvider = "pageSubTitle")
    public void verifyPageSubtitle(String username,String password){
        test=report.createTest("Verify page subtitle");
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
        VehicleCostsPage vehicleCostsPage=new VehicleCostsPage();
        vehicleCostsPage.navigateTo("Fleet","Vehicle Costs");

        String expectedSubtitle="All car's cost";
        String actualSubtitle= vehicleCostsPage.getSubTitle();

        Assert.assertEquals(expectedSubtitle,actualSubtitle);

       test.pass("Page subtitle verified");
    }
    @DataProvider
    public Object[][] pageSubTitle(){
        return new Object[][]{
                {"storemanager73","UserUser123"},
                {"storemanager74","UserUser123"},
                {"salesmanager134","UserUser123"},
                {"salesmanager135","UserUser123"},
                {"salesmanager136","UserUser123"}

        };
    }
}
//storemanager73 , storemanager74
//salesmanager134 , salesmanager135 , salesmanager136
//UserUser123