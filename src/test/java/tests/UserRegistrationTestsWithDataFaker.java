package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegistrationTestsWithDataFaker extends BaseTests {

    HomePage homeObj;
    UserRegisterationPage registerationObj;
    LoginPage loginObj;
    Faker faker = new Faker();
    String firstName=faker.name().firstName();
    String lastName = faker.name().lastName();
    String mail= faker.internet().emailAddress();
    String pass= faker.number().digits(8).toString();
    @Test (priority = 1, alwaysRun = true)
    public void UserRegisterSuccessfully()
    {
        homeObj= new HomePage(driver);
        homeObj.clickRegister();
        registerationObj =new UserRegisterationPage(driver);
        registerationObj.userRegistration(firstName,lastName,mail
                ,pass,pass);
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
        loginObj.Login(mail,pass);
    }
    @Test (dependsOnMethods = {"UserCanLogin"})
    public void UserCanLogout1()
    {
        registerationObj.clickLogout();
    }

}
