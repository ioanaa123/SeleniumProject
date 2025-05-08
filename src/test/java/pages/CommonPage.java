package pages;

import HelperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {
    protected WebDriver driver;
    protected ElementsMethods elementsMethods;
    protected JavaScriptMethods javaScriptMethods;
    protected AlertMethods alertMethods;
    protected WindowsMethods windowsMethods;
    protected FramesMethods framesMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javaScriptMethods = new JavaScriptMethods(driver);
        this.alertMethods = new AlertMethods(driver);
        this.windowsMethods = new WindowsMethods(driver);
        this.framesMethods = new FramesMethods(driver);
        PageFactory.initElements(driver,this);
    }

    // identificam WebElementele specifice pentru sub- pagini
    @FindBy(xpath = "//span[@class='text']")
    private List<WebElement> elements;

    // facem metode specifice

    public void goToDesiredSubMenu(String SubMenu){
        javaScriptMethods.scrollDown(400);
        elementsMethods.selectElementFromListByText(elements, SubMenu);
    }
}
