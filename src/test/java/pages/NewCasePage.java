package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.LogUtility;

import java.time.Duration;
import java.util.Objects;


public class NewCasePage extends BasePage {
        @FindBy(css = "input[placeholder='Adauga adresa de email']")
        private WebElement emailFieldValue;

        @FindBy(css = "input[placeholder='Adauga parola']")
        private WebElement passwordFieldValue;

        @FindBy(xpath = "//button[text()='Intra in cont']")
        public WebElement submitButton;

        @FindBy(xpath = "//a[@href='/new-case' and .//span[contains(text(),'Adaugă')]]")
        private WebElement addNewCaseButton;

        @FindBy(xpath = "//label[contains(normalize-space(.), 'Alege medic')]")
        private WebElement doctorLabel;

        @FindBy(xpath = "//label[contains(., 'Alege medic')]/following::input[@type='text'][1]")
        private WebElement doctorInputField;

        @FindBy(xpath = "//label[@for='patientName' and contains(normalize-space(.), 'Nume pacient')]")
        private WebElement patientNameLabel;

        @FindBy(xpath = "//input[@name='patientName' and @placeholder='Adauga nume pacient']")
        private WebElement patientNameInput;

        @FindBy(xpath = "//label[normalize-space(text())='Culoare']")
        private WebElement colorLabel;

        @FindBy(xpath = "//span[normalize-space(text())='Selecteaza o culoare']")
        private WebElement colorDropdownInput;

        @FindBy(xpath = "//button[normalize-space(text())='0M3']")
        private WebElement colorButton0M3;

        @FindBy(xpath = "//label[contains(normalize-space(.),'Alege Element')]")
        private WebElement chooseElementLabel;

        @FindBy(xpath = "//input[@type='text' and @autocomplete='off']")
        private WebElement elementInputField;

        @FindBy(xpath = "//*[name()='svg' and @width='31' and @height='48']")
        private WebElement toothElementButton;

        @FindBy(xpath = "//button[normalize-space()='Finalizeaza']")
        private WebElement finalizeButton;

        public NewCasePage(WebDriver driver) {
            super(driver);
        }

        public void addNewCaseProcess() {
            waitForElementToBeVisible(doctorLabel, 15);
            String labelText = doctorLabel.getText();
            Assert.assertTrue(labelText.contains("Alege medic"),
                    "The label does not contain the expected text!");
            LogUtility.infoLog("Found label text: " + labelText);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(doctorInputField));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", doctorInputField);
            doctorInputField.sendKeys("Ionescu Maria");
            LogUtility.infoLog("Entering doctor: Ionescu Maria");

            By firstSuggestion = By.xpath("//*[contains(text(),'Ionescu')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstSuggestion));
            WebElement suggestion = driver.findElement(firstSuggestion);
            suggestion.click();
            LogUtility.infoLog("Pressing ENTER to select the doctor from suggestions");

            waitForElementToBeVisible(patientNameLabel, 15);
            String labelText2 = patientNameLabel.getText();
            Assert.assertTrue(labelText2.contains("Nume pacient"),
                    "The label does not contain the expected text!");
            LogUtility.infoLog("Found label text: " + labelText2);

            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(patientNameInput));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", patientNameInput);
            patientNameInput.sendKeys("Laura Ion");
            LogUtility.infoLog("Entering patient name: Laura Ion");

            waitForElementToBeVisible(colorLabel, 15);
            String labelText3 = colorLabel.getText();
            Assert.assertTrue(labelText3.contains("Culoare"),
                    "The label does not contain the expected text!");
            LogUtility.infoLog("Found label text: " + labelText3);

            colorDropdownInput.click();
            LogUtility.infoLog("The user clicked on color dropdown");

            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(colorDropdownInput));
            waitForElementToBeVisible(colorDropdownInput, 10);
            LogUtility.infoLog("Color selection span is visible: " + colorDropdownInput.getText());

            colorButton0M3.click();
            LogUtility.infoLog("Selected color: 0M3");

            waitForElementToBeVisible(chooseElementLabel, 15);
            String labelText4 = chooseElementLabel.getText();
            Assert.assertTrue(labelText4.contains("Alege Element"),
                    "The label does not contain the expected text!");
            LogUtility.infoLog("Found label text: " + labelText4);

            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(elementInputField));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementInputField);
            elementInputField.sendKeys("Zirconium Monolithic");
            LogUtility.infoLog("User enters element: Zirconium Monolithic");

            waitForElementToBeVisible(toothElementButton, 15);
            Assert.assertTrue(toothElementButton.isDisplayed(), "The SVG element is not displayed!");
            LogUtility.infoLog("SVG element is visible on the page");
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].dispatchEvent(new MouseEvent('click', {bubbles: true}))",
                   toothElementButton);
            LogUtility.infoLog("The user chooses element: 12");

            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(finalizeButton));
            Assert.assertTrue(finalizeButton.isDisplayed(), "Finalize button is not visible!");
            LogUtility.infoLog("Finalize button is visible");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", finalizeButton);
            LogUtility.infoLog("The user clicked the Finalize button");

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("/cases"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(Objects.requireNonNull(currentUrl).contains("/cases"),
                    "User was not redirected to the Cases page!");
            LogUtility.infoLog("User successfully redirected to the Cases page: " + currentUrl);
        }}