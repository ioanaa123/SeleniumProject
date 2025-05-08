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

    public String getRowContentAsString(int rowIndex) {
        return tableElements.get(rowIndex).getText();
    }

    public void completeForm(String firstName, String lastName, String email, String age,
                             String salary, String department){
        elementsMethods.fillElement(firstNameElement, firstName);
        elementsMethods.fillElement(lastNameElement, lastName);
        elementsMethods.fillElement(emailElement, email);
        elementsMethods.fillElement(ageElement, age);
        elementsMethods.fillElement(salaryElement, salary);
        elementsMethods.fillElement(departmentElement, department);
    }

    public void  submitForm() {
        elementsMethods.clickOnElement(submitButton);
    }



}
