package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
        private WebDriver driver;
        private By size = By.id("group_1");
        private By colour = By.id("color_8");
        private By button = By.cssSelector("button.exclusive");
        private By status = By.id("availability_value");
        private By proceed = By.cssSelector("a.btn.btn-default.button.button-medium");
        public AddToCart(WebDriver driver){
            this.driver = driver;
        }
        public boolean checkURL(){
            if(driver.getCurrentUrl().contains("&controller=product")){
                return true;
            }else{
                return false;
            }
        }

        public boolean statusCheck(){
            String availability = driver.findElement(status).getText();
            if(availability.equalsIgnoreCase("This product is no longer in stock")){
                return false;
            }else if(availability.equalsIgnoreCase("This product is no longer in stock with those attributes but is available with others.")){
                    selectColour();
                    if(availability.equalsIgnoreCase("In stock")){
                        driver.findElement(button).click();
                        return true;
                    }
            }else if(availability.equalsIgnoreCase("In stock")){
                        driver.findElement(button).click();
                        return true;
                    }
                    return true;
        }
        // Sizes are S,M and L
        private void selectSize(String Size){
            Select sizes = new Select(driver.findElement(size));
            sizes.selectByVisibleText(Size);
        }
        public void selectColour(){
            Actions action = new Actions(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
           WebElement colourSelect = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(colour)));
           action.moveToElement(colourSelect).click().perform();
        }
        public void AddToCart(){
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
           wait.until(ExpectedConditions.visibilityOf(driver.findElement(button))).click(); 
           
        }
        public checkout clickProceed(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
           wait.until(ExpectedConditions.visibilityOf(driver.findElement(proceed))).click();
            return new checkout(driver);
        }
}
