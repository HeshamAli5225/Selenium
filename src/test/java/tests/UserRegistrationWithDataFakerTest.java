package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.DataProviders;

public class UserRegistrationWithDataFakerTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    UserRegistrationPage registrationPage;
    Faker faker=new Faker();
    String firstName=faker.name().firstName();
    String lastName=faker.name().lastName();
    String email=faker.internet().emailAddress();
    String password=faker.number().digits(8);


    @Test(priority = 1,alwaysRun = true)
    public void UserCanRegisterSuccessfully() throws InterruptedException {
        homePage=new HomePage(driver);
        registrationPage =new UserRegistrationPage(driver);

        registrationPage.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(registrationPage.successMessage.getText().contains("Your registration completed"));
        homePage.logOut();
        System.out.println("Hi5050");
        //Thread.sleep(5000);
    }


}
