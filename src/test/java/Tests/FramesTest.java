package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JavaScriptMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class FramesTest {
    public WebDriver driver;
    ElementsMethods elementsMethods;
    FramesMethods framesMethods;
    JavaScriptMethods javaScriptMethods;

    @Test
    public void framesMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);
        framesMethods = new FramesMethods(driver);

        javaScriptMethods = new JavaScriptMethods(driver);
        javaScriptMethods.scroll(0, 400);

        WebElement alertElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethods.clickOnElement(alertElement);

        WebElement framesElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementsMethods.clickOnElement(framesElement);

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
