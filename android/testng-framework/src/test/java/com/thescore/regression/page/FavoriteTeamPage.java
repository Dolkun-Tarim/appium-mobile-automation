package com.thescore.regression.page;

import com.thescore.regression.FunctionLibrary;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FavoriteTeamPage {
    private AndroidDriver driver;
    FunctionLibrary functionLibrary;
    public FavoriteTeamPage(AndroidDriver driver)
    {
        this.driver=driver;
        functionLibrary=new FunctionLibrary(driver);
    }


    public void clickLeagueName(String leagueName)
    {
        String displayedLeagueNameXpath=String.format("(//android.widget.TextView[@text=\"%s\"])[2]",leagueName);
        WebElement leagueNameElement=driver.findElement(AppiumBy.xpath(displayedLeagueNameXpath));
        functionLibrary.waitUntilElementIsVisible(leagueNameElement);
        leagueNameElement.click();
    }

    public void clickTeamName(String teamName)
    {
        String teamNameXpath=String.format("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"%s\"]",teamName);
        WebElement teamNameElement=driver.findElement(AppiumBy.xpath(teamNameXpath));
        functionLibrary.waitUntilElementIsVisible(teamNameElement);
        teamNameElement.click();
    }

    public boolean verifyFavoriteTeamTab(String teamShortName)
    {
        String teamShortNameTabXpath=String.format("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/label\" and @text=\"%s\"]",teamShortName);
        WebElement teamShortNameTab=driver.findElement(AppiumBy.xpath(teamShortNameTabXpath));
        functionLibrary.waitUntilElementIsVisible(teamShortNameTab);
       return teamShortNameTab.isDisplayed();
    }

    public boolean verifyFavoriteNavBar()
    {
        WebElement favoriteLeagueAndTeamsNavBar=driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/horizontal_recycler_view"));
        functionLibrary.waitUntilElementIsVisible(favoriteLeagueAndTeamsNavBar);
        return favoriteLeagueAndTeamsNavBar.isDisplayed();
    }

}
