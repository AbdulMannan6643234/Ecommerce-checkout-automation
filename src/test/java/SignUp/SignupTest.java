package SignUp;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Base.BaseTests;

public class SignupTest extends BaseTests {
        @Test
        public void testSignUpWithShortPassword(){
           var signin = homepage.clickSignIn();
           var createAccount = signin.createAccount("johnwick423@gmail.com");
           createAccount.setGender("Male");
           createAccount.FirstName("John");
           createAccount.LastName("Wick");
           createAccount.email("johnwick423@gmail.com");
           createAccount.password("cont");
           createAccount.selectFromDays("8");
           createAccount.selectFromMonths("7");
           createAccount.selectFromYears("2006");
           createAccount.newsLetterInput(0);
           createAccount.submitButton();
           
           assertTrue(createAccount.getError().contains("passwd is invalid"), "Unexpected Response");
        }
        @Test
        public void testSuccessfulSignUp(){
           var signin = homepage.clickSignIn();
           var createAccount = signin.createAccount("johnwick423@gmail.com");
           createAccount.setGender("Male");
           createAccount.FirstName("John");
           createAccount.LastName("Wick");
           createAccount.password("continental");
           createAccount.selectFromDays("8");
           createAccount.selectFromMonths("7");
           createAccount.selectFromYears("2006");
           createAccount.newsLetterInput(0);
           createAccount.submitButton();
           assertEquals(createAccount.getSuccess(), "Your account has been created.", "Unexpected response");
        }
        
        @Test
        public void testWithEmptyFields(){
                 var signin = homepage.clickSignIn();
           var createAccount = signin.createAccount("johnwick23@gmail.com");
           createAccount.submitButton();
           
           assertTrue(createAccount.getError().containsAll(Arrays.asList("lastname is required.","firstname is required.", "passwd is required.")), "");
        
        }
}
