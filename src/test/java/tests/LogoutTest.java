package tests;

import io.qameta.allure.*;
import models.UserModel;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.DashboardPage;
import pages.LoginPage;
import sharedData.SharedData;

public class LogoutTest extends SharedData {

    @Epic("Authentication Module")
    @Feature("User Logout")
    @Story("User logs out from the application")
    @Description("Verify that a logged-in user can successfully log out from the application and is redirected to the login page.")
    @Severity(SeverityLevel.NORMAL)
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
