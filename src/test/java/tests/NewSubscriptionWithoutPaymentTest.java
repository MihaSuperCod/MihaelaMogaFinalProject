package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewSubscriptionWithoutPaymentTest {

    public WebDriver driver;

    @Test
    public void newSubscriptionWithoutPaymentTest() {
        driver = new ChromeDriver();
        driver.get("https://dentops.ro/");
        driver.manage().window().maximize();

        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder='Adauga adresa de email']"));
        String emailFieldValue = "mihaelamoga23@gmail.com";
        emailField.sendKeys(emailFieldValue);

        WebElement passwordField = driver.findElement(By.cssSelector("input[placeholder='Adauga parola']"));
        String passwordFieldValue = "Pacific2027!";
        passwordField.sendKeys(passwordFieldValue);

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Intra in cont']"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement getSubscriptionButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Aboneaza-te acum")));
        getSubscriptionButton.click();
        System.out.println("Textul link-ului: " + getSubscriptionButton.getText());
        System.out.println("URL după click: " + driver.getCurrentUrl());

        WebElement abonamentLunarCard = driver.findElement
                (By.xpath("//div[.//h4[contains(text(),'Abonament Lunar')] "
                        + "and .//h3[contains(text(),'150 RON')]]"));

        System.out.println("Card gasit: " +
                abonamentLunarCard.findElement(By.xpath(".//h4")).getText() + " - " +
                abonamentLunarCard.findElement(By.xpath(".//h3")).getText());

        WebElement alegeAbonamentbutton = abonamentLunarCard.findElement(
                By.xpath(".//button[contains(text(),'Alege abonament')]"));
        System.out.println("Textul butonului găsit: " + alegeAbonamentbutton.getText());

        Assert.assertTrue(alegeAbonamentbutton.isDisplayed(), "Butonul nu este vizibil!");
        Assert.assertTrue(alegeAbonamentbutton.isEnabled(), "Butonul nu este activ!");
        Assert.assertEquals(alegeAbonamentbutton.getText(), "Alege abonament", "Textul butonului nu corespunde!");
        alegeAbonamentbutton.click();

        WebElement finalizarePlataMessage = driver.findElement(By.xpath("//h4[text()='Finalizare plata']"));
        Assert.assertTrue(finalizarePlataMessage.isDisplayed(), "Elementul 'Finalizare plata' nu este vizibil!");
        System.out.println("Element găsit: " + finalizarePlataMessage.getText());

        WebElement continuaFaraCUIButton = driver.findElement(By.xpath("//button[text()='Continua fara CUI']"));
        Assert.assertTrue(continuaFaraCUIButton.isDisplayed(), "Butonul nu este vizibil!");
        Assert.assertTrue(continuaFaraCUIButton.isEnabled(), "Butonul nu este activ!");
        System.out.println("Buton găsit: " + continuaFaraCUIButton.getText());
        continuaFaraCUIButton.click();

        WebElement aiAlesAbonamentCuPlataInFiecareLunaMessage = driver.findElement
                (By.xpath("//h5[contains(@class,'styles_typography__wu9wz') and contains(@class,'styles_center__U8G5d')]"));
        Assert.assertTrue(aiAlesAbonamentCuPlataInFiecareLunaMessage.isDisplayed(),
                "Elementul 'Ai ales abonament cu plata in fiecare luna' nu este vizibil!");
        System.out.println("Element găsit: " + aiAlesAbonamentCuPlataInFiecareLunaMessage.getText());

        WebElement confirmaButton = driver.findElement(By.xpath("//button[text()='Confirma']"));
        Assert.assertTrue(confirmaButton.isDisplayed(), "Butonul nu este vizibil!");
        Assert.assertTrue(confirmaButton.isEnabled(), "Butonul nu este activ!");
        System.out.println("Buton găsit: " + confirmaButton.getText());
        confirmaButton.click();

        WebDriverWait waitStripe = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitStripe.until(ExpectedConditions.urlContains("checkout.stripe.com"));

        String expectedStart = "https://checkout.stripe.com/";
        String actualPage = driver.getCurrentUrl();
        System.out.println("Verific URL: " + actualPage);
        Assert.assertTrue(
                actualPage.startsWith(expectedStart),
                "URL-ul nu începe cu partea statică! Actual: " + actualPage
                        + ", Așteptat să înceapă cu: " + expectedStart);
    }}