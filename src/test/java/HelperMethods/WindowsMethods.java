package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WindowsMethods {
    WebDriver driver;

    List<String> tabList = new ArrayList<>(driver.getWindowHandles());

    public WindowsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToOpenTab(){
        driver.switchTo().window(tabList.get(1));
    }

    public void switchToMainTab(){
        switchToMain();
    }

    public void switchToOpenWindow(){
        switchToOpenTab();
    }

    public void switchToMain(){
        driver.switchTo().window(tabList.get(0));
    }


}
