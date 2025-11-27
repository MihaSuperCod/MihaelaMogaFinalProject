package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    public WebDriver driver;

    @Test
    public void logInTest(){
        driver = new ChromeDriver();
        driver.get("https://dentops.ro/");
        driver.manage().window().maximize();

        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder='Adauga adresa de email']"));
        String emailFieldValue = "mihaelamoga23@gmail.com";
        emailField.sendKeys(emailFieldValue);

        WebElement passwordField = driver.findElement(By.cssSelector("input[placeholder='Adauga parola']"));
        String passwordFieldValue = "Pacific2027!";
        passwordField.sendKeys(passwordFieldValue);

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Intra in cont']"));
        submitButton.click();

        String expectedURL = "https://app.dentops.ro/login";
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL, "Nu sunt pe dashboard");
    }}
