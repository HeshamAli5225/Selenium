package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.DataProviders;

public class UserRegistrationDataProviderTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    UserRegistrationPage registrationPage;
    @Test(priority = 1,alwaysRun = true,dataProvider = "registration_data",dataProviderClass = DataProviders.class)
    public void UserCanRegisterSuccessfully(String fName,String lName,String email,String password) throws InterruptedException {
        homePage=new HomePage(driver);
        registrationPage =new UserRegistrationPage(driver);

        registrationPage.userRegistration(fName,lName,email,password);
        Assert.assertTrue(registrationPage.successMessage.getText().contains("Your registration completed"));
        homePage.logOut();
        System.out.println("Hi5050");
        //Thread.sleep(5000);
    }


}
