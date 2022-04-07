package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class ProductHoverTest extends BaseTests{
    HomePage homeObj;
    @Test
    public void UserCanSelectSubCategoryFromCategory()
    {
        homeObj= new HomePage(driver);
        homeObj.selectNoteBookFromComputers();
        Assert.assertEquals(homeObj.getSubCategory(),"Notebooks");
    }
}
