package com.gap.atpractice.common;

import com.gap.atpractice.pageobject.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by ssibaja on 6/5/17.
 */
public class CommonLogin{


    private String LOGIN_SUCCESS_MESSAGE = "Signed in successfully.";

    //I need to refactor this in order to return  the correct page
    public void TestLoginSuccess(String username, String password, WebDriver driver) {

        //when using the last "get()", I'm avoiding the goToLoginPage method
        LoginPage loginpage = (LoginPage) new LoginPage(driver).get();
        loginpage.userLoginSuccess(username, password);
    }


    public String getLoginSuccessMessage (){
        return LOGIN_SUCCESS_MESSAGE;
    }


}
