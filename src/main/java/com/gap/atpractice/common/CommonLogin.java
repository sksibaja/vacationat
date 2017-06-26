package com.gap.atpractice.common;

import com.gap.atpractice.pageobject.EmployeePage;
import com.gap.atpractice.pageobject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by ssibaja on 6/5/17.
 */
public class CommonLogin{


    private String LOGIN_SUCCESS_MESSAGE = "Signed in successfully.";

    public void TestLoginSuccess(String username, String password, WebDriver driver) {

        LoginPage loginpage = (LoginPage) new LoginPage(driver).get();
        EmployeePage employeePage = loginpage.userLoginSuccess(username, password);
        Assert.assertTrue(employeePage.isLoginSuccessMessagePresent());
    }

    public String getLoginSuccessMessage (){
        return LOGIN_SUCCESS_MESSAGE;
    }


}
