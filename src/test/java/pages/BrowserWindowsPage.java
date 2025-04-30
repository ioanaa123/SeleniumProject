package pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.WindowsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BrowserWindowsPage {
    WebDriver driver;
    ElementsMethods elementsMethods;
    WindowsMethods windowsMethods;

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.windowsMethods = new WindowsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabButtonElement;
    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFromNewTabElement;
    @FindBy(id = "windowButton")
    private WebElement newWindowButtonElement;
    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFromNewWindowElement;

    public void interactWithTheNewTab() {
        // New Tab:
        elementsMethods.clickOnElement(newTabButtonElement);
        windowsMethods.switchToOpenTab();
        Assert.assertEquals(sampleHeadingFromNewTabElement.getText(), "This is a sample page");
        driver.close();
        windowsMethods.switchToMainWindow();
    }

}
