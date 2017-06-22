package com.gap.atpractice.testSuites;

import com.gap.atpractice.common.CommonEmployee;
import com.gap.atpractice.common.CommonLogin;
import com.gap.atpractice.pageobject.AdminUsersPage;
import com.gap.atpractice.pageobject.EmployeePage;
import com.gap.atpractice.pageobject.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by ssibaja on 6/19/17.
 */
public class EmployeeTest extends TestBase {

    private CommonLogin commonLogin;
    private CommonEmployee commonEmployee;

    public EmployeeTest(){

        commonLogin = new CommonLogin();
        commonEmployee = new CommonEmployee();
    }

    @Test(groups = "employeePageNavigation")
    @Parameters({ "username", "password" })
    public void TestNavigateToAdminUsersTab (String username, String password) {

        commonLogin.TestLoginSuccess(username,password, super.driver);

        EmployeePage employeePage = (EmployeePage) new EmployeePage(driver).get();
        employeePage.userNavigatesToAdministrativeUsersTab();
        Assert.assertEquals(commonEmployee.getAdministrativeUsersTabTitle(), employeePage.getPageHeaderText());

    }

    @Test(groups = "employeePageNavigation")
    @Parameters({ "username", "password" })
    public void TestNavigateToMyAccountTab (String username, String password) {

        commonLogin.TestLoginSuccess(username,password, super.driver);

        EmployeePage employeePage = (EmployeePage) new EmployeePage(driver).get();
        MyAccountPage myAccountPage = employeePage.userNavigatesToMyAccountTab();
        Assert.assertEquals(commonEmployee.getMyAccountTabTitle(), myAccountPage.getPageHeaderText());

    }

    @Test(groups = "employeePageNavigation")
    @Parameters({ "username", "password" })
    public void TestNavigateBetweenTabs (String username, String password) {

        commonLogin.TestLoginSuccess(username,password, super.driver);

        EmployeePage employeePage = (EmployeePage) new EmployeePage(driver).get();
        AdminUsersPage adminUsersPage = employeePage.userNavigatesToAdministrativeUsersTab();
        MyAccountPage myAccountPage = adminUsersPage.userNavigatesToMyAccountPage();
        employeePage = myAccountPage.userNavigatesToEmployeesInfoTab();
        Assert.assertEquals(commonEmployee.getEmployeesInfoTabTitle(), employeePage.getPageHeaderText());

    }

}
