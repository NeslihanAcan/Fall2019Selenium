package com.automation.pages.fleet;

import com.automation.pages.AbstractPageBase;
import com.automation.pages.LoginPage;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleCostsPage extends AbstractPageBase {

    @FindBy(css = "[class='oro-subtitle']")
    private WebElement title;

    public String getSubTitle(){

      return title.getText().trim();
    }
}
