package com.gap.atpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by ssibaja on 5/25/17.
 */
public class EmployeePage extends PageBase{

    private static String PATH= "employees";

    //Locators
    private By administrativeUsersTab = By.xpath(".//ul[@id='menu']/li[2]/a[@href='/users']");
    private By myAccountTab = By.xpath(".//ul[@id='menu']/li[3]/a[@href='/my_account']");
    private By loginSuccess = By.xpath(".//div[@id='content']/p[@class='flash_notice']");
    private By pageHeader = By.xpath(".//div[@id='content']/h1");


    public  EmployeePage(WebDriver driver){

        super(driver);
    }

    public AdminUsersPage userNavigatesToAdministrativeUsersTab(){

        botDriver.click(administrativeUsersTab);
        return new AdminUsersPage(super.driver);
    }

    public MyAccountPage userNavigatesToMyAccountTab(){

        botDriver.click(myAccountTab);
        return new MyAccountPage(super.driver);
    }

    public boolean isLoginSuccessMessagePresent(){
        return botDriver.waitForElementPresent(loginSuccess,10);
    }

    public String getLoginSuccessMessage(){

        return botDriver.getTextOnElementPresent(loginSuccess,10);
    }

    public String getPageHeaderText(){

        return botDriver.getTextOnElementPresent(pageHeader,10);
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
                System.out.println("Employee (tab) page is loaded");
            }
        }catch(Exception ex)
        {
            System.out.println(String.format("%s%s", "Error on Employee (tab) page:", ex.getStackTrace().toString()));
        }

    }
}
