package tests;

import models.UserModel;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.DashboardPage;
import pages.LoginPage;
import sharedData.SharedData;

public class LogoutTest extends SharedData {

    @Test
    public void logOutTest() {
        UserModel testData = new UserModel("src/test/resources/ClientData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.validAuthenticationProcess(testData);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.logOutProcess();
    }}
