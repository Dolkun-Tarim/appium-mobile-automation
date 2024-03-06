package com.thescore.regression.page;

import com.thescore.regression.FunctionLibrary;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FavoriteLeaguePage {
    private AndroidDriver driver;
    FunctionLibrary functionLibrary;
    public FavoriteLeaguePage(AndroidDriver driver)
    {
        this.driver=driver;
        functionLibrary=new FunctionLibrary(driver);
    }
  public boolean verifyFavoriteLeagueTitle()
  {
      WebElement leaguesTitleTextElement=driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/title_onboarding"));
      functionLibrary.waitUntilElementIsVisible(leaguesTitleTextElement);
      String titleText= leaguesTitleTextElement.getText();
      return titleText.contains("favorite leagues");
  }

  public boolean clickFavoriteLeague(String leagueName)
  {
      //select favorite league and verify
      boolean isLeagueDisplayed;
      String favoriteLeagueNameXpath=String.format("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"%s\"]",leagueName);
      WebElement leagueNameElement=driver.findElement(AppiumBy.xpath(favoriteLeagueNameXpath));
      functionLibrary.waitUntilElementIsVisible(leagueNameElement);
     isLeagueDisplayed=leagueNameElement.isDisplayed();
      leagueNameElement.click();
      return isLeagueDisplayed;
  }

  public void clickContinueButton()
  {
      WebElement continueButtonOnFavoriteLeaguesPage=driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/btn_primary"));
      functionLibrary.waitUntilElementIsVisible(continueButtonOnFavoriteLeaguesPage);
      functionLibrary.waitUntilButtonIsClickable(continueButtonOnFavoriteLeaguesPage);
      continueButtonOnFavoriteLeaguesPage.click();
  }

}
