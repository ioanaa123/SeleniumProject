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
import pages.HomePage;


public class FramesTest {
    public WebDriver driver;
    ElementsMethods elementsMethods;
    FramesMethods framesMethods;
    JavaScriptMethods javaScriptMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void framesMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);
        framesMethods = new FramesMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        javaScriptMethods = new JavaScriptMethods(driver);
        javaScriptMethods.scroll(0, 400);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Frames");

        WebElement firstFrameElement = driver.findElement(By.id("frame1"));
        framesMethods.switchToFrame(firstFrameElement);

        WebElement firstFrameTextElement = driver.findElement(By.id("sampleHeading"));
        elementsMethods.displayElementContent(firstFrameTextElement);

        framesMethods.switchToDefault();

        WebElement secondFrameElement = driver.findElement(By.id("frame2"));
        framesMethods.switchToFrame(secondFrameElement);

        javaScriptMethods.scroll(200, 200);

        WebElement secondFrameTextElement = driver.findElement(By.id("sampleHeading"));
        elementsMethods.displayElementContent(secondFrameTextElement);
        framesMethods.switchToDefault();

        driver.close();
    }
}
