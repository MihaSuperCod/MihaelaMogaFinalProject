package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.UserModel;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SettingsPage;
import sharedData.SharedData;

public class NewSubscriptionWithoutPaymentTest extends SharedData{

    @Epic("Subscription Module")
    @Feature("Create Subscription")
    @Story("User creates subscription without payment")
    @Test
    public void newSubscriptionWithoutPaymentTest(){
        UserModel testData = new UserModel("src/test/resources/ClientData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.validAuthenticationProcess(testData);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.getSubscriptionStep();

        SettingsPage settingsPage = new SettingsPage(getDriver());
        settingsPage.getSubscriptionProcess();
    }}