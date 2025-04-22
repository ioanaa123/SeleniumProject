package Tests;

import HelperMethods.ElementsMethods;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;
    ElementsMethods js;

    @Test
    public void automationMethod() {
        //open Chrome browser
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethods = new ElementsMethods(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,400)");

        WebElement formsField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementsMethods.clickOnElement(formsField);

        WebElement practiceFormField = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementsMethods.clickOnElement(practiceFormField);

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        elementsMethods.fillElement(firstNameField, "Jane");

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        elementsMethods.fillElement(lastNameField, "Doe");

        WebElement emailAddressField = driver.findElement(By.id("userEmail"));
        elementsMethods.fillElement(emailAddressField, "jane.doe@gmail.com");

        WebElement mobileField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        elementsMethods.fillElement(mobileField, "0741258963");

        js.executeScript("window.scrollBy(0,400)");

        WebElement genderMField = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement genderFField = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement genderOtherField = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        String genderValue = "Female";

        List<WebElement> genderElement = new ArrayList<>();
        genderElement.add(genderMField);
        genderElement.add(genderFField);
        genderElement.add(genderOtherField);

        elementsMethods.selectElementFromListByText(genderElement,genderValue);

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        elementsMethods.uploadPicture(pictureElement);

        WebElement subjectElement = driver.findElement(By.id("subjectsInput"));
        elementsMethods.fillElement(subjectElement, "Social Studies");
        subjectElement.sendKeys(Keys.ENTER);

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));

        js.executeScript("arguments[0].click();", stateElement);
        stateElement.sendKeys("NCR");
        stateElement.sendKeys(Keys.ENTER);
//
//        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
//        js.executeScript("arguments[0].click();", cityElement);
//        cityElement.sendKeys("Delhi");
//        cityElement.sendKeys(Keys.ENTER);
//
//        WebElement submitBtn = driver.findElement(By.id("submit"));
//        js.executeScript("arguments[0].click();", submitBtn);
//
//        Date date = new Date();
//
//
//        HashMap<String, String> validateForm = new HashMap<>();
//        validateForm.put("Student Name", firstNameValue + " " + lastNameValue);
//        validateForm.put("Student Email", emailAddressValue);
//        validateForm.put("Gender", genderValue);
//        validateForm.put("Mobile", mobile);
//        validateForm.put("Date of Birth", String.valueOf(date));
//        validateForm.put("Subjects", subjectValue);
//        validateForm.put("Hobbies", "");
//        validateForm.put("Picture", file.getName());
//        validateForm.put("Address", "");
//        validateForm.put("State and City", "NCR Delhi");
//
//        List<WebElement> actualFormTable = driver.findElements(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr"));
//        for (WebElement rowElement : actualFormTable) {
//            List<WebElement> columns = rowElement.findElements(By.xpath("td"));
//            String label = columns.get(0).getText();
//            String values = columns.get(1).getText();
//
//            Assert.assertEquals(values, validateForm.get(label), "Validating failed at  " + label);
//
        //driver.close();

    }
}
