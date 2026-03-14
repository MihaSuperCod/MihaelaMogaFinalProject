package pages;

import models.ClientModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.LogUtility;

import java.time.Duration;

public class AuthenticationPage extends BasePage {
    @FindBy(css = "input[placeholder='Adauga adresa de email']")
    private WebElement emailFieldValue;

    @FindBy(css = "input[placeholder='Adauga parola']")
    private WebElement passwordFieldValue;

    @FindBy(xpath = "//button[text()='Intra in cont']")
    public WebElement submitButton;

    @FindBy(css = "input[placeholder='Adauga parola']")
    public WebElement invalidPasswordFieldValue;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public void validAuthenticationProcess(ClientModel testData){
        emailFieldValue.sendKeys(testData.getEmailFieldValue());
        LogUtility.infoLog("The user fills email address field with value: " + testData.getEmailFieldValue());

        passwordFieldValue.sendKeys(testData.getPasswordFieldValue());
        LogUtility.infoLog("The user fills password field with value: " + testData.getPasswordFieldValue());

        submitButton.click();
        LogUtility.infoLog("The user clicked on the submit button");

        String expectedURL = "https://app.dentops.ro/login";
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Nu sunt pe dashboard");
        LogUtility.infoLog("User successfully logged in and navigated to the dashboard page");
        }

    public void invalidAuthenticationProcess(ClientModel testData){
        emailFieldValue.sendKeys(testData.getEmailFieldValue());
        LogUtility.infoLog("The user fills email address field with value: " + testData.getEmailFieldValue());

        invalidPasswordFieldValue.sendKeys(testData.getInvalidPasswordFieldValue());
        LogUtility.infoLog("The user fills password field with value: " + testData.getInvalidPasswordFieldValue());

        submitButton.click();
        LogUtility.infoLog("The user clicked on the submit button");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/login"));

        String expectedURL = "https://app.dentops.ro/login";
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Userul NU ar trebui sa fie logat");
        LogUtility.infoLog("Authentication failed. User remains on the login page: " + actualURL);
    }
}

