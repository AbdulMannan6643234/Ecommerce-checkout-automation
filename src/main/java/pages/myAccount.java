package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class myAccount {
    private WebDriver driver;
    private By popUp = By.xpath("//a[@title='View my shopping cart']");
    private By checkOut=By.id("button_order_cart");
    public myAccount(WebDriver driver){
        this.driver = driver;
    }
    public checkout moveToCheckOut(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(popUp)).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d->true);
        driver.findElement(checkOut).click();
        return new checkout(driver);
    }
}
