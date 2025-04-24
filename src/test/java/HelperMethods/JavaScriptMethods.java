package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptMethods {

    WebDriver driver;
    JavascriptExecutor js;

    public JavaScriptMethods(WebDriver driver){
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void scroll(int x, int y){
        js.executeScript("window.scrollBy(" + x + " , " + y + ")");
    }

    public void scrollDown(int y){
        js.executeScript("window.scrollBy(0 , " + y + ")");
    }

    public void fillElementEnterAndForceClick(WebElement element, String value){
        js.executeScript("arguments[0].click();", element);
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }
    public void forceClick(WebElement element){
        js.executeScript("arguments[0].click();", element);
    }

}
