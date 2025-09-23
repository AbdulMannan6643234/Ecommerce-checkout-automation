package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class createAccount {
    private WebDriver driver;
    private By Gender1 = By.id("id_gender1");
    private By Gender2 = By.id("id_gender2");
    private By firstNameInput = By.id("customer_firstname");
    private By lastNameInput = By.id("customer_lastname");
    private By emailInput = By.id("email");
    private By passwdInput = By.id("passwd");
    private By Input = By.id("customer_firstname");
    private By day = By.id("days");
    private By month = By.id("months");
    private By year = By.id("years");
    private By newsLetter = By.id("newsletter");
    private By Submit = By.id("submitAccount");
    private By errorMessage = By.cssSelector(".alert-danger li");
    private By successMessage = By.cssSelector(".alert.alert-success");
    public createAccount(WebDriver driver){
        this.driver = driver;
    }
    public void setGender(String gender){
        
       
        if(gender.equalsIgnoreCase("male")){
            driver.findElement(Gender1).click();
        }
        else if(gender.equalsIgnoreCase("female")){
            driver.findElement(Gender2).click();
        }
    }
    public void FirstName(String Fname){
        driver.findElement(firstNameInput).sendKeys(Fname);
    }
    public void LastName(String Lname){
        driver.findElement(lastNameInput).sendKeys(Lname);
    }
    public void email(String Email){
        driver.findElement(emailInput).sendKeys(Email);
    }
    public void password(String pword){
    driver.findElement(passwdInput).sendKeys(pword);
    
}
    private Select findDay(){
        return new Select(driver.findElement(day));
    }
    private Select findMonth(){
        return new Select(driver.findElement(month));
    }
    private Select findYear(){
        return new Select(driver.findElement(year));
    }
    public void selectFromDays(String value){
        findDay().selectByValue(value);
    }
    public void selectFromMonths(String value){
        findMonth().selectByValue(value);
    }
    public void selectFromYears(String value){
        findYear().selectByValue(value);
    }
    public void newsLetterInput(int value){
        if(value == 1){
        driver.findElement(newsLetter).click();
    }}
    public void submitButton(){
        driver.findElement(Submit).click();
    }
    public List<String> getError(){
        List<WebElement> errors = driver.findElements(errorMessage);
        List<String> errorText = errors.stream()
                                 .map(WebElement::getText)
                                 .collect(Collectors.toList());
        return errorText;                         
    }
    public String getSuccess(){
        return driver.findElement(successMessage).getText();

    }



}
