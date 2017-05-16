package com.gap.atpractice.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ssibaja on 5/15/17.
 */
public class AdminUsersPage {

    WebDriver driver;


    //Locators
    By adminitrativeUsersTabLocator = By.cssSelector(".selected>a");


    public  AdminUsersPage(WebDriver driver){
        this.driver = driver;
    }

    public AdminUsersPage getAdministrativeUsersTab (){
        return new AdminUsersPage(this.driver);
    }
}

