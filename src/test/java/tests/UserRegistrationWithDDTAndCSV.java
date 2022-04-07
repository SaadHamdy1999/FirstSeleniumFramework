package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import data.CSVRead;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserRegistrationWithDDTAndCSV extends BaseTests {

    HomePage homeObj;
    UserRegisterationPage registerationObj;
    LoginPage loginObj;

    @DataProvider(name="csvData")
    public static Object[][] readData() throws IOException, CsvException {
        CSVRead reader= new CSVRead();
        return reader.readFromCSV();
    }
    @Test (priority = 1, alwaysRun = true, dataProvider = "csvData")
    public void UserRegisterSuccessfully(String firstName, String lastName, String mail,
                                         String pass, String confirm) {


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
