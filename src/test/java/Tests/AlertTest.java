package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavaScriptMethods;
import ShareData.ShareData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.CommonPage;
import pages.HomePage;

import java.time.Duration;

public class AlertTest extends ShareData {

    ElementsMethods elementsMethods;
    AlertMethods alertMethods;
    JavaScriptMethods javaScriptMethods;
    HomePage homePage;
    CommonPage commonPage;
    AlertsPage alertsPage;

    @Test
    public void alertMethod() {

        javaScriptMethods = new JavaScriptMethods(getDriver());
        alertMethods = new AlertMethods(getDriver());
        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        alertsPage = new AlertsPage(getDriver());

        javaScriptMethods.scrollDown(400);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Alerts");
        alertsPage.interactWithSimpleAlert();
        javaScriptMethods.scrollDown(300);

        alertsPage.interactWithDelayedAlert();
        alertsPage.interactWithConfirmAlert(false);
        alertsPage.verifyConfirmResult("You selected Cancel");
        alertsPage.interactWithPromptAlert("Jane", true);
        alertsPage.verifyPromptResult("You entered Jane");
    }
}
