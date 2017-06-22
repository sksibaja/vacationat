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
    private By employeesInformationTab = By.xpath(".//*[@id='menu']/li[1]/a");
    private By administrativeUsersTab = By.xpath(".//*[@id='menu']/li[2]/a");
    private By myAccountTab = By.xpath(".//*[@id='menu']/li[3]/a");

    private By loginSuccess = By.xpath(".//*[@id='content']/p[1]");
    private By pageHeader = By.xpath(".//*[@id='content']/h1");


    public  EmployeePage(WebDriver driver){

        super(driver);
    }

//    public EmployeePage userNavigatesToEmployeesInfoTab(){
//
//        WebElement employeesInfoTabElm = super.driver.findElement(employeesInformationTab);
//        employeesInfoTabElm.click();
//        return new EmployeePage(super.driver);
//    }

    public AdminUsersPage userNavigatesToAdministrativeUsersTab(){

        WebElement adminUsersTabElm = super.driver.findElement(administrativeUsersTab);
        adminUsersTabElm.click();
        return new AdminUsersPage(super.driver);
    }

    public MyAccountPage userNavigatesToMyAccountTab(){

        WebElement myAccountTabElm = super.driver.findElement(myAccountTab);
        myAccountTabElm.click();
        return new MyAccountPage(super.driver);
    }

    public EmployeePage getEmployeesPage (WebDriver driver){

        return new EmployeePage(driver);
    }

    public boolean isLoginSuccessMessagePresent(){

        WebElement header = botDriver.waitForElementPresent(loginSuccess,10);
        System.out.println(header.getText().toString());
        return header.isDisplayed();
    }

    public String getLoginSuccessMessage(){

        WebElement message = botDriver.waitForElementPresent(loginSuccess,10);
        return message.getText().toString();
    }

    public String getPageHeaderText(){

        WebElement header = botDriver.waitForElementPresent(pageHeader,10);
        return header.getText().toString();
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
            System.out.println("Error on Employee (tab) page:");
            System.out.print(ex.getStackTrace().toString());
        }

    }
}
