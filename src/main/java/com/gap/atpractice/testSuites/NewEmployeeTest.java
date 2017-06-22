package com.gap.atpractice.testSuites;

import com.gap.atpractice.common.CommonLogin;
import com.gap.atpractice.dataprovider.NewEmployeeDataProvider;
import com.gap.atpractice.pageobject.EmployeePage;
import com.gap.atpractice.pageobject.LoginPage;
import com.gap.atpractice.pageobject.NewEmployeePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.sql.CommonDataSource;

/**
 * Created by ssibaja on 5/30/17.
 */
public class NewEmployeeTest extends TestBase {

    //Added this variable to handle the iterations handled by the testFactory
    private int testIndex;

    private CommonLogin commonLogin;

    // The constructor initializes only the needed "Commons".
    public NewEmployeeTest(){

        commonLogin = new CommonLogin();
    }

    //In this case the index is initializes the index.
    public NewEmployeeTest (int index){

        testIndex = index;
    }


    @Test(groups = "newEmployee", dataProvider = "dpe", dataProviderClass = NewEmployeeDataProvider.class)
    public void TestNewEmployee(String username, String password, String firstEmployeeName, String lastEmployeeName, String employeeEmail,
                                String employeeID, String employeeLeaderName, String year, String month,
                                String day){
        try{
            commonLogin.TestLoginSuccess(username, password, super.driver);

            //when using the last "get()", I'm avoiding the goToLoginPage method, It works because of the implementation of the Loadable component
            NewEmployeePage newEmployeePage = (NewEmployeePage) new NewEmployeePage(driver).get();
            newEmployeePage.createNewEmployeeSuccess(firstEmployeeName,lastEmployeeName,employeeEmail,String.format("%s%d",employeeID,testIndex),
                    employeeLeaderName,year,month,day);

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
