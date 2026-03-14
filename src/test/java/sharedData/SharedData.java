package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.LogUtility;

import java.time.Duration;

public class SharedData {
    private WebDriver driver;
    private String testName;

    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        driver = new ChromeDriver(options);
        driver.get("https://dentops.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LogUtility.startTest(testName);
    }

    @AfterMethod
    public void clearEnvironment(){
        driver.quit();
        LogUtility.finishTest(testName);
    }

    public WebDriver getDriver(){
        return driver;
    }
}
