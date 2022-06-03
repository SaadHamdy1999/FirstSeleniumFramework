package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddReviewTest extends BaseTests{

    HomePage homeObj;
    UserRegisterationPage registerationObj;
    SearchPage searchObj;
    SearchResultPage searchResultObj;
    ProductDerailsPage productDerailsObj;
    AddReviewPage addReviewObj;
    String mail = "ososssss@sad.com";
    String oldpass = "1234567";
    String productName = "Apple MacBook Pro 13-inch";
    String title="ss";
    String review="asa";
    int rating=4;


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
    public void UserCanLeaveReview()
    {
        productDerailsObj.clickOnAddYourReview();
        addReviewObj=new AddReviewPage(driver);
        addReviewObj.leaveAReview(title,review,rating);
        Assert.assertEquals(addReviewObj.getReviewResult(),"Product review is successfully added.");
    }



}
