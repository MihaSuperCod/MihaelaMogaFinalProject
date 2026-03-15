package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.UserModel;
import models.DoctorModel;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.ClientPage;
import pages.DashboardPage;
import pages.LoginPage;
import sharedData.SharedData;

public class AddNewDoctorTest extends SharedData {

    @Epic("Doctor Management Module")
    @Feature("Add Doctor")
    @Story("Admin adds a new doctor to the system")
    @Test
    public void addNewDoctorTest(){
        UserModel userData = new UserModel("src/test/resources/ClientData.json");
        DoctorModel doctorData = new DoctorModel("src/test/resources/DoctorData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.validAuthenticationProcess(userData);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.addNewDoctorStep();

        ClientPage clientPage = new ClientPage(getDriver());
        clientPage.AddNewDoctorProcess(doctorData);
}}
