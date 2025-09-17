package Tests;


import ShareData.ShareData;
import org.junit.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PracticeFormTest extends ShareData {

    private HomePage homePage;
    private CommonPage commonPage;
    private PracticeFormPage practiceFormPage;

    @Test
    public void automationMethod() throws InterruptedException {
        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        practiceFormPage = new PracticeFormPage(getDriver());

        homePage.goToDesiredMenu("Forms");

        commonPage.goToDesiredSubMenu("Practice Form");

        practiceFormPage.completeFirstRegion("Jane", "Doe","jane.doe@gmail.com", "Oxford Str nr10", "0741258963");

        practiceFormPage.selectGender("Female");
        practiceFormPage.completeDateOfBirth(1990, 10, 02);


        List<String> subject = new ArrayList<>();
        subject.add("Maths");
        subject.add("English");
        practiceFormPage.completeSubjectWithList(subject);

        List<String> hobbies = new ArrayList<>();
        subject.add("Sports");
        subject.add("Reading");
        subject.add("Music");
        practiceFormPage.completeHobbies(hobbies);
        practiceFormPage.uploadPicture();
        practiceFormPage.submitForm();

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

//        List<WebElement> actualFormTable = driver.findElements(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr"));
//        for (WebElement rowElement : actualFormTable) {
//            List<WebElement> columns = rowElement.findElements(By.xpath("td"));
//            String label = columns.get(0).getText();
//            String values = columns.get(1).getText();
//
//            Assert.assertEquals(values, validateForm.get(label), "Validating failed at  " + label);
//
//            Thread.sleep(1000);
//           // driver.close();

        }
    }

