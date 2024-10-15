package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;

public class TestBase extends AbstractTestNGCucumberTests {

    public  static WebDriver driver;
    @BeforeSuite
    //@Parameters({"browser"})
    public void startDriver(@Optional("firefox") String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();}
        else if (browserName.equalsIgnoreCase("edge")){
            driver= new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://demo.nopcommerce.com/register?");
    }


    @AfterMethod
    public  void screenShotOnFailure(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            System.out.println(result.getName()+" Failed");
            System.out.println("Taking Screen Shot......");
            System.out.println(result.getName());

            Helper.captureScreenShot(driver,result.getName());
        }
    }

    @AfterSuite
    public  void closeDriver(){
        driver.quit();
    }
}
