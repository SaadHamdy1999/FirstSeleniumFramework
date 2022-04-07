package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparePage extends BasePage{
    public ComparePage(WebDriver driver) {
        super(driver);
    }
   @FindBy(xpath = "//tr[@class='product-name']/td[@style='width:45%']/a")
    List<WebElement> productsName;

    @FindBy(css="a.clear-list")
    WebElement removeProducts;

    @FindBy(className = "no-data")
    WebElement noDataToShowLabel;

    public void removeProductsFromComparison()
    {
        clickButton(removeProducts);
    }
    public String getLastItemAddedToList()
    {
       return productsName.get(1).getText();
    }
    public String getNoDataToCompareText(){ return noDataToShowLabel.getText();}

}
