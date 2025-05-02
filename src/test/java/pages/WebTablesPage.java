package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablesPage extends CommonPage{

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']")
    private List<WebElement> tableElements;
    @FindBy(id = "addNewRecordButton")
    private WebElement addNewRecordButtonElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitButton;

    public void addNewRecord() {
        elementsMethods.clickOnElement(addNewRecordButtonElement);
    }

    public int getCurrentTableSize() {
        return tableElements.size();
    }

}
