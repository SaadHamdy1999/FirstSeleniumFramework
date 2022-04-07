package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDerailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoComplete extends BaseTests{
    SearchPage searchObj;
    ProductDerailsPage productDerailsObj;
    String productName="Apple MacBook Pro 13-inch";
    @Test
    public void UserCanSearchUsingAutoComplete(){
        searchObj=new SearchPage(driver);
        searchObj.SearchUsingAutoComplete("MacB");
        productDerailsObj= new ProductDerailsPage(driver);
        Assert.assertEquals(productDerailsObj.getProductName(),productName);
    }
}
