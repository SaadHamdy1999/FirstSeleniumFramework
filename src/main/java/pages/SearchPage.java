package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="small-searchterms")
    WebElement searchBar;

    @FindBy(xpath = "//form[@id='small-search-box-form']/button")
    WebElement searchBtn;

    @FindBy(id = "ui-id-1")
    List<WebElement> searchSuggestionsBar;
    public void searchForProduct(String productName){
        setTextToTextBox(searchBar,productName);
        clickButton(searchBtn);
    }
    public void SearchUsingAutoComplete(String shortNameForProduct){
        setTextToTextBox(searchBar,shortNameForProduct);
        clickButton(searchSuggestionsBar.get(0));
    }
}
