package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LogUtility;

public class LoginPage extends BasePage {
    @FindBy (linkText = "Login")
    public WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void LoginButton(){
       submitButton.click();
       LogUtility.infoLog("The user clicked on the login button");
    }
}
