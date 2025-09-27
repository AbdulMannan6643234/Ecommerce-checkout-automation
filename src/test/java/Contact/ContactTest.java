package Contact;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Base.BaseTests;

public class ContactTest extends BaseTests {
    @Test(groups = {"smoke"})
    public void successfulMessage(){
        var contact = homepage.clickContactUs();
        contact.selectHeading("Webmaster");
        contact.enterOrderId("0");
        contact.inputEmail("johnwick423@gmail.com");
        contact.addMessage("The Product has not been delivered yet!!!");
        contact.attachFile("C:\\Users\\mrkho\\Documents\\Test Automation Projects\\The-Internet-Heroku-Selenium-TestNG\\screenshots\\Alerts.png");
        contact.sendMessage();
        assertEquals(contact.getSuccess(), "Your message has been successfully sent to our team.", "Unexpected response");
    }  
    @Test(groups ={"regression"}) 
    public void testWithEmptyMessage(){
        var contact = homepage.clickContactUs();
        contact.selectHeading("Webmaster");
        contact.enterOrderId("0");
        contact.inputEmail("johnwick423@gmail.com");
        contact.attachFile("C:\\Users\\mrkho\\Documents\\Test Automation Projects\\The-Internet-Heroku-Selenium-TestNG\\screenshots\\Alerts.png");
        contact.sendMessage();
        assertTrue(contact.getError().contains("The message cannot be blank."), "Unexpected Response!");
    }
    @Test(groups ={"regression"})
    public void testWithoutSubject(){
        var contact = homepage.clickContactUs();
        contact.enterOrderId("0");
        contact.inputEmail("johnwick423@gmail.com");
        contact.addMessage("The Product has not been delivered yet!!!");
        contact.attachFile("C:\\Users\\mrkho\\Documents\\Test Automation Projects\\The-Internet-Heroku-Selenium-TestNG\\screenshots\\Alerts.png");
        contact.sendMessage();
        assertTrue(contact.getError().contains("Please select a subject from the list provided.")  , "Unexpected Response!");
    }

}
