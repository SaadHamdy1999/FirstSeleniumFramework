package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    JavascriptExecutor js;
    Select select;
    Actions action;
    public BasePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        BasePage.driver=driver;
    }
    public void clickButton(WebElement Btn)
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(BasePage.driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(2L))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(Btn));
        Btn.click();

    }
    public void setTextToTextBox(WebElement textBox, String textValue)
    {
        textBox.sendKeys(textValue);
    }
    public void scrollToPageBottom()
    {
        js.executeScript("scrollBy(0,2500)");
    }
}
