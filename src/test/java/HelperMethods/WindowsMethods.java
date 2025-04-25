package HelperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowsMethods {
    WebDriver driver;

    public WindowsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToOpenTab(){
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
    }

    public void switchToMainTab(){
        switchToMain();
    }

    public void switchToOpenWindow(){
        switchToOpenTab();
    }

    public void switchToMainWindow(){
        switchToMain();
    }
    public void switchToMain(){
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(0));
    }

}
