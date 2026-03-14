package pages;

import models.DoctorModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.LogUtility;

import java.time.Duration;

public class ClientPage extends BasePage{
    @FindBy(css = "input[placeholder='Adauga adresa de email']")
    private WebElement emailFieldValue;

    @FindBy(css = "input[placeholder='Adauga parola']")
    private WebElement passwordFieldValue;

    @FindBy(xpath = "//button[text()='Intra in cont']")
    public WebElement submitButton;

    @FindBy(xpath = "//span[text()='Deconectare']")
    private WebElement disconnectButton;

    @FindBy(xpath ="//p[contains(text(),'Ai ales sa fii deconectat')]")
    private WebElement messageParagraph;

    @FindBy(xpath = "//button[normalize-space()='Continua']")
    private WebElement continueButton;

    @FindBy(xpath = "//a[.//span[text()='Colaboratori']]")
    private WebElement colaboratorsElement;

    @FindBy(xpath = "//button[contains(., 'Adauga medic')]")
    private WebElement addDoctorButton;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement nameInputValue;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement surnameInputValue;

    @FindBy(name = "address")
    private WebElement addressInputValue;

    @FindBy(name = "city")
    private WebElement cityInputValue;

    @FindBy(name = "email")
    private WebElement emailInputValue;

    @FindBy(name = "phone")
    private WebElement phoneInputValue;

    @FindBy(xpath = "//button[text()='Salveaza']")
    private WebElement saveButton;

    public ClientPage(WebDriver driver) {
        super(driver);
    }

    public void AddNewDoctorProcess(DoctorModel doctorData){
        addDoctorButton.click();
        LogUtility.infoLog("The user clicked the 'Add Doctor' button and the add doctor form was displayed");

        nameInputValue.sendKeys(doctorData.getNameInputValue());
        LogUtility.infoLog("The user fills name field with value: " + doctorData.getNameInputValue());

        surnameInputValue.sendKeys(doctorData.getSurnameInputValue());
        LogUtility.infoLog("The user fills surname field with value: " + doctorData.getSurnameInputValue());

        addressInputValue.sendKeys(doctorData.getAddressInputValue());
        LogUtility.infoLog("The user fills address field with value: " + doctorData.getAddressInputValue());

        cityInputValue.sendKeys(doctorData.getCityInputValue());
        LogUtility.infoLog("The user fills city field with value: " + doctorData.getCityInputValue());

        emailInputValue.sendKeys(doctorData.getEmailInputValue());
        LogUtility.infoLog("The user fills email field with value: " + doctorData.getEmailInputValue());

        phoneInputValue.sendKeys(doctorData.getPhoneInputValue());
        LogUtility.infoLog("The user fills email field with value: " + doctorData.getPhoneInputValue());

        saveButton.click();
        LogUtility.infoLog("The user clicked the 'Save' button and a new doctor was successfully added");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/clients"));

        String expectedPage = "https://app.dentops.ro/clients";
        String actualPage = driver.getCurrentUrl();
        System.out.println("Verific URL: " + actualPage);

        Assert.assertEquals(actualPage, expectedPage, "URL-ul nu este cel așteptat!");

        LogUtility.infoLog("User was successfully redirected to the Clients page");
    }
}
