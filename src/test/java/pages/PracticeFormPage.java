package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavaScriptMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends CommonPage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement userEmailElement;
    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileNumber;
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement maleGenderElement;
    @FindBy(xpath = "//label[@for='gender-radio-2']")
    private WebElement femaleGenderElement;
    @FindBy(xpath = "//label[@for='gender-radio-3']")
    private WebElement otherGenderElement;
    @FindBy(id = "currentAddress")
    private WebElement addressElement;
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
    private WebElement pictureElement;
    @FindBy(id = "react-select-3-input")
    private WebElement stateElement;
    @FindBy(id = "react-select-4-input")
    private WebElement cityElement;
    @FindBy(id = "submit")
    private WebElement submitElement;

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

    public void completeSubject(String subject) {
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillWithAction(subjectsElement, subject);
    }

    public void completeSubjectWithList(List<String> list) {
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillMultipleValues(subjectsElement, list);
    }

    public void completeHobbies(List<String> hobbies) {
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyElement);
        hobbiesElement.add(musicHobbyElement);
        hobbiesElement.add(readingHobbyElement);
        elementsMethods.clickMultipleValues(hobbiesElement, hobbies);
        javaScriptMethods.scrollDown(400);
    }

    public void uploadPicture() {
        elementsMethods.uploadPicture(pictureElement);
    }

    public void completeStateAndCity(String state, String city) {
        javaScriptMethods.forceClick(stateElement);
        elementsMethods.fillElementAndEnter(stateElement, state);

        javaScriptMethods.forceClick(cityElement);
        elementsMethods.fillElementAndEnter(cityElement, city);
    }

    public void completeDateOfBirth(int year, int month, int day) {
        elementsMethods.clickOnElement(dateOfBirthElement);
        elementsMethods.selectByValue(yearOfBirthElement, String.valueOf(year));
        elementsMethods.selectByValue(monthOfBirthElement, String.valueOf(month - 1));
        javaScriptMethods.scrollDown(400);
        String dayOfBirthXPath = "//div[@class='react-datepicker__day react-datepicker__day--0" + day + "']";
        WebElement dayOfBirthElement = driver.findElement(By.xpath(dayOfBirthXPath));
        elementsMethods.clickOnElement(dayOfBirthElement);
    }

    public void submitForm() {
        javaScriptMethods.forceClick(submitElement);
    }

}
