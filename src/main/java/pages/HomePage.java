package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText ="Register")
    WebElement registerLink;

    @FindBy(linkText ="Log in")
    WebElement loginLink;
    @FindBy(linkText = "Log out")
    public WebElement logOutBtn;
    @FindBy(css = ".cb-lb > inp0ut:nth-child(1)")
    WebElement human;

    public void human(){
        human.click();
    }
    public void openRegistrationPage(){
        clickButton(registerLink);
    }

    public void logOut(){
        clickButton(logOutBtn);
    }
    public void openLoginPage(){
        driver.navigate().to("https://demo.nopcommerce.com/login");
        //clickButton(logOutBtn);
    }



}
