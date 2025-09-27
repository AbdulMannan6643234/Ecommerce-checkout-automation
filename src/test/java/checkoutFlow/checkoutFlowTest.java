package checkoutFlow;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Base.BaseTests;
import utils.WindowManager;

public class checkoutFlowTest extends BaseTests {
    @Test(groups ={"smoke"})
    public void testSuccessfulCheckoutFlow(){
        var products = homepage.clickProductLink();
       
        var selectedProduct = products.selectItem(0);
        int i = 1;
        do{
        if(selectedProduct.checkURL()) {
           if(selectedProduct.statusCheck()){
            
            break;
        }else{
            WindowManager.goBack();
        }}
        else{
            i++;
            selectedProduct = products.selectItem(i);
        }
    }while(true);
    selectedProduct.AddToCart("1");
    var login = selectedProduct.clickProceedToLogin();
    login.enterEmail("johnwick423@gmail.com");
    login.enterPassword("continental");
    var myacc = login.clickSignIn();
    var checkout = myacc.moveToCheckOut();
    checkout.clickproceedtoAddress();
    checkout.proceedToShipping();
    checkout.agreeToTerms();
    var payment = checkout.clickProceedToPayment();
    payment.clickByBank();
    payment.clickProceed();
    assertEquals(payment.getSuccess(), "Your order on My Shop is complete.", "Unexpected Response");




    }

    @Test(groups ={"regression"})
    public void testWithWrongCredentials(){
    var products = homepage.clickProductLink();
       
        var selectedProduct = products.selectItem(0);
        int i = 1;
        do{
        if(selectedProduct.checkURL()) {
           if(selectedProduct.statusCheck()){
            
            break;
        }else{
            WindowManager.goBack();
        }}
        else{
            i++;
            selectedProduct = products.selectItem(i);
        }
    }while(true);
    selectedProduct.AddToCart("1");
    var login = selectedProduct.clickProceedToLogin();
    // = checkout.clickproceedtoLogin();
    login.enterEmail("johnwick23@gmail.com");
    login.enterPassword("testPasscode");
    login.clickSignIn();
    assertEquals(login.getError(), "Authentication failed.", "Unexpected Response");
}



    @Test(groups ={"regression"})
    public void testWithIncompleteSignUp(){
        var products = homepage.clickProductLink();
       
        var selectedProduct = products.selectItem(0);
        int i = 1;
        do{
        if(selectedProduct.checkURL()) {
           if(selectedProduct.statusCheck()){
            
            break;
        }else{
            WindowManager.goBack();
        }}
        else{
            i++;
            selectedProduct = products.selectItem(i);
        }
    }while(true);
    selectedProduct.AddToCart("1");
    var SignIn = selectedProduct.clickProceedToSignIn();
    // = checkout.clickproceedToSignIn();
    var create = SignIn.createAccount("testFrameWork@chad.com");
    create.submitButton();
    assertTrue(create.getError().containsAll(Arrays.asList(
"lastname is required.",
"firstname is required.",
"passwd is required.")), "Unexpected Response");
}
     @Test(groups ={"regression"})
     public void teestWithIncompleteAddress(){
        var products = homepage.clickProductLink();
       
        var selectedProduct = products.selectItem(0);
        int i = 1;
        do{
        if(selectedProduct.checkURL()) {
           if(selectedProduct.statusCheck()){
            
            break;
        }else{
            WindowManager.goBack();
        }}
        else{
            i++;
            selectedProduct = products.selectItem(i);
        }
    }while(true);
    selectedProduct.AddToCart("1");
    var login = selectedProduct.clickProceedToLogin();
    // = checkout.clickproceedtoLogin();
    login.enterEmail("johnwick423@gmail.com");
    login.enterPassword("continental");
    var myacc = login.clickSignIn();
    var checkout = myacc.moveToCheckOut();
    checkout.updateAddress();
    checkout.enterFirstName("##clear##");
    checkout.enterLastName("##clear##");
    checkout.enterAddress("##clear##");
    checkout.enterCity("##clear##");
    checkout.enterHomePhone("##clear##");
    checkout.enterMobilePhone("##clear##");
    checkout.enterPostalCode("##clear##");
    checkout.selectState("-");
    checkout.clickSave();
    assertTrue(checkout.getError().containsAll(Arrays.asList("lastname is required.",
    "firstname is required.",
    "address1 is required.",
    "city is required.",
    "You must register at least one phone number.",
    "This country requires you to chose a State.",
    "The Zip/Postal code you\'ve entered is invalid. It must follow this format: 00000")), "Unexpected Response");
     }
     
}
