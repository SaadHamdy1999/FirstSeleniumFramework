package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Email")
    WebElement emailBox;
    @FindBy(id = "Password")
    WebElement passwordBox;
    @FindBy(xpath = "//div[@class='buttons']/button[@type='submit']")
    WebElement loginBtn;

    public void Login(String email, String password){
        setTextToTextBox(emailBox,email);
        setTextToTextBox(passwordBox,password);
        clickButton(loginBtn);
    }
}
