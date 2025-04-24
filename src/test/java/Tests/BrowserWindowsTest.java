package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavaScriptMethods;
import HelperMethods.WindowsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;
    JavaScriptMethods javaScriptMethods;
    WindowsMethods windowsMethods;

    @Test
    public void browserWindowMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethods = new ElementsMethods(driver);
        windowsMethods = new WindowsMethods(driver);

        javaScriptMethods = new JavaScriptMethods(driver);
        javaScriptMethods.scrollDown(500);

        WebElement alertElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethods.clickOnElement(alertElement);

        WebElement browserWindowElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementsMethods.clickOnElement(browserWindowElement);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        elementsMethods.clickOnElement(newTabElement);

        windowsMethods.switchToOpenTab();

        WebElement newTabSampleElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul tab este: " + newTabSampleElement.getText());

        driver.close();
        windowsMethods.switchToMainTab();
       //driver.switchTo().window(tabList.getFirst());

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        windowsMethods.switchToOpenWindow();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        WebElement newWindowSampleElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul tab este: " + newWindowSampleElement.getText());

        driver.close();
        driver.switchTo().window(windowList.get(0));

        WebElement newWindowMsgElement = driver.findElement(By.id("messageWindowButton"));
        newWindowMsgElement.click();

        List<String> newWindowMsgList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newWindowMsgList.get(1));

//        WebElement newWindowMsgSampleElement = driver.findElement(By.id("sampleHeading"));
//        System.out.println("Textul din noul tab este: " + newWindowMsgSampleElement.getText());

        driver.close();
        driver.switchTo().window(newWindowMsgList.get(0));

    }
}
