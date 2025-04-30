package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavaScriptMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage {
    WebDriver driver;
    ElementsMethods elementsMethods;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstNameElement;
    @FindBy(id = "lastName")
    WebElement lastNameElement;
    @FindBy(id = "userEmail")
    WebElement userEmailElement;
    @FindBy(css = "input[placeholder='Mobile Number']")
    WebElement mobileNumber;
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleGenderElement;
    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleGenderElement;
    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherGenderElement;
    @FindBy(id = "currentAddress")
    WebElement addressElement;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1'] ")
    private WebElement sportHobbyElement;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2'] ")
    private WebElement readingHobbyElement;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3'] ")
    private WebElement musicHobbyElement;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsElement;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthElement;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearOfBirthElement;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthOfBirthElement;

    @FindBy(id = "uploadPicture")
    WebElement pictureElement;
    @FindBy(id = "react-select-3-input")
    WebElement stateElement;
    @FindBy(id = "react-select-4-input")
    WebElement cityElement;

    public void completeFirstRegion(String firstName, String lastName, String email, String address, String mobileNo) {
        elementsMethods.fillElement(firstNameElement, firstName);
        elementsMethods.fillElement(lastNameElement, lastName);
        elementsMethods.fillElement(userEmailElement, email);
        elementsMethods.fillElement(addressElement, address);
        elementsMethods.fillElement(mobileNumber, mobileNo);
    }

    public void selectGender(String gender) {
        switch (gender) {
            case "Male":
                elementsMethods.clickOnElement(maleGenderElement);
                break;
            case "Female":
                elementsMethods.clickOnElement(femaleGenderElement);
                break;
            case "Other":
                elementsMethods.clickOnElement(otherGenderElement);
                break;
        }
    }

    public void completeSubject(String subject){
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillWithAction(subjectsElement, subject);
    }

    public void completeSubjectWithList(List<String> list){
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillMultipleValues(subjectsElement, list);
    }

    public void completeHobbies(List<String> hobbies){
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyElement);
        hobbiesElement.add(musicHobbyElement);
        hobbiesElement.add(readingHobbyElement);
        elementsMethods.clickMultipleValues(hobbiesElement, hobbies);
    }


 }
