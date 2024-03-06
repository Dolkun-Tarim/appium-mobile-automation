package com.thescore.regression;

import com.thescore.regression.page.CommonPage;
import com.thescore.regression.page.FavoriteLeaguePage;
import com.thescore.regression.page.FavoriteTeamPage;
import com.thescore.regression.page.GetStartedPage;
import com.thescore.regression.popup.DialogPopup;
import com.thescore.regression.subtab.ScoresTab;
import com.thescore.regression.subtab.StandingsTab;
import com.thescore.regression.widget.FavoriteNavBar;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LeagueTest extends AppiumBaseTest {
    @Test (groups = "AppOnboarding")
    public void getStartedPageTest() {
      //find Get Started Button and Click
        GetStartedPage getStartedPage=new GetStartedPage(driver);
        getStartedPage.clickGetStartedButton();
      //verify Choose your favorite leagues title
        FavoriteLeaguePage favoriteLeaguePage=new FavoriteLeaguePage(driver);
        Assert.assertTrue(favoriteLeaguePage.verifyFavoriteLeagueTitle());
    }
    @Test(description = "add favorite leagues test",dataProvider = "leagues",dependsOnGroups = "AppOnboarding",groups = "favoriteLeague")
    public void favoriteLeaguesTest(String leagueName)
    {
        //verify selecting favorite leagues
        FavoriteLeaguePage favoriteLeaguePage=new FavoriteLeaguePage(driver);
        Assert.assertTrue(favoriteLeaguePage.clickFavoriteLeague(leagueName));
    }
    @DataProvider(name = "leagues")
    public Object[][] LeagueData()
    {
        return new Object[][]
                {
                        {"NFL Football"},
                        {"NBA Basketball"}
                };
    }

    @Test(description = "Tailored content test",dependsOnGroups = "favoriteLeague",groups = "tailoredContent")
    public void tailoredContentTest()
    {
        // find Continue Button and Click
        FavoriteLeaguePage favoriteLeaguePage=new FavoriteLeaguePage(driver);
        favoriteLeaguePage.clickContinueButton();
        // find Allow Location button and click
        CommonPage commonPage=new CommonPage(driver);
        commonPage.clickAllowLocationButton();
        //find While using the app button and click
        commonPage.clickAllowLocationWhileUsingButton();
        //verify the search field in the team page
        FavoriteTeamPage favoriteTeamPage=new FavoriteTeamPage(driver);
        Assert.assertTrue(favoriteTeamPage.verifyFavoriteTeamSearchField());

    }
    @Test(description = "add favorite teams test",dependsOnGroups ="tailoredContent",dataProvider = "teamData",groups = "favoriteTeams")
    public void favoriteTeamsTest(String leagueName,String teamName,String teamShortName)
    {
        //verify the favorite league page
        FavoriteTeamPage favoriteTeamPage=new FavoriteTeamPage(driver);
        favoriteTeamPage.clickLeagueName(leagueName);
        //verify the favorite team page and click on a team
        favoriteTeamPage.clickTeamName(teamName);
        //verify the team tab displayed
        Assert.assertTrue(favoriteTeamPage.verifyFavoriteTeamTab(teamShortName));
    }
    @DataProvider(name = "teamData")
    public Object[][] teamData()
    {
        return new Object[][]
                {
                        {"NFL","Buffalo Bills","BUF"},
                        {"NBA","Boston Celtics","BOS"}
                };
    }

    @Test(description = "verify that favorite leagues and team onboarding workflow",dependsOnGroups ="favoriteTeams",groups = "favoriteLeagueTeamBar")
    public void favoriteLeaguesTeamsBarTest()
    {
        FunctionLibrary functionLibrary=new FunctionLibrary(driver);
        // find Continue Button and Click
        FavoriteLeaguePage favoriteLeaguePage=new FavoriteLeaguePage(driver);
        favoriteLeaguePage.clickContinueButton();
        //find Done button and click
        CommonPage commonPage=new CommonPage(driver);
        commonPage.clickDoneButton();
        //click allow button if displayed
        functionLibrary.sleep(5);
        DialogPopup dialogPopup=new DialogPopup(driver);
        dialogPopup.clickAllowNotificationIfVisible();
        //verify favorite tabs
        FavoriteTeamPage favoriteTeamPage=new FavoriteTeamPage(driver);
        Assert.assertTrue(favoriteTeamPage.verifyFavoriteNavBar());
    }

    @Test(description = "verify page navigation for teams",dependsOnGroups = "favoriteLeagueTeamBar",dataProvider = "favoriteLeagueData")
    public void pageNavigationLeaguesTest(String leagueName)
    {
        FunctionLibrary functionLibrary=new FunctionLibrary(driver);
        FavoriteNavBar favoriteNavBar=new FavoriteNavBar(driver);
        favoriteNavBar.clickLeagueNameOnNavBar(leagueName);

        //verify STANDINGS Tab
        StandingsTab standingsTab=new StandingsTab(driver);
        Assert.assertTrue(standingsTab.verifyStandingsTab());
        //verify SCORES Tab
        ScoresTab scoresTab=new ScoresTab(driver);
        Assert.assertTrue(scoresTab.verifyScoresTab());
        //click on the back button
        CommonPage commonPage=new CommonPage(driver);
        commonPage.clickBackButton();
        //verify the favoriteLeagueTeamContainer
        Assert.assertTrue(favoriteNavBar.verifyFavoriteNavBar());
    }

    @DataProvider(name = "favoriteLeagueData")
    public Object[][] favoriteLeagueData()
    {
        return new Object[][]
                {
                        {"NFL"},
                        {"NBA"}
                };
    }
}
