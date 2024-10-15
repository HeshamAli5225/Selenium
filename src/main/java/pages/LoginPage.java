package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;
    @FindBy(css = "button.button-1.login-button")
    WebElement loginBtn;

    public void login(String email,String password){
        setText(this.email,email);
        setText(this.password,password);
        clickButton(loginBtn);
    }
}
