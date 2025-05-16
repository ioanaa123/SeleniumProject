package ShareData;

import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class ShareData {

    private WebDriver driver;

    @BeforeMethod
    public void prepareBrowser(){

        ConfigurationNode configurationNode = ConfigFile.createConfigNode(ConfigurationNode.class);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(configurationNode.driverConfigNode.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void clearBrowser(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
