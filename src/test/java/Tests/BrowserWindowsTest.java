package Tests;

import ShareData.ShareData;

import org.testng.annotations.Test;
import pages.BrowserWindowsPage;
import pages.CommonPage;
import pages.HomePage;

public class BrowserWindowsTest extends ShareData {

    HomePage homePage;
    CommonPage commonPage;
    BrowserWindowsPage browserWindowsPage;

    @Test
    public void browserWindowMethod() {


        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        browserWindowsPage = new BrowserWindowsPage(getDriver());
        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Browser Windows");

        browserWindowsPage.interactWithTheNewTab();



//        WebElement newWindowMsgElement = driver.findElement(By.id("messageWindowButton"));
//        elementsMethods.clickOnElement(newWindowMsgElement);
//
//        windowsMethods.switchToMainWindow();
//
//
//        WebElement newWindowMsgSampleElement = driver.findElement(By.id("sampleHeading"));
//        System.out.println("Textul din noul tab este: " + newWindowMsgSampleElement.getText());
//
//        driver.close();
//        windowsMethods.switchToMainTab();

    }
}
