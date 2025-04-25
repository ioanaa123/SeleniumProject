package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavaScriptMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {
    WebDriver driver;
    ElementsMethods elementsMethods;
    JavaScriptMethods javaScriptMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javaScriptMethods = new JavaScriptMethods(driver);
        PageFactory.initElements(driver,this);
    }

    // identificam WebElementele specifice pentru sub- pagini
    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elements;

    // facem metode specifice

    public void goToDesiredSubMenu(String SubMenu){
        javaScriptMethods.scrollDown(400);
        elementsMethods.selectElementFromListByText(elements, SubMenu);
    }


}
