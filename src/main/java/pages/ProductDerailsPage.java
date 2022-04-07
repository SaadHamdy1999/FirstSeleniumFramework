package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDerailsPage extends BasePage{
    public ProductDerailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "product-name")
    WebElement productName;

    @FindBy(xpath = "//div[@class='email-a-friend']/button")
    WebElement emailToFriendBtn;

    @FindBy(id = "price-value-4")
    WebElement productPrice;

    @FindBy(linkText = "Add your review")
    WebElement reviewLink;

    @FindBy(id = "add-to-wishlist-button-4")
    WebElement addToWishListBtn;
    @FindBy(partialLinkText = "Wishlist")
    WebElement wishListBtn;

    @FindBy(xpath = "//div[@class='compare-products']/button")
    WebElement addToCompareListBtn;
    @FindBy(linkText = "product comparison")
    WebElement productComparisonLink;

    public String getProductName() {
        return productName.getText();
    }

    public void clickOnSendToFriend()
    {
        clickButton(emailToFriendBtn);
    }

    public String getProductPrice(){ return  productPrice.getText(); }

    public void clickOnAddYourReview(){ clickButton(reviewLink);}

    public void clickOnAddToWishList(){ clickButton(addToWishListBtn);}

    public void goToWishList(){
       // clickButton(closeNotificationBtn);
        clickButton(wishListBtn);

    }
    public void addProductToComparison()
    {
        clickButton(addToCompareListBtn);
    }
    public void goToComparison(){clickButton(productComparisonLink);}

}
