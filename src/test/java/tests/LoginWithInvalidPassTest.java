package tests;

import models.UserModel;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.LoginPage;
import sharedData.SharedData;

public class LoginWithInvalidPassTest extends SharedData {

    @Test
    public void logInWithInvalidPassTest(){
        UserModel testData = new UserModel("src/test/resources/ClientInvalidData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.invalidAuthenticationProcess((testData));
}}
