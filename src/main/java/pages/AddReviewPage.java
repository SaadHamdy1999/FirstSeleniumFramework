package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddReviewPage extends BasePage{
    public AddReviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="AddProductReview_Title")
    WebElement reviewTitleBox;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewBodyBox;

    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> ratingRadioBtns;

    @FindBy(name = "add-review")
    WebElement submitReviewBtn;

    @FindBy (css = "div.result")
    WebElement reviewSubmittedText;

    public void leaveAReview(String title, String review,int rating)
    {
        setTextToTextBox(reviewTitleBox,title);
        setTextToTextBox(reviewBodyBox,review);
        clickButton(ratingRadioBtns.get(4));
        clickButton(submitReviewBtn);
    }
    public String getReviewResult(){
        return reviewSubmittedText.getText();
    }

}
