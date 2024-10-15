package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {

    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    @Given("the user in the home page")
    public void the_user_in_the_home_page() {
        homePage=new HomePage(driver);
    }
    @When("clicking on register link")
    public void clicking_on_register_link() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }
//    @When("entering a valid user data")
//    public void entering_a_valid_user_data() {
//        userRegistrationPage=new UserRegistrationPage(driver);
//        userRegistrationPage.userRegistration("Hesham","Ali","hd1@gmail.com","12345678");
//    }

    @When("entering {string},{string},{string},{string},")
    public void entering(String firstName, String lastName, String email, String password) {
        userRegistrationPage=new UserRegistrationPage(driver);
        userRegistrationPage.userRegistration(firstName,lastName,email, password);

    }
    @Then("the registration page displayed successfully")
    public void the_registration_page_displayed_successfully() {
        homePage.logOut();

    }
}
