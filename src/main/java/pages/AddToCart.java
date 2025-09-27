package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
        private WebDriver driver;
        private By size = By.id("group_1");
        private By quantityInput=By.id("quantity_wanted");
        private By colour = By.id("color_8");
        private By button = By.xpath("//button[@type='submit' and @name = 'Submit']");
        private By status = By.id("availability_value");
        private By proceed = By.xpath("//a[@rel = 'nofollow']");
        private By cartQuantity = By.xpath("//span[contains(text(),'(empty)')]");
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            String availability = wait.until(ExpectedConditions.visibilityOf(driver.findElement(status))).getText();
            if(availability.equalsIgnoreCase("This product is no longer in stock")){
                return false;
            }else if(availability.equalsIgnoreCase("This product is no longer in stock with those attributes but is available with others.")){
                    selectColour();
                    if(availability.equalsIgnoreCase("In stock")){
                        return true;
                    }
            }else if(availability.equalsIgnoreCase("In stock")){
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
           wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(colour)));
           driver.findElement(colour).click();
        }
        //quantity must be greater than 1
        public void AddToCart(String quantity){
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
           wait.until(d->true);
           selectColour();
           driver.findElement(quantityInput).sendKeys(Keys.BACK_SPACE+quantity);
           driver.findElement(button).click(); 
           System.out.println("Clicked Add To Cart");
        }
        public login clickProceedToLogin(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(d->true);
            driver.findElement(proceed).click();
            return new login(driver);
        }
        public SignIn clickProceedToSignIn(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
           wait.until(ExpectedConditions.visibilityOf(driver.findElement(proceed))).click();
            return new SignIn(driver);
        }
}
