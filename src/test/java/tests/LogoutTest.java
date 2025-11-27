package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class LogoutTest {
    public WebDriver driver;

    @Test
    public void logOutTest() {
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement disconnectButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Deconectare']")));
        disconnectButton.click();

        WebElement messageParagraph = driver.findElement(By.xpath("//p[contains(@class,'styles_center__U8G5d')]"));
        String actualText = messageParagraph.getText();
        if(actualText.contains("Ai ales sa fii deconectat")) {
            System.out.println("Mesajul este afișat corect!");
        } else {
            System.out.println("Mesajul este diferit!");
        }

        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Continua']"));
        continueButton.click();

        String expectedURL = "https://app.dentops.ro/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL, "Nu sunt pe pagina de setari");
    }}
