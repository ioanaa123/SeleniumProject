package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class Sortable {

    WebDriver driver;
    @Test
    public void parcurgereLista(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/sortable");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        List<WebElement> list = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));

        for (int i=0;i<list.size()-1;i++){
            WebElement webElem=list.get(i);
            WebElement urmElem=list.get(i++);
            System.out.println("Numarul elementului este " + webElem.getText());
            action.clickAndHold(webElem)
                            .moveToElement(urmElem)
                                    .release()
                                            .build()
                                                    .perform();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.close();
    }

}
