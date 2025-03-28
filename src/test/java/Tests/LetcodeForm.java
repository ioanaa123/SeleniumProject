package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LetcodeForm {

    public WebDriver driver;

    @Test
    public void Form(){
        driver = new ChromeDriver();
        driver.get("https://letcode.in/forms");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        WebElement countrycodeField = driver.findElement(By.xpath("//form/div[2]/div[2]//select"));
        js.executeScript("arguments[0].click();", countrycodeField);
        countrycodeField.sendKeys("RO");
        countrycodeField.sendKeys(Keys.ENTER);

        WebElement stateField = driver.findElement(By.id("state"));
        stateField.sendKeys("Cluj");

        driver.close();
    }
}
