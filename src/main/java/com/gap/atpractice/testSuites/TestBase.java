package com.gap.atpractice.testSuites;

import com.gap.atpractice.selenium.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Created by ssibaja on 5/25/17.
 */
public class TestBase extends SeleniumBase{

    private static String FILES_STORAGE_PATH = "./src/main/resources/screenshots/";

    protected WebDriver driver;

    // This method implements the initSetup method extended from SeleniumBase base class
    @BeforeMethod(alwaysRun = true)
    public  void initSetup(){
        driver = super.setup("Chrome");
    }

    // This method implements the quit method extended from SeleniumBase base class
    @AfterMethod(alwaysRun = true)
    public void quitSetup(){
        super.quit();
    }
}
