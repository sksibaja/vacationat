package com.gap.atpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by auto on 15/05/17.
 */
public class LoginPage extends PageBase{


    private static String PATH= "users/sign_in";

    //Locators used when implementing Page Objects
    By pageHeader = By.xpath("#content>h1");
    By userInput = By.cssSelector("#user_email");
    By passInput = By.cssSelector("#user_password");
    By loginBtn = By.xpath(".//*[@id='new_user']/div[3]/p[4]/input");


//    //Locators used when implementing Page Factory, we're using the annotation @FindBy
//    @FindBy(xpath = "#content>h1") private  WebElement headerEl;
//    @FindBy(css = "#user_email") private WebElement userInputEl;
//    @FindBy(css = "#user_password") private WebElement passInputEl;
//    @FindBy(xpath = ".//*[@id='new_user']/div[3]/p[4]/input") private WebElement loginBtnEl;


    //Constructor initializes both drivers
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public EmployeesPage userLoginSuccess(String username, String password){

        //botDriver.waitForPageTitle(10, "" );
        //WebElement headerElm = (new WebDriverWait(this.driver,10)).until(ExpectedConditions.presenceOfElementLocated());

        //Using botStyle
        WebElement userInputEl = super.driver.findElement(userInput);
        botDriver.type(userInputEl, username);

        WebElement passInputEl = super.driver.findElement(passInput);
        botDriver.type(passInputEl, password);

        WebElement loginBtnEl = super.driver.findElement(loginBtn);
        loginBtnEl.submit();

        System.out.println("Login form submitted");

        return new EmployeesPage(super.driver);
    }

    public LoginPage userLoginFail(String username, String password){

        //Using botStyle
        WebElement userInputEl = super.driver.findElement(userInput);
        botDriver.type(userInputEl, username);

        WebElement passInputEl = super.driver.findElement(passInput);
        botDriver.type(passInputEl, password);

        WebElement loginBtnEl = super.driver.findElement(loginBtn);
        loginBtnEl.submit();

        System.out.println("Login form submitted");

        return new LoginPage(super.driver);
    }

    @Override
    protected void load() {
        this.driver.get(getPageURL(PATH));
    }

    @Override
    protected void isLoaded() throws Error {
        this.driver.get(getPageURL(PATH));
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        if (js.executeScript("return document.readyState").toString().equals("complete")){
            System.out.println("Login page is loaded");
        }
    }

}
