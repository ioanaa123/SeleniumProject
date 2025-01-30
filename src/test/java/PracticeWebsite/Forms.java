package PracticeWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Forms {
    public WebDriver driver;

    @Test
    public void fillOutForms(){
        fillOutFirstForm("Jane Doe", "This is the first form!");
    }
    public void fillOutFirstForm(String name, String message  ) {
        //open Chrome browser
        driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/automation");
        driver.manage().window().maximize();

        WebElement fillForm = driver.findElement(By.linkText("Fill out forms"));
        fillForm.click();

        WebElement fullName = driver.findElement(By.xpath("//*[@id=\"et_pb_contact_name_0\"]"));
        fullName.sendKeys(name);

        WebElement messageBox = driver.findElement(By.xpath("//*[@id=\"et_pb_contact_message_0\"]"));
        messageBox.sendKeys(message);

        WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"et_pb_contact_form_0\"]/div[2]/form/div/button"));
        submitBtn.click();

        //WebElement thankYouText = driver.

       // driver.close();
    }

}
