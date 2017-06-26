package com.gap.atpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ssibaja on 5/30/17.
 */
public class EmployeeDetailsPage extends PageBase {

    private final String PATH= "";

    //Constructor initializes both drivers
    public EmployeeDetailsPage(WebDriver driver){
        super(driver);
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
                System.out.println("Employee Details page is loaded");
            }
        }catch(Exception ex)
        {
            System.out.println(String.format("%s%s", "Error on Employee Details page:", ex.getStackTrace().toString()));
        }

    }

}
