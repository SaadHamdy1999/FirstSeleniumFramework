package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContacUSPage extends BasePage{
    public ContacUSPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "FullName")
    WebElement fullNameBox;

    @FindBy(id="Email")
    WebElement emailBox;

    @FindBy(id = "Enquiry")
    WebElement enquiryBox;

    @FindBy(name = "send-email")
    WebElement sendBtn;
    @FindBy(css = "div.result")
    WebElement resultText;

    public void ContactUs(String fullName, String email, String enquiry)
    {
        setTextToTextBox(fullNameBox,fullName);
        setTextToTextBox(emailBox,email);
        setTextToTextBox(enquiryBox,enquiry);
        clickButton(sendBtn);
    }
    public String getResult()
    {
        return resultText.getText();
    }
}
