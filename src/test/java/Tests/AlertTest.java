package Tests;

import ShareData.ShareData;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.CommonPage;
import pages.HomePage;

public class AlertTest extends ShareData {

    HomePage homePage;
    CommonPage commonPage;
    AlertsPage alertsPage;

    @Test
    public void alertMethod() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        alertsPage = new AlertsPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Alerts");
        alertsPage.interactWithSimpleAlert();

        alertsPage.interactWithDelayedAlert();
        alertsPage.interactWithConfirmAlert(false);
        alertsPage.verifyConfirmResult("You selected Cancel");
        alertsPage.interactWithPromptAlert("Jane", true);
        alertsPage.verifyPromptResult("You entered Jane");
    }
}
