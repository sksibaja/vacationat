package com.gap.atpractice.testSuites;

import com.gap.atpractice.selenium.SeleniumBase;
import com.gap.atpractice.pageobject.LoginPage;
import org.openqa.selenium.WebDriver;


/**
 * Created by auto on 06/04/17.
 */
public class LoginTest {

    private static String USR = "at_java_training@wearegap.com";
    private static String PWD = "123queso";

    //
    private static String FILES_STORAGE_PATH = "./src/main/resources/screenshots/";



    public static void main(String [] args){
        SeleniumBase seleniumBase = new SeleniumBase();
        WebDriver driver = seleniumBase.setup("Chrome");

        TestPageObject(driver);
        //TakeScreenshot.takeScreenshot(driver, FILES_STORAGE_PATH + "welcomePage.png");


    }

    public static void TestPageObject (WebDriver driver) {
        try {
            LoginPage loginpage = new LoginPage(driver);
            loginpage.goToLoginPage();
            loginpage.userLogin(USR,PWD);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }


}
