package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonPage{

    public HomePage(WebDriver driver) {
        super(driver);
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
