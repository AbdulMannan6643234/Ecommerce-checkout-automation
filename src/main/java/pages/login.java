package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By password = By.id("passwd");
    private By signIn = By.id("SubmitLogin");
    private By error = By.cssSelector(".alert.alert-danger li");
    public login(WebDriver driver){
        this.driver = driver;
    }
    public void enterEmail(String Email){
        driver.findElement(emailField).sendKeys(Email);
    }
    public void enterPassword(String Passwd){
        driver.findElement(password).sendKeys(Passwd);
    }
    public void clickSignIn(){
        driver.findElement(signIn).click();
    }
    public String getError(){
        return driver.findElement(error).getText();
    }
}   
