package tests;

import dataBase.CasesTable;
import io.qameta.allure.*;
import models.CaseModel;
import models.UserModel;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NewCasePage;
import sharedData.SharedData;

public class AddNewCaseTest extends SharedData {

    @Epic("Case Management Module")
    @Feature("Create Case")
    @Story("User adds a new medical case for a patient")
    @Description("Verify that the user can successfully create a new medical case for an existing patient by filling in all required information.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addNewCaseTest(){
        UserModel testData = new UserModel("src/test/resources/ClientData.json");
        CaseModel caseData = new CaseModel("src/test/resources/CaseData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.validAuthenticationProcess(testData);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.addNewCaseStep();

        NewCasePage newCasePage = new NewCasePage(getDriver());
        newCasePage.addNewCaseProcess();

        CasesTable casesTable = new CasesTable();
        casesTable.insertCasesIntoTable(caseData);
    }
}
