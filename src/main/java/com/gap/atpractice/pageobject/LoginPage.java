package com.gap.atpractice.pageobject;

import org.openqa.selenium.*;


/**
 * Created by auto on 15/05/17.
 */
public class LoginPage extends PageBase{

    private final String PATH= "users/sign_in";

    //Locators used when implementing Page Objects
    private By pageHeader = By.xpath(".//div[@id='content']/h1");
    private By userInput = By.cssSelector("#user_email");
    private By passInput = By.cssSelector("#user_password");
    private By loginBtn = By.xpath(".//form[@id='new_user']/div[3]/p[4]/input[@name='commit'][@type='submit']");

    //Constructor initializes both drivers
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public EmployeePage userLoginSuccess(String username, String password){

        if (isPageHeaderPresent()) {

            //Using botStyle - using the Method that receives the By element.
            botDriver.type(userInput, username);
            botDriver.type(passInput, password);
            botDriver.submit(loginBtn);

            return new EmployeePage(super.driver);
        }
        return null;
    }

    public LoginPage userLoginFail(String invalidUsername, String invalidPassword){

        if (isPageHeaderPresent()) {
            botDriver.type(userInput, invalidUsername);
            botDriver.type(passInput, invalidPassword);
            botDriver.submit(loginBtn);
            return new LoginPage(super.driver);
        }
        return null;
    }

    public boolean isPageHeaderPresent(){

        return botDriver.waitForElementPresent(pageHeader,10);
    }

    @Override
    protected void load() {
        this.driver.get(getPageURL(PATH));
    }

    @Override
    protected void isLoaded(){
        try{
            this.driver.get(getPageURL(PATH));
            JavascriptExecutor js = (JavascriptExecutor)this.driver;
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                System.out.println("Login page is loaded");
            }
        }catch(Exception ex)
        {
            System.out.println( String.format("%s%s", "Error on Login page:", ex.getStackTrace().toString()) );
        }
    }

}
