package com.gap.atpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ssibaja on 5/15/17.
 */
public class AdminUsersPage extends PageBase {

    private final String PATH= "users";

    //Locators
    private By myAccountTab = By.xpath(".//ul[@id='menu']/li[3]/a[@href='/my_account']");


    public  AdminUsersPage(WebDriver driver){
        super(driver);
    }

    public MyAccountPage userNavigatesToMyAccountPage(){

         botDriver.click(myAccountTab);
        return new MyAccountPage(super.driver);
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
            if (js.executeScript("return document.readyState").toString().equals("complete"))
            {
                System.out.println("Administrative Users (tab) page is loaded");
            }
        }catch(Exception ex)
        {
            System.out.println(String.format("%s%s","Error on loading Administrative Users (tab) page:", ex.getStackTrace().toString()));
        }


    }
}

