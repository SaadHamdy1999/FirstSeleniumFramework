package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;

public class BaseTests {
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional("chromeheadless") String browserName) {

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
            case "headless":
                DesiredCapabilities DC = new DesiredCapabilities();
                DC.setJavascriptEnabled(true);
                DC.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                        System.getProperty("user.dir") + "/drivers/phantomjs.exe");
                String[] phantomArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
                DC.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,phantomArgs);

                driver =new PhantomJSDriver(DC);
                break;
            case"chromeheadless":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
                driver =new ChromeDriver(options );
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
