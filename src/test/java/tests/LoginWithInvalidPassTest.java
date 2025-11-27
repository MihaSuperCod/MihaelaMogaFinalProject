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

public class LoginWithInvalidPassTest {

    public WebDriver driver;

    @Test
    public void logInWithInvalidPassTest(){
        driver = new ChromeDriver();
        driver.get("https://app.dentops.ro/login");
        driver.manage().window().maximize();

        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder='Adauga adresa de email']"));
        String emailFieldValue = "mihaelamoga23@gmail.com";
        emailField.sendKeys(emailFieldValue);

        WebElement passwordField = driver.findElement(By.cssSelector("input[placeholder='Adauga parola']"));
        String passwordFieldValue = "ParolaGresita123!";
        passwordField.sendKeys(passwordFieldValue);

        WebElement submitButton;
        submitButton = driver.findElement(By.xpath("//button[text()='Intra in cont']"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/login"));

        String expectedURL = "https://app.dentops.ro/login";
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Userul NU ar trebui sa fie logat");
}}
