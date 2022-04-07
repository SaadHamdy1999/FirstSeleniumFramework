package tests;


import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

import java.io.IOException;

public class UserRegistrationWithDDTAndJSON extends BaseTests {

    HomePage homeObj;
    UserRegisterationPage registerationObj;
    LoginPage loginObj;

    @DataProvider(name="jsonData")
    public static Object[][] readData() throws IOException, ParseException {
        JsonDataReader json = new JsonDataReader();
       return json.JsonRead();
    }
    @Test (priority = 1, alwaysRun = true, dataProvider = "jsonData")
    public void UserRegisterSuccessfully(String pass, String firstName, String confirm,
                                         String mail, String lastName) {


        homeObj= new HomePage(driver);
        homeObj.clickRegister();
        registerationObj =new UserRegisterationPage(driver);
        registerationObj.userRegistration(firstName,lastName,mail
                ,pass,confirm);
        Assert.assertEquals(registerationObj.successMessage(),"Your registration completed");
        registerationObj.clickLogout();
        homeObj.clickLogin();
        loginObj= new LoginPage(driver);
        loginObj.Login(mail,pass);
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
