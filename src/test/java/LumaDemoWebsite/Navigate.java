package LumaDemoWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Navigate {
    public WebDriver driver;

    @Test
    public void navigateMenu() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();

        WebElement newMenu = driver.findElement(By.linkText("What's New"));
        newMenu.click();

        WebElement womanMenu = driver.findElement(By.linkText("Women"));
        womanMenu.click();

        WebElement menMenu = driver.findElement(By.linkText("Men"));
        menMenu.click();

        WebElement gearMenu = driver.findElement(By.linkText("Gear"));
        gearMenu.click();

        WebElement trainingMenu = driver.findElement(By.linkText("Training"));
        trainingMenu.click();

        WebElement saleMenu = driver.findElement(By.linkText("Sale"));
        saleMenu.click();

        driver.close();

    }

}
