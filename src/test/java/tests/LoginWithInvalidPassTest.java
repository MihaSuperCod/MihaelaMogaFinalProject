package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.UserModel;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.LoginPage;
import sharedData.SharedData;

public class LoginWithInvalidPassTest extends SharedData {

    @Epic("Authentication Module")
    @Feature("User Login")
    @Story("User cannot log in with invalid password")
    @Test
    public void logInWithInvalidPassTest(){
        UserModel testData = new UserModel("src/test/resources/ClientInvalidData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.invalidAuthenticationProcess((testData));
}}
