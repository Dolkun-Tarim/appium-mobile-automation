package com.thescore.regression.page;

import com.thescore.regression.FunctionLibrary;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class GetStartedPage {
    private AndroidDriver driver;
    FunctionLibrary functionLibrary;
    public GetStartedPage(AndroidDriver driver)
    {
        this.driver=driver;
        functionLibrary=new FunctionLibrary(driver);
    }
  public void clickGetStartedButton()
  {
      WebElement getStartedButton=driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/btn_primary"));
      functionLibrary.waitUntilElementIsVisible(getStartedButton);
      functionLibrary.waitUntilButtonIsClickable(getStartedButton);
      getStartedButton.click();
  }
}
