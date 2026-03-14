package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.LogUtility;

import java.time.Duration;

public class SettingsPage extends BasePage{
    @FindBy(css = "input[placeholder='Adauga adresa de email']")
    private WebElement emailFieldValue;

    @FindBy(css = "input[placeholder='Adauga parola']")
    private WebElement passwordFieldValue;

    @FindBy(xpath = "//button[text()='Intra in cont']")
    public WebElement submitButton;

    @FindBy(xpath = "//a[.//span[text()='Colaboratori']]")
    private WebElement colaboratorsElement;

    @FindBy(linkText = "Aboneaza-te acum")
    private WebElement getSubscriptionButton;

    @FindBy(css = ("div.styles_planCard__W38Qv.styles_card__yPQQg"))
    private WebElement monthlySubscriptionCard;

    @FindBy(xpath = ".//button[contains(text(),'Alege abonament')]")
    private WebElement chooseSubscriptionButton;

    @FindBy(xpath = "//button[contains(.,'Continua fara CUI')]")
    private WebElement continueWithoutCUIButton;

    @FindBy(xpath = "//h4[text()='Finalizare plata']")
    private WebElement paymentConfirmationMessage;

    @FindBy(xpath = "//h5[contains(@class,'styles_typography__wu9wz') and contains(@class,'styles_center__U8G5d')]")
    private WebElement monthlyPaymentSubscriptionMessage;

    @FindBy(xpath = "//button[text()='Confirma']")
    private WebElement confirmPaymentButton;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void getSubscriptionProcess(){
        monthlySubscriptionCard.getText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assert monthlySubscriptionCard != null;
        Assert.assertTrue(monthlySubscriptionCard.isDisplayed(), "Monthly subscription card is not visible!");
        LogUtility.infoLog("Monthly subscription card is visible on the page.");

        String actualTitle = monthlySubscriptionCard.findElement(By.tagName("h4")).getText().trim();
        String actualPrice = monthlySubscriptionCard.findElement(By.tagName("h3")).getText().trim();

        Assert.assertEquals(actualTitle, "Abonament Lunar", "Subscription title is not correct!");
        Assert.assertTrue(actualPrice.replaceAll("\\s+", "").equalsIgnoreCase("150RON"),
                "Subscription price is not correct!");
        String expectedPrice = "150 RON";
        Assert.assertEquals(actualPrice, expectedPrice, "Subscription price is not correct!");
        LogUtility.infoLog("Subscription price validated: " + actualPrice);

        chooseSubscriptionButton.click();
        Assert.assertEquals(chooseSubscriptionButton.getText(), "Alege abonament",
                        "Subscription button text is incorrect!");
        LogUtility.infoLog("The Choose Subscription button is displayed and its text was successfully validated");
        LogUtility.infoLog("Choose Subscription button clicked. User redirected to the payment page");

        Assert.assertTrue(paymentConfirmationMessage.isDisplayed(), "The 'Payment Confirmation' element is not visible!");
        LogUtility.infoLog("Payment confirmation message displayed: " + paymentConfirmationMessage.getText());

        waitAndClick(continueWithoutCUIButton);
        By continueWithoutCUIButton = By.xpath("//button[contains(.,'Continua fara CUI')]");
        LogUtility.infoLog("User clicked on the continua fara CUI button");

        wait.until(ExpectedConditions.visibilityOf(monthlyPaymentSubscriptionMessage));
        LogUtility.infoLog("Message displayed: " + monthlyPaymentSubscriptionMessage.getText());

        Assert.assertTrue(monthlyPaymentSubscriptionMessage.isDisplayed(),
                "The 'You chose a monthly payment subscription' message is not visible!");
        LogUtility.infoLog("Message displayed: " + monthlyPaymentSubscriptionMessage.getText());

        confirmPaymentButton.click();
        Assert.assertTrue(confirmPaymentButton.isDisplayed(), "The 'Confirm Payment' button is not visible!");
        Assert.assertTrue(confirmPaymentButton.isEnabled(), "The 'Confirm Payment' button is not enabled!");
        LogUtility.infoLog("Confirm Payment button found and ready to be clicked. Button text: "
                + confirmPaymentButton.getText());
        LogUtility.infoLog("'Confirm Payment' button clicked. User successfully redirected to Stripe payment page.");

        WebDriverWait waitStripe = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitStripe.until(ExpectedConditions.urlContains("checkout.stripe.com"));

        String expectedStart = "https://checkout.stripe.com/";
        String actualPage = driver.getCurrentUrl();
        LogUtility.infoLog("Checking current URL: " + actualPage);
        assert actualPage != null;
        Assert.assertTrue(
                actualPage.startsWith(expectedStart),
                "The URL does not start with the expected static part! Actual: " + actualPage
                        + ", Expected to start with: " + expectedStart
        );
    }
}
