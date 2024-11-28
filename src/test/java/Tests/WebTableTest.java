package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void automationMethod(){
        //open Chrome browser
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement elementsField=driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsField.click();

        WebElement webTablesField=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTablesField.click();

        WebElement addField=driver.findElement(By.id("addNewRecordButton"));
        addField.click();

        String firstNameValue="Jane";
        String lastNameValue="Doe";
        String emailAddressValue="jane.doe@gmail.com";
        String ageValue="25";
        String salaryValue="9500";
        String departmentValue="Testing";

        WebElement firstNameField=driver.findElement(By.id("firstName"));
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField=driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(lastNameValue);

        WebElement emailAddressField=driver.findElement(By.id("userEmail"));
        emailAddressField.sendKeys(emailAddressValue);

        WebElement ageField=driver.findElement(By.id("age"));
        ageField.sendKeys(ageValue);

        WebElement salaryField=driver.findElement(By.id("salary"));
        salaryField.sendKeys(salaryValue);

        WebElement departmentField=driver.findElement(By.id("department"));
        departmentField.sendKeys(departmentValue);

        WebElement submitBtn=driver.findElement(By.id("submit"));
        submitBtn.click();


        //driver.close();
    }
}
