package tests;

import models.UserModel;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.LoginPage;
import sharedData.SharedData;

public class LoginTest extends SharedData{

    @Test
    public void logInTest(){
        UserModel testData = new UserModel("src/test/resources/ClientData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.validAuthenticationProcess(testData);
    }
}
