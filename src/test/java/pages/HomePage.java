package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavaScriptMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    WebDriver driver;
    ElementsMethods elementsMethods;
    JavaScriptMethods javaScriptMethods;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javaScriptMethods = new JavaScriptMethods(driver);
        PageFactory.initElements(driver,this);
    }

    // identificam WebElementele specifice pentru pagina
    @FindBy(xpath = "//h5")
    List<WebElement> elements;

    // facem metode specifice

    public void goToDesiredMenu(String menu){
        javaScriptMethods.scrollDown(400);
        elementsMethods.selectElementFromListByText(elements, menu);
    }



}
