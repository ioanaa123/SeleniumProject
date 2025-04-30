package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {
    WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void interactWithAlertOk() {
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
    }

    public void interactWithAlertCancel() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //definim un wait explicit ca sa astepte dupa alerta
    public void explicitAlertWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void interactWithDelayAlert(){
        explicitAlertWait();
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.dismiss();
    }

    public void interactWithConfirmationAlert(){
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.dismiss();
    }

    public void interactWithPromptAlertAndConfirm(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public void interactWithPromptAlertAndCancel(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.dismiss();
    }
}
