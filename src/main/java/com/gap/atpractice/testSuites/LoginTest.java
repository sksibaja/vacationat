package com.gap.atpractice.testSuites;

import com.gap.atpractice.common.CommonLogin;
import com.gap.atpractice.dataprovider.LoginDataProvider;
import com.gap.atpractice.pageobject.EmployeePage;
import com.gap.atpractice.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Created by auto on 06/04/17.
 */
public class LoginTest extends TestBase{


    // This class does NOT need to implement the initSup and quitSetup methods, cause the base class
    // has the annotation with "always run" indicator.

    private CommonLogin commonLogin;

    public LoginTest(){
        commonLogin = new CommonLogin();
    }

    //This Test uses the dataProvider to pass parameters, not the testNG xml file
    @Test (groups = "loginSuccess", dataProvider = "dp", dataProviderClass = LoginDataProvider.class)
    public void TestLoginSuccess(String username, String password) {

        //when using the last "get()", I'm avoiding the goToLoginPage method
        LoginPage loginpage = (LoginPage) new LoginPage(driver).get();
        EmployeePage employeePage = loginpage.userLoginSuccess(username, password);
        Assert.assertTrue(employeePage.isLoginSuccessMessagePresent());
    }

    @Parameters({"username", "password"})
    @Test (groups = "loginSuccess")
    public void TestLoginSuccessDisplaysSuccessMessage(String username, String password) {

        //when using the last "get()", I'm avoiding the goToLoginPage method
        LoginPage loginpage = (LoginPage) new LoginPage(driver).get();
        EmployeePage employeePage = loginpage.userLoginSuccess(username, password);
        Assert.assertEquals(commonLogin.getLoginSuccessMessage(), employeePage.getLoginSuccessMessage());
    }

    // This Test uses the @Parameters annotation, cause the parameters are taking/set from the testNG xml file
    @Parameters({ "invalidUsername", "invalidPassword" })
    @Test (groups = "loginFail")
    public void TestLoginFail(String invalidUsername, String invalidPassword) {

        LoginPage loginpage = (LoginPage) new LoginPage(driver).get();
        loginpage.userLoginFail(invalidUsername, invalidPassword);
        Assert.assertTrue(loginpage.isPageHeaderPresent());
    }

    @Parameters({ "invalidUsername", "invalidPassword" })
    @Test (groups = "loginFail")
    public void TestLoginFailOnPurpose(String invalidUsername, String invalidPassword) {

        LoginPage loginpage = (LoginPage) new LoginPage(driver).get();
        loginpage.userLoginFail(invalidUsername, invalidPassword);
        Assert.assertEquals(true,false);
    }
}
