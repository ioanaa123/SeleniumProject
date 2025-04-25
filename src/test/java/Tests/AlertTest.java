package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;
    AlertMethods alertMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void alertMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);
        alertMethods = new AlertMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        // Definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Alerts");

        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        elementsMethods.clickOnElement(firstAlertElement);
        alertMethods.interactWithAlertOk();

        WebElement delayAlertElement = driver.findElement(By.id("timerAlertButton"));
        elementsMethods.clickOnElement(delayAlertElement);
        alertMethods.interactWithDelayAlert();

        WebElement confirmationAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethods.clickOnElement(confirmationAlertElement);
        alertMethods.interactWithConfirmationAlert();

        WebElement confirmationResultAlertElement = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(confirmationResultAlertElement.getText(), "You selected Cancel");

        WebElement promptAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethods.clickOnElement(promptAlertElement);
        alertMethods.interactWithPromtAlert("Jane");

        //Verify entered value
        WebElement promptResultAlertElement = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(promptResultAlertElement.getText(), "You entered Jane");

        driver.close();
    }
}
