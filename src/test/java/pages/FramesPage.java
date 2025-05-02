package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FramesPage extends CommonPage{

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "frame1")
    private WebElement frame1Element;
    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFromFrame1Element;
    @FindBy(id = "frame2")
    private WebElement frame2Element;
    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFromFrame2Element;

    public void interactWithFrame1() {
        framesMethods.switchToFrame(frame1Element);
        Assert.assertEquals(sampleHeadingFromFrame1Element.getText(), "This is a sample page");
        // Ne ducem cu focusul inapoi pe pagina principala
        framesMethods.switchToDefault();
    }

    public void interactWithFrame2() {
        // Frame 2:
        framesMethods.switchToFrame(frame2Element);
        Assert.assertEquals(sampleHeadingFromFrame2Element.getText(), "This is a sample page");
        framesMethods.switchToDefault();
    }
}
