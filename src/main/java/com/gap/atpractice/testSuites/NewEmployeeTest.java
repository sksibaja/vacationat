package com.gap.atpractice.testSuites;

import com.gap.atpractice.dataprovider.NewEmployeeDataProvider;
import com.gap.atpractice.pageobject.EmployeesPage;
import com.gap.atpractice.pageobject.LoginPage;
import com.gap.atpractice.pageobject.NewEmployeePage;
import org.testng.annotations.Test;

/**
 * Created by ssibaja on 5/30/17.
 */
public class NewEmployeeTest extends TestBase {

    //Added this variable to handle the the iterations handled by the testFactory
    private int testIndex;

    //In this case the index is initializes the index.
    public NewEmployeeTest (int index){
        testIndex = index;
    }


//    @Test(groups = "newEmployee", dataProvider = "dp", dataProviderClass = NewEmployeeDataProvider.class, dependsOnGroups = {"loginSuccess"})
    @Test(groups = "newEmployee", dataProvider = "dp", dataProviderClass = NewEmployeeDataProvider.class)
    public void TestNewEmployee(String firstEmployeeName, String lastEmployeeName, String employeeEmail,
                                String employeeID, String employeeLeaderName, String year, String month,
                                String day){


        // I need to call the Login test case first, just to login. But I need to refactor this later
        LoginPage loginpage = (LoginPage) new LoginPage(driver).get();
        loginpage.userLoginSuccess("at_java_training@wearegap.com", "123queso");

        //when using the last "get()", I'm avoiding the goToLoginPage method, It works because of the implementation of the Loadable component
        NewEmployeePage newEmployeePage = (NewEmployeePage) new NewEmployeePage(driver).get();
        newEmployeePage.createNewEmployeeSuccess(firstEmployeeName,lastEmployeeName,employeeEmail,String.format("%s%d",employeeID,testIndex),
                                                employeeLeaderName,year,month,day);
    }
}
