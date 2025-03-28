package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void automationMethod() {
        //open Chrome browser
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        String firstNameValue = "Jane";
        String lastNameValue = "Doe";
        String emailAddressValue = "jane.doe@gmail.com";
        String mobile = "0741258963";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement formsField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsField.click();

        WebElement practiceFormField = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormField.click();

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(lastNameValue);

        WebElement emailAddressField = driver.findElement(By.id("userEmail"));
        emailAddressField.sendKeys(emailAddressValue);

        js.executeScript("window.scrollBy(0,400)");

        WebElement genderMField = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement genderFField = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement genderOtherField = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        String genderValue = "Female";

//        if (genderValue.equals("Male")) {
//            genderMField.click();
//        } else if (genderValue.equals("Female")) {
//            genderFField.click();
//        } else if (genderValue.equals("Other")) {
//            genderOtherField.click();
//        }

        if (genderMField.getText().equals(genderValue)) {
            genderMField.click();
        } else if (genderFField.getText().equals(genderValue)) {
            genderFField.click();
        } else if (genderOtherField.getText().equals(genderValue)) {
            genderOtherField.click();
        }

        WebElement mobileField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        mobileField.sendKeys(mobile);

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/img1.png");
        pictureElement.sendKeys(file.getAbsolutePath());

        WebElement subjectElement = driver.findElement(By.id("subjectsInput"));
        String subjectValue = "Social Studies";
        subjectElement.sendKeys(subjectValue);
        subjectElement.sendKeys(Keys.ENTER);

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click();", stateElement);
        stateElement.sendKeys("NCR");
        stateElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();", cityElement);
        cityElement.sendKeys("Delhi");
        cityElement.sendKeys(Keys.ENTER);

        WebElement submitBtn = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitBtn);


        HashMap<String, String> validateForm = new HashMap<>();
        validateForm.put("Student Name", firstNameValue + " " + lastNameValue);
        validateForm.put("Student Email", emailAddressValue);
        validateForm.put("Gender", genderValue);
        validateForm.put("Mobile", mobile);
        validateForm.put("Date of Birth", "26 March,2025");
        validateForm.put("Subjects", subjectValue);
        validateForm.put("Hobbies", "");
        validateForm.put("Picture", file.getName());
        validateForm.put("Address", "");
        validateForm.put("State and City", "NCR Delhi");

        List<WebElement> actualFormTable = driver.findElements(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr"));
        for (WebElement rowElement : actualFormTable) {
            List<WebElement> columns = rowElement.findElements(By.xpath("td"));
            String label = columns.get(0).getText();
            String values = columns.get(1).getText();

            Assert.assertEquals(values, validateForm.get(label), "Validating failed at  " + label);

            //driver.close();

        }
    }
}
