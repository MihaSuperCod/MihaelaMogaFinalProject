package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.LogUtility;

import java.time.Duration;

public class DashboardPage extends BasePage {
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

    @FindBy(linkText = "Aboneaza-te acum")
    private WebElement getSubscriptionButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void logOutProcess(){
        disconnectButton.click();;
        LogUtility.infoLog("The user clicked on the disconnect button");

        LogUtility.infoLog("Checking the logout confirmation message");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(messageParagraph));

        String actualText = messageParagraph.getText();
        LogUtility.infoLog("Logout message displayed: " + actualText);

        actualText = messageParagraph.getText();
        if(actualText.contains("Ai ales sa fii deconectat")) {
            System.out.println("Mesajul este afișat corect!");
        } else {
            System.out.println("Mesajul este diferit!");
        }

        waitAndClick(continueButton);
        String expectedURL = "https://app.dentops.ro/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL, "Nu sunt pe pagina de setari");
        LogUtility.infoLog("The user clicked on the continue button");
        LogUtility.infoLog("The user is disconnected from the account");
    }

    public void addNewDoctorStep(){
        waitAndClick(colaboratorsElement);
        LogUtility.infoLog("The user clicked on the colaborators button and accessed the client page");
    }

    public void getSubscriptionStep(){
        String actualButtonText = getSubscriptionButton.getText();
        LogUtility.infoLog("Button text found: " + actualButtonText);

        String expectedButtonText = "Aboneaza-te acum";
        Assert.assertEquals(actualButtonText, expectedButtonText, "The button text is not correct!");
        LogUtility.infoLog("Get Subscription button text validated successfully.");

        waitAndClick(getSubscriptionButton);
        LogUtility.infoLog("Get Subscription button clicked by the user.");

        String actualUrl = driver.getCurrentUrl();
        LogUtility.infoLog("Current URL after click: " + actualUrl);
    }}

