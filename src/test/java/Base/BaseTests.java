package Base;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import utils.WindowManager;
public class BaseTests {
    private WebDriver driver;
    protected HomePage homepage;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        goHome();
        homepage = new HomePage(driver);
        WindowManager windowManager = new WindowManager(driver);
    }
    public void goHome(){
        driver.get("http://www.automationpractice.pl/index.php?");
    }
    @AfterMethod
    public void terminate(){
       driver.quit();
    }

}
