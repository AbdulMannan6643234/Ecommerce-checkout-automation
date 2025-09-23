package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
    public SignIn clickSignIn(){
        clickLink("Sign in");
        return new SignIn(driver);
    }
    public Contact clickContactUs(){
        clickLink("Contact us");
        return new Contact(driver);
    }
    public productPage clickProductLink(){
       driver.findElement(By.id("search_query_top")).sendKeys("Blouse");
       driver.findElement(By.cssSelector(".btn.btn-default.button-search")).click();
       return new productPage(driver);
    }
}
