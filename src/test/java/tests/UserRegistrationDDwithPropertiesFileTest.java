package tests;

import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationDDwithPropertiesFileTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    UserRegistrationPage registrationPage;

    String firstName= LoadProperties.userData.getProperty("firstName");
    String lastName= LoadProperties.userData.getProperty("lastName");
    String email= LoadProperties.userData.getProperty("email");
    String password= LoadProperties.userData.getProperty("password");

    @Test(priority = 1,alwaysRun = true)
    public void UserCanRegisterSuccessfully() throws InterruptedException {
        homePage=new HomePage(driver);
        registrationPage =new UserRegistrationPage(driver);

        registrationPage.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(registrationPage.successMessage.getText().contains("Your registration completed"));
        //homePage.logOut();
        //Thread.sleep(5000);

   }


}
