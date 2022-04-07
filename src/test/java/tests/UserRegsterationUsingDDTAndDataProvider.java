package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegsterationUsingDDTAndDataProvider extends BaseTests{
    HomePage homeObj;
    UserRegisterationPage registerationObj;
    LoginPage loginObj;

    @DataProvider (name="testData")
    public static Object[][]userData()
    {
        return new Object[][] {
                {"saad","hamdy","maiil@mail.com","123456","123456"},
                {"ahah","hahah","hahai@haha.com","123456","123456"}
        };
    }
    @Test(priority = 1, alwaysRun = true, dataProvider = "testData")
    public void UserRegisterSuccessfully(String firstName, String lastname, String mail, String password, String confirmPassword)
    {
        homeObj= new HomePage(driver);
        homeObj.clickRegister();
        registerationObj =new UserRegisterationPage(driver);
        registerationObj.userRegistration(firstName,lastname,mail,password,confirmPassword);
        Assert.assertEquals(registerationObj.successMessage(),"Your registration completed");
        registerationObj.clickLogout();
        homeObj.clickLogin();
        loginObj= new LoginPage(driver);
        loginObj.Login(mail,password);
        registerationObj.clickLogout();

    }
    /**@Test (dependsOnMethods = {"UserRegisterSuccessfully"})
    public void UserCanLogout()
    {

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
