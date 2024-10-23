package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationParallelTest extends TestBase2{

    HomePage homePage;
    LoginPage loginPage;
    UserRegistrationPage registrationPage;
    @Test(priority = 1,alwaysRun = true)
    public void UserCanRegisterSuccessfully() throws InterruptedException {
        homePage=new HomePage(getDriver());
        registrationPage =new UserRegistrationPage(getDriver());

        //System.out.println(homePage.);
        //homePage.human();
        //homePage.openRegistrationPage();

//        registrationPage.userRegistration("Hesham","ALi","he9@gmail.com","12345678");
//        Assert.assertTrue(registrationPage.successMessage.getText().contains("Your registration completed"));
//

    }

}
