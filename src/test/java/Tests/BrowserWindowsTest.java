package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavaScriptMethods;
import HelperMethods.WindowsMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BrowserWindowsPage;
import pages.CommonPage;
import pages.HomePage;

public class BrowserWindowsTest extends ShareData {

    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void browserWindowMethod() {


        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Browser Windows");

//        browserWindowsPage.interactWithTheNewTab();

//
//        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
//        elementsMethods.clickOnElement(newWindowElement);
//        windowsMethods.switchToOpenWindow();
//
//        WebElement newWindowSampleElement = driver.findElement(By.id("sampleHeading"));
//        System.out.println("Textul din noul window este: " + newWindowSampleElement.getText());
//
//        driver.close();
//        windowsMethods.switchToMainTab();
//        javaScriptMethods.scrollDown(500);
//
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
