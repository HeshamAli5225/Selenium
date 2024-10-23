package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase2 {
    public static String baseUrl="https://demo.nopcommerce.com/register?";
    protected ThreadLocal<RemoteWebDriver>  driver = null;
    @BeforeClass
    @Parameters(value = {"browser"})
    public void setup(@Optional("chrome") String browser) throws MalformedURLException {
        driver=new ThreadLocal<>();
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setBrowserName(browser);
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/"),caps));
        getDriver().navigate().to(baseUrl);
    }
    public WebDriver getDriver(){
        return driver.get();
    }

    @AfterMethod
    public  void screenShotOnFailure(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            System.out.println(result.getName()+" Failed");
            System.out.println("Taking Screen Shot......");
            System.out.println(result.getName());

            Helper.captureScreenShot(getDriver(),result.getName());
        }
    }

    @AfterClass
    public void stopDriver(){
        getDriver().quit();
        driver.remove();
    }
}


