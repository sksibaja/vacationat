package com.gap.atpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ssibaja on 5/30/17.
 */
public class NewEmployeePage extends PageBase {

    private final String PATH= "/employees/new";

    private final String CSS_LOCATOR_FINAL_STRING = "']";
    private final String CSS_LOCATOR_START_YEAR_VALUE_STRING = "#employee_start_working_on_1i>option[value='";
    private final String CSS_LOCATOR_START_MONTH_VALUE_STRING = "#employee_start_working_on_2i>option[value='";
    private final String CSS_LOCATOR_START_DAY_VALUE_STRING = "#employee_start_working_on_3i>option[value='";

    //Locators used when implementing Page Factory, we're using the annotation @FindBy
    //css locators -by id-
    @FindBy(css = "#employee_first_name") private WebElement firstEmployeeNameInput;
    @FindBy(css = "#employee_last_name") private WebElement lastEmployeeNameInput;
    @FindBy(css = "#employee_email") private WebElement employeeEmailInput;
    @FindBy(css = "#employee_identification") private WebElement employeeIdentificationInput;
    @FindBy(css = "#employee_leader_name") private WebElement employeeLeaderNameInput;
    @FindBy(css = "#employee_start_working_on_1i") private WebElement startedYearSelect;
    @FindBy(css = "#employee_start_working_on_2i") private WebElement startedMonthSelect;
    @FindBy(css = "#employee_start_working_on_3i") private WebElement startedDaySelect;
    @FindBy(css = "input[type=submit]") private WebElement createEmployeeButton;
    
    public  NewEmployeePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EmployeeDetailsPage createNewEmployeeSuccess(String firstEmployeeName, String lastEmployeeName, String employeeEmail,
                                                  String employeeID, String employeeLeaderName, String year, String month,
                                                  String day){

        firstEmployeeNameInput.clear(); //In this form I'm not using the botStyle, I'm using the WebDriver methods
        firstEmployeeNameInput.sendKeys(firstEmployeeName);

        // In these calls I'm using the botStyle pattern with the overloaded Type method. In this case I'm passing a
        // WebElement not a By element
        botDriver.type(lastEmployeeNameInput, lastEmployeeName);
        botDriver.type(employeeEmailInput, employeeEmail);
        botDriver.type(employeeIdentificationInput, employeeID);
        botDriver.type(employeeLeaderNameInput, employeeLeaderName);

        startedYearSelect.click(); // In this form I'm not using the botStyle, I'm using the WebDriver methods
        botDriver.click(getByCssLocatorElement(CSS_LOCATOR_START_YEAR_VALUE_STRING, year, CSS_LOCATOR_FINAL_STRING));

        botDriver.click(startedMonthSelect);
        botDriver.click(getByCssLocatorElement(CSS_LOCATOR_START_MONTH_VALUE_STRING, month, CSS_LOCATOR_FINAL_STRING));

        botDriver.click(startedDaySelect);
        botDriver.click(getByCssLocatorElement(CSS_LOCATOR_START_DAY_VALUE_STRING, day, CSS_LOCATOR_FINAL_STRING));

        createEmployeeButton.submit();

        return new EmployeeDetailsPage(super.driver);
    }

    //As started dates depend on test data, this method gets the drop down values accordingly
    private By getByCssLocatorElement (String cssLocatorStartString, String value, String cssLocatorFinalString){

        String cssLocator = String.format("%s%s%s",cssLocatorStartString, value, cssLocatorFinalString);
        return new By.ByCssSelector(cssLocator);
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
                System.out.println("New Employee page is loaded");
            }
        }catch(Exception ex)
        {
            System.out.println(String.format("%s%s", "Error on New Employee page:", ex.getStackTrace().toString()));
        }

    }
}
