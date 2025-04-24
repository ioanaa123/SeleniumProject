package HelperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class ElementsMethods {
    WebDriver driver;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
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
}
