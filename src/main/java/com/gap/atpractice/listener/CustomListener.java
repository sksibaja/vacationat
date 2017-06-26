package com.gap.atpractice.listener;

import com.gap.atpractice.testSuites.TestBase;
import com.gap.atpractice.utils.TakeScreenshot;
import com.gap.atpractice.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by ssibaja on 6/8/17.
 */
public class CustomListener implements ITestListener {

    private final String FILES_STORAGE_PATH = "./src/main/resources/screenshots/";
    private Utils utils;

    public CustomListener(){
        utils = new Utils();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(String.format("%s%s%s", "=========================    TEST CASE: ", iTestResult.getName().toString(), "   ========================= "));
        System.out.println("");
        System.out.println(String.format("%s", ">>> TEST STARTS:"));
        System.out.println("");
        System.out.println(String.format("%s", "Tracking ... "));
        System.out.println("");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        printExecutionSummary(iTestResult);
    }

    @Override
//    @Parameters({"screenShotsPath"})
    public void onTestFailure(ITestResult iTestResult) {

        printExecutionSummary(iTestResult);
        WebDriver driver = ((TestBase)(iTestResult.getInstance())).getDriver();
        new TakeScreenshot().takeScreenshot(driver, FILES_STORAGE_PATH +  iTestResult.getName().toString() + utils.getCurrentDateTime() + ".png");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        printExecutionSummary(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    // Prints the test execution summary at the end of the test execution
    private void printExecutionSummary(ITestResult result){

        System.out.println("");
        System.out.println(">>> TEST EXECUTION SUMMARY:");
        System.out.println("");
        System.out.println(String.format("%s%s", "Test Case status: ", getStatus(result)));
        System.out.println(String.format("%s%d", "Time elapsed: ", (result.getStartMillis())));
        System.out.println(" ====================================================================================== ");

    }

    // Converts the Enum to readable text
    private String getStatus(ITestResult iTestResult) {

        String status;
        switch (iTestResult.getStatus()) {
            case ITestResult.SUCCESS:
                status = "SUCCESS";
                break;

            case ITestResult.FAILURE:
                status = "FAIL";
                break;

            case ITestResult.SKIP:
                status = "SKIP / BLOCKED";
                break;

            default:
                status = "INVALID STATUS";
        }
        return status;
    }


}
