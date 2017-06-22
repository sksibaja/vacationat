package com.gap.atpractice.pageobject;

import org.openqa.selenium.*;


/**
 * Created by auto on 15/05/17.
 */
public class LoginPage extends PageBase{


    private static String PATH= "users/sign_in";

    //Locators used when implementing Page Objects
    private By pageHeader = By.xpath(".//*[@id='content']/h1");
    private By userInput = By.cssSelector("#user_email");
    private By passInput = By.cssSelector("#user_password");
    private By loginBtn = By.xpath(".//*[@id='new_user']/div[3]/p[4]/input");


    //Constructor initializes both drivers
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public EmployeePage userLoginSuccess(String username, String password){


        try{
            if (isPageHeaderPresent()) {

                //Using botStyle
                WebElement userInputEl = super.driver.findElement(userInput);
                botDriver.type(userInputEl, username);

                WebElement passInputEl = super.driver.findElement(passInput);
                botDriver.type(passInputEl, password);

                WebElement loginBtnEl = super.driver.findElement(loginBtn);
                loginBtnEl.submit();

                System.out.println("Login form submitted");

            }
        }catch (NoSuchElementException ex)
        {
            System.out.println("Error on Login page:");
            System.out.print(ex.getStackTrace().toString());
        }
        return new EmployeePage(super.driver);
    }

    public LoginPage userLoginFail(String invalidUsername, String invalidPassword){

        try{
            if (isPageHeaderPresent()) {

                //Using botStyle
                WebElement userInputEl = super.driver.findElement(userInput);
                botDriver.type(userInputEl, invalidUsername);

                WebElement passInputEl = super.driver.findElement(passInput);
                botDriver.type(passInputEl, invalidPassword);

                WebElement loginBtnEl = super.driver.findElement(loginBtn);
                loginBtnEl.submit();

                System.out.println("Login form submitted");

            }
        }catch (NoSuchElementException ex)
        {
            System.out.println("Error on Login page:");
            System.out.print(ex.getStackTrace().toString());
        }

        return new LoginPage(super.driver);
    }

    public boolean isPageHeaderPresent(){

        WebElement header = botDriver.waitForElementPresent(pageHeader,10);
        return header.isDisplayed();
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
            System.out.println("Error on Login page:");
            System.out.print(ex.getStackTrace().toString());
        }

    }

}
