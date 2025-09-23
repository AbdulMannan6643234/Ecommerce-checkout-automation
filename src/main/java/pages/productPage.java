package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class productPage {
    private WebDriver driver;
    private By topSellers = By.cssSelector("h4.title_block.active");
    private By products = By.cssSelector(".block_content.products-block a.product-name");
    public productPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickTopSellers(){
        driver.findElement(topSellers).click();
    }
    //index is 0 based
    public AddToCart selectItem(int Index){
        List<WebElement> Items = driver.findElements(products);
        Items.get(Index).click();
        return new AddToCart(driver);
    }
    




}
