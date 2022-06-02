package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContacUSPage;
import pages.HomePage;

public class ContactUsTest extends BaseTests {
    HomePage homeObj;
    ContacUSPage contactUsObj;
    String  name="saad";
    String email="saaad@saaad.com";
    String inquiry="jjrwgbqwro;gnas;ivnfbip";
    @Test
    public void contactUs()
    {
        homeObj=new HomePage(driver);
        homeObj.clickContactUs();
        contactUsObj=new ContacUSPage(driver);
        contactUsObj.ContactUs(name,email,inquiry);
        Assert.assertEquals(contactUsObj.getResult(),"Your enquiry has been successfully sent to the store owner.");

    }

}
