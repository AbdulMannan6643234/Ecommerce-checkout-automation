package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Contact {
    private WebDriver driver;
    private By subject = By.id("id_contact");
    private By email = By.id("email");
    private By orderId = By.id("id_order");
    private By fileUpload = By.id("fileUpload");
    private By message = By.id("message");
    private By send = By.id("submitMessage");
    private By errorMessage = By.cssSelector(".alert.alert-danger li");
    private By successMessage = By.cssSelector(".alert.alert-success");
    public Contact(WebDriver driver){
        this.driver = driver;
    }
    private Select findSubjectHeading(){
        return new Select(driver.findElement(subject));
    }
    public void selectHeading(String text){
        /*Subject can either be "Customer service"
        or "Webmaster"*/
        findSubjectHeading().selectByVisibleText(text);
    }
    public void enterOrderId(String value){
        driver.findElement(orderId).sendKeys(value);
    }
    public void inputEmail(String Email){
        driver.findElement(email).sendKeys(Email);
    }
    public void attachFile(String absolutepath){
        driver.findElement(fileUpload).sendKeys(absolutepath);
    }
    public void addMessage(String Message){
        driver.findElement(message).sendKeys(Message);
    }
    public void sendMessage(){
        driver.findElement(send).click();
    }
    public List<String> getError(){
        List<WebElement> errors = driver.findElements(errorMessage);
        List<String> errorText = errors.stream().map(WebElement::getText).collect(Collectors.toList());
        return errorText;
    }
    public String getSuccess(){
        return driver.findElement(successMessage).getText();
    }
}
