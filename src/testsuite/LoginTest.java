package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on the Register Link
        clickOnElement(By.linkText("Register"));
        //Enter first name
        sendTextToElement(By.id("customer.firstName"),"Roheet");
        // Enter Last name
        sendTextToElement(By.id("customer.lastName"),"Pawar");
        // Enter Address
        sendTextToElement(By.id("customer.address.street"),"20,Hollywood Way");
        // Enter City
        sendTextToElement(By.id("customer.address.city"),"Hollywood");
        // Enter State
        sendTextToElement(By.id("customer.address.state"),"Vatican");
        // Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"),"123456");
        // Enter Phone
       sendTextToElement(By.id("customer.phoneNumber"),"9876543");
        // Enter SSN
       sendTextToElement(By.id("customer.ssn"),"123");
        // Enter Username
        sendTextToElement(By.id("customer.username"),"RoheetPawar1");
        // Enter Password
       sendTextToElement(By.id("customer.password"),"Roheet@99");
        // Enter confirm
       sendTextToElement(By.id("repeatedPassword"),"Roheet@99");
        // Click on REGISTER button
        clickOnElement(By.xpath("//input[@value='Register']"));
        //verify the text"Your account was created successfully.you are now logged in.
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        String actualMessage = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter valid Username
        sendTextToElement(By.name("username"),"RoheetPawar1");
        // Enter valid Password
        sendTextToElement(By.name("password"),"Roheet@99");
        // Click on 'LOGIN' button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        // Verify the 'Accounts Overview' text is display
        String expectedMessage = "Accounts Overview";
        String actualMessage = getTextFromElement(By.xpath("//a[@href='/parabank/overview.htm']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        // Enter  invalid username
        sendTextToElement(By.name("username"),"Test123@gmail.com");
        // Enter invalid password
        sendTextToElement(By.name("password"),"Test1234");
        // Click on Login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        // Verify the error message 'The username and password could not be verified'
        String expectedMessage="An internal error has occurred and has been logged.";
        String actualMessage=getTextFromElement(By.xpath("//p[contains(text(),'An internal error has occurred and has been logged')]"));
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void userShouldLogoutSuccessfully(){
        // Enter valid username
        sendTextToElement(By.name("username"),"RoheetPawar1");
        // Enter valid password
        sendTextToElement(By.name("password"),"Roheet@99");
        // Click on 'LOGIN' button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        // Click on 'Log Out' link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        // Verify the text 'Customer Login'
        String expectedMessage="Customer Login";
        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}




