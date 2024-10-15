package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{
    public UserRegistrationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id ="gender-male")
    WebElement gender;

    @FindBy(id ="FirstName")
    WebElement firstName;

    @FindBy(id ="LastName")
    WebElement lastName;

    @FindBy(id ="Email")
    WebElement email;

    @FindBy(id ="Password")
    WebElement password;

    @FindBy(id ="ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id ="register-button")
    WebElement registerButton;

    @FindBy(css = "div.result")
    public WebElement successMessage;





    public void userRegistration(String fName,String lName,String email,String password){
        clickButton(gender);
        setText(firstName,fName);
        setText(lastName,lName);
        setText(this.email,email);
        setText(this.password,password);
        setText(confirmPassword,password);
        clickButton(registerButton);
    }









}
