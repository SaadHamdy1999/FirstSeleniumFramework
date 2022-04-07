package tests;

import data.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegistrationWithDDTAndProrperties extends BaseTests {

    HomePage homeObj;
    UserRegisterationPage registerationObj;
    LoginPage loginObj;
    String firstname= PropertiesReader.userData.getProperty("firstname");
    String lastname = PropertiesReader.userData.getProperty("lastname");
    String mail= PropertiesReader.userData.getProperty("email");
    String password=PropertiesReader.userData.getProperty("password");
    String confirm=PropertiesReader.userData.getProperty("confirm");
    @Test (priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully()
    {
        homeObj= new HomePage(driver);
        homeObj.clickRegister();
        registerationObj =new UserRegisterationPage(driver);
        registerationObj.userRegistration(firstname,lastname,mail,password,confirm);
        Assert.assertEquals(registerationObj.successMessage(),"Your registration completed");

    }
    @Test (dependsOnMethods = {"UserRegisterSuccessfully"})
    public void UserCanLogout()
    {
        registerationObj.clickLogout();
    }
    @Test (dependsOnMethods = {"UserCanLogout"})
    public void UserCanLogin()
    {
        homeObj.clickLogin();
        loginObj= new LoginPage(driver);
        loginObj.Login(mail,password);
    }
    @Test (dependsOnMethods = {"UserCanLogin"})
    public void UserCanLogout1()
    {
        registerationObj.clickLogout();
    }

}
