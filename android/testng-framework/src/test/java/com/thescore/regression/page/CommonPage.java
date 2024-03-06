package com.thescore.regression.page;

import com.thescore.regression.FunctionLibrary;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class CommonPage {
    private AndroidDriver driver;
    FunctionLibrary functionLibrary;
    public CommonPage(AndroidDriver driver)
    {
        this.driver=driver;
        functionLibrary=new FunctionLibrary(driver);
    }
  public void clickBackButton()
  {
      WebElement backButton=driver.findElement(AppiumBy.accessibilityId("Navigate up"));
      functionLibrary.waitUntilElementIsVisible(backButton);
      backButton.click();
  }

  public void clickAllowLocationButton()
  {
      WebElement allowLocationButton=driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/btn_allow"));
      functionLibrary.waitUntilElementIsVisible(allowLocationButton);
      functionLibrary.waitUntilButtonIsClickable(allowLocationButton);
      allowLocationButton.click();
  }
  public void clickAllowLocationWhileUsingButton()
  {
      WebElement whileUsingTheAppButton=driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
      functionLibrary.waitUntilElementIsVisible(whileUsingTheAppButton);
      functionLibrary.waitUntilButtonIsClickable(whileUsingTheAppButton);
      whileUsingTheAppButton.click();
  }
  public void clickDoneButton()
  {
      WebElement doneButton=driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"));
      functionLibrary.waitUntilElementIsVisible(doneButton);
      functionLibrary.waitUntilButtonIsClickable(doneButton);
      doneButton.click();
  }
}
