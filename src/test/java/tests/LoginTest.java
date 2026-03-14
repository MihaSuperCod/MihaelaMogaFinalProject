package tests;

import models.ClientModel;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.LoginPage;
import sharedData.SharedData;
import utils.LogUtility;

public class LoginTest extends SharedData{

    @Test
    public void logInTest(){
        ClientModel testData = new ClientModel("src/test/resources/ClientData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.validAuthenticationProcess(testData);
    }
}
