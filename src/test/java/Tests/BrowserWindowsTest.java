package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavaScriptMethods;
import HelperMethods.WindowsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;

public class BrowserWindowsTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;
    JavaScriptMethods javaScriptMethods;
    WindowsMethods windowsMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void browserWindowMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethods = new ElementsMethods(driver);
        windowsMethods = new WindowsMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        javaScriptMethods = new JavaScriptMethods(driver);
        javaScriptMethods.scrollDown(500);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Browser Windows");

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        elementsMethods.clickOnElement(newTabElement);

        windowsMethods.switchToOpenTab();

        WebElement newTabSampleElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul tab este: " + newTabSampleElement.getText());

        driver.close();
        windowsMethods.switchToMainTab();

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        elementsMethods.clickOnElement(newWindowElement);
        windowsMethods.switchToOpenWindow();

        WebElement newWindowSampleElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul window este: " + newWindowSampleElement.getText());

        driver.close();
        windowsMethods.switchToMainTab();
        javaScriptMethods.scrollDown(500);

        WebElement newWindowMsgElement = driver.findElement(By.id("messageWindowButton"));
        elementsMethods.clickOnElement(newWindowMsgElement);

        windowsMethods.switchToMainWindow();


        WebElement newWindowMsgSampleElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul tab este: " + newWindowMsgSampleElement.getText());

        driver.close();
        windowsMethods.switchToMainTab();

    }
}
