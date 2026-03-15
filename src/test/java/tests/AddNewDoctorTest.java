package tests;

import io.qameta.allure.*;
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
    @Description("Verify that an administrator can add a new doctor by completing the required fields in the doctor creation form.")
    @Severity(SeverityLevel.CRITICAL)
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
