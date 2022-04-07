package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy (linkText = "Change password")
    WebElement changePasswordLink;

    @FindBy(id = "OldPassword")
    WebElement oldPasswordBox;

    @FindBy(id = "NewPassword")
    WebElement newPasswordBox;

    @FindBy(id = "ConfirmNewPassword" )
    WebElement confirmNewPassword;

    @FindBy(xpath = "//div[@class='buttons']/button[@type='submit']")
    WebElement changePasswordBtn;

    @FindBy(xpath = "//div[@id='bar-notification']/div/p")
    WebElement changedSuccessfullyMessage;

    @FindBy(xpath = "//span[@class='close']")
    WebElement closeBtn;
    public void clickChangePassword(){
        clickButton(changePasswordLink);
    }
    public void changePassword(String oldPass, String newPass, String confirmPass){
        setTextToTextBox(oldPasswordBox,oldPass);
        setTextToTextBox(newPasswordBox,newPass);
        setTextToTextBox(confirmNewPassword,confirmPass);
        clickButton(changePasswordBtn);
    }
    public String getResult()
    {
        String ret=changedSuccessfullyMessage.getText();
        clickButton(closeBtn);
        return ret;
    }
}
