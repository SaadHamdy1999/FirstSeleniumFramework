package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDerailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class WishListTest extends BaseTests {
    SearchPage searchObj;
    ProductDerailsPage productDerailsObj;
    WishListPage wishListObj;
    String productName="Apple MacBook Pro 13-inch";
    @Test
    public void UserCanSearchUsingAutoComplete(){
        searchObj=new SearchPage(driver);
        searchObj.SearchUsingAutoComplete("MacB");
        productDerailsObj= new ProductDerailsPage(driver);
        Assert.assertEquals(productDerailsObj.getProductName(),productName);
    }
    @Test (dependsOnMethods = "UserCanSearchUsingAutoComplete")
    public void AddToWishList()
    {
        productDerailsObj.clickOnAddToWishList();
        productDerailsObj.goToWishList();
        wishListObj= new WishListPage(driver);
        Assert.assertEquals(wishListObj.getProductNameAdded(),productName);
    }
    @Test (dependsOnMethods = "AddToWishList")
    public void removeProductFromWishList()
    {
        wishListObj.removeElementFromWisList();
        Assert.assertEquals(wishListObj.returnLabelVal(),"The wishlist is empty!");
    }
}
