package com.gap.atpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ssibaja on 5/30/17.
 */
public class EmployeeDetailsPage extends PageBase {

    private static String PATH= "";

    By pageHeader = By.xpath(".//*[@id='content']/h1");


    //Constructor initializes both drivers
    public EmployeeDetailsPage(WebDriver driver){
        super(driver);
    }


    public boolean waitForPageHeader(){

        WebElement header = botDriver.waitForElementPresent(pageHeader,10);
        return header.isDisplayed();
    }

    @Override
    protected void load() {
        this.driver.get(getPageURL(PATH));
    }

//    @Override
//    protected void isLoaded() throws Error {
//        this.driver.get(getPageURL(PATH));
//        JavascriptExecutor js = (JavascriptExecutor)this.driver;
//        if (js.executeScript("return document.readyState").toString().equals("complete")){
//            System.out.println("Employee Details page is loaded");
//        }
//    }

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
            System.out.println("Error on Employee Details page:");
            System.out.print(ex.getStackTrace().toString());
        }

    }

}
