package com.thescore.regression.popup;

import com.thescore.regression.FunctionLibrary;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DialogPopup {
    private AndroidDriver driver;
    FunctionLibrary functionLibrary;
    public DialogPopup(AndroidDriver driver)
    {
        this.driver=driver;
        functionLibrary=new FunctionLibrary(driver);
    }
  public void clickAllowNotificationIfVisible()
  {
      List<WebElement> dialogElement=driver.findElements(AppiumBy.id("com.android.permissioncontroller:id/grant_dialog"));
      if(dialogElement.size()>=1)
      {
          WebElement allowNotificationButton=driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
          functionLibrary.waitUntilElementIsVisible(allowNotificationButton);
          functionLibrary.waitUntilButtonIsClickable(allowNotificationButton);
          allowNotificationButton.click();
      }
  }
}
