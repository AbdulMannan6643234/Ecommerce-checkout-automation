package pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkout {
    private WebDriver driver;
    private By proceed = By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium");
    private By address = By.id("address1");
    private By firstNameInput = By.id("firstname");
    private By lastNameInput = By.id("lastname");
    private By city = By.id("city");
    private By State = By.id("id_state");
    private By country = By.id("id_country");
    private By postalCode = By.id("postcode");
    private By phone_no = By.id("phone");
    private By alias = By.id("alias");
    private By mobile = By.id("phone_mobile");
    private By submitButton = By.id("submitAddress");
    private By error = By.cssSelector(".alert.alert-danger li");
    private By shipping = By.xpath("//button[@name='processAddress']");
    private By terms = By.id("uniform-cgv");
    private By update = By.xpath("//a[@title='Update']");
    public checkout(WebDriver driver){
        this.driver = driver;
    }
    public login clickproceedtoLogin(){
        driver.findElement(proceed).click();
        return new login(driver);
    }
    public SignIn clickproceedToSignIn(){
        driver.findElement(proceed).click();
        return new SignIn(driver);
    }
    public void updateAddress(){
        driver.findElement(update).click();
    }
    public void enterFirstName(String fname){
        if(fname.equalsIgnoreCase("##clear##")){
            driver.findElement(firstNameInput).clear();
        }else{
        driver.findElement(firstNameInput).sendKeys(fname);
        }
    }
    public void enterLastName(String lname){
        if(lname.equalsIgnoreCase("##clear##")){
            driver.findElement(lastNameInput).clear();
        }else{
        driver.findElement(lastNameInput).sendKeys(lname);
    }
}
    public void enterAddress(String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(address))).click();
        if(text.equalsIgnoreCase("##clear##")){
            driver.findElement(address).clear();
        }else{
        driver.findElement(address).sendKeys(text);
        
    }
}
    public void enterCity(String City){
       if(City.equalsIgnoreCase("##clear##")){
            driver.findElement(city).clear();
        }else{
        driver.findElement(city).sendKeys(City);
    }
}
    //State name must begin with capital alphabet
    public void selectState(String state){
        Select states = new Select(driver.findElement(State));
        states.selectByVisibleText(state);
    }
    public void enterPostalCode(String code){
        if(code.equalsIgnoreCase("##clear##")){
            driver.findElement(postalCode).clear();
        }else{
        driver.findElement(postalCode).sendKeys(code);
    }
}
    public void selectCountry(String Country){
        Select countries = new Select(driver.findElement(country));
        countries.selectByVisibleText(Country);
    }
    public void enterHomePhone(String homePhone){
        if(homePhone.equalsIgnoreCase("##clear##")){
            driver.findElement(phone_no).clear();
        }else{
        driver.findElement(phone_no).sendKeys(homePhone);
    }
}
    public void enterMobilePhone(String mobilePhone){
        if(mobilePhone.equalsIgnoreCase("##clear##")){
            driver.findElement(mobile).clear();
        }else{
        driver.findElement(mobile).sendKeys(mobilePhone);
    }
}
    public void clickSave(){
        driver.findElement(submitButton).click();
    }
    public List<String> getError(){
        List<WebElement> errors = driver.findElements(error);
        List<String> errorText = errors.stream().map(WebElement::getText).collect(Collectors.toList());
        return errorText;
    }

    public void proceedToShipping(){
        WebElement button = driver.findElement(shipping);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("layer_cart_overlay"))));
        action.moveToElement(button).click().perform();
    }
    public void agreeToTerms(){
        driver.findElement(terms).click();
    }
    public payment clickProceedToPayment(){
        driver.findElement(By.cssSelector("button.btn.btn-default.standard-checkout.button-medium")).click();
        return new payment(driver);
    }



}
