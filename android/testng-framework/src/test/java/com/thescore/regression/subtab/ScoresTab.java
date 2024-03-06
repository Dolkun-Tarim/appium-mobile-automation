package com.thescore.regression.subtab;

import com.thescore.regression.FunctionLibrary;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ScoresTab {
    private AndroidDriver driver;
    FunctionLibrary functionLibrary;
    public ScoresTab(AndroidDriver driver)
    {
        this.driver=driver;
        functionLibrary=new FunctionLibrary(driver);
    }
  public boolean verifyScoresTab()
  {
      WebElement scoresElement=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"SCORES\"]"));
      functionLibrary.waitUntilElementIsVisible(scoresElement);
      functionLibrary.waitUntilButtonIsClickable(scoresElement);
      return scoresElement.isDisplayed();
  }
}
