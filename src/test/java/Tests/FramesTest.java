package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JavaScriptMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.FramesPage;
import pages.HomePage;


public class FramesTest {
    public WebDriver driver;
    ElementsMethods elementsMethods;
    FramesMethods framesMethods;
    JavaScriptMethods javaScriptMethods;
    HomePage homePage;
    CommonPage commonPage;
    FramesPage framesPage;

    @Test
    public void framesMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);
        framesMethods = new FramesMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        framesPage= new FramesPage(driver);

        javaScriptMethods = new JavaScriptMethods(driver);
        javaScriptMethods.scroll(0, 400);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Frames");
        framesPage.interactWithFrame1();
        framesPage.interactWithFrame2();

        driver.close();
    }
}
