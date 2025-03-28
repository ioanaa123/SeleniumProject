package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class FramesTest {
    public WebDriver driver;

    @Test
    public void framesMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement alertElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertElement.click();

        WebElement framesElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        framesElement.click();

        WebElement firstFrameElement = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(firstFrameElement);

        WebElement firstFrameTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul frame este: " + firstFrameTextElement.getText());

        driver.switchTo().defaultContent();

        WebElement secondFrameElement = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(secondFrameElement);

        js.executeScript("window.scrollBy(200,200)");

        WebElement secondFrameTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din al doilea frame este: " + secondFrameTextElement.getText());

        driver.switchTo().defaultContent();

    }
}
