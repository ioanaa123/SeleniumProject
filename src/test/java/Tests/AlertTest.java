package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AlertTest {

    public WebDriver driver;

    @Test
    public void alertMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        // Definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement alertElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertElement.click();

        WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertsElement.click();

        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        firstAlertElement.click();

        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();

        WebElement delayAlertElement = driver.findElement(By.id("timerAlertButton"));
        delayAlertElement.click();

        //definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert delayAlert = driver.switchTo().alert();
        delayAlert.accept();

        WebElement confirmationAlertElement = driver.findElement(By.id("confirmButton"));
        confirmationAlertElement.click();

        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.dismiss();

        WebElement confirmationResultAlertElement = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(confirmationResultAlertElement.getText(), "You selected Cancel");

        WebElement promptAlertElement = driver.findElement(By.id("promtButton"));
        promptAlertElement.click();

        Alert promtAlert = driver.switchTo().alert();
        promtAlert.sendKeys("Jane");
        promtAlert.accept();

        //Verify entered value
        WebElement promptResultAlertElement = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(promptResultAlertElement.getText(), "You entered Jane");

        driver.close();
    }


}
