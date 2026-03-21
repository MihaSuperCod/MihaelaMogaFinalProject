package tests;

import dataBase.ClientTable;
import io.qameta.allure.*;
import models.UserModel;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.LoginPage;
import sharedData.SharedData;

public class LoginTest extends SharedData{

    @Epic("Authentication Module")
    @Feature("User Login")
    @Story("User logs in with valid credentials")
    @Description("Verify that a registered user can successfully log into the application using valid email and password.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void logInTest(){
        UserModel testData = new UserModel("src/test/resources/ClientData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.validAuthenticationProcess(testData);

        ClientTable clientTable = new ClientTable();
        clientTable.insertClientIntoTable(testData);
    }
}
