package tests;

import data.LoadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TestBase2 {
    public static String baseUrl="https://demo.nopcommerce.com/register?";
    public static final String seleniumURL= LoadProperties.sauceLabsData.getProperty("seleniumURL");
    public static final String username= LoadProperties.sauceLabsData.getProperty("username");
    public static final String accessKey= LoadProperties.sauceLabsData.getProperty("accessKey");

    RemoteWebDriver driver;
    //protected ThreadLocal<RemoteWebDriver>  driver = null;
    @BeforeClass
    @Parameters(value = {"browser"})
    public void setup(@Optional("chrome") String browser) throws MalformedURLException {
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username",username);
        sauceOptions.put("accessKey", accessKey);
        URL url = new URL(seleniumURL);

        if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("latest");
            browserOptions.setCapability("sauce:options", sauceOptions);
            driver= new RemoteWebDriver(url, browserOptions);
        }
        else if (browser.equalsIgnoreCase("firefox")){
            FirefoxOptions browserOptions = new FirefoxOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("latest");
            browserOptions.setCapability("sauce:options", sauceOptions);
            driver= new RemoteWebDriver(url, browserOptions);
        }
        driver.navigate().to(baseUrl);


//        driver=new ThreadLocal<>();
//        DesiredCapabilities caps= new DesiredCapabilities();
//        caps.setBrowserName(browser);
//        caps.setCapability("sauce:options", sauceOptions);
//        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/"),caps));

//        getDriver().navigate().to(baseUrl);
    }
//    public WebDriver getDriver(){
//        return driver.get();
//    }

    @AfterMethod
    public  void screenShotOnFailure(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            System.out.println(result.getName()+" Failed");
            System.out.println("Taking Screen Shot......");
            System.out.println(result.getName());

//            Helper.captureScreenShot(getDriver(),result.getName());
            Helper.captureScreenShot(driver,result.getName());
        }
    }

    @AfterClass
    public void stopDriver(){
        driver.quit();
//        getDriver().quit();
//        driver.remove();
    }
}


