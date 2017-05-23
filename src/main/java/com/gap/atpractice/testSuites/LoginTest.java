package com.gap.atpractice.testSuites;

import com.gap.atpractice.selenium.SeleniumBase;
import com.gap.atpractice.pageobject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Created by auto on 06/04/17.
 */
public class LoginTest {

    private static String USR = "at_java_training@wearegap.com";
    private static String PWD = "123queso";

    //
    private static String FILES_STORAGE_PATH = "./src/main/resources/screenshots/";

    private WebDriver driver;

    // I'm no longer using this method cause now I'm using the TestNG xml config
   /* public static void main(String [] args){

        SeleniumBase seleniumBase = new SeleniumBase();
        WebDriver driver = seleniumBase.setup("Chrome");

        TestLogin(driver);


    }*/

    @BeforeClass
    public  void initSetup(){
        SeleniumBase seleniumBase = new SeleniumBase();
        this.driver = seleniumBase.setup("Chrome");
    }

    @Parameters({ "username", "password" })
    @Test (groups = "login")
    public void TestLogin (String username, String password) {
        try {

            LoginPage loginpage = new LoginPage(driver).get();  //when using this last get, I'm avoiding the goToLoginPage method

            //loginpage.goToLoginPage(); //Used with Page Objects only
            loginpage.userLogin(username, password);

            //TakeScreenshot.takeScreenshot(driver, FILES_STORAGE_PATH + "welcomePage.png");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }


}
