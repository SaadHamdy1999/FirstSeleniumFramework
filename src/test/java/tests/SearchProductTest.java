package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDerailsPage;
import pages.SearchPage;
import pages.SearchResultPage;

public class SearchProductTest extends BaseTests{
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObj;
    SearchResultPage searchResultObj;
    ProductDerailsPage productDerailsObj;
    @Test
    public void UserCanSearchProduct(){
        searchObj= new SearchPage(driver);
        searchObj.searchForProduct(productName);
        searchResultObj=new SearchResultPage(driver);
        searchResultObj.clickOnSearchResult();
        productDerailsObj= new ProductDerailsPage(driver);

        Assert.assertEquals(productDerailsObj.getProductName(),productName);
    }
}
