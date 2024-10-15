package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    public static void captureScreenShot(WebDriver driver,String screenShotName){
        TakesScreenshot ts= (TakesScreenshot) driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        File destination=new File("Screenshots/"+screenShotName+".png");
        try {
            FileUtils.copyFile(source,destination);
        } catch (IOException e) {
            System.out.println("Exception when taking screenshot: "+e.getMessage());
        }


    }
}
