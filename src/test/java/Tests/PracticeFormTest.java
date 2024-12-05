package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.FileAssert;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void automationMethod() {
        //open Chrome browser
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement formsField=driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsField.click();

        WebElement practiceFormField=driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormField.click();

        String firstNameValue="Jane";
        String lastNameValue="Doe";
        String emailAddressValue="jane.doe@gmail.com";
        String mobile="0741258963";

        WebElement firstNameField=driver.findElement(By.id("firstName"));
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField=driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(lastNameValue);

        WebElement emailAddressField=driver.findElement(By.id("userEmail"));
        emailAddressField.sendKeys(emailAddressValue);

        WebElement mobileField=driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        mobileField.sendKeys(mobile);

        WebElement pictureElement=driver.findElement(By.id("uploadPicture"));
        File file=new File("src/test/resources/img1.png");
        pictureElement.sendKeys(file.getAbsolutePath());

    }


}
