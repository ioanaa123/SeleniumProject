package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BrowserWindowsPage extends CommonPage{

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
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
        javaScriptMethods.scrollDown(400);
    }


    public void interactWithTheNewWindow() {
        // New Window:
        elementsMethods.clickOnElement(newWindowButtonElement);
        windowsMethods.switchToOpenWindow();
        Assert.assertEquals(sampleHeadingFromNewWindowElement.getText(), "This is a sample page");
        windowsMethods.switchToMainWindow();
    }

}
