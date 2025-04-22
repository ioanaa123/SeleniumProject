package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class ElementsMethods {
    WebDriver driver;
    JavascriptExecutor js;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public void fillElement(WebElement element, String value){
        element.sendKeys(value);
    }

    public void uploadPicture(WebElement element){
        File file = new File("src/test/resources/img1.png");
        element.sendKeys(file.getAbsolutePath());
    }

    public void selectElementFromListByText(List<WebElement> elementList, String value){
        for (int i=0; i<elementList.size(); i++){
            if (elementList.get(i).getText().equals(value)){
                clickOnElement(elementList.get(i));
            }
        }
    }

    public void javaScript (WebElement element, String value){

    }



}
