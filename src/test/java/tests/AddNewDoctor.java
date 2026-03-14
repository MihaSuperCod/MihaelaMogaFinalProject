package tests;

import models.ClientModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.DashboardPage;
import pages.LoginPage;
import sharedData.SharedData;

import java.time.Duration;

public class AddNewDoctor extends SharedData {

    @Test
    public void AddNewDoctorTest(){
        ClientModel testData = new ClientModel("src/test/resources/ClientData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.validAuthenticationProcess(testData);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.addNewDoctor();

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
        Assert.assertEquals(actualPage, expectedPage, "URL-ul nu este cel așteptat!");
}}
