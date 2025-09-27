package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class payment {
    private WebDriver driver;
    private By bank = By.cssSelector(".col-xs-12 .bankwire");
    private By check = By.cssSelector(".col-xs-12 .cheque");
    private By proceed = By.cssSelector("button[type='submit'].button.btn.btn-default.button-medium");
    private By success = By.cssSelector(".alert.alert-success");
    private By Banner = By.cssSelector("div.banner");
    public payment(WebDriver driver){
        this.driver = driver;
    }
    public void clickByBank(){
        driver.findElement(bank).click();
    }
    public void clickByCheck(){
        driver.findElement(check).click();
    }
    public void clickProceed(){
        WebElement Proceed = driver.findElement(proceed);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 250);");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5) );
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".layer_cart_overlay"))));
        Actions action = new Actions(driver);
        action.moveToElement(Proceed).click().perform();
    }
    public String getSuccess(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(success))).getText();
    }

}
