package com.gap.atpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.gap.atpractice.pageobject.BotStyle;

/**
 * Created by ssibaja on 5/25/17.
 */
public class EmployeesPage extends PageBase{

    private static String PATH= "employees";

    //Locators
    By adminitrativeUsersTabLocator = By.cssSelector(".selected>a");


    public  EmployeesPage(WebDriver driver){

        super(driver);
    }


    public EmployeesPage getEmployeesPage (WebDriver driver){

        return new EmployeesPage(driver);
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
