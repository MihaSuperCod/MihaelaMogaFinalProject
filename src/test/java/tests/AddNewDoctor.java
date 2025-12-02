package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddNewDoctor {
    public WebDriver driver;

    @Test
    public void AddNewDoctorTest(){
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
        WebElement colaboratoriElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[.//span[text()='Colaboratori']]")));
        colaboratoriElement.click();

        WebElement adaugaMedicButton = driver.findElement(
                By.xpath("//button[contains(., 'Adauga medic')]"));
        adaugaMedicButton.click();

        WebElement nameInputElement = driver.findElement(By.xpath("//input[@name='lastName']"));
        String nameInputValue = "Ionescu";
        nameInputElement.sendKeys(nameInputValue);

        WebElement surnameInputElement = driver.findElement(By.xpath("//input[@name='firstName']"));
        String surnameInputValue = "Maria";
        surnameInputElement.sendKeys(surnameInputValue);

        WebElement addressInputElement = driver.findElement(By.name("address"));
        String addressInputValue = "Strada Viitorului 10";
        addressInputElement.sendKeys(addressInputValue);

        WebElement cityInputElement = driver.findElement(By.name("city"));
        String cityInputValue = "Brasov";
        cityInputElement.sendKeys(cityInputValue);

        WebElement emailInputElement = driver.findElement(By.name("email"));
        String emailInputValue = "mihamoga_93@yahoo.com";
        emailInputElement.sendKeys(emailInputValue);

        WebElement phoneInputElement = driver.findElement(By.name("phone"));
        String phoneInputValue = "0728004409";
        phoneInputElement.sendKeys(phoneInputValue);

        WebElement saveButton = driver.findElement(By.xpath("//button[text()='Salveaza']"));
        saveButton.click();

        String expectedPage = "https://app.dentops.ro/clients";
        String actualPage = driver.getCurrentUrl();
        System.out.println("Verific URL: " + actualPage);
}}
