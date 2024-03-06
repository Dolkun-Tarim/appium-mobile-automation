package com.thescore.regression.subtab;

import com.thescore.regression.FunctionLibrary;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class StandingsTab {
    private AndroidDriver driver;
    FunctionLibrary functionLibrary;
    public StandingsTab(AndroidDriver driver)
    {
        this.driver=driver;
        functionLibrary=new FunctionLibrary(driver);
    }
  public boolean verifyStandingsTab()
  {
      WebElement standingTabElement=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"STANDINGS\"]"));
      functionLibrary.waitUntilElementIsVisible(standingTabElement);
      functionLibrary.waitUntilButtonIsClickable(standingTabElement);
      return standingTabElement.isDisplayed();
  }
}
