package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Barnesandnoble {
    public WebDriver driver;
    public void BarnesandnobleMenu()
    {
        driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com/");
        driver.manage().window().maximize();

        WebElement booksMenu = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div/ul/li[1]"));
        booksMenu.click();

        WebElement fictionMenu = driver.findElement(By.id("rhfCategoryFlyout_Fiction"));
        fictionMenu.click();

        WebElement fictionTitle = driver.findElement(By.id("rhfCategoryFlyout_Fiction"));



    }
}
