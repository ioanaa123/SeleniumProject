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

        javaScriptMethods = new JavaScriptMethods(driver);
        alertMethods = new AlertMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        alertsPage = new AlertsPage(driver);

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
