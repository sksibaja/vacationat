package com.gap.atpractice.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ssibaja on 5/15/17.
 */
public class AdminUsersPage extends PageBase {

    private static String PATH= "users";

    //Locators
    private By employeesInformationTab = By.xpath(".//*[@id='menu']/li[1]/a");
    private By administrativeUsersTab = By.xpath(".//*[@id='menu']/li[2]/a");
    private By myAccountTab = By.xpath(".//*[@id='menu']/li[3]/a");


    public  AdminUsersPage(WebDriver driver){
        super(driver);
    }

    public AdminUsersPage getAdministrativeUsersPage (WebDriver driver){
        return new AdminUsersPage(driver);
    }

    public EmployeePage userNavigatesToEmployeesInfoTab(){

        WebElement employeesInfoTabElm = super.driver.findElement(employeesInformationTab);
        employeesInfoTabElm.click();
        return new EmployeePage(super.driver);
    }

    public AdminUsersPage userNavigatesToAdministrativeUsersTab(){

        WebElement adminUsersTabElm = super.driver.findElement(administrativeUsersTab);
        adminUsersTabElm.click();
        return new AdminUsersPage(super.driver);
    }

    public MyAccountPage userNavigatesToMyAccountPage(){

        WebElement myAccountTabElm = super.driver.findElement(myAccountTab);
        myAccountTabElm.click();
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
            System.out.println("Error on loading Administrative Users (tab) page:");
            System.out.print(ex.getStackTrace().toString());
        }


    }
}

