package Tests;

import HelperMethods.JavaScriptMethods;
import ShareData.ShareData;

import org.testng.annotations.Test;
import pages.CommonPage;
import pages.FramesPage;
import pages.HomePage;


public class FramesTest extends ShareData {

    JavaScriptMethods javaScriptMethods;
    HomePage homePage;
    CommonPage commonPage;
    FramesPage framesPage;

    @Test
    public void framesMethod() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        framesPage= new FramesPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Frames");

        framesPage.interactWithFrame1();
        framesPage.interactWithFrame2();
    }
}
