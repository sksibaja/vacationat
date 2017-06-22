package com.gap.atpractice.utils;

        import com.gap.atpractice.selenium.SeleniumBase;
        import org.openqa.selenium.OutputType;
        import org.openqa.selenium.TakesScreenshot;
        import org.openqa.selenium.WebDriver;
        import java.io.File;
        import java.io.IOException;
        import org.apache.commons.io.FileUtils;

/**
 * Created by auto on 24/04/17.
 */
public class TakeScreenshot {

    public void takeScreenshot(WebDriver driver, String filePath){

        File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(imageFile, new File(filePath));

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
