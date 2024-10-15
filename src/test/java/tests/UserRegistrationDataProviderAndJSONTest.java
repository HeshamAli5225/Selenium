package tests;

import data.JsonDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.DataProviders;

import java.io.FileNotFoundException;

public class UserRegistrationDataProviderAndJSONTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    UserRegistrationPage registrationPage;

    JsonDataReader jsonDataReader;
    @Test(priority = 1,alwaysRun = true,dataProvider = "excel_data",dataProviderClass = DataProviders.class)
    public void UserCanRegisterSuccessfully(String fName,String lName,String email,String password) throws InterruptedException, FileNotFoundException {
        homePage=new HomePage(driver);
        registrationPage =new UserRegistrationPage(driver);
        jsonDataReader=new JsonDataReader();
        jsonDataReader.jsonReader();

        registrationPage.userRegistration(jsonDataReader.firstName,jsonDataReader.lastName,jsonDataReader.email, jsonDataReader.password);
        Assert.assertTrue(registrationPage.successMessage.getText().contains("Your registration completed"));
        homePage.logOut();
        System.out.println("Hi5050");
        //Thread.sleep(5000);
    }


}
