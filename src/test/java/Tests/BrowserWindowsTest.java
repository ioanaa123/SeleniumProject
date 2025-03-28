package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTest {

    public WebDriver driver;

    @Test
    public void browserWindowMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement alertElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertElement.click();

        WebElement browserWindowElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindowElement.click();

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        newTabElement.click();

        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        WebElement newTabSampleElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul tab este: " + newTabSampleElement.getText());

        driver.close();
        driver.switchTo().window(tabList.get(0));
        //driver.switchTo().window(tabList.getFirst());

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        newWindowElement.click();

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
