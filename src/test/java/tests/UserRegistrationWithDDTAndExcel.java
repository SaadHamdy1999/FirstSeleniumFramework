package tests;

import data.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

import java.io.IOException;

public class UserRegistrationWithDDTAndExcel extends BaseTests {

    HomePage homeObj;
    UserRegisterationPage registerationObj;
    LoginPage loginObj;

    @DataProvider(name="excelData")
    public Object[][] userData() throws IOException {
        ExcelReader er= new ExcelReader();
        return er.getExcelData();
    }
    @Test (priority = 1, alwaysRun = true, dataProvider = "excelData")
    public void UserRegisterSuccessfully(String firstName, String lastName, String mail, String pass, String confirm)
    {
        homeObj= new HomePage(driver);
        homeObj.clickRegister();
        registerationObj =new UserRegisterationPage(driver);
        registerationObj.userRegistration(firstName,lastName,mail
                ,pass,confirm);
        Assert.assertEquals(registerationObj.successMessage(),"Your registration completed");
        registerationObj.clickLogout();
        homeObj.clickLogin();
        loginObj= new LoginPage(driver);
        loginObj.Login("sss@sss.com","saadsaad");
        registerationObj.clickLogout();
    }
    /**@Test (dependsOnMethods = {"UserRegisterSuccessfully"})
    public void UserCanLogout()
    {
        registerationObj.clickLogout();
    }
    @Test (dependsOnMethods = {"UserCanLogout"})
    public void UserCanLogin()
    {
        homeObj.clickLogin();
        loginObj= new LoginPage(driver);
        loginObj.Login("sss@sss.com","saadsaad");
    }
    @Test (dependsOnMethods = {"UserCanLogin"})
    public void UserCanLogout1()
    {
        registerationObj.clickLogout();
    }**/

}
