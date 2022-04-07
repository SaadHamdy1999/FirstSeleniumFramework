package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[@class='product-title']/a")
    WebElement searchResult;

    public void clickOnSearchResult()
    {
        clickButton(searchResult);
    }
}
