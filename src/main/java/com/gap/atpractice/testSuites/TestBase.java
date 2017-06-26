package com.gap.atpractice.testSuites;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionType;
import br.eti.kinoshita.testlinkjavaapi.model.*;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import com.gap.atpractice.selenium.SeleniumBase;
import com.gap.atpractice.testLinkAPI.TestLinkCustomAPI;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by ssibaja on 5/25/17.
 */
public class TestBase extends SeleniumBase{

    @BeforeSuite(alwaysRun = true)
    @Parameters ({"createTestPlan","testLinkURL", "testLinkKey", "testPlanName", "testProjectName", "testPlanNotes",
                  "testPlanIsActive", "testPlanIsPublic" })
    public TestPlan createTestPlan (Boolean createTestPlan, String testLinkURL, String testLinkKey, String testPlanName, String testProjectName,
                                    String testPlanNotes, Boolean testPlanIsActive, Boolean testPlanIsPublic)throws TestLinkAPIException, MalformedURLException{
        if (createTestPlan){
            TestLinkCustomAPI testLinkCustomAPI = new TestLinkCustomAPI(testLinkURL, testLinkKey);
            return testLinkCustomAPI.createTestPlan(testPlanName, testProjectName, testPlanNotes, testPlanIsActive, testPlanIsPublic);
        }
        return null;
    }



    @BeforeSuite(alwaysRun = true)
    @Parameters ({"createBuild", "testLinkURL", "testLinkKey", "testPlanID", "buildName", "buildNotes"})
    public Build createBuild(Boolean createBuild, String testLinkURL, String testLinkKey, Integer testPlanID, String buildName, String buildNotes)
                            throws TestLinkAPIException, MalformedURLException{

        if (createBuild){
            TestLinkCustomAPI testLinkCustomAPI = new TestLinkCustomAPI(testLinkURL, testLinkKey);
            return testLinkCustomAPI.createBuild(testPlanID, buildName, buildNotes);
        }
        return null;
    }



    @BeforeSuite(alwaysRun = true)
    @Parameters ({"addLoginSuccess", "testLinkURL", "testLinkKey", "testProjectName", "testPlanID", "loginSuccessID", "testCaseExternalId",
            "version", "platformId", "order", "urgency"})
    public Integer addTestCaseToTestPlan (Boolean addLoginSuccess, String testLinkURL, String testLinkKey, String testProjectName,
                                          Integer testPlanID, Integer loginSuccessID, Integer testCaseExternalId, Integer version, Integer platformId,
                                          Integer order, Integer urgency) throws TestLinkAPIException, MalformedURLException{

        if (addLoginSuccess) {
            TestLinkCustomAPI testLinkCustomAPI = new TestLinkCustomAPI(testLinkURL, testLinkKey);

            TestProject testproject = testLinkCustomAPI.getTestProjectByName(testProjectName);
            Integer testProjectId = testproject.getId();

            testLinkCustomAPI.setTestCaseExecutionType(testProjectId, loginSuccessID, testCaseExternalId, version, ExecutionType.AUTOMATED);

            return testLinkCustomAPI.addTestCaseToTestPlan(testProjectId, testPlanID, loginSuccessID, version,
                                                            platformId, order, urgency);
        }
        return null;

    }



    @AfterMethod(alwaysRun = true)
    @Parameters ({"testLinkURL", "testLinkKey",
                "loginSuccessID", "testCaseExternalId", "testPlanID", "buildID", "buildName", "testCaseNotes",
                  "platformId", "platformName", "overwrite" })
    public ReportTCResultResponse setTestCaseExecutionResult(String testLinkURL, String testLinkKey, Integer loginSuccessID,
                                                             Integer testCaseExternalId, Integer testPlanID, Integer buildID, String buildName,
                                                             String testCaseNotes,
                                                             Integer platformId, String platformName, Boolean overwrite)
            throws TestLinkAPIException, MalformedURLException{


        Map<String, String> customFields = new HashMap<>();
        String bugId = null;
        Boolean guess = false;
        TestLinkCustomAPI testLinkCustomAPI = new TestLinkCustomAPI(testLinkURL, testLinkKey);
        ReportTCResultResponse response;
        ITestResult result = Reporter.getCurrentTestResult();

        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                response = testLinkCustomAPI.setTestCaseExecutionResult(loginSuccessID, testCaseExternalId, testPlanID,
                        ExecutionStatus.PASSED, buildID, buildName, testCaseNotes, guess, bugId, platformId, platformName,
                        customFields, overwrite);

                break;

            case ITestResult.FAILURE:
                response = testLinkCustomAPI.setTestCaseExecutionResult(loginSuccessID, testCaseExternalId, testPlanID,
                        ExecutionStatus.FAILED, buildID, buildName, testCaseNotes, guess, bugId, platformId, platformName,
                        customFields, overwrite);
                break;

            case ITestResult.SKIP:
                response = testLinkCustomAPI.setTestCaseExecutionResult(loginSuccessID, testCaseExternalId, testPlanID,
                        ExecutionStatus.NOT_RUN, buildID, buildName, testCaseNotes, guess, bugId, platformId, platformName,
                        customFields, overwrite);
                break;
            default:
                response = testLinkCustomAPI.setTestCaseExecutionResult(loginSuccessID, testCaseExternalId, testPlanID,
                        ExecutionStatus.BLOCKED, buildID, buildName, testCaseNotes, guess, bugId, platformId, platformName,
                        customFields, overwrite);
        }
        return response;

    }

    // This method implements the initSetup method extended from SeleniumBase base class
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void initSetup(String browser){
        driver = super.setup(browser);
    }


    // This method implements the quit method extended from SeleniumBase base class
    @AfterMethod(alwaysRun = true)
    public void quitSetup(){
        super.quit();
    }

    public WebDriver getDriver (){
        return this.driver;

    }



}
