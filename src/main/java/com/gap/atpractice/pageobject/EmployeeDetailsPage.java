package com.gap.atpractice.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by ssibaja on 5/30/17.
 */
public class EmployeeDetailsPage extends PageBase {

    private static String PATH= "";

    //Constructor initializes both drivers
    public EmployeeDetailsPage(WebDriver driver){
        super(driver);
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
            System.out.println("Employee Details page is loaded");
        }
    }
}
