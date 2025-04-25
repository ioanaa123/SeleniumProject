package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavaScriptMethods;
import HelperMethods.WindowsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;

import java.util.List;

public class WebTableTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;
    JavaScriptMethods javaScriptMethods;
    WindowsMethods windowsMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void automationMethod() {
        //open Chrome browser
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethods = new ElementsMethods(driver);
        windowsMethods = new WindowsMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        javaScriptMethods = new JavaScriptMethods(driver);
        javaScriptMethods.scrollDown(500);

        String firstNameValue = "Jane";
        String lastNameValue = "Doe";
        String emailAddressValue = "jane.doe@gmail.com";
        String ageValue = "25";
        String salaryValue = "9500";
        String departmentValue = "Testing";

        homePage.goToDesiredMenu("Elements");

        commonPage.goToDesiredSubMenu("Web Tables");

        List<WebElement> tableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize = tableElements.size();

        WebElement addField = driver.findElement(By.id("addNewRecordButton"));
        elementsMethods.clickOnElement(addField);

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        elementsMethods.fillElement(firstNameField, firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        elementsMethods.fillElement(lastNameField, lastNameValue);

        WebElement emailAddressField = driver.findElement(By.id("userEmail"));
        elementsMethods.fillElement(emailAddressField, emailAddressValue);

        WebElement ageField = driver.findElement(By.id("age"));
        elementsMethods.fillElement(ageField, ageValue);

        WebElement salaryField = driver.findElement(By.id("salary"));
        elementsMethods.fillElement(salaryField, salaryValue);

        WebElement departmentField = driver.findElement(By.id("department"));
        elementsMethods.fillElement(departmentField, departmentValue);

        WebElement submitBtn = driver.findElement(By.id("submit"));
        elementsMethods.clickOnElement(submitBtn);

        List<WebElement> expectedTableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));

        Integer expectedTableSize = actualTableSize +1;

        Assert.assertEquals(expectedTableElements.size(),expectedTableSize);

        String actualTableValue = expectedTableElements.get(3).getText();

        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(emailAddressValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(salaryValue));
        Assert.assertTrue(actualTableValue.contains(departmentValue));

        driver.close();
    }
}
