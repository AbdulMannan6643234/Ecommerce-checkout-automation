package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {
    private WebDriver driver;
    private By emailField = By.cssSelector(".is_required.validate.account_input.form-control");
    private By submitButton = By.id("SubmitCreate");
    public SignIn(WebDriver driver){
        this.driver = driver;
    }
    public createAccount createAccount(String email){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(submitButton).click();
        return new createAccount(driver);
    }
}
