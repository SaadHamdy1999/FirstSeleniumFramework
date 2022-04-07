package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{


    public HomePage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
        action= new Actions(driver) ;


    }
    @FindBy(linkText = "Register")
    WebElement registerLink;
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy (id="customerCurrency")
    WebElement currencyDropDownList;

    @FindBy(linkText = "Computers")
    WebElement computerMenuLink;

    @FindBy(linkText = "Notebooks")
    WebElement noteBookLink;
    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement selectedSubCategory;
    public void clickRegister()
    {
        clickButton(registerLink);
    }
    public void clickLogin()
    {
        clickButton(loginLink);
    }

    public void clickContactUs(){
     scrollToPageBottom();
     clickButton(contactUsLink);
    }
    public void changeCurrencyToEuro()
    {
        select =new Select(currencyDropDownList);
        select.selectByVisibleText("Euro");
    }
    public void selectNoteBookFromComputers(){
        action = new Actions(driver);
        action.moveToElement(computerMenuLink).build().perform();
        action.moveToElement(noteBookLink).click().build().perform();
        //clickButton(computerMenuLink);
    }
    public String getSubCategory(){ return selectedSubCategory.getText(); }

}
