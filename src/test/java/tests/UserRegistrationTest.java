package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.util.Locale;

public class UserRegistrationTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    UserRegistrationPage registrationPage;
    @Test(priority = 1,alwaysRun = true)
    public void UserCanRegisterSuccessfully() throws InterruptedException {
        homePage=new HomePage(driver);
        registrationPage =new UserRegistrationPage(driver);
        //System.out.println(homePage.);
        //homePage.human();
        //homePage.openRegistrationPage();
        registrationPage.userRegistration("Hesham","ALi","h22@gmail.com","12345678");
        Assert.assertTrue(registrationPage.successMessage.getText().contains("Your registration completed"));
        //Thread.sleep(5000);

//        Thread.sleep(4000);
//        driver.findElement(By.partialLinkText("Computers")).click();
//        driver.findElement(By.partialLinkText("Software")).click();
    }
    @Test(priority = 2,dependsOnMethods = {"UserCanRegisterSuccessfully"})
    public void registerUserCanLogOut() throws InterruptedException {
        homePage.logOut();
        //Thread.sleep(5000);
    }
    @Test(priority = 3)
    public void registerUserCanLogin() throws InterruptedException {
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        homePage.openLoginPage();
        loginPage.login("he@gmail.com","123456");
        System.out.println(homePage.logOutBtn.getText().contains("Log out"));
        //Assert.assertTrue(homePage.logOutBtn.getText().contains("Log out"));
       // Thread.sleep(5000);

    }
}
