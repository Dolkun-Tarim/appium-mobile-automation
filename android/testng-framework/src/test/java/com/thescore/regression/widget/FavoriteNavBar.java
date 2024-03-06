package com.thescore.regression.widget;

import com.thescore.regression.FunctionLibrary;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FavoriteNavBar {
    private AndroidDriver driver;
    FunctionLibrary functionLibrary;
    public FavoriteNavBar(AndroidDriver driver)
    {
        this.driver=driver;
        functionLibrary=new FunctionLibrary(driver);
    }
  public void clickLeagueNameOnNavBar(String leagueName)
  {
      String leagueNameXpath=String.format("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/label\" and @text=\"%s\"]",leagueName);
      WebElement leagueNameElementOnTheBar=driver.findElement(AppiumBy.xpath(leagueNameXpath));
      functionLibrary.waitUntilElementIsVisible(leagueNameElementOnTheBar);
      leagueNameElementOnTheBar.click();
  }
  public boolean verifyFavoriteNavBar()
  {
      WebElement favoriteLeagueTeamContainer=driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/chips_container"));
      functionLibrary.waitUntilElementIsVisible(favoriteLeagueTeamContainer);
      return favoriteLeagueTeamContainer.isDisplayed();
  }
}
