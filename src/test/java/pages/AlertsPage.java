package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlertsPage extends CommonPage{

    @FindBy(id = "alertButton")
    private WebElement alertOkButtonElement;
    @FindBy(id = "timerAlertButton")
    private WebElement delayedAlertButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement alertConfirmButtonElement;
    @FindBy(id = "promtButton")
    private WebElement alertPromptButtonElement;
    @FindBy(id = "confirmResult")
    private WebElement confirmResult;
    @FindBy(id = "promptResult")
    private WebElement promptResult;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithSimpleAlert() {
        elementsMethods.clickOnElement(alertOkButtonElement);
        alertMethods.interactWithAlertOk();
    }

    public void interactWithDelayedAlert() {
        // Alert cu delay la afisare
        elementsMethods.clickOnElement(delayedAlertButtonElement);
        alertMethods.interactWithDelayAlert();
    }

    public void interactWithConfirmAlert(boolean isConfirmed) {
        // Alert cu Confirm - OK/cancel
        elementsMethods.clickOnElement(alertConfirmButtonElement);

        if (isConfirmed) {
            alertMethods.interactWithAlertOk();
        } else {
            alertMethods.interactWithAlertCancel();
        }
    }

    public void interactWithPromptAlert(String inputText, boolean isConfirmed) {
        // Alert cu Prompt Text
        elementsMethods.clickOnElement(alertPromptButtonElement);
        if (isConfirmed) {
            alertMethods.interactWithPromptAlertAndConfirm(inputText);
        } else {
            alertMethods.interactWithPromptAlertAndCancel(inputText);
        }
    }

    public void verifyConfirmResult(String expectedResult){
        Assert.assertEquals(confirmResult.getText(), expectedResult);
    }

    public void verifyPromptResult(String expectedResult){
        Assert.assertEquals(promptResult.getText(), expectedResult);
    }

}
