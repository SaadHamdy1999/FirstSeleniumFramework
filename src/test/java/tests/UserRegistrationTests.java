package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegistrationTests extends BaseTests {

    HomePage homeObj;
    UserRegisterationPage registerationObj;
    LoginPage loginObj;
    @Test (priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully()
    {
        homeObj= new HomePage(driver);
        homeObj.clickRegister();
        registerationObj =new UserRegisterationPage(driver);
        registerationObj.userRegistration("Saad","Hamdy","sssdwa@sss.com"
                ,"saadsaad","saadsaad");
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
        loginObj.Login("sss@sss.com","saadsaad");
    }
    @Test (dependsOnMethods = {"UserCanLogin"})
    public void UserCanLogout1()
    {
        registerationObj.clickLogout();
    }

}
