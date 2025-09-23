package utils;
import org.openqa.selenium.WebDriver;

public class WindowManager {
    private static  WebDriver driver;
    public WindowManager(WebDriver driver){
        this.driver = driver;
    }
    public static void goBack(){
        driver.navigate().back();
    }
    public static void refresh(){
        driver.navigate().refresh();
    }

}
