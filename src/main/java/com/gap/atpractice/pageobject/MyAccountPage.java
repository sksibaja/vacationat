package com.gap.atpractice.pageobject;

import com.gap.atpractice.botstyletest.BotStyle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ssibaja on 6/19/17.
 */
public class MyAccountPage extends PageBase{

    private final String PATH= "my_account";

    //Locators
    private By employeesInformationTab = By.xpath(".//ul[@id='menu']/li[1]/a[@href='/employees']");
    private By pageHeader = By.xpath(".//div[@id='content']/h2");

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    public EmployeePage userNavigatesToEmployeesInfoTab(){

        botDriver.click(employeesInformationTab);
        return new EmployeePage(super.driver);
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
                System.out.println("My Account (tab) page is loaded");
            }
        }catch(Exception ex)
        {
            System.out.println(String.format("%s%s", "Error on My Account page:", ex.getStackTrace().toString()));
        }

    }

}
