package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//button[@name='updatecart' and @type='button']")
    WebElement removeBtn;

    @FindBy(className = "no-data")
    WebElement noDataLabel;
    @FindBy(className = "product-name")
    WebElement productAddedToWishList;

    public void removeElementFromWisList()
    {
        clickButton(removeBtn);
    }
    public String returnLabelVal()
    {
        return noDataLabel.getText();
    }
    public String getProductNameAdded(){ return productAddedToWishList.getText();}

}
