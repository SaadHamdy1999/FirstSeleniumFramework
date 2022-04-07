package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDerailsPage;
import pages.SearchPage;

public class ChangCurrencyTest extends BaseTests{

    HomePage homeObj;
    SearchPage searchObj;
    ProductDerailsPage productDerailsObj;
    String productPrice="€1548.00";
    @Test
    public void UserCanSearchUsingAutoComplete(){
        homeObj=new HomePage(driver);
        homeObj.changeCurrencyToEuro();
        searchObj=new SearchPage(driver);
        searchObj.SearchUsingAutoComplete("MacB");
        productDerailsObj= new ProductDerailsPage(driver);
        Assert.assertEquals(productDerailsObj.getProductPrice(),productPrice);
    }

}
