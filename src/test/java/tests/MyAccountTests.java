package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;




public class MyAccountTests extends BaseTests{

    HomePage homeObj;
    UserRegisterationPage registerationObj;
    LoginPage loginObj;
    MyAccountPage myAccountObj;
    String mail="pdsboozo@sad.com";
    String oldpass="1234567";
    String newpass="12345678";
    String comfirmpass="12345678";
    @Test(priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully()
    {
        homeObj= new HomePage(driver);
        homeObj.clickRegister();
        registerationObj =new UserRegisterationPage(driver);
        registerationObj.userRegistration("Saad","Hamdy",mail
                ,oldpass,oldpass);
        Assert.assertEquals(registerationObj.successMessage(),"Your registration completed");

    }
    @Test (dependsOnMethods = "UserRegisterSuccessfully")
    public void ChangePassword(){

        registerationObj.clickMyAccount();
        myAccountObj= new MyAccountPage(driver);
        myAccountObj.clickChangePassword();
        myAccountObj.changePassword(oldpass,newpass,comfirmpass);
        Assert.assertEquals(myAccountObj.getResult(),"Password was changed");
    }
    @Test (dependsOnMethods = {"ChangePassword"})
    public void UserCanLogout()
    {
        registerationObj.clickLogout();
    }
    @Test (dependsOnMethods = {"UserCanLogout"})
    public void UserCanLogin()
    {
        homeObj.clickLogin();
        loginObj= new LoginPage(driver);
        loginObj.Login(mail,newpass);
    }
}
