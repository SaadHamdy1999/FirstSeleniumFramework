package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends BasePage{

    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="FriendEmail")
    WebElement friendEmailBox;

    @FindBy(id="PersonalMessage")
    WebElement personalMessageBox;

    @FindBy(name = "send-email")
    WebElement sendEmailBtn;

    @FindBy(css = "div.result")
    WebElement resultMessage;
    public void sendAnEmail(String friendEmail, String message){
        setTextToTextBox(friendEmailBox,friendEmail);
        setTextToTextBox(personalMessageBox,message);
        clickButton(sendEmailBtn);
    }
    public String getResultMessageText()
    {
        return resultMessage.getText();
    }

}
