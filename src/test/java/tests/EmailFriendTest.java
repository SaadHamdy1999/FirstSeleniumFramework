package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailFriendTest extends BaseTests{
    HomePage homeObj;
    UserRegisterationPage registerationObj;
    SearchPage searchObj;
    SearchResultPage searchResultObj;
    ProductDerailsPage productDerailsObj;
    EmailFriendPage emailFriendObj;

    String mail = "ozoo@sad.com";
    String oldpass = "1234567";
    String productName = "Apple MacBook Pro 13-inch";
    String friendMail="saad@saad.com";


    @Test(priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully() {
        homeObj = new HomePage(driver);
        homeObj.clickRegister();
        registerationObj = new UserRegisterationPage(driver);
        registerationObj.userRegistration("Saad", "Hamdy", mail
                , oldpass, oldpass);
        Assert.assertEquals(registerationObj.successMessage(), "Your registration completed");
    }



    @Test (dependsOnMethods = "UserRegisterSuccessfully")
    public void UserCanSearchProduct() {
        searchObj = new SearchPage(driver);
        searchObj.searchForProduct(productName);
        searchResultObj = new SearchResultPage(driver);
        searchResultObj.clickOnSearchResult();
        productDerailsObj = new ProductDerailsPage(driver);

        Assert.assertEquals(productDerailsObj.getProductName(), productName);
    }


    @Test (dependsOnMethods = "UserCanSearchProduct")
    public void UserCanSendMailToFriend()
    {
        emailFriendObj=new EmailFriendPage(driver);
        productDerailsObj.clickOnSendToFriend();
        emailFriendObj.sendAnEmail(friendMail,productName);
        Assert.assertEquals(emailFriendObj.getResultMessageText()
                ,"Your message has been sent.");

    }

    @Test (dependsOnMethods = {"UserCanSendMailToFriend"})
    public void UserCanLogout()
    {
        registerationObj.clickLogout();
    }


}




