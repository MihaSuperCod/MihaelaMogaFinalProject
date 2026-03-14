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
import pages.LoginPage;
import sharedData.SharedData;

import java.time.Duration;

public class LoginWithInvalidPassTest extends SharedData {

    @Test
    public void logInWithInvalidPassTest(){
        ClientModel testData = new ClientModel("src/test/resources/ClientInvalidData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.invalidAuthenticationProcess((testData));
}}
