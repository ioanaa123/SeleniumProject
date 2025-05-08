package HelperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ElementsMethods {
    private WebDriver driver;
    private Actions actions;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void uploadPicture(WebElement element) {
        File file = new File("src/test/resources/img1.png");
        element.sendKeys(file.getAbsolutePath());
    }

    public void fillElementAndEnter(WebElement element, String value) {
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }

    public void displayElementContent(WebElement element){
        System.out.println("The element text is + " + element.getText());
    }

    public void clickOnElements(WebElement element){
        element.click();
    }

    public void selectElementFromListByText(List<WebElement> elementList, String value) {
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().equals(value)) {
                clickOnElement(elementList.get(i));
            }
        }
    }

    public void fillWithAction(WebElement element, String value){
        actions.sendKeys(value).perform();
        waitVisibilityOfElement(element);
        actions.sendKeys(Keys.ENTER);
    }

    public void waitVisibilityOfElement(WebElement element) {
        // definim un wait explicit ca sa astepte dupa vizibilitatea elementului
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillMultipleValues(WebElement element, List<String> values) {
        for (String value : values) {
            element.sendKeys(value);
            element.sendKeys(Keys.ENTER);
        }
    }

    public void clickMultipleValues(List<WebElement> element, List<String> values){
        for (String value : values) {
            for (WebElement webElement: element){
                if (webElement.getText().equals(value)) {
                    webElement.click();
                }
            }
        }
    }

    public void selectByValue(WebElement element, String value) {
        Select selectValue = new Select(element);
        selectValue.selectByValue(value);
    }


}
