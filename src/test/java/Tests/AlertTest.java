package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavaScriptMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.CommonPage;
import pages.HomePage;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;
    AlertMethods alertMethods;
    JavaScriptMethods javaScriptMethods;
    HomePage homePage;
    CommonPage commonPage;
    AlertsPage alertsPage;

    @Test
    public void alertMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        javaScriptMethods = new JavaScriptMethods(driver);
        alertMethods = new AlertMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        alertsPage = new AlertsPage(driver);

        // Definim un wait implicit pentru un interval maxim de timp
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
        driver.close();
    }
}
