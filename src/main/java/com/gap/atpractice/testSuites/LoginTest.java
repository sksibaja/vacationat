package com.gap.atpractice.testSuites;

import com.gap.atpractice.dataprovider.LoginDataProvider;
import com.gap.atpractice.pageobject.LoginPage;
import org.testng.annotations.*;


/**
 * Created by auto on 06/04/17.
 */
public class LoginTest extends TestBase{

    private static String FILES_STORAGE_PATH = "./src/main/resources/screenshots/";

    // This class does NOT need to implement the initSup and quitSetup methods, cause the base class
    // has the annotation with "always run" indicator.


    //This Test uses the dataProvider to pass parameters, not the testNG xml file
    @Test (groups = "loginSuccess", dataProvider = "dp", dataProviderClass = LoginDataProvider.class)
    public void TestLoginSuccess(String username, String password) {

        //when using the last "get()", I'm avoiding the goToLoginPage method
        LoginPage loginpage = (LoginPage) new LoginPage(driver).get();

        loginpage.userLoginSuccess(username, password);

        //TakeScreenshot.takeScreenshot(driver, FILES_STORAGE_PATH + "welcomePage.png")
    }

    // This Test uses the @Parameters annotation, cause the parameters are taking/set from the testNG xml file
    @Parameters({ "invalidUsername", "invalidPassword" })
    @Test (groups = "loginFail")
    public void TestLoginFail(String invalidUsername, String invalidPassword) {

        LoginPage loginpage = (LoginPage) new LoginPage(driver).get();

        loginpage.userLoginFail(invalidUsername, invalidPassword);

        //TakeScreenshot.takeScreenshot(driver, FILES_STORAGE_PATH + "welcomePage.png")
    }
}
