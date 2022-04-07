package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;

public class BaseTests {
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browserName) {

        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                driver = new ChromeDriver();

            break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
        }


        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterMethod
    public void saveFailedTest(ITestResult res)
    {
        if(res.getStatus() == ITestResult.FAILURE)
        {
            Helper.captureScreenshot(driver, res.getName());
        }
    }
    /**@AfterClass
    public void goTohome(){
        driver.get("https://demo.nopcommerce.com/");
    }**/
   @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
