package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavaScriptMethods;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.CommonPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PracticeFormTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;
    JavaScriptMethods javaScriptMethods;
    HomePage homePage;
    CommonPage commonPage;
    PracticeFormPage practiceFormPage;

    @Test
    public void automationMethod() throws InterruptedException {
        //open Chrome browser
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethods = new ElementsMethods(driver);
        javaScriptMethods = new JavaScriptMethods(driver);
        javaScriptMethods.scrollDown(400);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        practiceFormPage = new PracticeFormPage(driver);

        homePage.goToDesiredMenu("Forms");

        commonPage.goToDesiredSubMenu("Practice Form");

        practiceFormPage.completeFirstRegion("Jane", "Doe","jane.doe@gmail.com", "Oxford Str nr10", "0741258963");

        javaScriptMethods.scrollDown(400);

        practiceFormPage.selectGender("Female");
        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        elementsMethods.uploadPicture(pictureElement);

        List<String> subject = new ArrayList<>();
        subject.add("Maths");
        subject.add("English");
        practiceFormPage.completeSubjectWithList(subject);
        List<String> hobbies = new ArrayList<>();
        subject.add("Sports");
        subject.add("Reading");
        practiceFormPage.completeHobbies(hobbies);


        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        javaScriptMethods.forceClick(stateElement);
        javaScriptMethods.fillElementEnterAndForceClick(stateElement, "NCR");

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        javaScriptMethods.fillElementEnterAndForceClick(cityElement, "Delhi");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        javaScriptMethods.forceClick(submitBtn);

        HashMap<String, String> validateForm = new HashMap<>();
        validateForm.put("Student Name", "Jane Doe");
        validateForm.put("Student Email", "jane.doe@gmail.com");
        validateForm.put("Gender", "Female");
        validateForm.put("Mobile", "0741258963");
        validateForm.put("Date of Birth", "28 April,2025");
        validateForm.put("Subjects", "Maths, English");
        validateForm.put("Hobbies", "");
        validateForm.put("Picture", "img1.png");
        validateForm.put("Address", "Oxford Str nr10");
        validateForm.put("State and City", "NCR Delhi");

        List<WebElement> actualFormTable = driver.findElements(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr"));
        for (WebElement rowElement : actualFormTable) {
            List<WebElement> columns = rowElement.findElements(By.xpath("td"));
            String label = columns.get(0).getText();
            String values = columns.get(1).getText();

            Assert.assertEquals(values, validateForm.get(label), "Validating failed at  " + label);

            Thread.sleep(1000);
           // driver.close();

        }
    }
}
