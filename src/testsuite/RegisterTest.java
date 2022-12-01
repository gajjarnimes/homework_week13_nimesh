package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.Utility;

public class RegisterTest extends Utility {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //click on the Register Link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Verify the text 'Signing up is easy!'
        String expectedMessage= "Signing up is easy!";
        String actualMessage= getTextFromElement(By.xpath("//h1[@class='title']"));
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
