package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.ProductDerailsPage;
import pages.SearchPage;

public class AddProductToCompareTests extends  BaseTests{
    SearchPage searchObj;
    ProductDerailsPage productDerailsObj;
    ComparePage compareObj;
    String FirstProductName="Apple MacBook Pro 13-inch";
    String SecondProductName="Asus N551JK-XO076H Laptop";
    @Test
    public void UserCanSearchForAppleUsingAutoComplete(){
        searchObj=new SearchPage(driver);
        searchObj.SearchUsingAutoComplete("MacB");
        productDerailsObj= new ProductDerailsPage(driver);
        Assert.assertEquals(productDerailsObj.getProductName(),FirstProductName);

    }
    @Test (dependsOnMethods = "UserCanSearchForAppleUsingAutoComplete")
    public void addAppleToComparison()
    {
        productDerailsObj.addProductToComparison();
    }
    @Test (dependsOnMethods = "addAppleToComparison")
    public void UserCanSearchForAsusUsingAutoComplete()
    {
        searchObj.SearchUsingAutoComplete("asus");
        productDerailsObj= new ProductDerailsPage(driver);
        Assert.assertEquals(productDerailsObj.getProductName(),SecondProductName);

    }
    @Test (dependsOnMethods = "UserCanSearchForAsusUsingAutoComplete")
    public void addAsusToComparison()
    {
        productDerailsObj.addProductToComparison();
        productDerailsObj.goToComparison();
        compareObj=new ComparePage(driver);
        Assert.assertEquals(compareObj.getLastItemAddedToList(),FirstProductName);
    }
    @Test(dependsOnMethods ="addAsusToComparison" )
    public void removeFromCompare(){
        compareObj.removeProductsFromComparison();
        Assert.assertEquals(compareObj.getNoDataToCompareText(),"You have no items to compare.");
    }
}
