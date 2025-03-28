package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Airbnb {
    public WebDriver driver;

    public void airBnbMenu(){
        driver = new ChromeDriver();
        driver.get("https://letcode.in/forms");
        driver.manage().window().maximize();

        //WebElement cabinsMenu = driver.findElement(By);

        driver.close();
    }
}
