package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends BasePage{


    public UserRegisterationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "gender")
    WebElement genderBtn;

    @FindBy(id = "FirstName")
    WebElement firstNameBox;

    @FindBy(id = "LastName")
    WebElement lastNameBox;

    @FindBy(id = "Email")
    WebElement emailBox;

    @FindBy(id = "Password")
    WebElement passwordBox;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordBox;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy (className = "result")
    WebElement registrationSuccessfully;
    @FindBy (linkText = "Log out")
    WebElement logoutLink;

    @FindBy (linkText = "My account")
    WebElement myAccountLink;
    public void userRegistration (String firstname, String lastname, String email, String password, String confirmPassword)
    {

        clickButton(genderBtn);
        setTextToTextBox(firstNameBox,firstname);
        setTextToTextBox(lastNameBox, lastname);
        setTextToTextBox(emailBox, email);
        setTextToTextBox(passwordBox, password);
        setTextToTextBox(confirmPasswordBox, confirmPassword);
        clickButton(registerBtn);
    }
    public String successMessage()
    {
        return registrationSuccessfully.getText();
    }
    public void clickLogout()
    {
        clickButton(logoutLink);
    }
    public void clickMyAccount()
    {
        clickButton(myAccountLink);
    }

}
